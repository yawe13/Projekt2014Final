/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loginservice.dao;

import fh.ostfalia.projekt2014.loginservice.entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yannick
 */
@Stateless
public class ClientDao {
    @PersistenceContext
    public List<Client> clientList;
    private EntityManager em;
   
    
    public List<Client> getAllClients(){
        TypedQuery<Client> query = em.createQuery("select u from User u", Client.class);
        clientList = query.getResultList();
        return clientList; 
    }


    public void create(Client client) {
      em.persist(client);
    }
 
    

}
