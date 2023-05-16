package Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class WorkPersistence {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static EntityManager readPersistence() {
        emf = Persistence
                .createEntityManagerFactory("authentificationPersonalData");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static void closePersistence() {
        emf.close();
    }
}
