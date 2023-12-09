const prompt = require("prompt-sync")();
let visitCards = [];

function manageVisitCards() {

    while (true) {
        let subMenuVisitCards = +prompt("Option de gestion des cartes de visite (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : ");

        if (![1, 2, 3, 4].includes(subMenuVisitCards)) {
            console.log("Veuillez saisir une option valable");
            continue;
        }

        if (subMenuVisitCards === 1) {
            // Ajout d'une carte de visite
            let nom = prompt("Nom sur la carte de visite : ");
            let prenom = prompt("Prénom sur la carte de visite : ");
            let entreprise = prompt("Entreprise sur la carte de visite : ");
            let telephone = prompt("Numéro de téléphone sur la carte de visite : ");

            if (nom.trim() === "" || prenom.trim() === "" || entreprise.trim() === "" || telephone.trim() === "") {
                console.log("Veuillez remplir tous les champs de la carte de visite.");
            } else {
                let newVisitCard = {
                    nom: nom,
                    prenom: prenom,
                    entreprise: entreprise,
                    telephone: telephone,
                };

                visitCards.push(newVisitCard);
                console.log("Carte de visite ajoutée avec succès.");
            }
        } else if (subMenuVisitCards === 2) {
            // Consultation des cartes de visite
            if (visitCards.length > 0) {
                console.log("Cartes de visite enregistrées :");
                for (let card of visitCards) {
                    console.log(`Nom : ${card.nom}, Prénom : ${card.prenom}, Entreprise : ${card.entreprise}, Téléphone : ${card.telephone}`);
                }
            } else {
                console.log("Aucune carte de visite enregistrée.");
            }
        } else if (subMenuVisitCards === 3) {
            // Suppression d'une carte de visite
            if (visitCards.length > 0) {
                for (let card of visitCards) {
                    console.log(`Nom : ${card.nom}, Prénom : ${card.prenom}, Entreprise : ${card.entreprise}, Téléphone : ${card.telephone}`);
                }

                let cardToDelete = prompt("Nom de la carte de visite à supprimer (Appuyez sur Entrée pour annuler) : ");
                if (cardToDelete.trim() === "") {
                    console.log("Suppression annulée.");
                    continue;
                }
                let index = visitCards.findIndex(card => card.nom === cardToDelete);

                if (index !== -1) {
                    visitCards.splice(index, 1);
                    console.log("Carte de visite supprimée avec succès.");
                } else {
                    console.log("Carte de visite non trouvée. Veuillez vérifier le nom de la carte.");
                }
            } else {
                console.log("Aucune carte de visite enregistrée.");
            }
        } else if (subMenuVisitCards === 4) {
            console.log("Retour au menu précédent.");
            break;
        }
    }
}

module.exports = {
    manageVisitCards
};