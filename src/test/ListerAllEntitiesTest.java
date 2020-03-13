package test;

import leSuperCoin.model.dao.*;
import leSuperCoin.model.entities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListerAllEntitiesTest {

    public static void main(final String[] args) throws Exception {

        AnnonceDao annonceManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getAnnonceDao();
        CategorieDao categorieManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCategorieDao();
        CritereDao critereManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCritereDao();
        PhotoDao photoManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getPhotoDao();
        SurCategorieDao surCategorieManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getSurCategorieDao();
        UserDao userManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getUserDao();
        ValeurCritereDao valeurCritereManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getValeurCritereDao();

        System.out.println("---------------");
        System.out.println("----Annonce----");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAll()) {
            System.out.println(t);
        }
        System.out.println("---------------");
        System.out.println("---Categorie---");
        System.out.println("---------------");
        for(Categorie c : categorieManager.findAll()) {
            System.out.println(c);
        }
        System.out.println("---------------");
        System.out.println("----Critere----");
        System.out.println("---------------");
        for(Critere c : critereManager.findAll()) {
            System.out.println(c);
        }
        System.out.println("---------------");
        System.out.println("-----Photo-----");
        System.out.println("---------------");
        for(Photo p : photoManager.findAll()) {
            System.out.println(p);
        }
        System.out.println("---------------");
        System.out.println("--SurCategorie--");
        System.out.println("---------------");
        for(SurCategorie sc : surCategorieManager.findAll()) {
            System.out.println(sc);
        }
        System.out.println("---------------");
        System.out.println("------User-----");
        System.out.println("---------------");
        for(User u : userManager.findAll()) {
            System.out.println(u);
        }
        System.out.println("---------------");
        System.out.println("-ValeurCritere-");
        System.out.println("---------------");
        for(ValeurCritere vc : valeurCritereManager.findAll()) {
            System.out.println(vc);
        }

        annonceManager.close();
        categorieManager.close();
        critereManager.close();
        photoManager.close();
        surCategorieManager.close();
        userManager.close();
        valeurCritereManager.close();


    }
}
