package br.com.edsonandrade.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorizationService {
	
	public boolean checkPermission(String rules, String rulesUser) {
		return true;
	}
}	
