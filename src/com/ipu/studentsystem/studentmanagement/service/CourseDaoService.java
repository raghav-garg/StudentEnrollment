
package com.ipu.studentsystem.studentmanagement.service;

import java.util.List;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;
import com.ipu.studentsystem.studentmanagement.model.Course;

/**
 * This interface defines the functionalities desired on Course Objects
 * 
 * @author raghav
 * 
 */
public interface CourseDaoService {

	/**
	 * Gets the course when the course id is passed as the paramter
	 * 
	 * @param id
	 *            : id of the desired course
	 * @return : Course Object with the given ID and null if the ID is not found
	 */
	public Course getCourse(int id) throws StudentEnrollmentException;

	/**
	 * Gets the list of all the available courses
	 * 
	 * 
	 * @return : Course List of all the available courses
	 */
	public List<Course> getAllCourses() throws StudentEnrollmentException;
}
