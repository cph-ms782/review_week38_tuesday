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
        Customer cust2 = new Customer("Børge", "Kurtsen");
        
        cust.addHobby("Fodbold");
        cust.addHobby("Frøer");
        cust.addHobby("Øl");
        Address add = new Address("VejVejen 21", "Roskilde");
        Address add2 = new Address("VejVejen 23", "Roskilde");
        cust.addAddress(add);
        cust.addAddress(add2);
        add2.addCustomers(cust2);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
//        em = emf.createEntityManager();
//        Customer found = em.find(Customer.class, cust.getId());
//        System.out.println("City: " + found.getAddress().getCity());
    }
    
}
