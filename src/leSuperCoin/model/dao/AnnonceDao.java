package leSuperCoin.model.dao;

import leSuperCoin.model.entities.AnnonceEntity;

import java.util.Collection;

public interface AnnonceDao extends Dao<AnnonceEntity> {

    public Collection<AnnonceEntity> findAnnonceByCategorie(int i);
    public Collection<AnnonceEntity> findAnnonceByCategorieEtat(int i, int j);
    public Collection<AnnonceEntity> findAllAnnonceByUser(int i);
    public Collection<AnnonceEntity> findAllAnnonceByUserEtat(int i, int j);
}