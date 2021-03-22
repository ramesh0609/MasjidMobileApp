package com.allmuslim.build;

import com.allmuslim.entity.AppUserEntity;
import com.allmuslim.entity.UserLocationEntity;
import com.allmuslim.entity.UserPersonalInfoEntity;
import com.allmuslim.request.AppUserRequest;
import com.allmuslim.request.UserLocationRequest;
import com.allmuslim.request.UserPersonalInfoRequest;


public class BuildAppUser {
	
	
	
	
	public static AppUserEntity appUser(AppUserRequest appUserRequest)
	{
		AppUserEntity appUserEntity=new AppUserEntity();
		appUserEntity.setEmail(appUserRequest.getEmail());
		appUserEntity.setUsername(appUserRequest.getUsername());
		appUserEntity.setPolls(appUserRequest.getPolls());
		appUserEntity.setRole(appUserRequest.getRole());
		appUserEntity.setEnabled(true);
		return appUserEntity;
		
	}
	public static UserPersonalInfoEntity buildUserPersonalInfo(UserPersonalInfoRequest userPersonalInfoRequest,AppUserEntity appUserData) {
		UserPersonalInfoEntity userPersonalInfoEntity=new UserPersonalInfoEntity();
		userPersonalInfoEntity.setOccupation(userPersonalInfoRequest.getOccupation());
		userPersonalInfoEntity.setAge(userPersonalInfoRequest.getAge());
		userPersonalInfoEntity.setGender(userPersonalInfoRequest.getGender());
		userPersonalInfoEntity.setAppuser(appUserData);
		userPersonalInfoEntity.setPhoneNo(userPersonalInfoRequest.getPhoneNo());
		userPersonalInfoEntity.setOtp(userPersonalInfoRequest.getOtp());
		userPersonalInfoEntity.setEnable(false);
		return userPersonalInfoEntity;
	}
	public static UserLocationEntity buildUserLocation(UserLocationRequest userLocationRequest) {
		UserLocationEntity userLocationEntity=new UserLocationEntity();
		userLocationEntity.setLangitude(userLocationRequest.getLangitude());
		userLocationEntity.setLatitude(userLocationRequest.getLatitude());
		return userLocationEntity;
	}

}
