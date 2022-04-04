/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubesys.httpfrk.cores;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wuheng@iscas.ac.cn
 * @since  2.2.3
 * 
 * The {@code HttpHandlerManager} class is used to save and get servlet handlers.
 */
@Component
public final class HttpHandlerManager  {

	/**
	 * handlers
	 */
	public static Map<String, Method> servletHandlers = new HashMap<String, Method>();
	
	@Autowired
	protected HttpAPIDoc apidoc;
	
	/**
	 * services 
	 */
	public final static Set<String> services = new HashSet<String>();

	/**
	 * @param serviceModule   service module
	 * @param serviceName     service name
	 */
	public void addHandler(String serviceModule, Method serviceName) {
		String servicePath = serviceModule + "/" + 
				serviceName.getName();
		servletHandlers.put(servicePath, serviceName);
		services.add(servicePath);
		apidoc.addPath("post", servicePath, serviceName);
	}

	/**
	 * @param servletPath   servlet
	 * @return              the related method
	 * @throws Exception    exception
	 */
	public Method getHandler(String servletPath) throws Exception {
		if (!servletHandlers.containsKey(servletPath)) {
			throw new Exception(HttpConstants.EXCEPTION_INVALID_REQUEST_URL);
		}
		return servletHandlers.get(servletPath);
	}

	/**
	 * @param servletPath   servlet
	 * @return              true or false
	 */
	public boolean contain(String servletPath) {
		return servletHandlers.containsKey(servletPath);
	}
		
}
