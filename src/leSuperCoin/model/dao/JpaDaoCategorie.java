package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;
import leSuperCoin.model.entities.Categorie;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoCategorie extends JpaDao<Categorie> implements CategorieDao {

    private static JpaDaoCategorie instance;

    private JpaDaoCategorie() {

    }

    public static JpaDaoCategorie getInstance() {
        if(instance == null)
            instance = new JpaDaoCategorie();
        return instance;
    }

    @Override
    public Categorie find(Class c, Integer id) {
        return super.find(Categorie.class, id);
    }

    @Override
    public Collection<Categorie> findAll() {
        Query query = session.createQuery("SELECT a FROM Categorie a");
        return (Collection<Categorie>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Categorie a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(Categorie obj) {
        return super.delete(obj);
    }
}