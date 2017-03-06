package DataAccess.Entity;

import DataAccess.Entity.Amigo;
import DataAccess.Entity.Autenticacion;
import DataAccess.Entity.Comentario;
import DataAccess.Entity.Publicacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-06T01:35:35")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usuarioNick;
    public static volatile SingularAttribute<Usuario, String> usuarioCorreo;
    public static volatile SingularAttribute<Usuario, Autenticacion> autenticacion;
    public static volatile CollectionAttribute<Usuario, Amigo> amigoCollection;
    public static volatile SingularAttribute<Usuario, Integer> usuarioId;
    public static volatile SingularAttribute<Usuario, String> usuarioNombre;
    public static volatile CollectionAttribute<Usuario, Publicacion> publicacionCollection;
    public static volatile CollectionAttribute<Usuario, Comentario> comentarioCollection;
    public static volatile CollectionAttribute<Usuario, Amigo> amigoCollection1;

}