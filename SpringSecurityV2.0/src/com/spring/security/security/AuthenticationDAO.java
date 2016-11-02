package com.spring.security.security;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.security.domain.common.UserDetailsDTO;




@Repository
public class AuthenticationDAO  {
	
	private Logger logger = Logger.getLogger(AuthenticationDAO.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDetailsDTO getDetailsForUserId(String strUserId) {
		UserDetailsDTO userDetailsDTO = null;
		System.out.println("USER ID :"+strUserId);

		Session session=null;
		try{
			session =sessionFactory.openSession();
			userDetailsDTO = (UserDetailsDTO) session.get(UserDetailsDTO.class, strUserId);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e);
			if( null == userDetailsDTO)
				userDetailsDTO = new UserDetailsDTO();
		}
		finally {
			if(session.isOpen())
				session.close();
		}
		System.out.println("Object: "+ userDetailsDTO);
		return userDetailsDTO;
	}
	
	public void updatePasswordForUser(String updateQuery, UserDetailsDTO userDetails,String newPassword){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int numOfUpdate = session.createQuery(updateQuery).
		setString("newPassword", newPassword).
		setInteger("version", userDetails.getVersion()+1).
		setString("updatedAuthor", userDetails.getUsername()).
		setDate("updatedDate", new Date()).setString("userId", userDetails.getUsername()).executeUpdate();
		transaction.commit();
		session.close();
		logger.debug("in change pwd method. num of rows updated: " + numOfUpdate);
	}
	
	public void updateUser(UserDetailsDTO userDetailsDTO)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(userDetailsDTO);
	}


}