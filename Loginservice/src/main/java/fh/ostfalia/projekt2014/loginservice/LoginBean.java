/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loginservice;


import fh.ostfalia.projekt2014.loginservice.dao.UserDao;
import fh.ostfalia.projekt2014.loginservice.entities.User;
import java.io.Serializable;
import java.security.Principal;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import fh.ostfalia.projekt2014.loginserviceremoteinterfaces.interfaces.Login;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;



/**
 * 
 * @author Yannick
 */
@Stateful
public class LoginBean implements Serializable, Login {

    @EJB
    private UserDao userdao;
  
 

    @Override
    public String addUser(String username, String password) {
        System.out.println("-----> Wir sind in Adduser im Loginservice!");
        User user = new User(username, password,"user");
        System.out.println("-----> Im Loginservice wurde der User erstellt!");
        userdao.addUser(user);
        return "index.xhtml";
    }

}
