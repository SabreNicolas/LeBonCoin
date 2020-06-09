package leSuperCoin.model.dao;

import leSuperCoin.model.entities.PhotoEntity;

import java.util.Collection;

public interface PhotoDao extends Dao<PhotoEntity> {

    public Collection<PhotoEntity> findAllPhotoByAnnonce(int i);
}
