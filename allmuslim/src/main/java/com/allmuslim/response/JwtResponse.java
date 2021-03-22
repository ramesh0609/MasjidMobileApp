package com.allmuslim.response;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String username;
	private final String status;
	private final Collection<? extends GrantedAuthority> collection;
	

	public JwtResponse(String status,String jwttoken,String username,Collection<? extends GrantedAuthority> collection) {
		this.jwttoken = jwttoken;
		this.username=username;
		this.status=status;
		this.collection=collection;
		
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getUsername() {
		return username;
	}

	public String getStatus() {
		return status;
	}

	public Collection<? extends GrantedAuthority> getCollection() {
		return collection;
	}

	

	
	
}