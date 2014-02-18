/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.beanmanager;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;


public class BeanManager {
    

    private static BeanManager instance = null;
    

    private BeanManager(){
    }
    

    public static BeanManager getInstance(){
        if(instance == null){
            instance = new BeanManager();
        }
        return instance;
    }
    
    public Object lookupRemoteBean(String jndiName, String ip, String port) {
        
        try {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

            props.setProperty("org.omg.CORBA.ORBInitialHost", ip);
            props.setProperty("org.omg.CORBA.ORBInitialPort", port);

            Context ic = new InitialContext(props);
            

            return ic.lookup(jndiName);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
