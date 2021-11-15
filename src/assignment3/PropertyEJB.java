/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

import assignment3.entities.Property;
import assignment3.entities.PropertyForRent;
import assignment3.entities.PropertyForSale;
import assignment3.entities.PropertyInRent;
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
public class PropertyEJB {
    
    @PersistenceContext(unitName = "Assignment_3PU")
    private EntityManager em;

    //create property for rent and persist to db
    public PropertyForRent createPropertyForRent(PropertyForRent property){
        em.persist(property);
        return property;
    }
    //create property ikn rent and persist to db
    public PropertyInRent createPropertyInRent(PropertyInRent property){
        em.persist(property);
        return property;
    }
    //create property for sale and persist to db
    public PropertyForSale createPropertyForSale(PropertyForSale property){
        em.persist(property);
        return property;
    }
    //List property query
    public List<Property> listPropertys(){
        Query query = em.createNamedQuery("findAllProperty");
        return query.getResultList();
    }
    
    //List properties for rent query
    public List<PropertyForRent> listPropertysForRent(){
        Query query = em.createNamedQuery("findAllPropertyForRent");
        return query.getResultList();
    }
    //List properties in rent
    public List<PropertyInRent> listPropertysInRent(){
        Query query = em.createNamedQuery("findAllPropertyInRent");
        return query.getResultList();
    }
    //list properties for sale
    public List<PropertyForSale> listPropertysForSale(){
        Query query = em.createNamedQuery("findAllPropertyForSale");
        return query.getResultList();
    }
    //search property by ID
    public Property searchProperty(Long Id){
        TypedQuery<Property> findByIdQuery = em.createNamedQuery("findPropertyById", Property.class);
        findByIdQuery.setParameter("id", Id);
        Property resultProperty = findByIdQuery.getSingleResult();
        try {
            resultProperty = findByIdQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultProperty;
    }
    //search property for sale by ID
    public PropertyForSale searchPropertyForSale(Long Id){
        TypedQuery<PropertyForSale> findByIdQuery = em.createNamedQuery("findPropertyForSaleById", PropertyForSale.class);
        findByIdQuery.setParameter("id", Id);
        PropertyForSale resultProperty = findByIdQuery.getSingleResult();
        try {
            resultProperty = findByIdQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultProperty;
    }
     //search property for rent by ID
    public PropertyForRent searchPropertyForRent(Long Id){
        TypedQuery<PropertyForRent> findByIdQuery = em.createNamedQuery("findPropertyForRentById", PropertyForRent.class);
        findByIdQuery.setParameter("id", Id);
        PropertyForRent resultProperty = findByIdQuery.getSingleResult();
        try {
            resultProperty = findByIdQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultProperty;
    }
    //search property in rent by ID
    public PropertyInRent searchPropertyInRent(Long Id){
        TypedQuery<PropertyInRent> findByIdQuery = em.createNamedQuery("findPropertyInRentById", PropertyInRent.class);
        findByIdQuery.setParameter("id", Id);
        PropertyInRent resultProperty = findByIdQuery.getSingleResult();
        try {
            resultProperty = findByIdQuery.getSingleResult();
        } catch (NoResultException nre){
        }
        return resultProperty;
    }
    //delete property from db
    public void deleteProperty(Property property){
        if (!em.contains(property)) {
            property = em.merge(property);
        }
        em.remove(property);
    }
}
