const prompt = require("prompt-sync")();
let solde = 200000;
let historiqueTransactions = [];

function isNumeric(value) {
    return !isNaN(parseFloat(value)) && isFinite(value);
}

function isPositiveNumeric(value) {
    return isNumeric(value) && parseFloat(value) > 0;
}

function manageMoney() {
    while (true) {
        let subMenu1 = +prompt("1. Versement 2. Retrait 3. Consultation du solde 4. Historique des transactions 5. Retour Choisissez une option : ");

        if (![1, 2, 3, 4, 5].includes(subMenu1)) {
            console.log("Veuillez saisir une option valable");
            continue;
        }

        if (subMenu1 === 1) {
            let versement = +prompt("Combien souhaitez-vous verser : ");
            if (isPositiveNumeric(versement)) {
                solde += versement;
                historiqueTransactions.push(`Versement de ${versement}`);
                console.log("Versement effectué avec succès !");
            } else {
                console.log("Veuillez entrer un montant valide.");
            }
        }
        else if (subMenu1 === 2) {
            let retrait = +prompt("Combien souhaitez-vous retirer : ");
            if (isPositiveNumeric(retrait)) {
                if (retrait > solde) {
                    console.log("Désolé, votre solde est insuffisant pour ce retrait");
                } else {
                    solde -= retrait;
                    historiqueTransactions.push(`Retrait de ${retrait}`);
                    console.log("Retrait effectué avec succès !");
                }
            } else {
                console.log("Veuillez entrer un montant valide.");
            }
        }
        else if (subMenu1 === 3) {
            console.log(`Votre solde est : ${solde}`);
        }
        else if (subMenu1 === 4) {
            console.log("Historique des transactions :");
            for (let transaction of historiqueTransactions) {
                console.log(transaction);
            }
        }
        else if (subMenu1 === 5) {
            console.log("Retour au menu principal.");
            break; 
        }
    }
}


module.exports = {
    manageMoney
};