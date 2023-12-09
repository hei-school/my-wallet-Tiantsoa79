import java.util.Scanner;

public class Wallet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoneyManagement moneyManagement = new MoneyManagement();
        CinManagement cinManagement = new CinManagement();
        BankCardManagement bankCardManagement = new BankCardManagement();
        VisitCardManagement visitCardManagement = new VisitCardManagement();
        DrivingLicenseManagement drivingLicenseManagement = new DrivingLicenseManagement();

        boolean exitMainMenu = false;

        while (!exitMainMenu) {
            try {
                System.out.println("Choisissez une option : ");
                System.out.println("1. argent 2. CIN 3. cartes bancaires. 4. cartes de visite 5. Permis 6. Quitter :");
                int menu = Integer.parseInt(scanner.nextLine());

                if (!(menu >= 1 && menu <= 6)) {
                    throw new IllegalArgumentException("Veuillez saisir une option valable");
                }

                switch (menu) {
                    case 1:
                        moneyManagement.manageMoney();
                        break;
                    case 2:
                        cinManagement.manageCIN();
                        break;
                    case 3:
                        bankCardManagement.manageBankCards();
                        break;
                    case 4:
                        visitCardManagement.manageVisitCards();
                        break;
                    case 5:
                        drivingLicenseManagement.manageDrivingLicense();
                        break;
                    case 6:
                        exitMainMenu = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier pour l'option.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
