package leSuperCoin.model.dao;

import leSuperCoin.model.entities.CritereEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoCritere extends JpaDao<CritereEntity> implements CritereDao {

    private static JpaDaoCritere instance;

    private JpaDaoCritere() {

    }

    public static JpaDaoCritere getInstance() {
        if(instance == null)
            instance = new JpaDaoCritere();
        return instance;
    }

    @Override
    public CritereEntity find(Class c, Integer id) {
        return super.find(CritereEntity.class, id);
    }

    @Override
    public Collection<CritereEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM CritereEntity a");
        return (Collection<CritereEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM CritereEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(CritereEntity obj) {
        return super.delete(obj);
    }


    public Collection<CritereEntity> findCritereByIdSurCategorieAndNoSurCategorie(int i) {
        Query query = session.createQuery("SELECT c FROM CritereEntity c WHERE c.surCategorieEntity="+i+" OR c.surCategorieEntity=null");
        return (Collection<CritereEntity>) query.getResultList();
    }
}