/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loginservice;

import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;
import fh.ostfalia.projekt2014.loginserviceremoteinterfaces.interfaces.Login;
import javax.annotation.PostConstruct;

/**
 *
 * @author Yannick
 */

public class LoginMBean extends RemoteManagedBean{
    
    private Login loginBean;
    private String username;
    private String password;
    
    public LoginMBean(){
         super("localhost", "3700", "java:global/Loginservice/LoginBean");
    
         
         
    }
    @PostConstruct
    public void initBean(){
        //Holen der entfernten Loginbean bzw. deren Stub-Objekt
        loginBean = (Login) super.getObject();
        loginBean.printSth();
    }
    
    public String login(){
        //Aufruf der entfernten Login-Methode und Rückgabe der entsprechenden Seite
        System.out.println("Username: " + username );
        System.out.println("Passwort: " + password );

        return loginBean.login(username,password);
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    

}
