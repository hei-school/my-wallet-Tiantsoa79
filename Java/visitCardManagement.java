import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitCardManagement {
    private static List<VisitCard> visitCards = new ArrayList<>();

    public static void manageVisitCards() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
            System.out.println("Option de gestion des cartes de visite (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : ");
            int subMenuVisitCards = Integer.parseInt(scanner.nextLine());

            if (!(subMenuVisitCards >= 1 && subMenuVisitCards <= 4)) {
                System.out.println("Veuillez saisir une option valable");
                continue;
            }

            if (subMenuVisitCards == 1) {
                addVisitCard();
            } else if (subMenuVisitCards == 2) {
                viewVisitCards();
            } else if (subMenuVisitCards == 3) {
                deleteVisitCard();
            } else if (subMenuVisitCards == 4) {
                System.out.println("Retour au menu précédent.");
                break;
            }
            
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier pour l'option.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addVisitCard() {
        Scanner scanner = new Scanner(System.in);

        // Ajout d'une carte de visite
        System.out.println("Nom sur la carte de visite : ");
        String nom = scanner.nextLine();

        System.out.println("Prénom sur la carte de visite : ");
        String prenom = scanner.nextLine();

        System.out.println("Entreprise sur la carte de visite : ");
        String entreprise = scanner.nextLine();

        System.out.println("Numéro de téléphone sur la carte de visite : ");
        String telephone = scanner.nextLine();

        if (nom.trim().isEmpty() || prenom.trim().isEmpty() || entreprise.trim().isEmpty() || telephone.trim().isEmpty()) {
            System.out.println("Veuillez remplir tous les champs de la carte de visite.");
        } else {
            VisitCard newVisitCard = new VisitCard(nom, prenom, entreprise, telephone);
            visitCards.add(newVisitCard);
            System.out.println("Carte de visite ajoutée avec succès.");
        }
    }

    private static void viewVisitCards() {
        // Consultation des cartes de visite
        if (!visitCards.isEmpty()) {
            System.out.println("Cartes de visite enregistrées :");
            for (VisitCard card : visitCards) {
                System.out.println("Nom : " + card.getNom() + ", Prénom : " + card.getPrenom() +
                        ", Entreprise : " + card.getEntreprise() + ", Téléphone : " + card.getTelephone());
            }
        } else {
            System.out.println("Aucune carte de visite enregistrée.");
        }
    }

    private static void deleteVisitCard() {
        Scanner scanner = new Scanner(System.in);

        // Suppression d'une carte de visite
        if (!visitCards.isEmpty()) {
            for (VisitCard card : visitCards) {
                System.out.println("Nom : " + card.getNom() + ", Prénom : " + card.getPrenom() +
                        ", Entreprise : " + card.getEntreprise() + ", Téléphone : " + card.getTelephone());
            }

            System.out.println("Nom de la carte de visite à supprimer (Appuyez sur Entrée pour annuler) : ");
            String cardToDelete = scanner.nextLine();

            if (cardToDelete.trim().isEmpty()) {
                System.out.println("Suppression annulée.");
                return;
            }

            VisitCard foundCard = visitCards.stream().filter(card -> card.getNom().equals(cardToDelete)).findFirst().orElse(null);

            if (foundCard != null) {
                visitCards.remove(foundCard);
                System.out.println("Carte de visite supprimée avec succès.");
            } else {
                System.out.println("Carte de visite non trouvée. Veuillez vérifier le nom de la carte.");
            }
        } else {
            System.out.println("Aucune carte de visite enregistrée.");
        }
    }

    public static class VisitCard {
        private String nom;
        private String prenom;
        private String entreprise;
        private String telephone;

        public VisitCard(String nom, String prenom, String entreprise, String telephone) {
            this.nom = nom;
            this.prenom = prenom;
            this.entreprise = entreprise;
            this.telephone = telephone;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getEntreprise() {
            return entreprise;
        }

        public String getTelephone() {
            return telephone;
        }
    }
}
