/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Autenticacion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wilman
 */
public class AutenticacionDAO {
    
    public EntityManagerFactory emf1= Persistence.createEntityManagerFactory("MuroPU");
    
    public Autenticacion persist(Autenticacion autenticacion) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(autenticacion);
            em.getTransaction().commit();
            em.close();
            return autenticacion;                    
        } catch(Exception e) {
            e.printStackTrace();
            em.close();
            return null;
        }
    }
    
}
