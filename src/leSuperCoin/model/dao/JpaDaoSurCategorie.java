package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Photo;
import leSuperCoin.model.entities.SurCategorie;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoSurCategorie extends JpaDao<SurCategorie> implements SurCategorieDao {

    private static JpaDaoSurCategorie instance;

    private JpaDaoSurCategorie() {

    }

    public static JpaDaoSurCategorie getInstance() {
        if(instance == null)
            instance = new JpaDaoSurCategorie();
        return instance;
    }

    @Override
    public SurCategorie find(Class c, Integer id) {
        return super.find(SurCategorie.class, id);
    }

    @Override
    public Collection<SurCategorie> findAll() {
        Query query = session.createQuery("SELECT a FROM SurCategorie a");
        return (Collection<SurCategorie>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM SurCategorie a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(SurCategorie obj) {
        return super.delete(obj);
    }
}