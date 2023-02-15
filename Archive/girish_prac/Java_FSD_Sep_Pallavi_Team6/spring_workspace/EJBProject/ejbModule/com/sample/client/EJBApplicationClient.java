package com.sample.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.sample.business.HelloBeanRemote;
import com.sample.businesslogic.HelloBean;
import com.sample.clientutility.ClientUtility;

public class EJBApplicationClient {

	public static void main(String[] args) {
		HelloBeanRemote bean = doLookup();
		System.out.println(bean.hello());
	}
	
	private static HelloBeanRemote doLookup() {
		Context context = null;
		HelloBeanRemote bean = null;
		
		try {
			context = ClientUtility.getInitialContext();
			String lookupName = getLookupName();
			//System.out.println(lookupName);
			bean = (HelloBeanRemote) context.lookup(lookupName);
		}catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
		return bean;
	}
	
	private static String getLookupName() {
		String appName = "";
		String moduleName = "EJBProject";
		String distinctName = "";
		String beanName = HelloBean.class.getSimpleName();
		
		final String interfaceName = HelloBeanRemote.class.getName();
		
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;
		
		return name;
	}

}
