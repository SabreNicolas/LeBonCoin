package leSuperCoin.model.dao;

import leSuperCoin.model.entities.AnnonceEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoAnnonce extends JpaDao<AnnonceEntity> implements AnnonceDao {

    private static JpaDaoAnnonce instance;

    private JpaDaoAnnonce() {

    }

    public static JpaDaoAnnonce getInstance() {
        if(instance == null)
            instance = new JpaDaoAnnonce();
        return instance;
    }

    @Override
    public AnnonceEntity find(Class c, Integer id) {
        return super.find(AnnonceEntity.class, id);
    }

    @Override
    public Collection<AnnonceEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a");
        return (Collection<AnnonceEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM AnnonceEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(AnnonceEntity obj) {
        return super.delete(obj);
    }

    public Collection<AnnonceEntity> findAnnonceByCategorie(int i) {
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a WHERE a.categorieEntity="+i);
        return (Collection<AnnonceEntity>) query.getResultList();
    }

    public Collection<AnnonceEntity> findAnnonceByCategorieEtat(int i, int j) {
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a WHERE a.categorie="+i+"AND a.statut="+j);
        return (Collection<AnnonceEntity>) query.getResultList();
    }

    public Collection<AnnonceEntity> findAllAnnonceByUser(int i) {
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a WHERE a.utilisateur="+i);
        return (Collection<AnnonceEntity>) query.getResultList();
    }

    // 1 = annonce active et 0 annonce inactive
    public Collection<AnnonceEntity> findAllAnnonceByUserEtat(int i, int j) {
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a WHERE a.utilisateur="+i+"AND a.statut="+j);
        return (Collection<AnnonceEntity>) query.getResultList();
    }

}
