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
    @NamedQuery(name = "findAllPropertyForSale", query = "SELECT p FROM PropertyForSale p"),
    @NamedQuery(name = "findPropertyForSaleById", query = "select p from PropertyForSale p where p.propertyID = :id")
})
public class PropertyForSale extends Property {

  private Double salePrice;

  //constructors, getters and setters.
    public PropertyForSale() {
    }

    public PropertyForSale( String address, String description, Integer numberOfBedrooms, Double salePrice) {
        super(address, description, numberOfBedrooms);
        this.salePrice = salePrice;
    }
    
    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    //toString method for output and testing.
    @Override
    public String toString() {
        return super.toString() + "\nSale Price: $" + salePrice;
    }
  
    
    
}
