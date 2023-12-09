import java.util.Scanner;

public class CinManagement {
    private static CinInfo cinInfo = null;

    public static void manageCIN() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
            System.out.println("Option de gestion du CIN (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4. Retour) : ");
            int subMenu2 = Integer.parseInt(scanner.nextLine());

            if (!(subMenu2 >= 1 && subMenu2 <= 4)) {
                System.out.println("Veuillez saisir une option valable");
                continue;
            }

            if (subMenu2 == 1) {
                addCIN();
            } else if (subMenu2 == 2) {
                updateCIN();
            } else if (subMenu2 == 3) {
                viewCIN();
            } else if (subMenu2 == 4) {
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

    private static void addCIN() {
        Scanner scanner = new Scanner(System.in);

        if (cinInfo == null) {
            System.out.println("Enregistrement des informations du CIN...");

            System.out.println("Numéro du CIN : ");
            String numeroCIN = scanner.nextLine();

            System.out.println("Nom sur le CIN : ");
            String nomCIN = scanner.nextLine();

            System.out.println("Date de naissance sur le CIN : ");
            String dateNaissanceCIN = scanner.nextLine();

            if (numeroCIN.trim().isEmpty() || nomCIN.trim().isEmpty() || dateNaissanceCIN.trim().isEmpty()) {
                System.out.println("Veuillez remplir tous les champs du CIN.");
            } else {
                cinInfo = new CinInfo(numeroCIN, nomCIN, dateNaissanceCIN);
                System.out.println("Informations du CIN enregistrées avec succès.");
            }
        } else {
            System.out.println("Des informations de CIN existent déjà. Vous ne pouvez pas enregistrer de nouveau CIN.");
        }
    }

    private static void updateCIN() {
        Scanner scanner = new Scanner(System.in);

        if (cinInfo != null) {
            System.out.println("Option de mise à jour et de renouvellement du CIN...");

            // Affichez les informations actuelles du CIN
            System.out.println("Informations actuelles du CIN :");
            System.out.println("Numéro du CIN : " + cinInfo.numero);
            System.out.println("Nom sur le CIN : " + cinInfo.nom);
            System.out.println("Date de naissance sur le CIN : " + cinInfo.dateNaissance);

            // Collectez les nouvelles informations du CIN
            System.out.println("Nouveau numéro du CIN  : ");
            String nouveauNumeroCIN = scanner.nextLine();

            System.out.println("Nouveau nom sur le CIN : ");
            String nouveauNomCIN = scanner.nextLine();

            System.out.println("Nouvelle date de naissance sur le CIN : ");
            String nouvelleDateNaissanceCIN = scanner.nextLine();

            // Vérifiez que les champs ne sont pas vides
            if (nouveauNumeroCIN.trim().isEmpty() || nouveauNomCIN.trim().isEmpty() || nouvelleDateNaissanceCIN.trim().isEmpty()) {
                System.out.println("Veuillez remplir tous les champs du CIN.");
            } else {
                // Mettez à jour les informations du CIN
                cinInfo.numero = nouveauNumeroCIN;
                cinInfo.nom = nouveauNomCIN;
                cinInfo.dateNaissance = nouvelleDateNaissanceCIN;

                System.out.println("Informations du CIN mises à jour avec succès.");
            }
        } else {
            System.out.println("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.");
        }
    }

    private static void viewCIN() {
        if (cinInfo != null) {
            System.out.println("Consultation des informations du CIN...");

            System.out.println("Informations actuelles du CIN :");
            System.out.println("Numéro du CIN : " + cinInfo.numero);
            System.out.println("Nom sur le CIN : " + cinInfo.nom);
            System.out.println("Date de naissance sur le CIN : " + cinInfo.dateNaissance);
        } else {
            System.out.println("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.");
        }
    }

    public static class CinInfo {
        private String numero;
        private String nom;
        private String dateNaissance;

        public CinInfo(String numero, String nom, String dateNaissance) {
            this.numero = numero;
            this.nom = nom;
            this.dateNaissance = dateNaissance;
        }
    }
}
