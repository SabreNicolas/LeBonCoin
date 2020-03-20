package leSuperCoin.model.dao;

import leSuperCoin.model.entities.ValeurCritere;

import java.util.Collection;

public interface ValeurCritereDao extends Dao<ValeurCritere>{

    public Collection<ValeurCritere> findAllValeurCritereByAnnonce(int i);
}
