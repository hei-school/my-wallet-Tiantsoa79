visit_cards = []

def manage_visit_cards():
    global visit_cards
    
    while True:
        sub_menu_visit_cards = int(input("Option de gestion des cartes de visite (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : "))

        if sub_menu_visit_cards not in [1, 2, 3, 4]:
            print("Veuillez saisir une option valable")
            continue

        if sub_menu_visit_cards == 1:
            # Ajout d'une carte de visite
            nom = input("Nom sur la carte de visite : ")
            prenom = input("Prénom sur la carte de visite : ")
            entreprise = input("Entreprise sur la carte de visite : ")
            telephone = input("Numéro de téléphone sur la carte de visite : ")

            if nom.strip() == "" or prenom.strip() == "" or entreprise.strip() == "" or telephone.strip() == "":
                print("Veuillez remplir tous les champs de la carte de visite.")
            else:
                new_visit_card = {
                    "nom": nom,
                    "prenom": prenom,
                    "entreprise": entreprise,
                    "telephone": telephone,
                }

                visit_cards.append(new_visit_card)
                print("Carte de visite ajoutée avec succès.")
        elif sub_menu_visit_cards == 2:
            # Consultation des cartes de visite
            if visit_cards:
                print("Cartes de visite enregistrées :")
                for card in visit_cards:
                    print(f"Nom : {card['nom']}, Prénom : {card['prenom']}, Entreprise : {card['entreprise']}, Téléphone : {card['telephone']}")
            else:
                print("Aucune carte de visite enregistrée.")
        elif sub_menu_visit_cards == 3:
            # Suppression d'une carte de visite
            if visit_cards:
                for card in visit_cards:
                    print(f"Nom : {card['nom']}, Prénom : {card['prenom']}, Entreprise : {card['entreprise']}, Téléphone : {card['telephone']}")

                card_to_delete = input("Nom de la carte de visite à supprimer (Appuyez sur Entrée pour annuler) : ")
                if card_to_delete.strip() == "":
                    print("Suppression annulée.")
                    continue
                index = next((i for i, card in enumerate(visit_cards) if card["nom"] == card_to_delete), -1)

                if index != -1:
                    visit_cards.pop(index)
                    print("Carte de visite supprimée avec succès.")
                else:
                    print("Carte de visite non trouvée. Veuillez vérifier le nom de la carte.")
            else:
                print("Aucune carte de visite enregistrée.")
        elif sub_menu_visit_cards == 4:
            print("Retour au menu précédent.")
            break

if __name__ == "__main__":
    manage_visit_cards()
