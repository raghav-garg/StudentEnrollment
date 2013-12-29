
package com.ipu.studentsystem.studentmanagement.action.applicationuser;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.service.CourseDaoService;
import com.ipu.studentsystem.studentmanagement.service.UserDaoService;
import com.ipu.studentsystem.studentmanagement.validator.FormFieldValidator;
import com.opensymphony.xwork2.ActionSupport;

/**
 * It is used for providing a new session to the Application User. A user logs
 * in with the username and password if the username and password are matched
 * then the user is provided with the valid session
 * 
 * @author raghav
 * 
 */
public class LoginAction extends ActionSupport implements SessionAware {

	@Autowired
	UserDaoService userDao;
	/**
	 * SerialVersionUID of the serialized class
	 */
	private static final long serialVersionUID = -6010412420287859695L;
	private Map<String, Object> sessionMap;
	private String username;
	private String password;
	private String role;
	private final String INCORRECT_DETAILS = "error.inc";
	@Autowired
	CourseDaoService courseDaoService;

	/**
	 * This is the function which is executed before the execute function. If
	 * the field error is added then the execute function is not called else the
	 * call is made to the execute function
	 */
	@Override
	public void validate() {
		FormFieldValidator.validateLoginDetails(this, username, password);
	}

	/**
	 * This is the default function which is called when the user requests to
	 * log-in. This function can have only two types of output parameters one
	 * for successful login and one for incorrect login details
	 */
	public String execute() throws Exception {
		String operationResult;
		if (userDao.validateUser(username, password, sessionMap)) {
			operationResult = RedirectionOutput.SUCCESSFUL_LOGIN;
		} else {
			addFieldError("username", getText(INCORRECT_DETAILS));
			operationResult = RedirectionOutput.INCORRECT_DETAILS;
		}
		return operationResult;
	}

	/**
	 * This function is overriden function from SessionAware interface. This
	 * provides us with the Map of session Attributes
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}