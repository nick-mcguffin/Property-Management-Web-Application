package assignment3.entities;

import assignment3.entities.Property;
import assignment3.entities.PropertyManager;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-22T23:36:03")
@StaticMetamodel(Allocation.class)
public class Allocation_ { 

    public static volatile SingularAttribute<Allocation, PropertyManager> manager;
    public static volatile SingularAttribute<Allocation, Property> property;
    public static volatile SingularAttribute<Allocation, Integer> allocationID;
    public static volatile SingularAttribute<Allocation, Date> creationDate;

}