cin_info = None

def manage_cin():
    global cin_info

    while True:
        sub_menu_2 = int(input("Option de gestion du CIN (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4.Retour ) : "))

        if sub_menu_2 not in [1, 2, 3, 4]:
            print("Veuillez saisir une option valable")
            continue

        if sub_menu_2 == 1:
            if cin_info is None:
                print("Enregistrement des informations du CIN...")

                numero_cin = input("Numéro du CIN : ")
                nom_cin = input("Nom sur le CIN : ")
                date_naissance_cin = input("Date de naissance sur le CIN : ")

                if numero_cin.strip() == "" or nom_cin.strip() == "" or date_naissance_cin.strip() == "":
                    print("Veuillez remplir tous les champs du CIN.")
                else:
                    cin_info = {
                        "numero": numero_cin,
                        "nom": nom_cin,
                        "date_naissance": date_naissance_cin,
                    }

                    print("Informations du CIN enregistrées avec succès.")
            else:
                print("Des informations de CIN existent déjà. Vous ne pouvez pas enregistrer de nouveau CIN.")
        elif sub_menu_2 == 2:
            if cin_info is not None:
                print("Option de mise à jour et de renouvellement du CIN...")

                # Affichez les informations actuelles du CIN
                print("Informations actuelles du CIN :")
                print("Numéro du CIN : " + cin_info["numero"])
                print("Nom sur le CIN : " + cin_info["nom"])
                print("Date de naissance sur le CIN : " + cin_info["date_naissance"])

                # Collectez les nouvelles informations du CIN
                nouveau_numero_cin = input("Nouveau numéro du CIN (Appuyez sur Entrée pour conserver l'ancien numéro) : ") or cin_info["numero"]
                nouveau_nom_cin = input("Nouveau nom sur le CIN (Appuyez sur Entrée pour conserver l'ancien nom) : ") or cin_info["nom"]
                nouvelle_date_naissance_cin = input("Nouvelle date de naissance sur le CIN (Appuyez sur Entrée pour conserver l'ancienne date) : ") or cin_info["date_naissance"]

                # Vérifiez que les champs ne sont pas vides
                if nouveau_numero_cin.strip() == "" or nouveau_nom_cin.strip() == "" or nouvelle_date_naissance_cin.strip() == "":
                    print("Veuillez remplir tous les champs du CIN.")
                else:
                    # Mettez à jour les informations du CIN
                    cin_info["numero"] = nouveau_numero_cin
                    cin_info["nom"] = nouveau_nom_cin
                    cin_info["date_naissance"] = nouvelle_date_naissance_cin
                    # Mettez à jour d'autres champs si nécessaire

                    print("Informations du CIN mises à jour avec succès.")
            else:
                print("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.")
        elif sub_menu_2 == 3:
            if cin_info is not None:
                print("Consultation des informations du CIN...")

                print("Informations actuelles du CIN :")
                print("Numéro du CIN : " + cin_info["numero"])
                print("Nom sur le CIN : " + cin_info["nom"])
                print("Date de naissance sur le CIN : " + cin_info["date_naissance"])
            else:
                print("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.")
        elif sub_menu_2 == 4:
            print("Retour au menu principal.")
            break
