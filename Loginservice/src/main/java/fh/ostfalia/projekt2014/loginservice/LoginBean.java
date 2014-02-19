/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loginservice;


import java.io.Serializable;
import java.security.Principal;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import fh.ostfalia.projekt2014.loginserviceremoteinterfaces.interfaces.Login;
import javax.ejb.Stateful;

@Stateful
public class LoginBean implements Serializable, Login {

    @Override
    public void printSth(){
        System.out.println("LoginBean erstellt!");
    }
   @Override
  public String login (String username, String password) {
    System.out.println("Ich wurde aufgerufen! :D");
    FacesContext fc = FacesContext.getCurrentInstance();
    HttpServletRequest request;
      request = (HttpServletRequest) fc.getExternalContext().getRequest();
      
    try {
      request.login(username, password);
      Principal principal = request.getUserPrincipal();
      if (request.isUserInRole("admin")) {
				String msg = "User: " + principal.getName() + ", Role: admin";
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
				return "adminseite";
      }
       else if (request.isUserInRole("user")) {
				String msg = "User: " + principal.getName() + ", Role: user";
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
				return "musikservice";
       } 
        return "du_musst_die_rollen_noch_definieren";
    } catch (ServletException e) {
   
        fc.addMessage(null, new FacesMessage("Login failed."));
        return "error";
    }   
  }
  @Override
  public boolean logout() {
    FacesContext fc = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)
        fc.getExternalContext().getRequest();
    try {
      request.logout();
      return true;
    } catch (ServletException e) {
  
      fc.addMessage(null, new FacesMessage("Logout failed."));
      return false;
    }
  }

    @Override
    public boolean registration() {
      System.out.println("SINNLOSE REGISTRIERUNG");
      return true;
    }

  
}
