package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;

import java.util.Collection;

public interface AnnonceDao extends Dao<Annonce> {

    public Collection<Annonce> findAnnonceByCategorie(int i);
}