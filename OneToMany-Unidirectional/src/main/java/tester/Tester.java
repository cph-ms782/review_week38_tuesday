package tester;

import entity.Address;
import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author martin
 */
public class Tester {
    
    public static void main(String[] args) {
        
        Customer cust = new Customer("Kurt", "Børgesen");
        
        Address add = new Address("VejVejen 21", "Roskilde");
        Address add2 = new Address("VejVejen 23", "Roskilde");
        
        cust.addAddress(add);
        cust.addAddress(add2);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }
    
}
