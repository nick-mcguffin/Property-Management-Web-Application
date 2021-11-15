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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Nick McGuffin
 */

//create entity, query to find property via address parameter given by a user. 
//create Join inheritance with subclasses (PropertyForRent, PropertyForSale, PropertyInRent).
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllProperty", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "findPropertyWithParam", query = "select p from Property p where p.address = :address"),
    @NamedQuery(name = "findPropertyById", query = "select p from Property p where p.propertyID = :id")
        
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Property implements Serializable {
    
    //create auto generating id, max column length 2000 for description.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long propertyID;
    @Column(unique=true)
    private String address;
    @Column(length = 2000)
    private String description;
    private Integer numberOfBedrooms;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "property")
    private List<Allocation> allocations;

    //constructors, getters and setters.
    public Property() {
    }    
    
    public Property(String address, String description, Integer numberOfBedrooms) {
       
        this.address = address;
        this.description = description;
        this.numberOfBedrooms = numberOfBedrooms;
        this.allocations = new ArrayList<>();
    }    
    
    public Long getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Long propertyID) {
        this.propertyID = propertyID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    public void addAllocation(Allocation allocation) {
        this.allocations.add(allocation);
    }

    //toString method for output and testing.
    @Override
    public String toString() {
        return "Property ID: " + propertyID + "\nAddress: " + 
                address + "\nDescription: " + description + 
                "\nNumber of Bedrooms: " + numberOfBedrooms;
    }
}
