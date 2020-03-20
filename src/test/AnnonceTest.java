package test;

import leSuperCoin.model.dao.*;
import leSuperCoin.model.entities.*;

public class AnnonceTest {

    public static void main(final String[] args) throws Exception {

        AnnonceDao annonceManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getAnnonceDao();
        CategorieDao categorieManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCategorieDao();
        UserDao userManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getUserDao();

        Categorie categorie = categorieManager.find(Categorie.class,2);
        System.out.println("-----categorie----");
        System.out.println(categorie);

        User user = userManager.find(User.class,3);
        System.out.println("-----user----");
        System.out.println(user);

        System.out.println("---------------");
        System.out.println("----Annonce----");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAll()) {
            System.out.println(t);
        }

        Annonce annonce = new Annonce();
        annonce.setDescription("Description Test");
        annonce.setStatut(true);
        annonce.setCategorie(categorie);
        annonce.setUtilisateur(user);
        annonceManager.create(annonce);

        System.out.println("---------------");
        System.out.println("---Annonce apres push---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAll()) {
            System.out.println(t);
        }

        annonce.setDescription("Update Test");
        annonce.setStatut(false);
        annonceManager.update(annonce);

        System.out.println("---------------");
        System.out.println("---Annonce apres update---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAll()) {
            System.out.println(t);
        }


        annonceManager.delete(annonce);

        System.out.println("---------------");
        System.out.println("---Annonce apres delete---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAll()) {
            System.out.println(t);
        }


        System.out.println("---------------");
        System.out.println("---Annonce By Categorie---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAnnonceByCategorie(4)) {
            System.out.println(t);
        }

        System.out.println("---------------");
        System.out.println("---Annonce By Categorie & active---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAnnonceByCategorieEtat(4,1)) {
            System.out.println(t);
        }

        System.out.println("---------------");
        System.out.println("---Annonce By Categorie & inactive---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAnnonceByCategorieEtat(4,0)) {
            System.out.println(t);
        }

        System.out.println("---------------");
        System.out.println("---Annonce By User---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAllAnnonceByUser(3)) {
            System.out.println(t);
        }


        System.out.println("---------------");
        System.out.println("---Annonce By User and active---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAllAnnonceByUserEtat(3,1)) {
            System.out.println(t);
        }


        System.out.println("---------------");
        System.out.println("---Annonce By User and inactive---");
        System.out.println("---------------");
        for(Annonce t : annonceManager.findAllAnnonceByUserEtat(3,0)) {
            System.out.println(t);
        }


        annonceManager.close();


    }
}
