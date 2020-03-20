package test;


import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.dao.ValeurCritereDao;
import leSuperCoin.model.entities.ValeurCritere;

public class ValeurCritereTest {

    public static void main(final String[] args) throws Exception {


        ValeurCritereDao valeurManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getValeurCritereDao();

        System.out.println("---------------");
        System.out.println("-valeurCritere by annonce-");
        System.out.println("---------------");
        for(ValeurCritere v : valeurManager.findAllValeurCritereByAnnonce(2)) {
            System.out.println(v);
        }


        valeurManager.close();

    }
}
