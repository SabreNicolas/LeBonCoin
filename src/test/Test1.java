package test;

import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;

public class Test1 {

    public static void main(final String[] args) throws Exception {

        AnnonceDao atelierManager = (AnnonceDao) JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getAtelierDao();

    }
}
