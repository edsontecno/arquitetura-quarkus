package br.com.edsonandrade.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LogFilter implements ContainerRequestFilter {

	public void filter(ContainerRequestContext context) {
		System.out.println(context.getUriInfo().getPath());
	}
}
