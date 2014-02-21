/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loginservice.dao;

import fh.ostfalia.projekt2014.loginservice.entities.User;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


@Stateless
public class UserDao implements Serializable {
     @PersistenceContext
    private EntityManager em;
  //  @Resource
    //UserTransaction ut;
    
    public void addUser(User user) {
         System.out.println("-----> Wir sind in Adduser im UserDAO!");
        
           //  ut.begin();
             em.persist(user);
             //ut.commit();
       
    }

    public void editUser(User user) {
        em.merge(user);
    }


    public void deleteUser(int userId) {
        em.remove(getUser(userId));
    }


    public User getUser(int userId) {
        return em.find(User.class, userId);
    }


    public List<User> getAllUsers() {
        return em.createNamedQuery("User.getAll").getResultList();
    }

}
