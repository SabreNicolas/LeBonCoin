package test;

import leSuperCoin.model.dao.DaoFactory;
import leSuperCoin.model.dao.JpaDaoFactory;
import leSuperCoin.model.dao.PhotoDao;
import leSuperCoin.model.entities.PhotoEntity;

public class PhotoTest {

    public static void main(final String[] args) throws Exception {


        PhotoDao photoManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getPhotoDao();

        System.out.println("---------------");
        System.out.println("-PhotoEntity by annonce-");
        System.out.println("---------------");
        for(PhotoEntity p : photoManager.findAllPhotoByAnnonce(3)) {
            System.out.println(p);
        }


        photoManager.close();

    }
}
