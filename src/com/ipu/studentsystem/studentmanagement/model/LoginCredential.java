
package com.ipu.studentsystem.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class which contains the Login credentials of the Application User
 * 
 * @author raghav
 * 
 */
@Entity(name = "Login")
public class LoginCredential {

	@Id
	private String userName;
	private String password;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
}