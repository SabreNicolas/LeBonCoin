package leSuperCoin.model.dao;

import leSuperCoin.model.entities.ValeurCritereEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoValeurCritere extends JpaDao<ValeurCritereEntity> implements ValeurCritereDao {

    private static JpaDaoValeurCritere instance;

    private JpaDaoValeurCritere() {

    }

    public static JpaDaoValeurCritere getInstance() {
        if(instance == null)
            instance = new JpaDaoValeurCritere();
        return instance;
    }

    @Override
    public ValeurCritereEntity find(Class c, Integer id) {
        return super.find(ValeurCritereEntity.class, id);
    }

    @Override
    public Collection<ValeurCritereEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM ValeurCritereEntity a");
        return (Collection<ValeurCritereEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM ValeurCritereEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(ValeurCritereEntity obj) {
        return super.delete(obj);
    }


    public Collection<ValeurCritereEntity> findAllValeurCritereByAnnonce(int i) {
        Query query = session.createQuery("SELECT v FROM ValeurCritereEntity v WHERE v.annonceEntity="+i);
        return (Collection<ValeurCritereEntity>) query.getResultList();
    }
}