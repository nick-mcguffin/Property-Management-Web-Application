/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import assignment3.entities.Allocation;
import assignment3.entities.PropertyManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author dean
 */
@ManagedBean(name = "propertyManager")
@RequestScoped
public class PropertyManagerController {

    @EJB
    private PropertyManagerEJB propertyManagerEJB;
    @EJB
    private AllocationEJB allocationEJB;
    
    List<PropertyManager> propertyManagerList = new ArrayList<>();
    PropertyManager propertyManager = new PropertyManager();
    List<PropertyManager> listPropertyManagers;
    String searchFirstName;
    String searchLastName;

    //create Property Manager and return property manager list
    public String doCreatePropertyManager() {
        propertyManager = propertyManagerEJB.createPropertyManager(propertyManager);
        listPropertyManagers();
        return "listPropertyManagers.xhtml";
    }

    //return a list of property managers.
    public List<PropertyManager> propertyManagerList() {
        listPropertyManagers = propertyManagerEJB.listPropertyManagers();
        return listPropertyManagers;
    }

    //return property managers list page with list of  current managers.
    public String listPropertyManagers() {
        propertyManagerList = propertyManagerEJB.listPropertyManagers();
        return "listPropertyManagers.xhtml";
    }

    //search property manager using firstname, last name or full name and return search page.
    public String searchPropertyManager() {
        if (searchLastName.isEmpty()) {
            propertyManager = propertyManagerEJB.searchPropertyManagerFirstName(searchFirstName);
        } else if (searchFirstName.isEmpty()) {
            propertyManager = propertyManagerEJB.searchPropertyManagerLastName(searchLastName);
        } else {
            propertyManager = propertyManagerEJB.searchPropertyManagerName(searchFirstName, searchLastName);
        }
        return "searchPropertyManagerInfo.xhtml";
    }
    
    //search manager name using property manager id.
    public String managerNameForID(long ID){
        PropertyManager pm = propertyManagerEJB.searchPropertyManagerID(ID);
        String name = pm.getFirstName() + " " + pm.getLastName();
        return name;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters-and-Setters">
    public PropertyManagerEJB getPropertyManagerEJB() {return propertyManagerEJB;}

    public void setPropertyManagerEJB(PropertyManagerEJB propertyManagerEJB) {this.propertyManagerEJB = propertyManagerEJB;}

    public List<PropertyManager> getPropertyManagerList() {return propertyManagerList;}

    public void setPropertyManagerList(List<PropertyManager> propertyManagerList) {this.propertyManagerList = propertyManagerList;}

    public PropertyManager getPropertyManager() {return propertyManager;}

    public void setPropertyManager(PropertyManager propertyManager) {this.propertyManager = propertyManager;}

    public String getSearchFirstName() {return searchFirstName;}

    public void setSearchFirstName(String searchFirstName) {this.searchFirstName = searchFirstName;}

    public String getSearchLastName() {return searchLastName;}

    public void setSearchLastName(String searchLastName) {this.searchLastName = searchLastName;}
    //</editor-fold>
   
    //navigation / page-link methods
    public String searchPropertyManagerPageLink() {return "searchPropertyManager.xhtml";}

    public String pageLink() {return "createPropertyManager.xhtml";}
    
    public String detailsPageLink(PropertyManager pm) {
        propertyManager = pm;
        return "propertyManagerDetails.xhtml";
    }
    
    //gets full name as string from manager
    public String getName (PropertyManager pm){return pm.getFirstName() + " " + pm.getLastName();}
    
    //gets total number of allocations for manager
    public int getNumOfAllocations (){return getManagerAllocations().size();}
    
    //gets allocations for manager
    public List<Allocation> getManagerAllocations () {return allocationEJB.getAllocationsForManager(propertyManager);}
}
