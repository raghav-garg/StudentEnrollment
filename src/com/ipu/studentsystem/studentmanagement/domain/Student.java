
package com.ipu.studentsystem.studentmanagement.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKeyManyToMany;

import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.model.Person;

/**
 * Domain class which contains the characterstics a Student should possess
 * 
 * @author raghav
 * 
 */
@Entity(name = "Student")
public class Student extends Person {

	@Column(name = "enrollmentNumber", unique = true)
	private int enrollmentNumber;

	@CollectionOfElements(targetElement = Integer.class, fetch = FetchType.EAGER)
	@JoinTable(name = "CourseMarks", joinColumns = @JoinColumn(name = "StudentID", nullable = false))
	@MapKeyManyToMany(targetEntity = Course.class)
	private Map<Course, Integer> marksList = new HashMap<Course, Integer>();

	public Student() {
		super();
	}

	/**
	 * @return the enrollmentNumber
	 */
	public int getEnrollmentNumber() {
		return enrollmentNumber;
	}

	/**
	 * @param enrollmentNumber
	 *            the enrollmentNumber to set
	 */
	public void setEnrollmentNumber(int enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	/**
	 * @return the marksList
	 */
	public Map<Course, Integer> getMarksList() {
		return marksList;
	}

	/**
	 * @param marksList
	 *            the marksList to set
	 */
	public void setMarksList(Map<Course, Integer> marksList) {
		this.marksList = marksList;
	}

	/**
	 * Update the marks of a particular course of a student
	 * 
	 * @param course
	 *            : Course Object to be updated
	 * @param newMarks
	 *            : new marks of the course
	 */
	public void updateMarks(Course courseToUpdate, int newMarks) {
		Integer marks = marksList.get(courseToUpdate);
		if (marks != null) {
			marksList.put(courseToUpdate, newMarks);
		}
	}

	/**
	 * Removes the course from the students list
	 * 
	 * @param courseToRemove
	 */
	public void removeCourse(Course courseToRemove) {
		marksList.remove(courseToRemove);
	}

	/**
	 * Assign a new course to the user
	 * 
	 * @param course
	 *            : course to be assigned
	 */
	public void assignNewCourse(Course course) {
		marksList.put(course, -1);
	}
}