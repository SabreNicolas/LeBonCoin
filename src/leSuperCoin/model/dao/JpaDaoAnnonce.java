package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Annonce;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoAnnonce extends JpaDao<Annonce> implements AnnonceDao {

    private static JpaDaoAnnonce instance;

    private JpaDaoAnnonce() {

    }

    public static JpaDaoAnnonce getInstance() {
        if(instance == null)
            instance = new JpaDaoAnnonce();
        return instance;
    }

    @Override
    public Annonce find(Class c, Integer id) {
        return super.find(c, id);
    }

    @Override
    public Collection<Annonce> findAll() {
        return super.findAll();
    }

    @Override
    public boolean delete(Annonce obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }
}