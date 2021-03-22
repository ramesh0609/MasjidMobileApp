package com.allmuslim.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allmuslim.config.HibSession;
import com.allmuslim.dao.AppUserDao;
import com.allmuslim.entity.AppUserEntity;
import com.allmuslim.entity.UserLocationEntity;
import com.allmuslim.entity.UserPersonalInfoEntity;

@Repository
public class AppUserDaoImpl implements AppUserDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public AppUserEntity findAppUserByEmailID(String email) {
		Session session=sessionFactory.openSession();
		Criteria crt=session.createCriteria(AppUserEntity.class);
		crt.add(Restrictions.eq("email", email));
		AppUserEntity result=(AppUserEntity) crt.uniqueResult();
		session.close();
		return result;
	}
	@Override
	public AppUserEntity saveUser(AppUserEntity appUser) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(appUser);
		session.close();
		return appUser;
	}
	@Override
	public AppUserEntity findUserByID(Long id) {
		Session session=sessionFactory.openSession();
		Criteria crt=session.createCriteria(AppUserEntity.class);
		crt.add(Restrictions.eq("id", id));
		AppUserEntity result=(AppUserEntity) crt.uniqueResult();
		session.close();
		return result;
	}
	@Override
	public void saveUserPersonalInfo(UserPersonalInfoEntity userPersonalInfo) {
		Session session=sessionFactory.openSession();
		session.save(userPersonalInfo);
		session.close();
		
		
	}
	@Override
	public UserLocationEntity addLocation(UserLocationEntity userLocation) {
		Session session=sessionFactory.openSession();
		session.save(userLocation);
		session.close();
		return userLocation;
	}
	

}
