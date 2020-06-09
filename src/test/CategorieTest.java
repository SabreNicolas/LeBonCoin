package test;


import leSuperCoin.model.dao.CategorieDao;
import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.entities.CategorieEntity;

public class CategorieTest {

    public static void main(final String[] args) throws Exception {


        CategorieDao categorieManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCategorieDao();

        System.out.println("---------------");
        System.out.println("-CategorieEntity by surCategoire-");
        System.out.println("---------------");
        for(CategorieEntity c : categorieManager.findAllCategorieBySurCategorie(4)) {
            System.out.println(c);
        }


        categorieManager.close();

    }
}
