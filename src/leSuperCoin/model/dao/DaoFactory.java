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
                throw new UnsupportedOperationException("Not implemented yet.");
            case XML:
                throw new UnsupportedOperationException("Not implemented yet.");
            default:
                return null;
        }
    }
    
  //  public abstract AnnonceDao getAnnonceDao();
}
