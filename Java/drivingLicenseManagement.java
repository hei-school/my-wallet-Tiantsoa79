import java.util.Scanner;

public class DrivingLicenseManagement {
    private static DrivingLicenseInfo drivingLicenseInfo = null;

    public static void manageDrivingLicense() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Option de gestion du permis de conduire (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4. Retour) : ");
                int subMenuLicense = Integer.parseInt(scanner.nextLine());

                if (!(subMenuLicense >= 1 && subMenuLicense <= 4)) {
                    throw new IllegalArgumentException("Veuillez saisir une option valable");
                }

                if (subMenuLicense == 1) {
                    addDrivingLicense();
                } else if (subMenuLicense == 2) {
                    updateDrivingLicense();
                } else if (subMenuLicense == 3) {
                    viewDrivingLicense();
                } else if (subMenuLicense == 4) {
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

    private static void addDrivingLicense() {
        Scanner scanner = new Scanner(System.in);

        if (drivingLicenseInfo == null) {
            System.out.println("Enregistrement des informations du permis de conduire...");

            System.out.println("Nom sur le permis de conduire : ");
            String nomLicense = scanner.nextLine();

            System.out.println("Date d'expiration du permis de conduire : ");
            String dateExpirationLicense = scanner.nextLine();

            System.out.println("Catégories de permis de conduire : ");
            String categoriesLicense = scanner.nextLine();

            if (nomLicense.trim().isEmpty() || dateExpirationLicense.trim().isEmpty() || categoriesLicense.trim().isEmpty()) {
                System.out.println("Veuillez remplir tous les champs du permis de conduire.");
            } else {
                drivingLicenseInfo = new DrivingLicenseInfo(nomLicense, dateExpirationLicense, categoriesLicense);
                System.out.println("Informations du permis de conduire enregistrées avec succès.");
            }
        } else {
            System.out.println("Des informations de permis de conduire existent déjà. Vous ne pouvez pas enregistrer de nouveau permis de conduire.");
        }
    }

    private static void updateDrivingLicense() {
        Scanner scanner = new Scanner(System.in);

        if (drivingLicenseInfo != null) {
            System.out.println("Option de mise à jour du permis de conduire...");

            // Affichez les informations actuelles du permis de conduire
            System.out.println("Informations actuelles du permis de conduire :");
            System.out.println("Nom sur le permis de conduire : " + drivingLicenseInfo.nom);
            System.out.println("Date d'expiration du permis de conduire : " + drivingLicenseInfo.dateExpiration);
            System.out.println("Catégories de permis de conduire : " + drivingLicenseInfo.categories);

            // Collectez les nouvelles informations du permis de conduire
            System.out.println("Nouveau nom sur le permis de conduire  : ");
            String nouveauNomLicense = scanner.nextLine();

            System.out.println("Nouvelle date d'expiration du permis de conduire  : ");
            String nouvelleDateExpirationLicense = scanner.nextLine();

            System.out.println("Nouvelles catégories de permis de conduire : ");
            String nouvellesCategoriesLicense = scanner.nextLine();

            // Vérifiez que les champs ne sont pas vides
            if (nouveauNomLicense.trim().isEmpty() || nouvelleDateExpirationLicense.trim().isEmpty() || nouvellesCategoriesLicense.trim().isEmpty()) {
                System.out.println("Veuillez remplir tous les champs du permis de conduire.");
            } else {
                // Mettez à jour les informations du permis de conduire
                drivingLicenseInfo.nom = nouveauNomLicense;
                drivingLicenseInfo.dateExpiration = nouvelleDateExpirationLicense;
                drivingLicenseInfo.categories = nouvellesCategoriesLicense;

                System.out.println("Informations du permis de conduire mises à jour avec succès.");
            }
        } else {
            System.out.println("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.");
        }
    }

    private static void viewDrivingLicense() {
        if (drivingLicenseInfo != null) {
            System.out.println("Consultation des informations du permis de conduire...");

            System.out.println("Informations actuelles du permis de conduire :");
            System.out.println("Nom sur le permis de conduire : " + drivingLicenseInfo.nom);
            System.out.println("Date d'expiration du permis de conduire : " + drivingLicenseInfo.dateExpiration);
            System.out.println("Catégories de permis de conduire : " + drivingLicenseInfo.categories);
        } else {
            System.out.println("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.");
        }
    }

    public static class DrivingLicenseInfo {
        private String nom;
        private String dateExpiration;
        private String categories;

        public DrivingLicenseInfo(String nom, String dateExpiration, String categories) {
            this.nom = nom;
            this.dateExpiration = dateExpiration;
            this.categories = categories;
        }
    }
}
