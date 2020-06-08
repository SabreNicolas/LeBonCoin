package leSuperCoin.model.dao;

import leSuperCoin.model.entities.ValeurCritereEntity;

import java.util.Collection;

public interface ValeurCritereDao extends Dao<ValeurCritereEntity>{

    public Collection<ValeurCritereEntity> findAllValeurCritereByAnnonce(int i);
}
