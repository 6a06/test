package controler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.UserList;
import model.dao.DAOMutter;

/**
 * Application Lifecycle Listener implementation class docoTsubuListener
 *
 */
//@WebListener
public class docoTsubuListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public docoTsubuListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent var1)  {
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent var1)  {
         // TODO Auto-generated method stub
		ServletContext application=var1.getServletContext();
    	System.out.println("リスナーが動いています");
		UserList ul = new UserList();
		DAOMutter daom=new DAOMutter();
		daom.findAll(ul);
		application.setAttribute("ul", ul);
    }

}
