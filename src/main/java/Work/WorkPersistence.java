package Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class WorkPersistence {
    public static EntityManager readPersistence() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("authentificationPersonalData");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static void closePersistence(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();
        entityManager.close();
    }
}
