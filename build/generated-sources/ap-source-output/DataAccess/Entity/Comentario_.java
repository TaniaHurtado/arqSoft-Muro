package DataAccess.Entity;

import DataAccess.Entity.Publicacion;
import DataAccess.Entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-06T00:52:03")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Usuario> comentarioUsuarioId;
    public static volatile SingularAttribute<Comentario, String> comentarioContenido;
    public static volatile SingularAttribute<Comentario, Date> comentarioFecha;
    public static volatile SingularAttribute<Comentario, Integer> comentarioId;
    public static volatile SingularAttribute<Comentario, Publicacion> comentarioPublicacionId;

}