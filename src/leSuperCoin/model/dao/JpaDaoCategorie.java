package leSuperCoin.model.dao;

import leSuperCoin.model.entities.CategorieEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoCategorie extends JpaDao<CategorieEntity> implements CategorieDao {

    private static JpaDaoCategorie instance;

    private JpaDaoCategorie() {

    }

    public static JpaDaoCategorie getInstance() {
        if(instance == null)
            instance = new JpaDaoCategorie();
        return instance;
    }

    @Override
    public CategorieEntity find(Class c, Integer id) {
        return super.find(CategorieEntity.class, id);
    }

    @Override
    public Collection<CategorieEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM CategorieEntity a");
        return (Collection<CategorieEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM CategorieEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(CategorieEntity obj) {
        return super.delete(obj);
    }

    public Collection<CategorieEntity> findAllCategorieBySurCategorie(int i) {
        Query query = session.createQuery("SELECT c FROM CategorieEntity c WHERE c.surCategorieEntity="+i);
        return (Collection<CategorieEntity>) query.getResultList();
    }
}