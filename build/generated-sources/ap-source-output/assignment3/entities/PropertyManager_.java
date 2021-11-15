package assignment3.entities;

import assignment3.entities.Allocation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-22T23:36:03")
@StaticMetamodel(PropertyManager.class)
public class PropertyManager_ { 

    public static volatile SingularAttribute<PropertyManager, String> firstName;
    public static volatile SingularAttribute<PropertyManager, String> lastName;
    public static volatile SingularAttribute<PropertyManager, Integer> phoneNumber;
    public static volatile ListAttribute<PropertyManager, Allocation> allocations;
    public static volatile SingularAttribute<PropertyManager, Long> propertyManagerID;
    public static volatile SingularAttribute<PropertyManager, String> email;

}