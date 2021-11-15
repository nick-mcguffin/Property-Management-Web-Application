/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import assignment3.entities.Allocation;
import assignment3.entities.PropertyForRent;
import assignment3.entities.PropertyForSale;
import assignment3.entities.PropertyInRent;
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
@ManagedBean(name= "allocation")
@RequestScoped
public class AllocationController {
    @EJB
    private AllocationEJB allocationEJB;
    @EJB
    private PropertyManagerEJB propertyManagerEJB;
    @EJB
    private PropertyEJB propertyEJB;
    
    private String managerFName;
    private String managerLName;
    private long propertyID;
    private long alloID;
    
    private Allocation allocation;
    
    List<Allocation> allocationList = new ArrayList<>();
    List<PropertyForSale> propertyForSaleList = new ArrayList<>();
    List<PropertyForRent> propertyForRentList = new ArrayList<>();
    List<PropertyInRent> propertyInRentList = new ArrayList<>();
    List<PropertyManager> propertyManagerList = new ArrayList<>();

    //getters and setters
    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    public long getAlloID() {
        return alloID;
    }

    public void setAlloID(long alloID) {
        this.alloID = alloID;
    }

    public String getManagerFName() {
        return managerFName;
    }

    public void setManagerFName(String managerFName) {
        this.managerFName = managerFName;
    }

    public String getManagerLName() {
        return managerLName;
    }

    public void setManagerLName(String managerLName) {
        this.managerLName = managerLName;
    }

    public long getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(long propertyID) {
        this.propertyID = propertyID;
    }
    
     public List<Allocation> getAllocationList() {
        return allocationList;
    }

    public void setAllocationList(List<Allocation> allocationList) {
        this.allocationList = allocationList;
    }

    public List<PropertyManager> getPropertyManagerList() {
        return propertyManagerList;
    }

    public void setPropertyManagerList(List<PropertyManager> propertyManagerList) {
        this.propertyManagerList = propertyManagerList;
    }
    public List<PropertyForSale> getPropertyForSaleList() {
        return propertyForSaleList;
    }

    public void setPropertyForSaleList(List<PropertyForSale> propertyForSaleList) {
        this.propertyForSaleList = propertyForSaleList;
    }

    public List<PropertyForRent> getPropertyForRentList() {
        return propertyForRentList;
    }

    public void setPropertyForRentList(List<PropertyForRent> propertyForRentList) {
        this.propertyForRentList = propertyForRentList;
    }

    public List<PropertyInRent> getPropertyInRentList() {
        return propertyInRentList;
    }

    public void setPropertyInRentList(List<PropertyInRent> propertyInRentList) {
        this.propertyInRentList = propertyInRentList;
    }
    
    //create new allocation form.
    public String newAllocationForm(){
        listAllocations();
        propertyManagerList = propertyManagerEJB.listPropertyManagers();
        propertyForSaleList = propertyEJB.listPropertysForSale();
        propertyInRentList = propertyEJB.listPropertysInRent();
        propertyForRentList = propertyEJB.listPropertysForRent();
        return "createAllocation.xhtml";
    }
    
    //create allocaiton  based on manager first name and last name and property id.
    public String doCreateAllocation(){
//        Allocation allocation = new Allocation(propertyManagerEJB.searchPropertyManagerName(managerFName, managerLName), propertyEJB.searchProperty(propertyID));
        allocationEJB.createAllocation(propertyManagerEJB.searchPropertyManagerName(managerFName, managerLName), propertyEJB.searchProperty(propertyID));
        listAllocations();
        return "listAllocations.xhtml";
    }
    
   //list all current allocations. return list allo page.
    public String listAllocations(){
        allocationList = allocationEJB.listAllocations();
        return "listAllocations.xhtml";
    }
    
    //search allocations page.
    public String searchAllocations(){
        return "searchAllocation.xhtml";
    }
    
    //return a list of allocations
    public List<Allocation> allocationList() {
        allocationList = allocationEJB.listAllocations();
        return allocationList;
    }

   //return create allocation page link
    public String pageLink() {
        return "createAllocation.xhtml";
    }
    
    //delete allocation from database.
    public void deleteAllocation(Allocation allo) {
        allocationEJB.deleteAllocation(allo);
    }
    
    //search allocations by ID.
    public String searchAllocationByID() {
        allocation = allocationEJB.searchAllocation(alloID);
        return "searchAllocationResult.xhtml";
    }
}
