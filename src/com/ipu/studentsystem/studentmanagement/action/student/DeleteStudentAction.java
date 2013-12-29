
package com.ipu.studentsystem.studentmanagement.action.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This is the action class for updating the Student details in the database
 * 
 * @author raghav
 * 
 */
public class DeleteStudentAction extends ActionSupport {

	/**
	 * Serialized version UID of the serialized class
	 */
	private static final long serialVersionUID = -4060514854420048860L;

	private int personID;
	@Autowired
	private StudentDaoService studentDao;

	/**
	 * This function is overriden from the ActionSupport Class. It performs the
	 * functionality of adding student to the databse
	 */
	public String execute() throws Exception {
		String responseString = RedirectionOutput.DEFAULT_OUTPUT;
		Student studentToDelete = studentDao.getStudent(personID);
		if (studentToDelete != null) {
			studentDao.deleteStudent(studentToDelete);
			responseString = RedirectionOutput.SUCCESSFULLY_DELETED;
		}
		return responseString;
	}

	/**
	 * @return the studentID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * @param studentID
	 *            the studentID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}
}