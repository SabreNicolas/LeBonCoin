package leSuperCoin.model.dao;

import leSuperCoin.model.entities.UserEntity;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoUser extends JpaDao<UserEntity> implements UserDao {

    private static JpaDaoUser instance;

    private JpaDaoUser() {

    }

    public static JpaDaoUser getInstance() {
        if(instance == null)
            instance = new JpaDaoUser();
        return instance;
    }

    @Override
    public UserEntity find(Class c, Integer id) {
        return super.find(UserEntity.class, id);
    }

    @Override
    public Collection<UserEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM UserEntity a");
        return (Collection<UserEntity>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM UserEntity a");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(UserEntity obj) {
        return super.delete(obj);
    }


    public UserEntity findUserByLoginAndPasse(String login , String passe) {
        Query query = session.createQuery("SELECT u FROM UserEntity u WHERE u.login="+login+" AND u.motDePasse="+passe);
        return (UserEntity) query.getSingleResult();
    }
}