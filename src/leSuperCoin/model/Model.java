package leSuperCoin.model;


import leSuperCoin.model.dao.*;
import leSuperCoin.model.entities.*;
import leSuperCoin.view.Annonce;

import java.util.Collection;

public class Model {
    /*private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }*/

    private AnnonceDao annonceManager;
    private CategorieDao categorieManager;
    private CritereDao critereManager;
    private PhotoDao photoManager;
    private SurCategorieDao surCategorieManager;
    private UserDao userManager;
    private ValeurCritereDao valeurCritereManager;

    private UserEntity currentUser;

    public Model() {
        DaoFactory daoFactory = JpaDaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA);

        this.annonceManager = daoFactory.getAnnonceDao();
        this.categorieManager = daoFactory.getCategorieDao();
        this.critereManager = daoFactory.getCritereDao();
        this.photoManager = daoFactory.getPhotoDao();
        this.surCategorieManager = daoFactory.getSurCategorieDao();
        this.userManager = daoFactory.getUserDao();
        this.valeurCritereManager = daoFactory.getValeurCritereDao();
    }

    // Meta

    public void register(String login, String password, String nom, String prenom, String mail) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setMotDePasse(password);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setMail(mail);

        userManager.create(user);

        this.currentUser = user;
    }

    public boolean login(String login, String password) {
        for (UserEntity user : this.userManager.findAll()) {
            if (user.getLogin() == login && user.getMotDePasse() == password) {
                this.currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void disconnect() {
        this.currentUser = null;
    }

    // Getters

    public Collection<AnnonceEntity> getAnnonces() {
        return this.annonceManager.findAll();
    }

    public Collection<AnnonceEntity> getAnnoncesIn(CategorieEntity categorie) {
        return this.annonceManager.findAnnonceByCategorie(categorie.getId());
    }

    public Collection<SurCategorieEntity> getSurCategories() {
        return this.surCategorieManager.findAll();
    }

    public Collection<CategorieEntity> getCategoriesOf(SurCategorieEntity surCategorie) {
        return this.categorieManager.findAllCategorieBySurCategorie(surCategorie.getId());
    }

    public Collection<CritereEntity> getCriteresOf(SurCategorieEntity surCategorie) {
        return this.critereManager.findCritereByIdSurCategorieAndNoSurCategorie(surCategorie.getId());
    }

    public Collection<ValeurCritereEntity> getValeurCriteresOf(AnnonceEntity annonce) {
        return this.valeurCritereManager.findAllValeurCritereByAnnonce(annonce.getId());
    }

    public boolean isConnected() {
        return this.currentUser != null;
    }

    public UserEntity getCurrentUser() {
        return this.currentUser;
    }

    // Modifiers

    public void addAnnonce(AnnonceEntity annonce) {
        annonceManager.create(annonce);
    }

    public void addValeurCritere(ValeurCritereEntity valeurCritere) {

        valeurCritereManager.create(valeurCritere);
    }
}
