package leSuperCoin.resources;

import java.awt.*;

public class Globals {

    public static class Colors {
        public static final Color NOIR = new Color(29, 29, 29);
        public static final Color GRIS_FONCE = new Color(129, 129, 129);
        public static final Color GRIS_CLAIR = new Color(229, 229, 229);
        public static final Color BLANC = new Color(255, 255, 255);
        public static final Color BLEU = new Color(29, 129, 197);
    }

    public static class Constans {
        public static final String NOM_APPLI = "Le Super Coin";
        public static final String DEPOT_ANNONCE_BTN = "Déposer une annonce";
        public static final String MON_COMPTE_BTN = "Mon compte";
        public static final String LANCER_RECHERCHE = "Lancer la recherche";
        public static final String CHAMPS_RECHERCHE = "Que cherchez-vous ?";
        public static final String TITRE_DESCRIPTION = "Description";
        public static final String TITRE_DEPOT_ANNONCE = "Déposer une annonce";
        public static final String ETAPE_SUIVANTE = "Étape suivante >";
        public static final String ETAPE_CATEGORIE = "Choisir une catégorie";
        public static final String ETAPE_DESCRIPTION = "Description";
        public static final String ETAPE_PRIX = "Votre prix";
        public static final String ETAPE_RECAPITULATIF = "Récapitulatif de votre annonce";
        public static final String CATEGORIE_AUTOMOBILE = "Véhicules";
        public static final String CATEGORIE_IMMOBILIER = "Immobilier";
        public static final String CATEGORIE_MULTIMEDIA = "Multimédia";
        public static final String CATEGORIE_MATERIEL_PRO = "Matériel professionnel";
        public static final String CATEGORIE_SERVICES = "Services";
        public static final String CATEGORIE_MODE = "Mode";
        public static final String CATEGORIE_LOISIRS = "Loisirs";
        public static final String CATEGORIE_DIVERS = "Divers";
        public static final String ANNONCE_TITRE = "Titre de l'annonce";
        public static final String ANNONCE_DESCRIPTION = "Description de l'annonce";
        public static final String ANNONCE_PRIX = "Indiquer le prix de votre article (en €)";
    }

    public static class  Images {
        public static final Image PLUS = Toolkit.getDefaultToolkit().getImage("plus.png");
        public static final Image MON_COMPTE = Toolkit.getDefaultToolkit().getImage("utilisateur.png");
    }
}
