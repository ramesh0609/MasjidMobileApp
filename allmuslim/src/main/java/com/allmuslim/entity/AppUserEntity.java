package com.allmuslim.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.allmuslim.request.UserLocationRequest;






@Entity
@Table(name="app_user")
public class AppUserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	private String[] polls;
	private String role;
	private boolean enabled;
	
	@OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "appuser")
	
	private UserPersonalInfoEntity userPersonalInfo;
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "appuserLocation")
	private UserLocationEntity userLocationEntity;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public String[] getPolls() {
		return polls;
	}
	public void setPolls(String[] polls) {
		this.polls = polls;
	}
	public UserPersonalInfoEntity getUserPersonalInfo() {
		return userPersonalInfo;
	}
	public void setUserPersonalInfo(UserPersonalInfoEntity userPersonalInfo) {
		this.userPersonalInfo = userPersonalInfo;
	}
	
	
	

}
