package com.allmuslim.dao;

import com.allmuslim.entity.AppUserEntity;
import com.allmuslim.entity.UserLocationEntity;
import com.allmuslim.entity.UserPersonalInfoEntity;

public interface AppUserDao {

	AppUserEntity findAppUserByEmailID(String email);

	AppUserEntity saveUser(AppUserEntity appUser);

	AppUserEntity findUserByID(Long id);

	void saveUserPersonalInfo(UserPersonalInfoEntity userPersonalInfo);

	UserLocationEntity addLocation(UserLocationEntity userLocation);

	

}
