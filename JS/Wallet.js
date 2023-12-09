const prompt = require("prompt-sync")();
const moneyManagement = require('./moneyManagement');
const cinManagement = require('./cinManagement');
const bankCardManagement = require('./bankCardManagement');
const visitCardManagement = require('./visitCardManagement');
const drivingLicenseManagement = require('./drivingLicenseManagement');

let exitMainMenu = false;

while (!exitMainMenu) {
    console.log(" Choisissez une option : ");
    let menu = +prompt("1. argent 2. CIN 3. cartes bancaires. 4. cartes de visite 5. Permis 6. Quitter.");

    if (![1, 2, 3, 4, 5, 6].includes(menu)) {
        console.log("Veuillez saisir une option valable");
        continue;
    }

    if (menu === 1) {
        moneyManagement.manageMoney();
    }
    else if (menu === 2) {
        cinManagement.manageCIN();
    }
    else if (menu === 3) {
        bankCardManagement.manageBankCards();
    }
    else if (menu === 4) {
        visitCardManagement.manageVisitCards();
    }
    else if (menu === 5) {
        drivingLicenseManagement.manageDrivingLicense();
    }
    else if (menu === 6) {
        break;
    }
}

