
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
 * This is the action class for updating the Student details in the database
 * 
 * @author raghav
 * 
 */
public class UpdateStudentDetailAction extends ActionSupport {

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
	 * This function is used to validate the request input parameter
	 */
	@Override
	public void validate() {
		FormFieldValidator.validateCourseList(this, courseID);
		FormFieldValidator.validateStudent(this, student);
	}

	/**
	 * This function is overriden from the ActionSupport Class. It performs the
	 * functionality of adding student to the databse
	 */
	public String execute() throws Exception {
		String responseString;
		assignCourses();
		studentDao.updateStudentDetails(student);
		responseString = RedirectionOutput.SUCCESSFULLY_UPDATED;
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
}