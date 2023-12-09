const prompt = require("prompt-sync")();
let drivingLicenseInfo = null;

function manageDrivingLicense() {
    while (true) {
        let subMenuLicense = +prompt("Option de gestion du permis de conduire (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4. Retour) : ");

        if (![1, 2, 3, 4].includes(subMenuLicense)) {
            console.log("Veuillez saisir une option valable");
            continue;
        }

        if (subMenuLicense === 1) {
            if (drivingLicenseInfo == null) {
                console.log("Enregistrement des informations du permis de conduire...");

                let nomLicense = prompt("Nom sur le permis de conduire : ");
                let dateExpirationLicense = prompt("Date d'expiration du permis de conduire : ");
                let categoriesLicense = prompt("Catégories de permis de conduire : ");

                if (nomLicense.trim() === "" || dateExpirationLicense.trim() === "" || categoriesLicense.trim() === "") {
                    console.log("Veuillez remplir tous les champs du permis de conduire.");
                } else {
                    drivingLicenseInfo = {
                        nom: nomLicense,
                        dateExpiration: dateExpirationLicense,
                        categories: categoriesLicense,
                    };

                    console.log("Informations du permis de conduire enregistrées avec succès.");
                }
            } else {
                console.log("Des informations de permis de conduire existent déjà. Vous ne pouvez pas enregistrer de nouveau permis de conduire.");
            }
        }
        else if (subMenuLicense === 2) {
            if (drivingLicenseInfo != null) {
                console.log("Option de mise à jour du permis de conduire...");

                // Affichez les informations actuelles du permis de conduire
                console.log("Informations actuelles du permis de conduire :");
                console.log("Nom sur le permis de conduire : " + drivingLicenseInfo.nom);
                console.log("Date d'expiration du permis de conduire : " + drivingLicenseInfo.dateExpiration);
                console.log("Catégories de permis de conduire : " + drivingLicenseInfo.categories);

                // Collectez les nouvelles informations du permis de conduire
                let nouveauNomLicense = prompt("Nouveau nom sur le permis de conduire (Appuyez sur Entrée pour conserver l'ancien nom) : ") || drivingLicenseInfo.nom;
                let nouvelleDateExpirationLicense = prompt("Nouvelle date d'expiration du permis de conduire (Appuyez sur Entrée pour conserver l'ancienne date) : ") || drivingLicenseInfo.dateExpiration;
                let nouvellesCategoriesLicense = prompt("Nouvelles catégories de permis de conduire (Appuyez sur Entrée pour conserver les anciennes catégories) : ") || drivingLicenseInfo.categories;

                // Vérifiez que les champs ne sont pas vides
                if (nouveauNomLicense.trim() === "" || nouvelleDateExpirationLicense.trim() === "" || nouvellesCategoriesLicense.trim() === "") {
                    console.log("Veuillez remplir tous les champs du permis de conduire.");
                } else {
                    // Mettez à jour les informations du permis de conduire
                    drivingLicenseInfo.nom = nouveauNomLicense;
                    drivingLicenseInfo.dateExpiration = nouvelleDateExpirationLicense;
                    drivingLicenseInfo.categories = nouvellesCategoriesLicense;

                    console.log("Informations du permis de conduire mises à jour avec succès.");
                }
            } else {
                console.log("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.");
            }
        }
        else if (subMenuLicense === 3) {
            if (drivingLicenseInfo != null) {
                console.log("Consultation des informations du permis de conduire...");

                console.log("Informations actuelles du permis de conduire :");
                console.log("Nom sur le permis de conduire : " + drivingLicenseInfo.nom);
                console.log("Date d'expiration du permis de conduire : " + drivingLicenseInfo.dateExpiration);
                console.log("Catégories de permis de conduire : " + drivingLicenseInfo.categories);
            } else {
                console.log("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.");
            }
        }
        else if (subMenuLicense === 4) {
            console.log("Retour au menu principal.");
            break;
        }
    }
}


module.exports = {
    manageDrivingLicense
};