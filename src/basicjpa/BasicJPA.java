/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author A3VB0ZZ
 */
public class BasicJPA {

     private static final String PERSISTENCE_UNIT_NAME = "Engine";
     private static EntityManagerFactory factory;
     
    public static void main(String[] args) {
          factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          EntityManager em = factory.createEntityManager();
          // Read the existing entries and write to console
          Query q = em.createQuery("SELECT u FROM Engine u");
          List<Engine> engList = q.getResultList();
          for (Engine eng : engList) {
               System.out.println(eng.getId()+" "+eng.getHp());
          }
          System.out.println("Size: " + engList.size());

          // Create new user
          em.getTransaction().begin();
          Engine eng = new Engine();
          
          eng.setHp(160);
          em.persist(eng);
          em.getTransaction().commit();

          em.close();
    }
    
}
