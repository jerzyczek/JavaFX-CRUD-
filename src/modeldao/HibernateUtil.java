package modeldao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import hotelklasy.Klient;
import hotelklasy.Pracownik;
import hotelklasy.Rezerwacja;
import hotelklasy.Pokoj;

public class HibernateUtil {
    
    private Session currentSession;
    private Transaction currentTransaction;
    private String  pathConfiguration;
    private static ServiceRegistry serviceRegistry;
    private static String mainConfiguration;
    private static SessionFactory sessionFactory;
    private static Configuration configuration;
    
    

    public HibernateUtil(){
        this.pathConfiguration = mainConfiguration;
    }
    
    public static void setMainConfiguration(String configurationPath){
        mainConfiguration = configurationPath;
        SessionFactory(mainConfiguration);
    } 
   
    public static String getMainConfiguration(){
        return mainConfiguration;
    }
    
    public static ServiceRegistry getServiceRegistry() {
        return HibernateUtil.serviceRegistry;
    }
    
    public String getPathConfiguration() {
        return pathConfiguration;
    }

    public void setPathConfiguration(String path) {
        pathConfiguration = path;
    }
    
    public static void addAddnotation(Configuration x){
        x.addAnnotatedClass(Klient.class);
        x.addAnnotatedClass(Pokoj.class);
        x.addAnnotatedClass(Pracownik.class);
        x.addAnnotatedClass(Rezerwacja.class);
    }

    private static void SessionFactory(String pathConfiguration) {
        configuration = new Configuration()
                .configure(pathConfiguration);
        
        addAddnotation(configuration);

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
    }
    
    private static SessionFactory getSessionFactory(String pathConfiguration){
        
        return sessionFactory;
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory(pathConfiguration).openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
}
