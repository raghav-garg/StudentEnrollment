
package com.ipu.studentsystem.studentmanagement.service;

import java.util.List;
import java.util.Map;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;

/**
 * This interface defines the functionalities desired on Student Objects
 * 
 * @author raghav
 * 
 */
public interface StudentDaoService {

	/**
	 * This is the function which will be used to add the students object to the
	 * storage device.
	 * 
	 * @param student
	 *            : The Object to be added to the storage
	 */
	public void addStudent(Student student, Map<Course, Integer> marksList)
			throws StudentEnrollmentException;

	/**
	 * This is the function which is used to get the list of students enrolled
	 * for various courses
	 * 
	 * @return : List of students enrolled for various courses
	 */
	public List<Student> getAllStudents() throws StudentEnrollmentException;

	/**
	 * This is the function which will be used to update the students object to
	 * the storage device.
	 * 
	 * @param student
	 *            : The Object to be updated to the storage
	 */
	public void updateStudentDetails(Student student)
			throws StudentEnrollmentException;

	/**
	 * This function is used to update the marks list of a student
	 * 
	 * @param student
	 *            : A student whose mark list is to be updated
	 * @param marksList
	 *            : MarkList of the student
	 */
	public void updateMarksList(Student student, Map<Course, Integer> marksList)
			throws StudentEnrollmentException;

	/**
	 * Update the marks of single subject of a student
	 * 
	 * @param student
	 *            : Student whose marks are to be updated
	 * @param course
	 *            : Course whose marks are updated
	 * @param marks
	 *            : new marks for the course
	 */
	public void updateSingleSubjectMarks(Student student, Course course,
			int marks) throws StudentEnrollmentException;

	/**
	 * Deletes the Student from the data storage
	 * 
	 * @param student
	 *            : the student to be deleted from the data storage
	 */
	public void deleteStudent(Student student)
			throws StudentEnrollmentException;

	/**
	 * Deletes the course from the student list
	 * 
	 * @param student
	 *            : student whose list is to be updated
	 * 
	 */
	public void deleteAllCourse(Student student)
			throws StudentEnrollmentException;

	/**
	 * Return the student with the given id
	 * 
	 * @param id
	 *            : The id of the student
	 * @return : Student object with the mapped id else null if no student is
	 *         mapped
	 */
	public Student getStudent(int id) throws StudentEnrollmentException;
}