from moneyManagement import manage_money
from cinManagement import manage_cin
from bankCardManagement import manage_bank_cards
from visitCardManagement import manage_visit_cards
from drivingLicenseManagement import manage_driving_license

exit_main_menu = False

while not exit_main_menu:
    print(" Choisissez une option : ")
    menu = int(input("1. argent 2. CIN 3. cartes bancaires. 4. cartes de visite 5. Permis 6. Quitter."))

    if menu not in [1, 2, 3, 4, 5, 6]:
        print("Veuillez saisir une option valable")
        continue

    if menu == 1:
        manage_money()
    elif menu == 2:
        manage_cin()
    elif menu == 3:
        manage_bank_cards()
    elif menu == 4:
        manage_visit_cards()
    elif menu == 5:
        manage_driving_license()
    elif menu == 6:
        exit_main_menu = True
