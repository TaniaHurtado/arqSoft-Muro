/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import BusinessLogic.Controller.sesionUsuario;
import DataAccess.Entity.Comentario;
import DataAccess.Entity.Publicacion;
import DataAccess.Entity.Usuario;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author wilman
 */
public class PublicacionDAO {
    
    public EntityManagerFactory emf1= Persistence.createEntityManagerFactory("MuroPU");
    
    public Publicacion persist(Publicacion publicacion) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(publicacion);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return publicacion;
    }
    
    public List buscarpublicaciones(){
        EntityManager em = emf1.createEntityManager();
        List pub = null;
        sesionUsuario us = new sesionUsuario();
        String peticion = "select a from Publicacion a"; // where a.publicacionUsuarioId = " + us.getusuarioActual().getUsuarioId();
        Query q = em.createQuery(peticion);
        try {
            pub =  q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return pub;
        }
    }
    
    public Publicacion buscarPublicacionId(Integer id){
        EntityManager em = emf1.createEntityManager();
        Publicacion publicacion = em.find(Publicacion.class, id);
        em.close();
        return publicacion;
    }
    
    public boolean editarPublicacion(Integer id, String contenido) {
        Publicacion pb;
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        boolean success = true;
        try {
            
            pb = em.merge(em.find(Publicacion.class, id));
            System.out.println("encontro pb"+pb);
            pb.setPublicacionContenido(contenido);
            System.out.println("cambio contenido"+ contenido);
            em.getTransaction().commit();
        } catch (Exception e) {
            success = false;
        } finally {
            em.close();
        }
        return success;
    }
    
    public Publicacion eliminarPublicacion(int id) {
        EntityManager em = emf1.createEntityManager();
        try {
            Publicacion publicacion = em.find(Publicacion.class, id);
            em.getTransaction().begin();
            System.out.println(" DAO eliminar" + id);
            //Collection<Comentario> comentarios = publicacion.getComentarioCollection();
            //System.out.println(" comentarios en dao"+comentarios);
            //publicacion.getComentarioCollection().removeAll(publicacion.getComentarioCollection());
            //System.out.println(" comentarios en dao despues"+comentarios);
            em.remove(publicacion);
            em.getTransaction().commit();
            em.close();
            return publicacion;
        } catch(Exception e) {
            e.printStackTrace(); 
            em.close();
            return null;
        }
    }
    /*
    public Publicacion buscarPublicacionPorId(Integer id){
        EntityManager em = emf1.createEntityManager();
        Query q = em.createNamedQuery("Publicacion.findByPublicacionId");
        q.setParameter("publicacionId", id);
        Publicacion publicacion = null;
        try {
            publicacion = (Publicacion) q.getSingleResult();
            setmessage("Publicacion encontrada");
        }catch (Exception e){
            setmessage("Publicacion no encontrada");
        } finally {
            em.close();
            return publicacion;
        }
    }*/
    
}
