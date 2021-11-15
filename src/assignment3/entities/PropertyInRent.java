/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Nick McGuffin
 */
@Entity
@NamedQueries({
@NamedQuery(name = "findAllPropertyInRent", query = "SELECT p FROM PropertyInRent p"),
@NamedQuery(name = "findPropertyInRentById", query = "SELECT p FROM PropertyInRent p WHERE p.propertyID = :id")
})
public class PropertyInRent extends Property {

   //constructors, getters and setters.
   private Double rentalPrice;
   private String tenantName;

    public PropertyInRent() {
    }

    public PropertyInRent(String address, String description, Integer numberOfBedrooms, Double rentalPrice, String tenantName) {
        super(address, description, numberOfBedrooms);
        this.rentalPrice = rentalPrice;
        this.tenantName = tenantName;
    }
 
    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    //toString method for output and testing.
    @Override
    public String toString() {
        return super.toString() + "\nRental Price: $" + rentalPrice + " per week. " + "\nTenant Name: " + tenantName;
    }
   
   
}
