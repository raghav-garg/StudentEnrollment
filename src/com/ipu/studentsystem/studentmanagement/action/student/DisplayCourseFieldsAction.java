
package com.ipu.studentsystem.studentmanagement.action.student;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This is the action class for displaying the form of addding marks
 * 
 * @author raghav
 * 
 */
public class DisplayCourseFieldsAction extends ActionSupport {

	/**
	 * Serial Version ID of the serialized class
	 */
	private static final long serialVersionUID = 1L;

	private int personID;
	private Map<Course, Integer> courseMap;
	@Autowired
	private StudentDaoService studentDao;

	@Override
	public String execute() throws Exception {
		String operationResult;
		Student student = studentDao.getStudent(personID);
		courseMap = student.getMarksList();
		operationResult = RedirectionOutput.ALL_COURSES_FETCHED;
		return operationResult;
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
	 * @return the courseMap
	 */
	public Map<Course, Integer> getCourseMap() {
		return courseMap;
	}

	/**
	 * @param courseMap
	 *            the courseMap to set
	 */
	public void setCourseMap(Map<Course, Integer> courseMap) {
		this.courseMap = courseMap;
	}
}