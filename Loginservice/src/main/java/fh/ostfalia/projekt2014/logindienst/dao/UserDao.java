/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.logindienst.dao;

import fh.ostfalia.projekt2014.logindienst.entities.User;
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

/**
 *
 * @author anton
 */
@Stateless
public class UserDao  {
     @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction ut;
    
    public void addUser(User user) {
         try {
             ut.begin();
             em.persist(user);
             ut.commit();
         } catch (NotSupportedException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SystemException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (RollbackException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (HeuristicMixedException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (HeuristicRollbackException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalStateException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
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