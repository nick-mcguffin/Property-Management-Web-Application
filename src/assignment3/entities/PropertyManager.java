/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Nick McGuffin
 */
//create property manager entity, and a named query to find property manager with user input.
@Entity
@NamedQueries({
    @NamedQuery(name = "findPropertyManagerFirstName", query = "SELECT m FROM PropertyManager m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "findPropertyManagerLastName", query = "SELECT m FROM PropertyManager m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "findPropertyManagerName", query = "SELECT m FROM PropertyManager m WHERE m.firstName = :firstName AND m.lastName = :lastName"),
    @NamedQuery(name = "findPropertyManagerID", query = "SELECT m FROM PropertyManager m WHERE m.propertyManagerID = :pmID"),
    @NamedQuery(name = "findAllPropertyManagers", query = "SELECT m FROM PropertyManager m")
})
public class PropertyManager implements Serializable {

    //create auto generated id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long propertyManagerID;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "manager")
    private List<Allocation> allocations;
    
    
    //constructors, getters and setters.
    public PropertyManager() {
    }

    public PropertyManager(String firstName, String lastName, String email, Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.allocations = new ArrayList<>();
    }

    
    public Long getPropertyManagerID() {
        return propertyManagerID;
    }

    public void setPropertyManagerID(Long propertyManagerID) {
        this.propertyManagerID = propertyManagerID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public List<Allocation> getAllocations (){
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }
    
    public void addAllocation (Allocation allocation){
        this.allocations.add(allocation);
    }
    
    //toString method for output and testing.
    @Override
    public String toString() {
        return "First Name: " + firstName + "Last Name: " + lastName + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "allocations" + allocations;
    }

    
    
    
    
    
}
