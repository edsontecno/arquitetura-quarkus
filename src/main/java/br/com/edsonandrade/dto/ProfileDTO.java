package br.com.edsonandrade.dto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfileDTO {
	String profile;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
