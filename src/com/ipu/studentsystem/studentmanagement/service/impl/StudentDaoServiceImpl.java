
package com.ipu.studentsystem.studentmanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;
import com.ipu.studentsystem.studentmanagement.constant.HQLQuery;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;

/**
 * This class performs the functionality of applying the CRUD operations on the
 * student object and its corresponding values in the database using hibernate.
 * 
 * @author raghav
 * 
 */
@Repository
public class StudentDaoServiceImpl implements StudentDaoService {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addStudent(Student student, Map<Course, Integer> courseMarks)
			throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Transaction transaction = hibernateSession.beginTransaction();
			hibernateSession.save(student.getResidentAddress());
			hibernateSession.save(student);
			transaction.commit();
			hibernateSession.close();
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	@Override
	public List<Student> getAllStudents() throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Query query = hibernateSession.createQuery(HQLQuery.FETCH_STUDENTS);
			@SuppressWarnings("unchecked")
			List<Student> studentList = (List<Student>) query.list();
			hibernateSession.close();
			return studentList;
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	@Override
	public void updateStudentDetails(Student student)
			throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Transaction transaction = hibernateSession.beginTransaction();
			hibernateSession.update(student);
			transaction.commit();
			hibernateSession.close();
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	@Override
	public void updateMarksList(Student student, Map<Course, Integer> marksList)
			throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Transaction transaction = hibernateSession.beginTransaction();
			student.setMarksList(marksList);
			hibernateSession.update(student);
			transaction.commit();
			hibernateSession.close();
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	@Override
	public void updateSingleSubjectMarks(Student student, Course course,
			int marks) throws StudentEnrollmentException {
		student.updateMarks(course, marks);
	}

	@Override
	public void deleteStudent(Student student)
			throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Transaction transaction = hibernateSession.beginTransaction();
			hibernateSession.delete(student);
			transaction.commit();
			hibernateSession.close();
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	@Override
	public void deleteAllCourse(Student student)
			throws StudentEnrollmentException {
		try {
			Session hibernateSession = sessionFactory.openSession();
			Transaction transaction = hibernateSession.beginTransaction();
			Map<Course, Integer> marksList = new HashMap<Course, Integer>();
			student.setMarksList(marksList);
			hibernateSession.update(student);
			transaction.commit();
			hibernateSession.close();
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}

	@Override
	public Student getStudent(int id) throws StudentEnrollmentException {
		Student studentAttribute = null;
		try {
			Session hibernateSession = sessionFactory.openSession();
			Object studentObject = hibernateSession.get(Student.class, id);
			if (studentObject != null) {
				studentAttribute = (Student) studentObject;
			}
			hibernateSession.close();
			return studentAttribute;
		} catch (HibernateException hibernateException) {
			throw new StudentEnrollmentException(hibernateException);
		}
	}
}