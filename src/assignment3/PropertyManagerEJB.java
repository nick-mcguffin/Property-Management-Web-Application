/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import assignment3.entities.PropertyForSale;
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
public class PropertyManagerEJB {
    
    @PersistenceContext(unitName = "Assignment_3PU")
    private EntityManager em;
    
    //create property manager and persist to db
    public PropertyManager createPropertyManager(PropertyManager propertyManager){
        em.persist(propertyManager);
        return propertyManager;
    }
    //list property manager query from db
    public List<PropertyManager> listPropertyManagers(){
        Query query = em.createNamedQuery("findAllPropertyManagers");
        return query.getResultList();
    }
    //search property manager function from db using first name
     public PropertyManager searchPropertyManagerFirstName (String firstName){
        TypedQuery<PropertyManager> findByFirstNameQuery = em.createNamedQuery("findPropertyManagerFirstName", PropertyManager.class);
        findByFirstNameQuery.setParameter("firstName", firstName);
        PropertyManager resultManager = findByFirstNameQuery.getSingleResult();
        try {
            resultManager = findByFirstNameQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultManager;
    }
     //search property manager function from db using last name
     public PropertyManager searchPropertyManagerLastName (String lastName){
        TypedQuery<PropertyManager> findByLastNameQuery = em.createNamedQuery("findPropertyManagerLastName", PropertyManager.class);
        findByLastNameQuery.setParameter("lastName", lastName);
        PropertyManager resultManager = findByLastNameQuery.getSingleResult();
        try {
            resultManager = findByLastNameQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultManager;
    }
     //search property manager function from db using full name
     public PropertyManager searchPropertyManagerName (String firstName, String lastName){
        TypedQuery<PropertyManager> findByNameQuery = em.createNamedQuery("findPropertyManagerName", PropertyManager.class);
        findByNameQuery.setParameter("firstName", firstName);
        findByNameQuery.setParameter("lastName", lastName);
        PropertyManager resultManager = findByNameQuery.getSingleResult();
        try {
            resultManager = findByNameQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultManager;
    }
    //search property manager function from db using manager ID
    public PropertyManager searchPropertyManagerID (long ID){
        TypedQuery<PropertyManager> findByIDQuery = em.createNamedQuery("findPropertyManagerID", PropertyManager.class);
        findByIDQuery.setParameter("pmID", ID);
        PropertyManager resultManager = findByIDQuery.getSingleResult();
        try {
            resultManager = findByIDQuery.getSingleResult();
        } catch (NoResultException nre){
            System.out.println("no result for ID: " + ID);
        }
        return resultManager;
    }
     
}
