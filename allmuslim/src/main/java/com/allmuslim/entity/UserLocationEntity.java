package com.allmuslim.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="user_location")
public class UserLocationEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private AppUserEntity appuserLocation;
	private String latitude;
	private String langitude;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLangitude() {
		return langitude;
	}
	public void setLangitude(String langitude) {
		this.langitude = langitude;
	}
	public AppUserEntity getAppuserLocation() {
		return appuserLocation;
	}
	public void setAppuserLocation(AppUserEntity appuserLocation) {
		this.appuserLocation = appuserLocation;
	}
	

}
