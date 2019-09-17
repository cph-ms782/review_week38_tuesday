package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;

/**
 *
 * @author msi
 */
@Entity
@NamedQuery(name = "Customer.deleteAllRows", query = "DELETE from Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerID;
    private String firstName;
    private String lastName;

    @ElementCollection()
    @CollectionTable(
            name = "HOBBIES",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    @Column(name = "HOBBY")
    private List<String> hobbies = new ArrayList();

    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name = "DESCRIPTION")
    private Map<String, String> phones = new HashMap();

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addHobby(String s) {
        hobbies.add(s);
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    
    
//    public String getHobbies() {
//        String listHobbies = null;
//        for (String hobby : hobbies) {
//            if (listHobbies == null) {
//                listHobbies = hobby + ",";
//            } else {
//                listHobbies += hobby + ",";
//            }
//        }
//        return listHobbies.substring(0, listHobbies.length() - 1);
//    }

    public void addPhone(String phoneNo, String description) {
        phones.put(phoneNo, description);
    }

    public String getPhoneDescription(String phoneNo) {
        return phones.get(phoneNo);
    }

}
