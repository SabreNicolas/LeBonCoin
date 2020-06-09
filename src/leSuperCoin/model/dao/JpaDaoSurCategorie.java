package leSuperCoin.model.dao;

import leSuperCoin.model.entities.SurCategorieEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoSurCategorie extends JpaDao<SurCategorieEntity> implements SurCategorieDao {

    private static JpaDaoSurCategorie instance;

    private JpaDaoSurCategorie() {

    }

    public static JpaDaoSurCategorie getInstance() {
        if(instance == null)
            instance = new JpaDaoSurCategorie();
        return instance;
    }

    @Override
    public SurCategorieEntity find(Class c, Integer id) {
        return super.find(SurCategorieEntity.class, id);
    }

    @Override
    public Collection<SurCategorieEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM SurCategorieEntity a");
        return (Collection<SurCategorieEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM SurCategorieEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(SurCategorieEntity obj) {
        return super.delete(obj);
    }
}