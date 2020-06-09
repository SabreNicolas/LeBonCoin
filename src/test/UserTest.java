package test;


import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.dao.UserDao;
import leSuperCoin.model.dao.ValeurCritereDao;
import leSuperCoin.model.entities.ValeurCritere;

public class UserTest {

    public static void main(final String[] args) throws Exception {


        UserDao userManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getUserDao();

        System.out.println("---------------");
        System.out.println("-User by login et passe-");
        System.out.println("----nico----nico-------");
        System.out.println(userManager.findUserByLoginAndPasse("nico","nico"));

        userManager.close();

    }
}
