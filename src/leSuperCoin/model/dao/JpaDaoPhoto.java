package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;
import leSuperCoin.model.entities.Critere;
import leSuperCoin.model.entities.Photo;
import leSuperCoin.model.entities.ValeurCritere;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoPhoto extends JpaDao<Photo> implements PhotoDao {

    private static JpaDaoPhoto instance;

    private JpaDaoPhoto() {

    }

    public static JpaDaoPhoto getInstance() {
        if(instance == null)
            instance = new JpaDaoPhoto();
        return instance;
    }

    @Override
    public Photo find(Class c, Integer id) {
        return super.find(Photo.class, id);
    }

    @Override
    public Collection<Photo> findAll() {
        Query query = session.createQuery("SELECT a FROM Photo a");
        return (Collection<Photo>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Photo a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(Photo obj) {
        return super.delete(obj);
    }

    public Collection<Photo> findAllPhotoByAnnonce(int i) {
        Query query = session.createQuery("SELECT p FROM Photo p WHERE p.annonce="+i);
        return (Collection<Annonce>) query.getResultList();
    }
}