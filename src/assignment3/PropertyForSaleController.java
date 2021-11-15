/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import assignment3.entities.Property;
import assignment3.entities.PropertyForSale;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author dean
 */
@ManagedBean(name = "propertyForSale")
@RequestScoped
public class PropertyForSaleController {

    @EJB
    private PropertyEJB propertyEJB;
    List<PropertyForSale> propertyForSaleList = new ArrayList<>();
    
    List<PropertyForSale> listProperty;
    Long searchParam;
    PropertyForSale propertySearch;
    PropertyForSale propertyForSale = new PropertyForSale();
    
    //create a new for SAle property and persist to DB, return lsit sale properties page.
    public String doCreateForSaleProperty(){
        propertyForSale = propertyEJB.createPropertyForSale(propertyForSale);
        listSaleProperties();
        return "listSaleProperties.xhtml";
    }
    
    //return list of properties.
    public List<PropertyForSale> listForSaleProperties(){
        listProperty = propertyEJB.listPropertysForSale(); 
        return listProperty;
    }
    //return list sale properties page alongside list of properties as string.
    public String listSaleProperties(){
        propertyForSaleList = propertyEJB.listPropertysForSale();
        return "listSaleProperties.xhtml";
    }
    //getters and setters
    public PropertyEJB getPropertyEJB() {
        return propertyEJB;
    }

    public void setPropertyEJB(PropertyEJB propertyEJB) {
        this.propertyEJB = propertyEJB;
    }

    public PropertyForSale getPropertyForSale() {
        return propertyForSale;
    }

    public void setPropertyForSale(PropertyForSale propertyForSale) {
        this.propertyForSale = propertyForSale;
    }
    
     public List<PropertyForSale> getPropertyForSaleList() {
        return propertyForSaleList;
    }

    public Long getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(Long searchParam) {
        this.searchParam = searchParam;
    }

    public PropertyForSale getPropertySearch() {
        return propertySearch;
    }

    public void setPropertySearch(PropertyForSale propertySearch) {
        this.propertySearch = propertySearch;
    }

    //return create page link
     public String pageLink() {
        return "createSaleProperty.xhtml";
    }
     
     //return search page link.
     public String searchPageLink(){
         return "searchSaleProperty.xhtml";
     }
     
     //search Sale property info using search parameter from JSF page, return info page based on search params.
     public String searchSalePropertyInfo(){
        propertySearch = propertyEJB.searchPropertyForSale(searchParam);
        return "searchSalePropertyInfo.xhtml";
    }
   
     //return sale property details page.
     public String detailsPageLink(Long id) {
      propertySearch = propertyEJB.searchPropertyForSale(id);
         return "salePropertyDetails.xhtml";
     }
}
