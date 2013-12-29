
package com.ipu.studentsystem.studentmanagement.service;

import java.util.Map;

import com.ipu.studentsystem.common.exception.StudentEnrollmentException;

/**
 * This interface defines the functionalities desired on Student Objects
 * 
 * @author raghav
 * 
 */
public interface UserDaoService {

	/**
	 * This function validate the functionality of validating the user if the
	 * Credentials matches the login Credentials as specified by the user
	 */
	public boolean validateUser(String username, String password,
			Map<String, Object> sessionMap) throws StudentEnrollmentException;
}