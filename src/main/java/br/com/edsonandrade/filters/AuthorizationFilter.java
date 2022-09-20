package br.com.edsonandrade.filters;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import br.com.edsonandrade.annotations.Authorization;
import br.com.edsonandrade.dto.ProfileDTO;
import br.com.edsonandrade.exceptions.AuthorizationException;
import br.com.edsonandrade.services.AuthorizationService;

@Provider
@ApplicationScoped
@Authorization
public class AuthorizationFilter implements ContainerRequestFilter{
	
	@Context
    private ResourceInfo resourceInfo;
	
	@Inject
	private AuthorizationService authorizationService;
	
	@Inject
	private ProfileDTO profile;
	
    @Override
    public void filter(ContainerRequestContext request) throws IOException{
    	String value = getParameterAnnotation();
    	
    	if(!authorizationService.checkPermission(value, value)){
    		throw new AuthorizationException();
    	}
    	
    	profile.setProfile("parameter adicionado e alterado");
    }

	private String getParameterAnnotation() {
		Method theMethod = resourceInfo.getResourceMethod();
    	return theMethod.getAnnotation(Authorization.class).value();
	}

}
