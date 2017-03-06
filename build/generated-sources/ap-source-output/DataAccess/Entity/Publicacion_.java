package DataAccess.Entity;

import DataAccess.Entity.Comentario;
import DataAccess.Entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T23:58:59")
@StaticMetamodel(Publicacion.class)
public class Publicacion_ { 

    public static volatile SingularAttribute<Publicacion, Integer> publicacionId;
    public static volatile SingularAttribute<Publicacion, Usuario> publicacionUsuarioId;
    public static volatile SingularAttribute<Publicacion, String> publicacionContenido;
    public static volatile SingularAttribute<Publicacion, Date> publicacionFecha;
    public static volatile CollectionAttribute<Publicacion, Comentario> comentarioCollection;

}