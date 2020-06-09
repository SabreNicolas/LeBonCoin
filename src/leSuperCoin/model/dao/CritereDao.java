package leSuperCoin.model.dao;

import leSuperCoin.model.entities.CritereEntity;

import java.util.Collection;

public interface CritereDao extends Dao<CritereEntity>{

    public Collection<CritereEntity> findCritereByIdSurCategorieAndNoSurCategorie(int i);
}
