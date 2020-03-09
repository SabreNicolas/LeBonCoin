package test;

import leSuperCoin.model.dao.AnnonceDao;
import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;

public class Test1 {

    public static void main(final String[] args) throws Exception {

        AnnonceDao annonceManager = (AnnonceDao) JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getAnnonceDao();
        annonceManager.close();
    }
}
