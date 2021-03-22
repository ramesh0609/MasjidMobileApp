package com.allmuslim.service;



import com.allmuslim.entity.AppUserEntity;

import com.allmuslim.request.AppUserRequest;
import com.allmuslim.request.PollsRequest;
import com.allmuslim.request.UserLocationRequest;
import com.allmuslim.request.UserPersonalInfoRequest;

public interface AppUserService {

	AppUserEntity addAppUser(AppUserRequest appUserRequest);

	Long adduserPersonalInfo(UserPersonalInfoRequest userPersonalInfoRequest, Long id);

	String addLocation(UserLocationRequest userLocationRequest, long id);

	

}
