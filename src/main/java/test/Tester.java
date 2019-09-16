package test;

import entities.Customer;
import facades.CustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static javax.ws.rs.client.Entity.entity;

/**
 *
 * @author msi
 */
public class Tester {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);

    public static void main(String[] args) {
        Customer c1 = facade.addCustomer("Hans", "Børgesen");
        c1.addHobby("Fisk");
        c1.addHobby("Fugle");
        c1.addHobby("Træer");

        Customer c2 = facade.addCustomer("Jens", "Hansen");
        c2.addHobby("Sommerfugle");
        c2.addHobby("Frimærker");
        c2.addHobby("Træer");

        Customer c3 = facade.addCustomer("Jørgen", "Paulsen");
        c3.addHobby("Biler");
        c3.addHobby("Motorcykler");
        c3.addHobby("Skibe");

    }
}
