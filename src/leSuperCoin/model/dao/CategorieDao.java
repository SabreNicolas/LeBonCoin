package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Categorie;

import java.util.Collection;

public interface CategorieDao extends Dao<Categorie> {

    public Collection<Categorie> findAllCategorieBySurCategorie(int i);
}
