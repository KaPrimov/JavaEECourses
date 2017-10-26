package bg.jwd.listeners;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestLogger
 *
 */
@WebListener
public class RequestLogger implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestLogger() {
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
    public void requestDestroyed(ServletRequestEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @Override
    public void requestInitialized(ServletRequestEvent event)  {    	
		System.out.println("Address: " + event.getServletRequest().getRemoteAddr());
		System.out.println("Request session: " + ((HttpServletRequest) event.getServletRequest()).getSession().getId());
		String method = ((HttpServletRequest)event.getServletRequest()).getMethod();
		String uri = ((HttpServletRequest)event.getServletRequest()).getRequestURI().toString();
		if ("post".equals(method.toLowerCase()) && uri != null && uri.endsWith("/Login")) {
			System.out.println("Login");
		} else {
			System.out.println("Regular");
		}
		System.out.println(new Date());
    }
	
}
