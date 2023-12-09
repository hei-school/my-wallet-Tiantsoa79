const prompt = require("prompt-sync")();
let cinInfo = null; 

function manageCIN() {
    while (true) {
        let subMenu2 = +prompt("Option de gestion du CIN (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4.Retour ) : ");

        if (![1, 2, 3, 4, 5].includes(subMenu2)) {
            console.log("Veuillez saisir une option valable");
            continue;
        }
        if (subMenu2 === 1) {
            if (cinInfo == null) {
                console.log("Enregistrement des informations du CIN...");
        
                let numeroCIN = prompt("Numéro du CIN : ");
                let nomCIN = prompt("Nom sur le CIN : ");
                let dateNaissanceCIN = prompt("Date de naissance sur le CIN : ");
        
                if (numeroCIN.trim() === "" || nomCIN.trim() === "" || dateNaissanceCIN.trim() === "") {
                    console.log("Veuillez remplir tous les champs du CIN.");
                } else {
                    cinInfo = {
                        numero: numeroCIN,
                        nom: nomCIN,
                        dateNaissance: dateNaissanceCIN,
                    };
        
                    console.log("Informations du CIN enregistrées avec succès.");
                }
            } else {
                console.log("Des informations de CIN existent déjà. Vous ne pouvez pas enregistrer de nouveau CIN.");
            }
        }              
        else if (subMenu2 === 2) {
            if (cinInfo != null) {
                console.log("Option de mise à jour et de renouvellement du CIN...");
        
                // Affichez les informations actuelles du CIN
                console.log("Informations actuelles du CIN :");
                console.log("Numéro du CIN : " + cinInfo.numero);
                console.log("Nom sur le CIN : " + cinInfo.nom);
                console.log("Date de naissance sur le CIN : " + cinInfo.dateNaissance);
        
                // Collectez les nouvelles informations du CIN
                let nouveauNumeroCIN = prompt("Nouveau numéro du CIN (Appuyez sur Entrée pour conserver l'ancien numéro) : ") || cinInfo.numero;
                let nouveauNomCIN = prompt("Nouveau nom sur le CIN (Appuyez sur Entrée pour conserver l'ancien nom) : ") || cinInfo.nom;
                let nouvelleDateNaissanceCIN = prompt("Nouvelle date de naissance sur le CIN (Appuyez sur Entrée pour conserver l'ancienne date) : ") || cinInfo.dateNaissance;
        
                // Vérifiez que les champs ne sont pas vides
                if (nouveauNumeroCIN.trim() === "" || nouveauNomCIN.trim() === "" || nouvelleDateNaissanceCIN.trim() === "") {
                    console.log("Veuillez remplir tous les champs du CIN.");
                } else {
                    // Mettez à jour les informations du CIN
                    cinInfo.numero = nouveauNumeroCIN;
                    cinInfo.nom = nouveauNomCIN;
                    cinInfo.dateNaissance = nouvelleDateNaissanceCIN;
                    // Mettez à jour d'autres champs si nécessaire
        
                    console.log("Informations du CIN mises à jour avec succès.");
                }
            } else {
                console.log("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.");
            }
        } 
        else if (subMenu2 === 3) {
            if (cinInfo != null) {
                console.log("Consultation des informations du CIN...");
        
                console.log("Informations actuelles du CIN :");
                console.log("Numéro du CIN : " + cinInfo.numero);
                console.log("Nom sur le CIN : " + cinInfo.nom);
                console.log("Date de naissance sur le CIN : " + cinInfo.dateNaissance);
            } else {
                console.log("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.");
            }
        }        
        else if (subMenu2 === 4) {
            console.log("Retour au menu principal.");
            break;
        }
    }
}

module.exports = {
    manageCIN
};
