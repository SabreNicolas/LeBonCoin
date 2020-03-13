package test;

import leSuperCoin.model.dao.AnnonceDao;
import leSuperCoin.model.dao.CategorieDao;
import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.entities.Annonce;
import leSuperCoin.model.entities.Categorie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test1 {

    public static void main(final String[] args) throws Exception {

        AnnonceDao annonceManager = (AnnonceDao) JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getAnnonceDao();
        CategorieDao categorieManager = (CategorieDao) JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCategorieDao();


        for(Annonce t : annonceManager.findAll()) {
            System.out.println(t);
        }
        for(Categorie c : categorieManager.findAll()) {
            System.out.println(c);
        }

        annonceManager.close();
        categorieManager.close();


    }
}
