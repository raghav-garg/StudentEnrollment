
package com.ipu.studentsystem.studentmanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class which contains the characterstics a User should possess
 * 
 * @author raghav
 */
@Entity
@Table(name = "UserLogin")
public class ApplicationUser extends Person {

	@ManyToOne(cascade = CascadeType.PERSIST)
	LoginCredential userCredential;
	private String role;

	public ApplicationUser() {
		super();
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the userCredential
	 */
	public LoginCredential getUserCredential() {
		return userCredential;
	}

	/**
	 * @param userCredential
	 *            the userCredential to set
	 */
	public void setUserCredential(LoginCredential userCredential) {
		this.userCredential = userCredential;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}