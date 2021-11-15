/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;


/**
 *
 * @author Nick McGuffin
 */

//create Allocation entity and named query to select an allocation from database using user input.
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllocationByID", query = "select a from Allocation a where a.allocationID = :alloID"),
    @NamedQuery(name = "findAllocationswithManagerResult", query = "select a from Allocation a where a.manager = :manager"),
    @NamedQuery(name = "findAllAllocations", query = "select a from Allocation a")
})
public class Allocation implements Serializable  {
    //use @ annotations to auto generate an allocation ID for the entity, create Many to One relationships with both property and property manager.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer allocationID;
    @JoinColumn(name="property")
    @ManyToOne(fetch = FetchType.LAZY)
    private Property property;
    @JoinColumn(name="manager")
    @ManyToOne(fetch = FetchType.LAZY)
    private PropertyManager manager;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;

    //constructors, getters and setters.
    public Allocation() {
    }

    public Allocation(PropertyManager manager, Property property) { 
        this.manager = manager;
        this.property = property;
        this.creationDate = new Date();
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setManager(PropertyManager manager) {
        this.manager = manager;
    }

    public int getAllocationID() {
        return allocationID;
    }

    public Property getProperty() {
        return property;
    }

    public PropertyManager getManager() {
        return manager;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
