
package com.ipu.studentsystem.studentmanagement.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;
import com.ipu.studentsystem.studentmanagement.constant.HQLQuery;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;

/**
 * This class performs the functionality of applying the CRUD operations on the
 * Course object and its corresponding values in the database using hibernate
 * 
 * @author raghav
 * 
 */
@Repository
public class CourseDaoServiceImpl implements CourseDaoService {

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@Override
	public Course getCourse(int id) throws StudentEnrollmentException {
		Course courseAttribute = null;
		try {
			Session hibernateSession = sessionFactory.openSession();
			Object courseObject = hibernateSession.get(Course.class, id);
			if (courseObject != null) {
				courseAttribute = (Course) courseObject;
			}
			hibernateSession.close();
			return courseAttribute;
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}

	}

	@Override
	public List<Course> getAllCourses() throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Query fetchCourseQuery = hibernateSession
					.createQuery(HQLQuery.FETCH_COURSES);
			@SuppressWarnings("unchecked")
			List<Course> courseList = (List<Course>) fetchCourseQuery.list();
			return courseList;
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}
}