
package com.ipu.studentsystem.studentmanagement.action.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Its the action class which is used to display the form for updating the
 * student details
 * 
 * @author raghav
 * 
 */
public class DisplayUpdateStudentFormAction extends ActionSupport {

	/**
	 * Serial Version UID of the serialized class
	 */
	private static final long serialVersionUID = -2475187041317971389L;
	private int personID;
	private Student student;
	private List<Course> courseList = new ArrayList<Course>();

	@Autowired
	CourseDaoService courseDao;
	@Autowired
	private StudentDaoService studentDAO;

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

	/**
	 * @return the courseList
	 */
	public List<Course> getCourseList() {
		return courseList;
	}

	/**
	 * @param courseList
	 *            the courseList to set
	 */
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	/**
	 * Fetches the correct student on the basis of the personID.
	 */
	@Override
	public String execute() throws Exception {
		String operationResult = RedirectionOutput.DEFAULT_OUTPUT;
		student = studentDAO.getStudent(personID);
		if (student != null) {
			courseList = courseDao.getAllCourses();
			operationResult = RedirectionOutput.STUDENT_FETCHED;
		}
		return operationResult;
	}
}