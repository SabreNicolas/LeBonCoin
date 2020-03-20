package test;

import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.dao.PhotoDao;
import leSuperCoin.model.entities.Photo;

public class PhotoTest {

    public static void main(final String[] args) throws Exception {


        PhotoDao photoManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getPhotoDao();

        System.out.println("---------------");
        System.out.println("-Photo by annonce-");
        System.out.println("---------------");
        for(Photo p : photoManager.findAllPhotoByAnnonce(3)) {
            System.out.println(p);
        }


        photoManager.close();

    }
}
