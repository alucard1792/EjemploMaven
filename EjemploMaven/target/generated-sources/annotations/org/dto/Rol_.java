package org.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.dto.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-09T13:28:54")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, User> userList;
    public static volatile SingularAttribute<Rol, String> name;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile SingularAttribute<Rol, Integer> status;

}