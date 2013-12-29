
package com.ipu.studentsystem.studentmanagement.action.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.ipu.studentsystem.studentmanagement.model.Course;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.ipu.studentsystem.studentmanagement.service.StudentDaoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Its the action class which is used to display the form for updating the
 * student Marks Details
 * 
 * @author raghav
 * 
 */
public class EditMarksMenuAction extends ActionSupport {

	/**
	 * Serial Version UID of the serialized class
	 */
	private static final long serialVersionUID = -2475187041317971389L;

	private int personID;
	private List<Student> studentList;
	@Autowired
	private StudentDaoService studentDao;
	@Autowired
	private CourseDaoService courseDao;

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

	/**
	 * This method fetches the entire students list and rectify them on the
	 * basis of the marks they earlier had an input from
	 */
	@Override
	public String execute() throws Exception {
		String operationResult;
		studentList = studentDao.getAllStudents();
		rectifyStudents();
		operationResult = RedirectionOutput.ALL_STUDENTS_FECTHED;
		return operationResult;
	}

	/**
	 * Rectifies the student from the list on the basis of their marks. If the
	 * students marks are input earlier then the student will be removed from
	 * the list
	 */
	private void rectifyStudents() {
		List<Student> rectifiedStudent = new ArrayList<Student>();
		for (Student student : studentList) {
			Map<Course, Integer> marksList = student.getMarksList();
			Set<Course> keySet = marksList.keySet();
			boolean flag = true;
			for (Course key : keySet) {
				int marks = marksList.get(key);
				if (marks <= 0) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				rectifiedStudent.add(student);
			}
		}
		studentList = rectifiedStudent;
	}
}