package leSuperCoin.model.dao;

import leSuperCoin.model.entities.PhotoEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoPhoto extends JpaDao<PhotoEntity> implements PhotoDao {

    private static JpaDaoPhoto instance;

    private JpaDaoPhoto() {

    }

    public static JpaDaoPhoto getInstance() {
        if(instance == null)
            instance = new JpaDaoPhoto();
        return instance;
    }

    @Override
    public PhotoEntity find(Class c, Integer id) {
        return super.find(PhotoEntity.class, id);
    }

    @Override
    public Collection<PhotoEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM PhotoEntity a");
        return (Collection<PhotoEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM PhotoEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(PhotoEntity obj) {
        return super.delete(obj);
    }

    public Collection<PhotoEntity> findAllPhotoByAnnonce(int i) {
        Query query = session.createQuery("SELECT p FROM PhotoEntity p WHERE p.annonce="+i);
        return (Collection<PhotoEntity>) query.getResultList();
    }
}