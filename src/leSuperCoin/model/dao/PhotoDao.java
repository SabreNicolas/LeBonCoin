package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Photo;

import java.util.Collection;

public interface PhotoDao extends Dao<Photo> {

    public Collection<Photo> findAllPhotoByAnnonce(int i);
}
