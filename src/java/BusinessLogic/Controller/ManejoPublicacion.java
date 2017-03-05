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
        Publicacion publicacion = new Publicacion();
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarUsuarioId(id);
        publicacion.setPublicacionFecha(date);
        publicacion.setPublicacionContenido(contenido);
        publicacion.setPublicacionUsuarioId(usuario);
        PublicacionDAO publiDAO = new PublicacionDAO();
        Publicacion publiE = publiDAO.persist(publicacion);
        return publiE; 
    }
    
    public List<Publicacion> publicaciones(Integer id){
        // Crear un objeto PublicacionDAO y buscar las publicaciones del usuario
        PublicacionDAO publiDAO = new PublicacionDAO();
        List<Publicacion> publicaciones = publiDAO.buscarpublicaciones(id);
        // Se reversa la lista para mostrar las publicaciones en orden cronológico
        // descendente.
        Collections.reverse(publicaciones);
        return publicaciones;
    }
    
}