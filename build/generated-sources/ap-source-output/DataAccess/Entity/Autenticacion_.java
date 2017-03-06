package DataAccess.Entity;

import DataAccess.Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T23:58:59")
@StaticMetamodel(Autenticacion.class)
public class Autenticacion_ { 

    public static volatile SingularAttribute<Autenticacion, String> autenticacionContrasena;
    public static volatile SingularAttribute<Autenticacion, Integer> autenticacionId;
    public static volatile SingularAttribute<Autenticacion, Usuario> usuario;

}