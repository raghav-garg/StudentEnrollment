
package com.ipu.studentsystem.studentmanagement.action.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This is the action class for deleting assigned course the Student details in
 * the database
 * 
 * @author raghav
 * 
 */
public class DeleteAssignedCourseAction extends ActionSupport {

	/**
	 * Serialized version UID of the serialized class
	 */
	private static final long serialVersionUID = -4060514854420048860L;

	private int personID;
	@Autowired
	private StudentDaoService studentDao;
	@Autowired
	private CourseDaoService courseDao;

	/**
	 * This function is overriden from the ActionSupport Class. It performs the
	 * functionality of deleting assigned course from the database
	 */
	public String execute() throws Exception {
		String responseString = RedirectionOutput.DEFAULT_OUTPUT;
		Student requiredStudent = studentDao.getStudent(personID);
		if (requiredStudent != null) {
			studentDao.deleteAllCourse(requiredStudent);
			responseString = RedirectionOutput.COURSE_DELETED;
		}
		return responseString;
	}

	/**
	 * @return the personID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * @param personID
	 *            the personID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}
}