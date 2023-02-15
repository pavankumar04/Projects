package com.sample.business;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
	public String hello();
}
