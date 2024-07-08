package pkg;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class ListenerClass implements ServletRequestListener 
{

    
    public void requestInitialized(ServletRequestEvent event) 
    { 
         
    	System.out.println("Servlet Initialised");
    }

	
    public void requestDestroyed(ServletRequestEvent event) 
    { 
         
    	System.out.println("Servlet Destroyed ");
    	
    }
	
}
