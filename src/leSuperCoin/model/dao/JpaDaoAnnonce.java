package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;
import leSuperCoin.model.entities.Critere;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoAnnonce extends JpaDao<Annonce> implements AnnonceDao {

    private static JpaDaoAnnonce instance;

    private JpaDaoAnnonce() {

    }

    public static JpaDaoAnnonce getInstance() {
        if(instance == null)
            instance = new JpaDaoAnnonce();
        return instance;
    }

    @Override
    public Annonce find(Class c, Integer id) {
        return super.find(Annonce.class, id);
    }

    @Override
    public Collection<Annonce> findAll() {
        Query query = session.createQuery("SELECT a FROM Annonce a");
        return (Collection<Annonce>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Annonce a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(Annonce obj) {
        return super.delete(obj);
    }

    public Collection<Annonce> findAnnonceByCategorie(int i) {
        Query query = session.createQuery("SELECT a FROM Annonce a WHERE a.categorie="+i);
        return (Collection<Annonce>) query.getResultList();
    }

    public Collection<Annonce> findAnnonceByCategorieEtat(int i,int j) {
        Query query = session.createQuery("SELECT a FROM Annonce a WHERE a.categorie="+i+"AND a.statut="+j);
        return (Collection<Annonce>) query.getResultList();
    }

    public Collection<Annonce> findAllAnnonceByUser(int i) {
        Query query = session.createQuery("SELECT a FROM Annonce a WHERE a.utilisateur="+i);
        return (Collection<Annonce>) query.getResultList();
    }

    // 1 = annonce active et 0 annonce inactive
    public Collection<Annonce> findAllAnnonceByUserEtat(int i, int j) {
        Query query = session.createQuery("SELECT a FROM Annonce a WHERE a.utilisateur="+i+"AND a.statut="+j);
        return (Collection<Annonce>) query.getResultList();
    }

}
