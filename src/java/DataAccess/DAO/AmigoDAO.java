/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Amigo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author wilman
 */
public class AmigoDAO {
    
    public EntityManagerFactory emf1= Persistence.createEntityManagerFactory("MuroPU");
    
    public Amigo persist(Amigo amigo) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(amigo);
            em.getTransaction().commit();
            return amigo;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Integer> obtenerAmigos(Integer id){
        List<Integer> amigos1;
        List<Integer> amigos2;
        EntityManager em = emf1.createEntityManager();
        amigos1 = em.createNamedQuery("Amigo.findByAmigoIdA")
            .setParameter("amigoIdA", id)
            .getResultList();
        amigos2 = em.createNamedQuery("Amigo.findByAmigoIdB")
            .setParameter("amigoIdB", id)
            .getResultList();
        List<Integer> amigos = new ArrayList<Integer>();
        amigos.addAll(amigos1);
        amigos.addAll(amigos2);
        em.close();
        return amigos;
    }
    
}