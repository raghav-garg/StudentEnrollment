
package com.ipu.studentsystem.studentmanagement.constant;

/**
 * This class stores the constant which maps the HQL queries used to fetch data.
 * 
 * @author raghav
 * 
 */
public class HQLQuery {

	/**
	 * QUERY used for fetching the user details
	 */
	public static final String FETCH_USER = "from "
			+ "com.ipu.studentsystem.studentmanagement.model.ApplicationUser "
			+ "where userCredential.userName=:username";

	/**
	 * QUERY used for fetching all the Student
	 */
	public static final String FETCH_STUDENTS = "from com.ipu.studentsystem.studentmanagement.domain.Student";

	/**
	 * QUERY used for fetching all the COURSES
	 */
	public static final String FETCH_COURSES = "from com.ipu.studentsystem.studentmanagement.model.Course";
}