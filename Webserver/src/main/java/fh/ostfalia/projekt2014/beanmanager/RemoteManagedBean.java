package fh.ostfalia.projekt2014.beanmanager;

import fh.ostfalia.projekt2014.beanmanager.BeanManager;
import javax.annotation.PostConstruct;


/* abstrakte Klasse, die von jeder Bean pro Service geerbet wird,
 * damit die Services auf ihre Objekte zugreifen können
 * 
 */
public abstract class RemoteManagedBean { 
    private String ip = null;
    private String port = null;
    //Objektname
    private String name = null;
    private Object object;
    

    public RemoteManagedBean(String ip, String port, String name){
        this.ip = ip;
        this.port = port;
        this.name = name;
    }
    
    public Object getObject() {
        return object;
    }
    
    @PostConstruct
    private void initObject(){
        this.object = BeanManager.getInstance().lookupRemoteBean(name, ip, port);
    }
}
