package test;

import leSuperCoin.model.dao.*;
import leSuperCoin.model.entities.*;

public class AnnonceTest {

    public static void main(final String[] args) throws Exception {

        AnnonceDao annonceManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getAnnonceDao();
        CategorieDao categorieManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCategorieDao();
        UserDao userManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getUserDao();

        CategorieEntity categorieEntity = categorieManager.find(CategorieEntity.class,2);
        System.out.println("-----categorieEntity----");
        System.out.println(categorieEntity);

        UserEntity userEntity = userManager.find(UserEntity.class,3);
        System.out.println("-----userEntity----");
        System.out.println(userEntity);

        System.out.println("---------------");
        System.out.println("----AnnonceEntity----");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAll()) {
            System.out.println(t);
        }

        AnnonceEntity annonceEntity = new AnnonceEntity();
        annonceEntity.setDescription("Description Test");
        annonceEntity.setStatut(true);
        annonceEntity.setCategorieEntity(categorieEntity);
        annonceEntity.setUtilisateur(userEntity);
        annonceManager.create(annonceEntity);

        System.out.println("---------------");
        System.out.println("---AnnonceEntity apres push---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAll()) {
            System.out.println(t);
        }

        annonceEntity.setDescription("Update Test");
        annonceEntity.setStatut(false);
        annonceManager.update(annonceEntity);

        System.out.println("---------------");
        System.out.println("---AnnonceEntity apres update---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAll()) {
            System.out.println(t);
        }


        annonceManager.delete(annonceEntity);

        System.out.println("---------------");
        System.out.println("---AnnonceEntity apres delete---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAll()) {
            System.out.println(t);
        }


        System.out.println("---------------");
        System.out.println("---AnnonceEntity By CategorieEntity---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAnnonceByCategorie(4)) {
            System.out.println(t);
        }

        System.out.println("---------------");
        System.out.println("---AnnonceEntity By CategorieEntity & active---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAnnonceByCategorieEtat(4,1)) {
            System.out.println(t);
        }

        System.out.println("---------------");
        System.out.println("---AnnonceEntity By CategorieEntity & inactive---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAnnonceByCategorieEtat(4,0)) {
            System.out.println(t);
        }

        System.out.println("---------------");
        System.out.println("---AnnonceEntity By UserEntity---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAllAnnonceByUser(3)) {
            System.out.println(t);
        }


        System.out.println("---------------");
        System.out.println("---AnnonceEntity By UserEntity and active---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAllAnnonceByUserEtat(3,1)) {
            System.out.println(t);
        }


        System.out.println("---------------");
        System.out.println("---AnnonceEntity By UserEntity and inactive---");
        System.out.println("---------------");
        for(AnnonceEntity t : annonceManager.findAllAnnonceByUserEtat(3,0)) {
            System.out.println(t);
        }


        annonceManager.close();


    }
}
