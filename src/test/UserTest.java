package test;


import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.dao.UserDao;
import leSuperCoin.model.entities.UserEntity;

public class UserTest {

    public static void main(final String[] args) throws Exception {


        UserDao userManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getUserDao();

        System.out.println("---------------");
        System.out.println("-User by login et passe-");
        System.out.println("----nico----nico-------");
        UserEntity userNico = userManager.findUserByLoginAndPasse("nico","nico");
        System.out.println(userNico.toString());

        userManager.close();

    }
}
