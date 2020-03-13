package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Critere;

import java.util.Collection;

public interface CritereDao extends Dao<Critere>{

    public Collection<Critere> findCritereByIdSurCategorieAndNoSurCategorie(int i);
}
