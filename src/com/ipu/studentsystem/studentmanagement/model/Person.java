
package com.ipu.studentsystem.studentmanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ipu.studentsystem.common.util.StringUtil;

/**
 * Model class which contains the characterstics a person possess
 * 
 * @author raghav
 * 
 */
@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int personID;
	private String firstName;
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressID")
	private Address residentAddress;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the residentAddress
	 */

	public Address getResidentAddress() {
		return residentAddress;
	}

	/**
	 * @param residentAddress
	 *            the residentAddress to set
	 */

	public void setResidentAddress(Address residentAddress) {
		this.residentAddress = residentAddress;
	}

	@Override
	public String toString() {
		return StringUtil.concatenate(firstName, " ", lastName);
	}
}