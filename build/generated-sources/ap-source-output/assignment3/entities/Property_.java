package assignment3.entities;

import assignment3.entities.Allocation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-22T23:36:03")
@StaticMetamodel(Property.class)
public class Property_ { 

    public static volatile SingularAttribute<Property, String> address;
    public static volatile ListAttribute<Property, Allocation> allocations;
    public static volatile SingularAttribute<Property, String> description;
    public static volatile SingularAttribute<Property, Long> propertyID;
    public static volatile SingularAttribute<Property, Integer> numberOfBedrooms;

}