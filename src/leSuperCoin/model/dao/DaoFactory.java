package leSuperCoin.model.dao;

public abstract class DaoFactory {

    public enum PersistenceType {
        JPA,
        JDBC,
        XML
    };
    
    public static DaoFactory getDaoFactory(PersistenceType type) {
        switch(type) {
            case JPA:
                return new JpaDaoFactory();
            case JDBC:
                throw new UnsupportedOperationException("JDBC DAO not implemented yet.");
            case XML:
                throw new UnsupportedOperationException("XML DAO not implemented yet.");
            default:
                throw new UnsupportedOperationException("Unspecified DAO not implemented yet.");
        }
    }

    public abstract AnnonceDao getAnnonceDao();
    public abstract CategorieDao getCategorieDao();
    public abstract CritereDao getCritereDao();
    public abstract PhotoDao getPhotoDao();
    public abstract SurCategorieDao getSurCategorieDao();
    public abstract UserDao getUserDao();
    public abstract ValeurCritereDao getValeurCritereDao();


}
