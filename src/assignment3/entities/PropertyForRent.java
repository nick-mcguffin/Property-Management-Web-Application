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
@NamedQuery(name = "findAllPropertyForRent", query = "SELECT p FROM PropertyForRent p"),
@NamedQuery(name = "findPropertyForRentById", query = "SELECT p FROM PropertyForRent p WHERE p.propertyID = :id")
})
public class PropertyForRent extends Property {
   
  private Double rentalPrice;

    //constructors, getters and setters.
    public PropertyForRent() {
    }

    public PropertyForRent(String address, String description, Integer numberOfBedrooms, Double rentalPrice) {
        super( address, description, numberOfBedrooms);
        this.rentalPrice = rentalPrice;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    //toString method for output and testing.
    @Override
    public String toString() {
        return super.toString() + "\nRental Price: $" + rentalPrice + " per week.";
    }
    
  
  
}
