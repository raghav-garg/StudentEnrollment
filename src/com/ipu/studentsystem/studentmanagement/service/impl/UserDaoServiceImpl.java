
package com.ipu.studentsystem.studentmanagement.service.impl;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;
import com.ipu.studentsystem.studentmanagement.constant.HQLQuery;
import com.ipu.studentsystem.studentmanagement.constant.SessionAttribute;
import com.ipu.studentsystem.studentmanagement.model.ApplicationUser;
import com.ipu.studentsystem.studentmanagement.service.UserDaoService;

/**
 * This class performs the functionality of applying the CRUD operations on the
 * user object and its corresponding values in the database using hibernate
 * 
 * @author raghav
 * 
 */
@Repository
public class UserDaoServiceImpl implements UserDaoService {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public boolean validateUser(String username, String password,
			Map<String, Object> sessionMap) throws StudentEnrollmentException {
		boolean isValidUser = false;
		try {
			Session hibernateSession = sessionFactory.openSession();
			Query hqlQuery = hibernateSession.createQuery(HQLQuery.FETCH_USER);
			hqlQuery.setString("username", username);
			Object userObject = hqlQuery.uniqueResult();
			if (userObject != null) {
				ApplicationUser user = (ApplicationUser) userObject;
				if (user.getUserCredential().getPassword().equals(password)) {
					sessionMap.put(SessionAttribute.USERNAME, username);
					sessionMap.put(SessionAttribute.ROLE, "role");
					isValidUser = true;
				}
			}
			return isValidUser;
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}