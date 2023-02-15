package com.sample.businesslogic;

import com.sample.business.HelloBeanRemote;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@Remote(HelloBeanRemote.class)
public class HelloBean implements HelloBeanRemote {

    /**
     * Default constructor. 
     */
    public HelloBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String hello() {
    	return "Welcome to EJB";
    }

}
