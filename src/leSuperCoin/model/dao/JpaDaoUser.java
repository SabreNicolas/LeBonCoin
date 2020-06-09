package leSuperCoin.model.dao;

import leSuperCoin.model.entities.Critere;
import leSuperCoin.model.entities.SurCategorie;
import leSuperCoin.model.entities.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoUser extends JpaDao<User> implements UserDao {

    private static JpaDaoUser instance;

    private JpaDaoUser() {

    }

    public static JpaDaoUser getInstance() {
        if(instance == null)
            instance = new JpaDaoUser();
        return instance;
    }

    @Override
    public User find(Class c, Integer id) {
        return super.find(User.class, id);
    }

    @Override
    public Collection<User> findAll() {
        Query query = session.createQuery("SELECT a FROM User a");
        return (Collection<User>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(User obj) {
        return super.delete(obj);
    }


    public User findUserByLoginAndPasse(String login , String passe) {
        Query query = session.createQuery("SELECT u FROM User u WHERE u.login="+login+" AND u.motDePasse="+passe);
        return (User) query.getSingleResult();
    }
}