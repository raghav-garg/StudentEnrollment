
package com.ipu.studentsystem.studentmanagement.validator;

import com.ipu.studentsystem.common.constant.UtilityConstant;
import com.ipu.studentsystem.studentmanagement.domain.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Form field validator is used to validate the inputs given by the user
 * 
 * @author raghav
 * 
 */
public class FormFieldValidator {

	private static String BLANK_FIELD_ERROR = "error.blankField";
	private static String NEGATIVE_MARKS = "error.negativeMarks";

	/**
	 * This field validator function validates the user input for the student
	 * fields in the struts2 Action class
	 * 
	 * @param validator
	 *            : Action support class object from which the call is made
	 */
	public static void validateStudent(ActionSupport validator, Student student) {
		if (student.getFirstName() == null || student.getFirstName().equals("")) {
			validator.addFieldError("student.firstName",
					validator.getText(BLANK_FIELD_ERROR));
		}

		if (student.getLastName() == null || student.getLastName().equals("")) {
			validator.addFieldError("student.lastName",
					validator.getText(BLANK_FIELD_ERROR));
		}

		if (student.getDateOfBirth() == null) {
			validator.addFieldError("student.dateOfBirth",
					validator.getText(BLANK_FIELD_ERROR));
		}

		if (student.getResidentAddress() == null) {
			validator.addFieldError("student.residentAddress",
					validator.getText(BLANK_FIELD_ERROR));
		}
	}

	/**
	 * This function is used to validate the course list. If the user has
	 * selected the appropriate number of courses
	 * 
	 * @param validator
	 *            : Action support class object from which the call is made
	 * @param courseID
	 *            : course IDs to be validated
	 */
	public static void validateCourseList(ActionSupport validator,
			int[] courseID) {
		if (courseID == null || courseID.length == 0) {
			validator.addFieldError("courseID",
					validator.getText(BLANK_FIELD_ERROR));
		}
	}

	/**
	 * This function is used to validate the course list. If the user has
	 * entered the appropriate number of marks
	 * 
	 * @param validator
	 *            : Action support class object from which the call is made
	 * @param marks
	 *            : marks to be validated
	 */
	public static void validateMarksList(ActionSupport validator, int[] marks) {
		if (marks == null || marks.length == 0) {
			validator.addFieldError("marks",
					validator.getText(BLANK_FIELD_ERROR));
		}

		for (int subjectMark : marks) {
			if (subjectMark < 0) {
				validator.addFieldError("marks",
						validator.getText(NEGATIVE_MARKS));
			}
		}
	}

	/**
	 * This function validates the user login credentials. The username or the
	 * password is blank or not
	 * 
	 * @param validator
	 *            : validator is the object of the action support class
	 * @param username
	 *            : username entered by the client
	 * @param password
	 *            : password entered ny the user
	 */
	public static void validateLoginDetails(ActionSupport validator,
			String username, String password) {
		if (username == null || username.equals(UtilityConstant.BLANK_STRING)) {
			validator.addFieldError("username",
					validator.getText(BLANK_FIELD_ERROR));
		}

		if (password == null || password.equals(UtilityConstant.BLANK_STRING)) {
			validator.addFieldError("password",
					validator.getText(BLANK_FIELD_ERROR));
		}
	}
}