package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;

import java.util.Collection;

public interface AnnonceDao extends Dao<Annonce> {

    public Collection<Annonce> findAnnonceByCategorie(int i);
    public Collection<Annonce> findAllAnnonceByUser(int i);
    public Collection<Annonce> findAllAnnonceByUserEtat(int i, int j);
}