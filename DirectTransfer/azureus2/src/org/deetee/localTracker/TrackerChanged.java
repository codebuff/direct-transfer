package org.deetee.localTracker;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.deetee.host_ip.*;
import org.gudy.azureus2.core3.config.COConfigurationManager;

public class TrackerChanged {
	String currentTracker = COConfigurationManager.getStringParameter("Tracker IP");
	
    HostIp hostIp = new HostIp();
    
    String currentIp ;
    
    public boolean trackerChanged() throws UnknownHostException, SocketException{
    	
    	final boolean connectedToNu = hostIp.isConnectedToNU();
    	
    	if ( !connectedToNu ){
    		return false;
    	}
    	
    	//System.out.println(hostIp.isConnectedToNU());
    	
    	// getting the current ip of system
    		currentIp = hostIp.getHost_ip();
    		//System.out.println(currentIp);
    		
    	
    	if ( (currentIp.equals("unknown") ) || ( currentIp.equals("127.0.0.1") ) ) {//not connected to nu or wireless
    		return false;
    	}
    	
    	if(currentTracker.equals("")){// default configuration
    		return false;
    	}
    	
    	if ( !currentTracker.equals(currentIp) ) {
        	
    		return true;
    	}
    	
    	
    	return false;
    }
	
}
