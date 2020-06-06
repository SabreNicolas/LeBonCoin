package leSuperCoin;

import leSuperCoin.resources.Globals.*;
import leSuperCoin.view.Accueil;
import leSuperCoin.view.Annonce;
import leSuperCoin.view.DepotAnnonce;
import leSuperCoin.view.Entete;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import javax.swing.*;

import java.awt.*;
import java.util.Map;

public class Main extends JFrame {
    /*
    private static final SessionFactory ourSessionFactory;

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
    }
    */
    public static void main(String[] args) {

        new Main();
    }

    public Main() {
//        Accueil a = new Accueil();
//        Annonce a = new Annonce();
        DepotAnnonce a = new DepotAnnonce();
        this.add(a);

        a.setBackground(Colors.BLANC);

        this.setTitle("Le super coin");
        java.net.URL imgURL = getClass().getResource("resources/images/logo.png");
        ImageIcon icon = new ImageIcon(imgURL);
        Image image = icon.getImage();
        this.setIconImage(image);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}