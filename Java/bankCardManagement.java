import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankCardManagement {
    private static List<BankCard> bankCards = new ArrayList<>();

    public static void manageBankCards() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
            System.out.println("Option de gestion des cartes bancaires (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : ");
            int subMenuCards = Integer.parseInt(scanner.nextLine());

            if (!(subMenuCards >= 1 && subMenuCards <= 4)) {
                System.out.println("Veuillez saisir une option valable");
                continue;
            }

            if (subMenuCards == 1) {
                addBankCard();
            } else if (subMenuCards == 2) {
                viewBankCards();
            } else if (subMenuCards == 3) {
                deleteBankCard();
            } else if (subMenuCards == 4) {
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

    private static void addBankCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numéro de la carte bancaire : ");
        String numeroCarte = scanner.nextLine();

        System.out.println("Nom du titulaire de la carte bancaire : ");
        String nomTitulaire = scanner.nextLine();

        System.out.println("Date d'expiration de la carte bancaire : ");
        String dateExpiration = scanner.nextLine();

        if (numeroCarte.trim().isEmpty() || nomTitulaire.trim().isEmpty() || dateExpiration.trim().isEmpty()) {
            System.out.println("Veuillez remplir tous les champs de la carte bancaire.");
        } else {
            BankCard newBankCard = new BankCard(numeroCarte, nomTitulaire, dateExpiration);
            bankCards.add(newBankCard);
            System.out.println("Carte bancaire ajoutée avec succès.");
        }
    }

    private static void viewBankCards() {
        if (bankCards.isEmpty()) {
            System.out.println("Aucune carte bancaire enregistrée.");
        } else {
            System.out.println("Cartes bancaires disponibles :");
            for (BankCard card : bankCards) {
                System.out.println("Numéro : " + card.getNumero() + ", Titulaire : " + card.getNomTitulaire() +
                                   ", Expiration : " + card.getDateExpiration());
            }
        }
    }

    private static void deleteBankCard() {
        Scanner scanner = new Scanner(System.in);

        if (bankCards.isEmpty()) {
            System.out.println("Aucune carte bancaire enregistrée.");
        } else {
            System.out.println("Liste des numéros de carte bancaire :");
            for (BankCard card : bankCards) {
                System.out.println("Numéro : " + card.getNumero());
            }

            System.out.println("Numéro de la carte bancaire à supprimer (Appuyez sur Entrée pour annuler) : ");
            String cardToDelete = scanner.nextLine();

            if (cardToDelete.trim().isEmpty()) {
                System.out.println("Suppression annulée.");
            } else {
                int index = -1;

                for (int i = 0; i < bankCards.size(); i++) {
                    if (bankCards.get(i).getNumero().equals(cardToDelete)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    bankCards.remove(index);
                    System.out.println("Carte bancaire supprimée avec succès.");
                } else {
                    System.out.println("Carte bancaire non trouvée. Veuillez vérifier le numéro de carte.");
                }
            }
        }
    }

    public static class BankCard {
        private String numero;
        private String nomTitulaire;
        private String dateExpiration;

        public BankCard(String numero, String nomTitulaire, String dateExpiration) {
            this.numero = numero;
            this.nomTitulaire = nomTitulaire;
            this.dateExpiration = dateExpiration;
        }

        public String getNumero() {
            return numero;
        }

        public String getNomTitulaire() {
            return nomTitulaire;
        }

        public String getDateExpiration() {
            return dateExpiration;
        }
    }
}
