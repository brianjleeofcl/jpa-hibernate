import Data.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from User");
        List results = query.getResultList();
        for (User user: (List<User>) results) {
            System.out.printf("#%d: %s %s, tel: %s%n",user.getId(), user.getFirstName(), user.getLastName(), user.getPhoneNumber());
        }

        em.close();
        if (!em.isOpen()) {
            System.exit(0);
        }
    }
}