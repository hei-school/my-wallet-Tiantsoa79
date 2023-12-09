using System;
using System.Collections.Generic;

class Program
{
    static double solde = 200000;
    static List<string> historiqueTransactions = new List<string>();
    static Dictionary<string, string> cinInfo = null;
    static List<Dictionary<string, string>> bankCards = new List<Dictionary<string, string>>();
    static List<Dictionary<string, string>> visitCards = new List<Dictionary<string, string>>();
    static Dictionary<string, string> drivingLicenseInfo = null;

    static void Main()
    {
        bool exitMainMenu = false;

        while (!exitMainMenu)
        {
            Console.WriteLine(" Choisissez une option : ");
            Console.WriteLine("1. argent 2. CIN 3. cartes bancaires. 4. cartes de visite 5. Permis 6. Quitter.");

            if (!int.TryParse(Console.ReadLine(), out int menu) || menu < 1 || menu > 6)
            {
                Console.WriteLine("Veuillez saisir une option valable");
                continue;
            }

            switch (menu)
            {
                case 1:
                    ManageMoney();
                    break;
                case 2:
                    ManageCIN();
                    break;
                case 3:
                    ManageBankCards();
                    break;
                case 4:
                    ManageVisitCards();
                    break;
                case 5:
                    ManageDrivingLicense();
                    break;
                case 6:
                    exitMainMenu = true;
                    break;
            }
        }
    }

    static bool IsNumeric(string value)
    {
        return double.TryParse(value, out _);
    }

    static bool IsPositiveNumeric(string value)
    {
        return IsNumeric(value) && double.Parse(value) > 0;
    }

    static void ManageMoney()
    {
        while (true)
        {
            Console.WriteLine("1. Versement 2. Retrait 3. Consultation du solde 4. Historique des transactions 5. Retour Choisissez une option : ");

            if (!int.TryParse(Console.ReadLine(), out int subMenu1) || subMenu1 < 1 || subMenu1 > 5)
            {
                Console.WriteLine("Veuillez saisir une option valable");
                continue;
            }

            switch (subMenu1)
            {
                case 1:
                    Console.Write("Combien souhaitez-vous verser : ");
                    if (double.TryParse(Console.ReadLine(), out double versement) && IsPositiveNumeric(versement.ToString()))
                    {
                        solde += versement;
                        historiqueTransactions.Add($"Versement de {versement}");
                        Console.WriteLine("Versement effectué avec succès !");
                    }
                    else
                    {
                        Console.WriteLine("Veuillez entrer un montant valide.");
                    }
                    break;
                case 2:
                    Console.Write("Combien souhaitez-vous retirer : ");
                    if (double.TryParse(Console.ReadLine(), out double retrait) && IsPositiveNumeric(retrait.ToString()))
                    {
                        if (retrait > solde)
                        {
                            Console.WriteLine("Désolé, votre solde est insuffisant pour ce retrait");
                        }
                        else
                        {
                            solde -= retrait;
                            historiqueTransactions.Add($"Retrait de {retrait}");
                            Console.WriteLine("Retrait effectué avec succès !");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Veuillez entrer un montant valide.");
                    }
                    break;
                case 3:
                    Console.WriteLine($"Votre solde est : {solde}");
                    break;
                case 4:
                    Console.WriteLine("Historique des transactions :");
                    foreach (var transaction in historiqueTransactions)
                    {
                        Console.WriteLine(transaction);
                    }
                    break;
                case 5:
                    Console.WriteLine("Retour au menu principal.");
                    return;
            }
        }
    }

    static void ManageCIN()
    {
        while (true)
        {
            Console.WriteLine("Option de gestion du CIN (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4.Retour ) : ");

            if (!int.TryParse(Console.ReadLine(), out int subMenu2) || subMenu2 < 1 || subMenu2 > 4)
            {
                Console.WriteLine("Veuillez saisir une option valable");
                continue;
            }

            switch (subMenu2)
            {
                case 1:
                    if (cinInfo == null)
                    {
                        Console.WriteLine("Enregistrement des informations du CIN...");

                        Console.Write("Numéro du CIN : ");
                        string numeroCIN = Console.ReadLine();
                        Console.Write("Nom sur le CIN : ");
                        string nomCIN = Console.ReadLine();
                        Console.Write("Date de naissance sur le CIN : ");
                        string dateNaissanceCIN = Console.ReadLine();

                        if (string.IsNullOrWhiteSpace(numeroCIN) || string.IsNullOrWhiteSpace(nomCIN) || string.IsNullOrWhiteSpace(dateNaissanceCIN))
                        {
                            Console.WriteLine("Veuillez remplir tous les champs du CIN.");
                        }
                        else
                        {
                            cinInfo = new Dictionary<string, string>
                            {
                                { "numero", numeroCIN },
                                { "nom", nomCIN },
                                { "dateNaissance", dateNaissanceCIN }
                            };

                            Console.WriteLine("Informations du CIN enregistrées avec succès.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Des informations de CIN existent déjà. Vous ne pouvez pas enregistrer de nouveau CIN.");
                    }
                    break;
                case 2:
                    if (cinInfo != null)
                    {
                        Console.WriteLine("Option de mise à jour et de renouvellement du CIN...");

                        Console.WriteLine("Informations actuelles du CIN :");
                        Console.WriteLine($"Numéro du CIN : {cinInfo["numero"]}");
                        Console.WriteLine($"Nom sur le CIN : {cinInfo["nom"]}");
                        Console.WriteLine($"Date de naissance sur le CIN : {cinInfo["dateNaissance"]}");

                        Console.Write("Nouveau numéro du CIN : ");
                        string nouveauNumeroCIN = Console.ReadLine();
                        Console.Write("Nouveau nom sur le CIN : ");
                        string nouveauNomCIN = Console.ReadLine();
                        Console.Write("Nouvelle date de naissance sur le CIN  : ");
                        string nouvelleDateNaissanceCIN = Console.ReadLine();

                        if (string.IsNullOrWhiteSpace(nouveauNumeroCIN) || string.IsNullOrWhiteSpace(nouveauNomCIN) || string.IsNullOrWhiteSpace(nouvelleDateNaissanceCIN))
                        {
                            Console.WriteLine("Veuillez remplir tous les champs du CIN.");
                        }
                        else
                        {
                            cinInfo["numero"] = nouveauNumeroCIN;
                            cinInfo["nom"] = nouveauNomCIN;
                            cinInfo["dateNaissance"] = nouvelleDateNaissanceCIN;

                            Console.WriteLine("Informations du CIN mises à jour avec succès.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.");
                    }
                    break;
                case 3:
                    if (cinInfo != null)
                    {
                        Console.WriteLine("Consultation des informations du CIN...");

                        Console.WriteLine("Informations actuelles du CIN :");
                        Console.WriteLine($"Numéro du CIN : {cinInfo["numero"]}");
                        Console.WriteLine($"Nom sur le CIN : {cinInfo["nom"]}");
                        Console.WriteLine($"Date de naissance sur le CIN : {cinInfo["dateNaissance"]}");
                    }
                    else
                    {
                        Console.WriteLine("Aucune information de CIN existante. Veuillez enregistrer des informations de CIN d'abord.");
                    }
                    break;
                case 4:
                    Console.WriteLine("Retour au menu principal.");
                    return;
            }
        }
    }

    static void ManageBankCards()
    {
        while (true)
        {
            Console.WriteLine("Option de gestion des cartes bancaires (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : ");

            if (!int.TryParse(Console.ReadLine(), out int subMenuCards) || subMenuCards < 1 || subMenuCards > 4)
            {
                Console.WriteLine("Veuillez saisir une option valable");
                continue;
            }

            switch (subMenuCards)
            {
                case 1:
                    Console.Write("Numéro de la carte bancaire : ");
                    string numeroCarte = Console.ReadLine();
                    Console.Write("Nom du titulaire de la carte bancaire : ");
                    string nomTitulaire = Console.ReadLine();
                    Console.Write("Date d'expiration de la carte bancaire : ");
                    string dateExpiration = Console.ReadLine();

                    if (string.IsNullOrWhiteSpace(numeroCarte) || string.IsNullOrWhiteSpace(nomTitulaire) || string.IsNullOrWhiteSpace(dateExpiration))
                    {
                        Console.WriteLine("Veuillez remplir tous les champs de la carte bancaire.");
                    }
                    else
                    {
                        Dictionary<string, string> newBankCard = new Dictionary<string, string>
                        {
                            { "numero", numeroCarte },
                            { "nomTitulaire", nomTitulaire },
                            { "dateExpiration", dateExpiration }
                        };

                        bankCards.Add(newBankCard);
                        Console.WriteLine("Carte bancaire ajoutée avec succès.");
                    }
                    break;
                case 2:
                    if (bankCards.Count > 0)
                    {
                        Console.WriteLine("Cartes bancaires disponibles :");
                        foreach (var card in bankCards)
                        {
                            Console.WriteLine($"Numéro : {card["numero"]}, Titulaire : {card["nomTitulaire"]}, Expiration : {card["dateExpiration"]}");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Aucune carte bancaire enregistrée.");
                    }
                    break;
                case 3:
                    if (bankCards.Count > 0)
                    {
                        Console.WriteLine("Liste des numéros de carte bancaire :");
                        foreach (var card in bankCards)
                        {
                            Console.WriteLine($"Numéro : {card["numero"]}");
                        }

                        Console.Write("Numéro de la carte bancaire à supprimer (Appuyez sur Entrée pour annuler) : ");
                        string cardToDelete = Console.ReadLine();

                        if (string.IsNullOrWhiteSpace(cardToDelete))
                        {
                            Console.WriteLine("Suppression annulée.");
                            continue;
                        }

                        int index = bankCards.FindIndex(card => card["numero"] == cardToDelete);

                        if (index != -1)
                        {
                            bankCards.RemoveAt(index);
                            Console.WriteLine("Carte bancaire supprimée avec succès.");
                        }
                        else
                        {
                            Console.WriteLine("Carte bancaire non trouvée. Veuillez vérifier le numéro de carte.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("Aucune carte bancaire enregistrée.");
                    }
                    break;
                case 4:
                    Console.WriteLine("Retour au menu précédent.");
                    return;
            }
        }
    }

    static void ManageVisitCards()
{
    while (true)
    {
        Console.WriteLine("Option de gestion des cartes de visite (1. Ajouter, 2. Consulter, 3. Supprimer, 4. Retour) : ");

        if (!int.TryParse(Console.ReadLine(), out int subMenuVisitCards) || subMenuVisitCards < 1 || subMenuVisitCards > 4)
        {
            Console.WriteLine("Veuillez saisir une option valable");
            continue;
        }

        switch (subMenuVisitCards)
        {
            case 1:
                Console.Write("Nom sur la carte de visite : ");
                string nom = Console.ReadLine();
                Console.Write("Prénom sur la carte de visite : ");
                string prenom = Console.ReadLine();
                Console.Write("Entreprise sur la carte de visite : ");
                string entreprise = Console.ReadLine();
                Console.Write("Numéro de téléphone sur la carte de visite : ");
                string telephone = Console.ReadLine();

                if (string.IsNullOrWhiteSpace(nom) || string.IsNullOrWhiteSpace(prenom) || string.IsNullOrWhiteSpace(entreprise) || string.IsNullOrWhiteSpace(telephone))
                {
                    Console.WriteLine("Veuillez remplir tous les champs de la carte de visite.");
                }
                else
                {
                    Dictionary<string, string> newVisitCard = new Dictionary<string, string>
                    {
                        { "nom", nom },
                        { "prenom", prenom },
                        { "entreprise", entreprise },
                        { "telephone", telephone }
                    };

                    visitCards.Add(newVisitCard);
                    Console.WriteLine("Carte de visite ajoutée avec succès.");
                }
                break;
            case 2:
                if (visitCards.Count > 0)
                {
                    Console.WriteLine("Cartes de visite enregistrées :");
                    foreach (var card in visitCards)
                    {
                        Console.WriteLine($"Nom : {card["nom"]}, Prénom : {card["prenom"]}, Entreprise : {card["entreprise"]}, Téléphone : {card["telephone"]}");
                    }
                }
                else
                {
                    Console.WriteLine("Aucune carte de visite enregistrée.");
                }
                break;
            case 3:
                if (visitCards.Count > 0)
                {
                    foreach (var card in visitCards)
                    {
                        Console.WriteLine($"Nom : {card["nom"]}, Prénom : {card["prenom"]}, Entreprise : {card["entreprise"]}, Téléphone : {card["telephone"]}");
                    }

                    Console.Write("Nom de la carte de visite à supprimer (Appuyez sur Entrée pour annuler) : ");
                    string cardToDelete = Console.ReadLine();

                    if (string.IsNullOrWhiteSpace(cardToDelete))
                    {
                        Console.WriteLine("Suppression annulée.");
                        continue;
                    }

                    int index = visitCards.FindIndex(card => card["nom"] == cardToDelete);

                    if (index != -1)
                    {
                        visitCards.RemoveAt(index);
                        Console.WriteLine("Carte de visite supprimée avec succès.");
                    }
                    else
                    {
                        Console.WriteLine("Carte de visite non trouvée. Veuillez vérifier le nom de la carte.");
                    }
                }
                else
                {
                    Console.WriteLine("Aucune carte de visite enregistrée.");
                }
                break;
            case 4:
                Console.WriteLine("Retour au menu précédent.");
                return;
        }
    }
}

    static void ManageDrivingLicense()
{
    while (true)
    {
        Console.WriteLine("Option de gestion du permis de conduire (1. Enregistrement, 2. Mise à jour, 3. Consultation, 4. Retour) : ");

        if (!int.TryParse(Console.ReadLine(), out int subMenuLicense) || subMenuLicense < 1 || subMenuLicense > 4)
        {
            Console.WriteLine("Veuillez saisir une option valable");
            continue;
        }

        switch (subMenuLicense)
        {
            case 1:
                if (drivingLicenseInfo == null)
                {
                    Console.WriteLine("Enregistrement des informations du permis de conduire...");

                    Console.Write("Nom sur le permis de conduire : ");
                    string nomLicense = Console.ReadLine();
                    Console.Write("Date d'expiration du permis de conduire : ");
                    string dateExpirationLicense = Console.ReadLine();
                    Console.Write("Catégories de permis de conduire : ");
                    string categoriesLicense = Console.ReadLine();

                    if (string.IsNullOrWhiteSpace(nomLicense) || string.IsNullOrWhiteSpace(dateExpirationLicense) || string.IsNullOrWhiteSpace(categoriesLicense))
                    {
                        Console.WriteLine("Veuillez remplir tous les champs du permis de conduire.");
                    }
                    else
                    {
                        drivingLicenseInfo = new Dictionary<string, string>
                        {
                            { "nom", nomLicense },
                            { "dateExpiration", dateExpirationLicense },
                            { "categories", categoriesLicense }
                        };

                        Console.WriteLine("Informations du permis de conduire enregistrées avec succès.");
                    }
                }
                else
                {
                    Console.WriteLine("Des informations de permis de conduire existent déjà. Vous ne pouvez pas enregistrer de nouveau permis de conduire.");
                }
                break;
            case 2:
                if (drivingLicenseInfo != null)
                {
                    Console.WriteLine("Option de mise à jour du permis de conduire...");

                    // Affichez les informations actuelles du permis de conduire
                    Console.WriteLine("Informations actuelles du permis de conduire :");
                    Console.WriteLine("Nom sur le permis de conduire : " + drivingLicenseInfo["nom"]);
                    Console.WriteLine("Date d'expiration du permis de conduire : " + drivingLicenseInfo["dateExpiration"]);
                    Console.WriteLine("Catégories de permis de conduire : " + drivingLicenseInfo["categories"]);

                    // Collectez les nouvelles informations du permis de conduire
                    Console.Write("Nouveau nom sur le permis de conduire: ");
                    string nouveauNomLicense = Console.ReadLine();
                    Console.Write("Nouvelle date d'expiration du permis de conduire  : ");
                    string nouvelleDateExpirationLicense = Console.ReadLine();
                    Console.Write("Nouvelles catégories de permis de conduire  : ");
                    string nouvellesCategoriesLicense = Console.ReadLine();

                    // Vérifiez que les champs ne sont pas vides
                    if (string.IsNullOrWhiteSpace(nouveauNomLicense) || string.IsNullOrWhiteSpace(nouvelleDateExpirationLicense) || string.IsNullOrWhiteSpace(nouvellesCategoriesLicense))
                    {
                        Console.WriteLine("Veuillez remplir tous les champs du permis de conduire.");
                    }
                    else
                    {
                        // Mettez à jour les informations du permis de conduire
                        drivingLicenseInfo["nom"] = nouveauNomLicense;
                        drivingLicenseInfo["dateExpiration"] = nouvelleDateExpirationLicense;
                        drivingLicenseInfo["categories"] = nouvellesCategoriesLicense;

                        Console.WriteLine("Informations du permis de conduire mises à jour avec succès.");
                    }
                }
                else
                {
                    Console.WriteLine("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.");
                }
                break;
            case 3:
                if (drivingLicenseInfo != null)
                {
                    Console.WriteLine("Consultation des informations du permis de conduire...");

                    Console.WriteLine("Informations actuelles du permis de conduire :");
                    Console.WriteLine("Nom sur le permis de conduire : " + drivingLicenseInfo["nom"]);
                    Console.WriteLine("Date d'expiration du permis de conduire : " + drivingLicenseInfo["dateExpiration"]);
                    Console.WriteLine("Catégories de permis de conduire : " + drivingLicenseInfo["categories"]);
                }
                else
                {
                    Console.WriteLine("Aucune information de permis de conduire existante. Veuillez enregistrer des informations de permis de conduire d'abord.");
                }
                break;
            case 4:
                Console.WriteLine("Retour au menu principal.");
                return;
        }
    }
}

 
}
