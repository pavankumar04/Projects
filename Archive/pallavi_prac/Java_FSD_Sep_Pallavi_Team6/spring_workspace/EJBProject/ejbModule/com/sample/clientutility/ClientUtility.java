package com.sample.clientutility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientUtility {
	
	public static Context initialContext;
	
	private static final String PKG_CONTEXT = "org.jboss.ejb.client.naming";
	
	public static Context getInitialContext() throws NamingException {
		//if(initialContext == null) {
			Properties properties = new Properties();
			
			properties.put(Context.URL_PKG_PREFIXES, PKG_CONTEXT);
			properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		    properties.put(javax.naming.Context.PROVIDER_URL, "remote://localhost:4447");
		    properties.put("jboss.naming.client.ejb.context", true);
			
			initialContext = new InitialContext(properties);
		//}
		
		return initialContext;
	}
}
