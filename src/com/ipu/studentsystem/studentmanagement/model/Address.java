
package com.ipu.studentsystem.studentmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ipu.studentsystem.common.constant.UtilityConstant;
import com.ipu.studentsystem.common.util.StringUtil;

/**
 * Model class which contains the characterstics an address possess
 * 
 * @author raghav
 * 
 */
@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int addressId;
	private String houseNumber;
	private String street;
	private String city;
	private String zipCode;
	private String state;
	private String country;

	/**
	 * The id for the unique address
	 * 
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * Sets the address ID for the address
	 * 
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * Return the house number associated with the address
	 * 
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Sets the house Number
	 * 
	 * @param houseNumber
	 *            the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * Return the street name
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street Name
	 * 
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Return the city name
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city name
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Return the zip code
	 * 
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code
	 * 
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Return the state name
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state name
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Return the country name
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country name
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		String addressOutput = StringUtil.concatenate(houseNumber,
				UtilityConstant.ADDRESS_SEPERATOR, street,
				UtilityConstant.ADDRESS_SEPERATOR, city,
				UtilityConstant.ADDRESS_SEPERATOR, state,
				UtilityConstant.ADDRESS_SEPERATOR, zipCode,
				UtilityConstant.ADDRESS_SEPERATOR, state,
				UtilityConstant.ADDRESS_SEPERATOR, country);

		return addressOutput;
	}
}