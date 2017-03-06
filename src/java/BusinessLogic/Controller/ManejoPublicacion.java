/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;
import java.util.Date;
//import java.sql.Date;
import DataAccess.DAO.PublicacionDAO;
import DataAccess.DAO.UsuarioDAO;
import DataAccess.Entity.Publicacion;
import DataAccess.Entity.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tania
 */public class ManejoPublicacion {
    public Publicacion crearPublicacion(Date fecha, String contenido, Integer id ){
        // Crear un objeto de la clase Publicacion
        Publicacion publicacion = new Publicacion();
        // Crear un objeto de UsuarioDAO y realizar la búsqueda de Usuario por id
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarUsuarioId(id);
        // Asignar atributos a la publicación
        publicacion.setPublicacionFecha(fecha);
        publicacion.setPublicacionContenido(contenido);
        publicacion.setPublicacionUsuarioId(usuario);
        // Crear un objeto PublicacionDAO para registrar en la base de datos
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        Publicacion publicacionE = publicacionDAO.persist(publicacion);
        return publicacionE; 
    }
    
    public List<Publicacion> publicaciones(Integer id){
        // Crear un objeto PublicacionDAO y buscar las publicaciones del usuario
        PublicacionDAO publiDAO = new PublicacionDAO();
        List<Publicacion> publicaciones = publiDAO.buscarPublicaciones(id);
        // Se reversa la lista para mostrar las publicaciones en orden cronológico
        // descendente.
        //Collections.reverse(publicaciones);
        return publicaciones;
    }
    
    public Publicacion editarPublicacion(Integer id, String contenido){
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        return publicacionDAO.editarPublicacion(id, contenido);       
    }
    
    public Publicacion eliminarPublicacion(Integer id){
        PublicacionDAO publiDAO = new PublicacionDAO();        
        Publicacion publicacion = publiDAO.buscarPublicacionId(id);
        System.out.println("encontro publicacion en manejo para eliminar" + publicacion);
        publiDAO.eliminarPublicacion(publicacion.getPublicacionId());
        //Publicacion pb = publiDAO.persist(publicacion);
        
        return publicacion;        
    }
}