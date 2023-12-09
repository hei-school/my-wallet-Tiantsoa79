bank_cards = []

def manage_bank_cards():
    while True:
        sub_menu_cards = int(input("Option de gestion des cartes bancaires (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : "))

        if sub_menu_cards not in [1, 2, 3, 4]:
            print("Veuillez saisir une option valable")
            continue

        if sub_menu_cards == 1:
            numero_carte = input("Numéro de la carte bancaire : ")
            nom_titulaire = input("Nom du titulaire de la carte bancaire : ")
            date_expiration = input("Date d'expiration de la carte bancaire : ")

            if numero_carte.strip() == "" or nom_titulaire.strip() == "" or date_expiration.strip() == "":
                print("Veuillez remplir tous les champs de la carte bancaire.")
            else:
                new_bank_card = {
                    "numero": numero_carte,
                    "nom_titulaire": nom_titulaire,
                    "date_expiration": date_expiration,
                }

                bank_cards.append(new_bank_card)
                print("Carte bancaire ajoutée avec succès.")
        elif sub_menu_cards == 2:
            if bank_cards:
                print("Cartes bancaires disponibles :")
                for card in bank_cards:
                    print(f"Numéro : {card['numero']}, Titulaire : {card['nom_titulaire']}, Expiration : {card['date_expiration']}")
            else:
                print("Aucune carte bancaire enregistrée.")
        elif sub_menu_cards == 3:
            if bank_cards:
                print("Liste des numéros de carte bancaire :")
                for card in bank_cards:
                    print(f"Numéro : {card['numero']}")
        
                card_to_delete = input("Numéro de la carte bancaire à supprimer (Appuyez sur Entrée pour annuler) : ")
        
                if card_to_delete.strip() == "":
                    print("Suppression annulée.")
                    continue
        
                index = next((i for i, card in enumerate(bank_cards) if card["numero"] == card_to_delete), -1)
        
                if index != -1:
                    bank_cards.pop(index)
                    print("Carte bancaire supprimée avec succès.")
                else:
                    print("Carte bancaire non trouvée. Veuillez vérifier le numéro de carte.")
            else:
                print("Aucune carte bancaire enregistrée.")
        elif sub_menu_cards == 4:
            print("Retour au menu précédent.")
            break

if __name__ == "__main__":
    manage_bank_cards()
