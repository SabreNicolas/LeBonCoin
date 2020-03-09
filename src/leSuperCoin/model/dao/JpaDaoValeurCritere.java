package leSuperCoin.model.dao;

import leSuperCoin.model.entities.User;
import leSuperCoin.model.entities.ValeurCritere;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoValeurCritere extends JpaDao<ValeurCritere> implements ValeurCritereDao {

    private static JpaDaoValeurCritere instance;

    private JpaDaoValeurCritere() {

    }

    public static JpaDaoValeurCritere getInstance() {
        if(instance == null)
            instance = new JpaDaoValeurCritere();
        return instance;
    }

    @Override
    public ValeurCritere find(Class c, Integer id) {
        return super.find(ValeurCritere.class, id);
    }

    @Override
    public Collection<ValeurCritere> findAll() {
        Query query = session.createQuery("SELECT a FROM ValeurCritere a");
        return (Collection<ValeurCritere>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM ValeurCritere a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(ValeurCritere obj) {
        return super.delete(obj);
    }
}