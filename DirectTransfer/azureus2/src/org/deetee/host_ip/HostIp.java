package org.deetee.host_ip;
// support of ipv6 is disabled
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class HostIp  {
	private  String host_ip = "unknown" ;
	private boolean connectedToNU = false;
	
	private boolean findHostIp() throws UnknownHostException, SocketException {
		
		Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        while ( n.hasMoreElements() )  {
                NetworkInterface e = n.nextElement();
               // System.out.println("Interface: " + e.getName());
                Enumeration<InetAddress> a = e.getInetAddresses();
                while( a.hasMoreElements())  {
                	    InetAddress addr = a.nextElement();
                	    String currentAddress = addr.getHostAddress() ;
                        if( (currentAddress).startsWith("172.19") ) {
                        	host_ip = currentAddress ;
                        	connectedToNU = true ;
                        	return true ;
                        }
                       // System.out.println("  " + addr.getHostAddress());
                }
        }
        return false ;
	}
	
	
	public  boolean isConnectedToNU() throws  SocketException, UnknownHostException {
		
		return findHostIp();
	}

	public  String getHost_ip() {
		return host_ip;
	}
  
}
