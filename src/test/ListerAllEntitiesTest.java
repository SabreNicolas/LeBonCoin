package test;

import leSuperCoin.model.dao.*;
import leSuperCoin.model.entities.*;

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
        System.out.println("----AnnonceEntity----");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAll()) {
            System.out.println(t);
        }
        System.out.println("---------------");
        System.out.println("---CategorieEntity---");
        System.out.println("---------------");
        for(CategorieEntity c : categorieManager.findAll()) {
            System.out.println(c);
        }
        System.out.println("---------------");
        System.out.println("----CritereEntity----");
        System.out.println("---------------");
        for(CritereEntity c : critereManager.findAll()) {
            System.out.println(c);
        }
        System.out.println("---------------");
        System.out.println("-----PhotoEntity-----");
        System.out.println("---------------");
        for(PhotoEntity p : photoManager.findAll()) {
            System.out.println(p);
        }
        System.out.println("---------------");
        System.out.println("--SurCategorieEntity--");
        System.out.println("---------------");
        for(SurCategorieEntity sc : surCategorieManager.findAll()) {
            System.out.println(sc);
        }
        System.out.println("---------------");
        System.out.println("------UserEntity-----");
        System.out.println("---------------");
        for(UserEntity u : userManager.findAll()) {
            System.out.println(u);
        }
        System.out.println("---------------");
        System.out.println("-ValeurCritereEntity-");
        System.out.println("---------------");
        for(ValeurCritereEntity vc : valeurCritereManager.findAll()) {
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
