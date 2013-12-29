
package com.ipu.studentsystem.studentmanagement.action.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Gets he list of all the students from the database to be displayed to the
 * user
 * 
 * @author raghav
 * 
 */
public class GetAllStudentsAction extends ActionSupport {

	/**
	 * A serialVersionUID for the Serialized class
	 */
	private static final long serialVersionUID = 6200368664397751300L;

	@Autowired
	private StudentDaoService studentDao;

	private List<Student> studentList;

	/**
	 * This the action which is used to fetch the students list from the storage
	 */
	@Override
	public String execute() throws Exception {
		String operationResult;
		studentList = studentDao.getAllStudents();
		operationResult = RedirectionOutput.ALL_STUDENTS_FECTHED;
		return operationResult;
	}

	/**
	 * @return the studentList
	 */
	public List<Student> getStudentList() {
		return studentList;
	}

	/**
	 * @param studentList
	 *            the studentList to set
	 */
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}