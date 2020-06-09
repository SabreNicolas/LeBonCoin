package test;

import leSuperCoin.model.dao.*;
import leSuperCoin.model.entities.*;

public class CritereTest {

    public static void main(final String[] args) throws Exception {


        CritereDao critereManager = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA).getCritereDao();

        System.out.println("---------------");
        System.out.println("-CritereEntity by surcat id or no surcatId-");
        System.out.println("---------------");
        for(CritereEntity c : critereManager.findCritereByIdSurCategorieAndNoSurCategorie(4)) {
            System.out.println(c);
        }


        critereManager.close();

    }
}
