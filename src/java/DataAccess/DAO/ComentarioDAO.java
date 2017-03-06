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
    
    public List<Comentario> buscarComentarios(Integer id){
        // Crear objeto EntityManager para correr queries
        EntityManager em = emf1.createEntityManager();
        // Crear un objeto PublicacionDAO y bus car la publicación por id
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        Publicacion publicacion = publicacionDAO.buscarPublicacionId(id);
        // Declarar una lista de comentarios
        List<Comentario> comentarios;
        try {
            // Asignar a la lista el resultado de la namedQuery findAllByPublicacion
            // Esta consulta debe recibir un objeto de clase Publicacion, no un Integer
            // Retorna los comentarios pertenecientes a la pulicacion
            comentarios = em.createNamedQuery("Comentario.findAllByPublicacion")
            .setParameter("comentarioPublicacionId", publicacion)
            .getResultList();
            em.close();
            return comentarios;
        } catch (Exception e){
            em.close();
            comentarios = null;
            return comentarios;
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
