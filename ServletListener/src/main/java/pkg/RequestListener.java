package pkg;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;



public class RequestListener implements ServletRequestListener {

   

    public void requestInitialized(ServletRequestEvent event)  
    { 
       System.out.println("Request Created");
    }

	
    
    public void requestDestroyed(ServletRequestEvent event)
    { 
    	System.out.println("Request Destroyed");
    }
	
}
