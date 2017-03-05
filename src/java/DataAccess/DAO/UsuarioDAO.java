/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Autenticacion;
import java.io.*;
import java.util.*;
import DataAccess.Entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author wilman
 */
public class UsuarioDAO {
    
    private String message;
    
    public EntityManagerFactory emf1= Persistence.createEntityManagerFactory("MuroPU");
    
    public Usuario persist(Usuario usuario) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(usuario);
            em.getTransaction().commit();
            em.close();
            return usuario;
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }    
    
    public Usuario delete(int usuarioID) {
        EntityManager em = emf1.createEntityManager();
        Usuario usuario = em.find(Usuario.class, usuarioID);
        em.getTransaction().begin();
        try {
            em.remove(usuario);
            em.getTransaction().commit();
            em.close();
            return usuario;
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }
    
    public Usuario buscarUsuario(String nick, String contrasena){
        EntityManager em = emf1.createEntityManager();
        Usuario usuario = null;
        Autenticacion aut = null;
        String peticionu = "select a from Usuario a where a.usuarioNick = '" + nick + "'";
        Query q = em.createQuery(peticionu);
        try {
            usuario = (Usuario) q.getSingleResult();
            String peticiona = "select a from Autenticacion a where a.autenticacionId = " + usuario.getUsuarioId();
            q = em.createQuery(peticiona);
            aut = (Autenticacion) q.getSingleResult();
            if(!aut.getAutenticacionContrasena().equals(contrasena))
                setmessage("Invalido");
            else
                setmessage("Encontrado");
        } catch (Exception e){
            setmessage("No encontrado");
        } finally {
            em.close();
            return usuario;
        }
    }
    
    public Usuario buscarUsuarioId(Integer id){
        EntityManager em = emf1.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }
    
    public String getmessage(){
        return this.message;
    }
    
    public void setmessage(String message){
        this.message = message;
    }
}
