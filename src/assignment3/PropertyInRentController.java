/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;


import assignment3.entities.PropertyForRent;
import assignment3.entities.PropertyInRent;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author dean
 */
@ManagedBean(name = "propertyInRent")
@RequestScoped
public class PropertyInRentController {

    @EJB
    private PropertyEJB propertyEJB;
    List<PropertyInRent> propertyInRentList = new ArrayList<>();
    Long createId;
    String tenantName;
    Long searchParam;
    PropertyInRent propertySearch;
    
    PropertyInRent propertyInRent = new PropertyInRent();
   
    //return list of properties in rent
    public List<PropertyInRent> getPropertyInRentList() {
        propertyInRentList = propertyEJB.listPropertysInRent();
        return propertyInRentList;
    }
    
    //create in rent properties and return a link to the list in rent properties page.
    public String doCreateInRentProperty(){
        PropertyForRent propertyForRent = propertyEJB.searchPropertyForRent(createId);
        propertyInRent = new PropertyInRent(propertyForRent.getAddress(), propertyForRent.getDescription(), propertyForRent.getNumberOfBedrooms(), propertyForRent.getRentalPrice(), tenantName);
        propertyEJB.deleteProperty(propertyForRent);
        propertyInRent = propertyEJB.createPropertyInRent(propertyInRent);
        listInRentProperties();
        return "listInRentProperties.xhtml";
    }

    //return list in properties page with listed properties.
    public String listInRentProperties(){
        propertyInRentList = propertyEJB.listPropertysInRent();
        return "listInRentProperties.xhtml";
    }
    //search in rent property page link.
    public String searchInRentProperty(){
        return "searchInRentProperty.xhtml";
    }

    //getters and setters
    
    public PropertyEJB getPropertyEJB() {
        return propertyEJB;
    }

    public void setPropertyEJB(PropertyEJB propertyEJB) {
        this.propertyEJB = propertyEJB;
    }

    public PropertyInRent getPropertyInRent() {
        return propertyInRent;
    }

    public void setPropertyInRent(PropertyInRent propertyInRent) {
        this.propertyInRent = propertyInRent;
    }

    public Long getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(Long searchParam) {
        this.searchParam = searchParam;
    }

    public PropertyInRent getPropertySearch() {
        return propertySearch;
    }

    public void setPropertySearch(PropertyInRent propertySearch) {
        this.propertySearch = propertySearch;
    }
    
    
    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    // return link to in rent property page.
    public String pageLink() {
        return "createInRentProperty.xhtml";
    }
    
    public String searchRentedPropertyInfo(){
        propertySearch = propertyEJB.searchPropertyInRent(searchParam);
        return "searchRentedPropertyInfo.xhtml";
    }
}
