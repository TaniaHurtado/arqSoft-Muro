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
        PublicacionDAO publiDAO = new PublicacionDAO();
        List<Publicacion> p = (List<Publicacion>)publiDAO.buscarpublicaciones();
        List<Publicacion> pubs = new ArrayList();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarUsuarioId(id);
        // Recorrer lista y escoger publicaciones por id
        for(Publicacion x: p){
            if(x.getPublicacionUsuarioId().equals(usuario)){
                pubs.add(x);
            }
        }
        Collections.reverse(pubs);
        return pubs;
    }
    
}