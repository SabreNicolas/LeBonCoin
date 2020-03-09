package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;
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

}
