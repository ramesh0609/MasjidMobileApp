package com.allmuslim.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allmuslim.build.BuildAppUser;
import com.allmuslim.dao.AppUserDao;
import com.allmuslim.entity.AppUserEntity;
import com.allmuslim.entity.UserLocationEntity;
import com.allmuslim.entity.UserPersonalInfoEntity;
import com.allmuslim.exception.CustomException;

import com.allmuslim.request.AppUserRequest;
import com.allmuslim.request.PollsRequest;
import com.allmuslim.request.UserLocationRequest;
import com.allmuslim.request.UserPersonalInfoRequest;
import com.allmuslim.service.AppUserService;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

	@Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
	private static final Logger log=LoggerFactory.getLogger(AppUserServiceImpl.class);
	
	@Autowired
	private AppUserDao appUserDao;
	AppUserEntity findAppUser;
	
	@Override
	public AppUserEntity addAppUser(AppUserRequest appUserRequest) {
		AppUserEntity appUser=BuildAppUser.appUser(appUserRequest);
		appUser.setPassword(bCryptPasswordEncoder.encode(appUserRequest.getPassword()));
		System.out.println(appUser);
		findAppUser=appUserDao.findAppUserByEmailID(appUserRequest.getEmail());
		if(findAppUser!=null)
		{
			log.info("user "+appUserRequest.getEmail()+" allready exist");
			System.out.println("user allready exist");
			throw new CustomException("User Allready Exist");
		}
		findAppUser=appUserDao.saveUser(appUser);
		return findAppUser;
	}

	@Override
	public Long adduserPersonalInfo(UserPersonalInfoRequest userPersonalInfoRequest, Long id) {
		AppUserEntity appUserData=appUserDao.findUserByID(id);
		UserPersonalInfoEntity userPersonalInfo=BuildAppUser.buildUserPersonalInfo(userPersonalInfoRequest,appUserData);
		appUserDao.saveUserPersonalInfo(userPersonalInfo);
		appUserData.setUserPersonalInfo(userPersonalInfo);
		return appUserData.getId();
	}

	
	@Override
	public String addLocation(UserLocationRequest userLocationRequest,long id) {
		UserLocationEntity userLocation=BuildAppUser.buildUserLocation(userLocationRequest);
		AppUserEntity appUserData=appUserDao.findUserByID(id);
		userLocation.setAppuserLocation(appUserData);
		UserLocationEntity resSatatus=appUserDao.addLocation(userLocation);
		
		return null;
	}

	
}
