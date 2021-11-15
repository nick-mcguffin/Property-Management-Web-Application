/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import assignment3.entities.Allocation;
import assignment3.entities.Property;
import assignment3.entities.PropertyManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author dean
 */
@Stateless
public class AllocationEJB {
    @PersistenceContext(unitName = "Assignment_3PU")
    private EntityManager em;

    //create new allocation by merging property manager and property
    public void createAllocation(PropertyManager propertyManager, Property property){
        Allocation allocation = new Allocation (propertyManager, property);
        em.merge(allocation);
    }
    //return a list of all current allocations using find all allo cquery.
    public List<Allocation> listAllocations(){
        Query query = em.createNamedQuery("findAllAllocations");
        return query.getResultList();
    }
    //search allocations using ID
    public Allocation searchAllocation(long Id){
        TypedQuery<Allocation> findByIdQuery = em.createNamedQuery("findAllocationByID", Allocation.class);
        findByIdQuery.setParameter("alloID", Id);
        Allocation resultAllocation = null;
        try {
            resultAllocation = findByIdQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultAllocation;
    }
    
    //get allocations for a manger using the manager result query.
    public List<Allocation> getAllocationsForManager (PropertyManager pm){
        TypedQuery<Allocation> findByIdQuery = em.createNamedQuery("findAllocationswithManagerResult", Allocation.class);
        findByIdQuery.setParameter("manager", pm);
        List<Allocation> results = null;
        try {
            results = findByIdQuery.getResultList();
        } catch (NoResultException nre){
        }
        return results;
    }

    //delete all allocations.
    public void deleteAllocation(Allocation allocation){
        if (!em.contains(allocation)) {
            allocation = em.merge(allocation);
        }
        em.remove(allocation);
    }
}
