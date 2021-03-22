package com.allmuslim.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.allmuslim.dao.AppUserDao;
import com.allmuslim.entity.AppUserEntity;
import com.allmuslim.exception.CustomException;


@Service
@Transactional
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserDao AppUserDao;

	private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		

		AppUserEntity user = AppUserDao.findAppUserByEmailID(email);
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		
		if (user == null) {
			log.debug("invalid user");
			throw new CustomException("invalid user");
		} 
		//authorities.add(new SimpleGrantedAuthority(role));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
