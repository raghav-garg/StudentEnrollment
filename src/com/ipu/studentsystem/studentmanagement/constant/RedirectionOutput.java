
package com.ipu.studentsystem.studentmanagement.constant;

/**
 * RedirectionOutput are the parameters used to decide the forwarding and
 * redirection among various pages
 * 
 * @author raghav
 * 
 */
public class RedirectionOutput {

	/**
	 * Constant used when there is no session that exists while accessing a
	 * resource
	 */

	public static final String NO_SESSION = "noSession";
	/**
	 * Constant used when login is successful
	 */
	public static final String SUCCESSFUL_LOGIN = "successfulLogin";

	/**
	 * Constant used when username or password is incorrect
	 */
	public static final String INCORRECT_DETAILS = "incorrectDetails";

	/**
	 * Constant used when user tries to attempt a login when the session is
	 * already mapped to the user
	 */
	public static final String SESSION_EXISTS = "sessionExists";

	/**
	 * Constant used when the student is successfully added to the database
	 */
	public static final String SUCCESSFULLY_ADDED = "studentAdded";

	/**
	 * Constant used when the student is successfully updated to the database
	 */
	public static final String SUCCESSFULLY_UPDATED = "studentUpdated";

	/**
	 * Constant used when the student is successfully deleted from the database
	 */
	public static final String SUCCESSFULLY_DELETED = "studentDeleted";

	/**
	 * Constant used when the Course is successfully deleted from the student
	 * course list database
	 */
	public static final String COURSE_DELETED = "courseDeleted";

	/**
	 * Constant used when the Course Marks are successfully updated from the
	 * student course list database
	 */
	public static final String COURSE_MARKS_UPDATED = "courseMarksUpdated";

	/**
	 * Constant used when the marks of the courses are successfully updated
	 */
	public static final String ALL_MARKS_UPDATED = "allMarksUpdated";

	/**
	 * Constant used when all the students are fetched from the database
	 */
	public static final String ALL_STUDENTS_FECTHED = "allStudentsFetched";

	/**
	 * Constant used when all the courses are fetched from the database
	 */
	public static final String ALL_COURSES_FETCHED = "allCoursesFetched";

	/**
	 * Constant used when the student is fetched from the database
	 */
	public static final String STUDENT_FETCHED = "studentFetched";

	/**
	 * Constant used for default output
	 */
	public static final String DEFAULT_OUTPUT = "input";
}