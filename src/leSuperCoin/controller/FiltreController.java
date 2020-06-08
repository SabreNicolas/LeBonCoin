package leSuperCoin.controller;

import leSuperCoin.model.entities.CategorieEntity;
import leSuperCoin.model.entities.SurCategorieEntity;

public class FiltreController {
    Controller controller;

    SurCategorieEntity surCategorieEntity;
    CategorieEntity categorieEntity;

    public FiltreController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }

    public SurCategorieEntity getSurCategorieEntity() {
        return surCategorieEntity;
    }

    public void setSurCategorieEntity(SurCategorieEntity surCategorieEntity) {
        this.surCategorieEntity = surCategorieEntity;
    }

    public CategorieEntity getCategorieEntity() {
        return categorieEntity;
    }

    public void setCategorieEntity(CategorieEntity categorieEntity) {
        this.categorieEntity = categorieEntity;
    }
}
