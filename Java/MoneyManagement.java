import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoneyManagement {
    private static double solde = 200000;
    private static List<String> historiqueTransactions = new ArrayList<>();

    private static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositiveNumeric(String value) {
        return isNumeric(value) && Double.parseDouble(value) > 0;
    }

    public static void manageMoney() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
            System.out.println("1. Versement 2. Retrait 3. Consultation du solde 4. Historique des transactions 5. Retour Choisissez une option : ");
            int subMenu1 = Integer.parseInt(scanner.nextLine());

            if (!(subMenu1 >= 1 && subMenu1 <= 5)) {
                System.out.println("Veuillez saisir une option valable");
                continue;
            }

            if (subMenu1 == 1) {
                System.out.print("Combien souhaitez-vous verser : ");
                String versementStr = scanner.nextLine();

                if (isPositiveNumeric(versementStr)) {
                    double versement = Double.parseDouble(versementStr);
                    solde += versement;
                    historiqueTransactions.add("Versement de " + versement);
                    System.out.println("Versement effectué avec succès !");
                } else {
                    System.out.println("Veuillez entrer un montant valide.");
                }
            } else if (subMenu1 == 2) {
                System.out.print("Combien souhaitez-vous retirer : ");
                String retraitStr = scanner.nextLine();

                if (isPositiveNumeric(retraitStr)) {
                    double retrait = Double.parseDouble(retraitStr);

                    if (retrait > solde) {
                        System.out.println("Désolé, votre solde est insuffisant pour ce retrait");
                    } else {
                        solde -= retrait;
                        historiqueTransactions.add("Retrait de " + retrait);
                        System.out.println("Retrait effectué avec succès !");
                    }
                } else {
                    System.out.println("Veuillez entrer un montant valide.");
                }
            } else if (subMenu1 == 3) {
                System.out.println("Votre solde est : " + solde);
            } else if (subMenu1 == 4) {
                System.out.println("Historique des transactions :");
                for (String transaction : historiqueTransactions) {
                    System.out.println(transaction);
                }
            } else if (subMenu1 == 5) {
                System.out.println("Retour au menu principal.");
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
