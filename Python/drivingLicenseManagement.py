driving_license_info = None

def manage_driving_license():
    global driving_license_info
    
    while True:
        sub_menu_license = int(input("Option de gestion du permis de conduire (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4. Retour) : "))

        if sub_menu_license not in [1, 2, 3, 4]:
            print("Veuillez saisir une option valable")
            continue

        if sub_menu_license == 1:
            if driving_license_info is None:
                print("Enregistrement des informations du permis de conduire...")

                nom_license = input("Nom sur le permis de conduire : ")
                date_expiration_license = input("Date d'expiration du permis de conduire : ")
                categories_license = input("Catégories de permis de conduire : ")

                if nom_license.strip() == "" or date_expiration_license.strip() == "" or categories_license.strip() == "":
                    print("Veuillez remplir tous les champs du permis de conduire.")
                else:
                    driving_license_info = {
                        "nom": nom_license,
                        "date_expiration": date_expiration_license,
                        "categories": categories_license,
                    }

                    print("Informations du permis de conduire enregistrées avec succès.")
            else:
                print("Des informations de permis de conduire existent déjà. Vous ne pouvez pas enregistrer de nouveau permis de conduire.")
        elif sub_menu_license == 2:
            if driving_license_info is not None:
                print("Option de mise à jour du permis de conduire...")

                # Affichez les informations actuelles du permis de conduire
                print("Informations actuelles du permis de conduire :")
                print("Nom sur le permis de conduire : " + driving_license_info["nom"])
                print("Date d'expiration du permis de conduire : " + driving_license_info["date_expiration"])
                print("Catégories de permis de conduire : " + driving_license_info["categories"])

                # Collectez les nouvelles informations du permis de conduire
                nouveau_nom_license = input("Nouveau nom sur le permis de conduire (Appuyez sur Entrée pour conserver l'ancien nom) : ") or driving_license_info["nom"]
                nouvelle_date_expiration_license = input("Nouvelle date d'expiration du permis de conduire (Appuyez sur Entrée pour conserver l'ancienne date) : ") or driving_license_info["date_expiration"]
                nouvelles_categories_license = input("Nouvelles catégories de permis de conduire (Appuyez sur Entrée pour conserver les anciennes catégories) : ") or driving_license_info["categories"]

                # Vérifiez que les champs ne sont pas vides
                if nouveau_nom_license.strip() == "" or nouvelle_date_expiration_license.strip() == "" or nouvelles_categories_license.strip() == "":
                    print("Veuillez remplir tous les champs du permis de conduire.")
                else:
                    # Mettez à jour les informations du permis de conduire
                    driving_license_info["nom"] = nouveau_nom_license
                    driving_license_info["date_expiration"] = nouvelle_date_expiration_license
                    driving_license_info["categories"] = nouvelles_categories_license

                    print("Informations du permis de conduire mises à jour avec succès.")
            else:
                print("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.")
        elif sub_menu_license == 3:
            if driving_license_info is not None:
                print("Consultation des informations du permis de conduire...")

                print("Informations actuelles du permis de conduire :")
                print("Nom sur le permis de conduire : " + driving_license_info["nom"])
                print("Date d'expiration du permis de conduire : " + driving_license_info["date_expiration"])
                print("Catégories de permis de conduire : " + driving_license_info["categories"])
            else:
                print("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.")
        elif sub_menu_license == 4:
            print("Retour au menu principal.")
            break

if __name__ == "__main__":
    manage_driving_license()
