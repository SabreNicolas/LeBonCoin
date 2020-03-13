package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;
import leSuperCoin.model.entities.Categorie;
import leSuperCoin.model.entities.Critere;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoCritere extends JpaDao<Critere> implements CritereDao {

    private static JpaDaoCritere instance;

    private JpaDaoCritere() {

    }

    public static JpaDaoCritere getInstance() {
        if(instance == null)
            instance = new JpaDaoCritere();
        return instance;
    }

    @Override
    public Critere find(Class c, Integer id) {
        return super.find(Critere.class, id);
    }

    @Override
    public Collection<Critere> findAll() {
        Query query = session.createQuery("SELECT a FROM Critere a");
        return (Collection<Critere>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Critere a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(Critere obj) {
        return super.delete(obj);
    }
}