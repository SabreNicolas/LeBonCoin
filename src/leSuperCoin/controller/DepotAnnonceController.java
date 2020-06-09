package leSuperCoin.controller;

import leSuperCoin.model.entities.*;
import leSuperCoin.view.View;

import java.util.HashMap;
import java.util.Map;

public class DepotAnnonceController {
    private Controller controller;

    private SurCategorieEntity surCategorie;
    private CategorieEntity categorie;
    private String titre;
    private String description;
    private Map<CritereEntity, String> critereMap;

    public DepotAnnonceController(Controller controller) {
        this.controller = controller;

        this.critereMap = new HashMap<>();
    }

    public Controller getController() {
        return this.controller;
    }

    public void submit() {
        AnnonceEntity annonceEntity = new AnnonceEntity();
        annonceEntity.setDescription(this.description);
        annonceEntity.setStatut(true);
        annonceEntity.setCategorieEntity(this.categorie);
        annonceEntity.setUtilisateur(this.controller.getModel().getCurrentUser());
        this.controller.getModel().addAnnonce(annonceEntity);

        for( Map.Entry<CritereEntity, String> entry: critereMap.entrySet()){
            ValeurCritereEntity valeurCritere = new ValeurCritereEntity();
            valeurCritere.setAnnonceEntity(annonceEntity);
            valeurCritere.setCritereEntity(entry.getKey());
            valeurCritere.setValeur(entry.getValue());
            this.controller.getModel().addValeurCritere(valeurCritere);
        }

        this.controller.getView().navigate(View.Target.ACCUEIL);
    }

    public SurCategorieEntity getSurCategorie() {
        return surCategorie;
    }

    public void setSurCategorie(SurCategorieEntity surCategorie) {
        this.surCategorie = surCategorie;
    }

    public CategorieEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntity categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCritere(CritereEntity critere, String value) {
        this.critereMap.put(critere, value);
    }
}
