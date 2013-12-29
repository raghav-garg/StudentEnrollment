
package com.ipu.studentsystem.studentmanagement.action.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Its the action class which is used to display the form for adding the student
 * 
 * @author raghav
 * 
 */
public class DisplayStudentFormAction extends ActionSupport {

	/**
	 * SerialVersionUID of the serialized class
	 */
	private static final long serialVersionUID = 1L;

	private List<Course> courseList = new ArrayList<Course>();
	@Autowired
	CourseDaoService courseDao;

	/**
	 * Fetches the list of courses from the database from which student can opt
	 * to choose from
	 */
	@Override
	public String execute() throws Exception {
		String operationResult;
		courseList = courseDao.getAllCourses();
		operationResult = RedirectionOutput.ALL_COURSES_FETCHED;
		return operationResult;
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
}