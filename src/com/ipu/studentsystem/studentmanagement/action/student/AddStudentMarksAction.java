
package com.ipu.studentsystem.studentmanagement.action.student;

import java.util.HashMap;
import java.util.Map;

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
 * This is the action class for adding the marks of courses to the database
 * 
 * @author raghav
 * 
 */
public class AddStudentMarksAction extends ActionSupport {

	/**
	 * Serialized version UID of the serialized class
	 */
	private static final long serialVersionUID = -4060514854420048860L;

	private int studentID;
	private int[] courseID;
	private int[] marks;

	@Autowired
	private StudentDaoService studentDao;
	@Autowired
	private CourseDaoService courseDao;

	/**
	 * This function validates the input request parameter from the form field
	 */
	@Override
	public void validate() {
		FormFieldValidator.validateCourseList(this, courseID);
		FormFieldValidator.validateMarksList(this, marks);
	}

	/**
	 * This function is overriden from the ActionSupport Class. It performs the
	 * functionality of adding marks of student to the database
	 */
	public String execute() throws Exception {
		String responseString;
		Student requiredStudent = studentDao.getStudent(studentID);
		Map<Course, Integer> marksList = generateMarksList();
		studentDao.updateMarksList(requiredStudent, marksList);
		responseString = RedirectionOutput.ALL_MARKS_UPDATED;
		return responseString;
	}

	/**
	 * This function performs the functionality of generating the marks list
	 * from the course id list and marks list provided
	 * 
	 * @return : marksList of the student courses in the form of
	 *         Map<Course,Marks>
	 */
	private Map<Course, Integer> generateMarksList()
			throws StudentEnrollmentException {
		Map<Course, Integer> marksList = new HashMap<Course, Integer>();
		Course newCourse;
		for (int i = 0; i < courseID.length; i++) {
			newCourse = courseDao.getCourse(courseID[i]);
			marksList.put(newCourse, marks[i]);
		}
		return marksList;
	}

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID
	 *            the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
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
	 * @return the marks
	 */
	public int[] getMarks() {
		return marks;
	}

	/**
	 * @param marks
	 *            the marks to set
	 */
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
}