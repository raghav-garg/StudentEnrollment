
package com.ipu.studentsystem.studentmanagement.action.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;
import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.ipu.studentsystem.studentmanagement.validator.FormFieldValidator;
import com.opensymphony.xwork2.ActionSupport;

/**
 * AddStudentAction is the action class for adding the student to the database
 * 
 * @author raghav
 * 
 */
public class AddStudentAction extends ActionSupport {

	/**
	 * Serialized version UID of the serialized class
	 */
	private static final long serialVersionUID = -4060514854420048860L;

	private Student student;
	private int[] courseID;
	@Autowired
	private StudentDaoService studentDao;
	@Autowired
	private CourseDaoService courseDao;

	/**
	 * This function is used to validate the input parameters
	 */
	@Override
	public void validate() {
		FormFieldValidator.validateStudent(this, student);
		FormFieldValidator.validateCourseList(this, courseID);
	}

	/**
	 * This function is overriden from the ActionSupport Class. It performs the
	 * functionality of adding student to the databse
	 */
	public String execute() throws Exception {
		String responseString;
		assignCourses();
		studentDao.addStudent(student, student.getMarksList());
		responseString = RedirectionOutput.SUCCESSFULLY_ADDED;
		return responseString;
	}

	/**
	 * THis function performs the functionality of assigning new courses to the
	 * student received from the HTTP request by the client
	 */
	private void assignCourses() throws StudentEnrollmentException {
		Course newCourse;
		for (int id : courseID) {
			newCourse = courseDao.getCourse(id);
			student.assignNewCourse(newCourse);
		}
	}

	/**
	 * @return the courseID
	 */
	public int[] getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID
	 *            the courseID to set
	 */
	public void setCourseID(int[] courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
}