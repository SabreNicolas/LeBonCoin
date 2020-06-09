package leSuperCoin.model.dao;

import leSuperCoin.model.entities.CategorieEntity;

import java.util.Collection;

public interface CategorieDao extends Dao<CategorieEntity> {

    public Collection<CategorieEntity> findAllCategorieBySurCategorie(int i);
}
