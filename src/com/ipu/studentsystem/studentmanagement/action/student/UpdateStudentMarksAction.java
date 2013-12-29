
package com.ipu.studentsystem.studentmanagement.action.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * UpdateStudentMarksAction Updates the marks of the student in the particular
 * Subject
 * 
 * @author raghav
 * 
 */
public class UpdateStudentMarksAction extends ActionSupport {

	/**
	 * Serialized version UID of the serialized class
	 */
	private static final long serialVersionUID = -4060514854420048860L;

	private int studentID;
	private int courseID;
	private int marks;
	@Autowired
	private StudentDaoService studentDao;
	@Autowired
	private CourseDaoService courseDao;

	/**
	 * This function is overriden from the ActionSupport Class. It performs the
	 * functionality of updating student marks
	 */
	public String execute() throws Exception {
		String responseString = RedirectionOutput.DEFAULT_OUTPUT;
		Student requiredStudent = studentDao.getStudent(studentID);
		Course courseToUpdate = courseDao.getCourse(courseID);
		if (requiredStudent != null && courseToUpdate != null) {
			studentDao.updateSingleSubjectMarks(requiredStudent,
					courseToUpdate, marks);
			responseString = RedirectionOutput.COURSE_MARKS_UPDATED;
		}
		return responseString;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks
	 *            the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
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
	public int getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID
	 *            the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
}
