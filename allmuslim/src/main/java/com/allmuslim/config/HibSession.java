package com.allmuslim.config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibSession {
	
	private static SessionFactory hibernateFactory;
	@Autowired
	  public static Session getSession() {
		Session session=hibernateFactory.getCurrentSession();
		
		 return session;
	  }
}
