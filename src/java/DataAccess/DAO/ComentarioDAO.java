/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import BusinessLogic.Controller.sesionUsuario;
import DataAccess.Entity.Comentario;
import DataAccess.Entity.Publicacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author wilman
 */
public class ComentarioDAO {
    
    public EntityManagerFactory emf1= Persistence.createEntityManagerFactory("MuroPU");
    
    public Comentario persist(Comentario comentario) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(comentario);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return comentario;
    }
    
    public List buscarcomentarios(){
        EntityManager em = emf1.createEntityManager();
        List pub = null;
        sesionUsuario us = new sesionUsuario();
        String peticion = "select a from Comentario a"; // where a.publicacionUsuarioId = " + us.getusuarioActual().getUsuarioId();
        Query q = em.createQuery(peticion);
        try {
            pub =  q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return pub;
        }
    }
    public Comentario buscarComentarioId(Integer id){
        EntityManager em = emf1.createEntityManager();
        Comentario comentario = em.find(Comentario.class, id);
        em.close();
        return comentario;
    }
    
    public Comentario eliminarComentario(int id) {
        EntityManager em = emf1.createEntityManager();
        Comentario comentario = em.find(Comentario.class, id);
        em.getTransaction().begin();
        try {
            em.remove(comentario);
            em.getTransaction().commit();
            em.close();
            return comentario;
        } catch(Exception e) {
            e.printStackTrace();
            em.close();            
            return null;
        }
    }
    
}
