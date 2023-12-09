const prompt = require("prompt-sync")();
let bankCards = [];

function manageBankCards() {

    while (true) {
        let subMenuCards = +prompt("Option de gestion des cartes bancaires (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : ");

        if (![1, 2, 3, 4].includes(subMenuCards)) {
            console.log("Veuillez saisir une option valable");
            continue;
        }

        if (subMenuCards === 1) {
 
            let numeroCarte = prompt("Numéro de la carte bancaire : ");
            let nomTitulaire = prompt("Nom du titulaire de la carte bancaire : ");
            let dateExpiration = prompt("Date d'expiration de la carte bancaire : ");

            if (numeroCarte.trim() === "" || nomTitulaire.trim() === "" || dateExpiration.trim() === "") {
                console.log("Veuillez remplir tous les champs de la carte bancaire.");
            } else {
                let newBankCard = {
                    numero: numeroCarte,
                    nomTitulaire: nomTitulaire,
                    dateExpiration: dateExpiration,
                };

                bankCards.push(newBankCard);
                console.log("Carte bancaire ajoutée avec succès.");
            }
        } else if (subMenuCards === 2) {
          
            if (bankCards.length > 0) {
                console.log("Cartes bancaires disponibles :");
                for (let card of bankCards) {
                    console.log(`Numéro : ${card.numero}, Titulaire : ${card.nomTitulaire}, Expiration : ${card.dateExpiration}`);
                }
            } else {
                console.log("Aucune carte bancaire enregistrée.");
            }
        } else if (subMenuCards === 3) {
            // Suppression d'une carte bancaire
            if (bankCards.length > 0) {
                console.log("Liste des numéros de carte bancaire :");
                for (let card of bankCards) {
                    console.log(`Numéro : ${card.numero}`);
                }
        
                let cardToDelete = prompt("Numéro de la carte bancaire à supprimer (Appuyez sur Entrée pour annuler) : ");
        
                if (cardToDelete.trim() === "") {
                    console.log("Suppression annulée.");
                    continue;
                }
        
                let index = -1;
        
                for (let i = 0; i < bankCards.length; i++) {
                    if (bankCards[i].numero === cardToDelete) {
                        index = i;
                        break;
                    }
                }
        
                if (index !== -1) {
                    bankCards.splice(index, 1);
                    console.log("Carte bancaire supprimée avec succès.");
                } else {
                    console.log("Carte bancaire non trouvée. Veuillez vérifier le numéro de carte.");
                }
            } else {
                console.log("Aucune carte bancaire enregistrée.");
            }
        } else if (subMenuCards === 4) {
            console.log("Retour au menu précédent.");
            break;
        }
    }
}

module.exports = {
    manageBankCards
};