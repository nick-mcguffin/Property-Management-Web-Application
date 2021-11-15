/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;


import assignment3.entities.PropertyForRent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;



/**
 *
 * @author dean
 */
@ManagedBean(name = "propertyForRent")
@RequestScoped
public class PropertyForRentController {

    @EJB
    private PropertyEJB propertyEJB;
    List<PropertyForRent> propertyForRentList = new ArrayList<>();
    
    List<PropertyForRent> listProperty;
   
    Long searchParam;
    PropertyForRent propertySearch;

    PropertyForRent propertyForRent = new PropertyForRent();
   
    
    
    //create new rent property, persist to database and return a list of current rent properties.
    public String doCreateForRentProperty(){
        propertyForRent = propertyEJB.createPropertyForRent(propertyForRent);
        listForRentProperties();
        return "listForRentProperty.xhtml";
    }

    //return list of current properties for rent
    public List<PropertyForRent> listPropertyForRent() {
        listProperty = propertyEJB.listPropertysForRent(); 
        return listProperty;
    }
    
    //return list for rent properties page.
    public String listForRentProperties(){
        propertyForRentList = propertyEJB.listPropertysForRent();   
        return "listForRentProperty.xhtml";
    }
    //return search for rent properties page.
    public String searchForRentProperty(){
        return "searchForRentProperty.xhtml";
    }
    //getters and setters
    public PropertyEJB getPropertyEJB() {
        return propertyEJB;
    }

    public void setPropertyEJB(PropertyEJB propertyEJB) {
        this.propertyEJB = propertyEJB;
    }

    public PropertyForRent getPropertyForRent() {
        return propertyForRent;
    }

    public void setPropertyForRent(PropertyForRent propertyForRent) {
        this.propertyForRent = propertyForRent;
    }

    public List<PropertyForRent> getPropertyForRentList() {
        return propertyForRentList;
    }

    public Long getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(Long searchParam) {
        this.searchParam = searchParam;
    }

    public PropertyForRent getPropertySearch() {
        return propertySearch;
    }

    public void setPropertySearch(PropertyForRent propertySearch) {
        this.propertySearch = propertySearch;
    }
    
     public List<PropertyForRent> getListProperty() {
        return listProperty;
    }

    public void setListProperty(List<PropertyForRent> listProperty) {
        this.listProperty = listProperty;
    }
    
    //return details from property search using search param
    public String searchRentalPropertyInfo(){
        propertySearch = propertyEJB.searchPropertyForRent(searchParam);
        return "searchRentalPropertyInfo.xhtml";
    }
    
    //return create for rent property page link.
    public String pageLink() {
        return "createForRentProperty.xhtml";
    }

    //return property details link after searching using property ID.
     public String detailsPageLink(Long id) {
         propertySearch = propertyEJB.searchPropertyForRent(id);
         return "rentalPropertyDetails.xhtml";
     }


     
}
