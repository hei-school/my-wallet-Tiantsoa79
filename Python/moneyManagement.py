solde = 200000.0
historique_transactions = []

def is_numeric(value):
    return value.replace(".", "", 1).isdigit()

def is_positive_numeric(value):
    return is_numeric(value) and float(value) > 0

def manage_money():
    global solde  # Declare solde as a global variable
    global historique_transactions
    
    while True:
        sub_menu_1 = int(input("1. Versement 2. Retrait 3. Consultation du solde 4. Historique des transactions 5. Retour Choisissez une option : "))

        if sub_menu_1 not in [1, 2, 3, 4, 5]:
            print("Veuillez saisir une option valable")
            continue

        if sub_menu_1 == 1:
            versement = input("Combien souhaitez-vous verser : ")
            if is_positive_numeric(versement):
                solde += float(versement)
                historique_transactions.append(f"Versement de {versement}")
                print("Versement effectué avec succès !")
            else:
                print("Veuillez entrer un montant valide.")
        elif sub_menu_1 == 2:
            retrait = input("Combien souhaitez-vous retirer : ")
            if is_positive_numeric(retrait):
                if float(retrait) > solde:
                    print("Désolé, votre solde est insuffisant pour ce retrait")
                else:
                    solde -= float(retrait)
                    historique_transactions.append(f"Retrait de {retrait}")
                    print("Retrait effectué avec succès !")
            else:
                print("Veuillez entrer un montant valide.")
        elif sub_menu_1 == 3:
            print(f"Votre solde est : {solde}")
        elif sub_menu_1 == 4:
            print("Historique des transactions :")
            for transaction in historique_transactions:
                print(transaction)
        elif sub_menu_1 == 5:
            print("Retour au menu principal.")
            break


