/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;


import assignment3.entities.Property;
import assignment3.entities.PropertyForRent;
import assignment3.entities.PropertyForSale;
import assignment3.entities.PropertyInRent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;



/**
 *
 * @author rory
 */
@ManagedBean(name = "property")
@RequestScoped
public class PropertyController {

    @EJB
    private PropertyEJB propertyEJB;
    List<Property> propertyList = new ArrayList<>();
    private Property property = new Property();

    //getters and setters
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
    
    public String getAddress(Property p){
        property = p;
        return property.getAddress();
    }
    
    public List<Property> propertyList() {
        propertyList = propertyEJB.listPropertys();
        return propertyList;
    }
    
    //return property details page link
    public String detailsPageLink(Property p){
        property = p;
        return "propertyDetails.xhtml";
    }
    
    //return property type based on ID search as a string.
    public String propertyType(long ID){
        property = propertyEJB.searchProperty(ID);
        String type = new String();
        if (property instanceof PropertyForSale){
            type = "ForSale";
        } else  if (property instanceof PropertyForRent){
            type = "ForRent";
        } else  if (property instanceof PropertyInRent){
            type = "InRent";
        }
        return type;
    }
    //return cost string based on property type - For sale = $xxx.xx, For Rent/In Rent = $xxx.xx per week.
    public String cost(){
        String costString = "";
        if (null != propertyType(property.getPropertyID()))switch (propertyType(property.getPropertyID())) {
            case "ForSale":
                PropertyForSale pfs = (PropertyForSale)property;
                costString += String.format("$%.2f", pfs.getSalePrice());
                break;
            case "ForRent":
                PropertyForRent pfr = (PropertyForRent)property;
                costString += String.format("$%.2f per week", pfr.getRentalPrice());
                break;
            case "InRent":
                PropertyInRent pir = (PropertyInRent)property;
                costString += String.format("$%.2f per week", pir.getRentalPrice());
                break;
            default:
                break;
        }
        return costString;
    }
    
    //return tenant name of property in rent
    public String occupant(){
        PropertyInRent pir = (PropertyInRent)property;
        return pir.getTenantName();
    }
}
