package gov.alaska.escdataloader.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mhspellecacy
 */
public class JpaManager {
    private static final String persistenceUnit = "gov.alaska_EscDataLoader_jar_0.1PU";
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
