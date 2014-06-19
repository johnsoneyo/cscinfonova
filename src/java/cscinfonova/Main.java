/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cscinfonova;

import bl.OrderManagerEJBRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Guest
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        // glassfish default port value will be 3700,
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(props);
        
        OrderManagerEJBRemote bean = (OrderManagerEJBRemote) ctx.lookup("bl.OrderManagerEJBRemote");
        
        bean.printOrder("Yam");
    }
}
// OrderManagerEJBRemote bean = (OrderManagerEJBRemote) ctx.lookup("java:global/InfonovaEJB/OrderManagerEJB!bl.OrderManagerEJBRemote");
       