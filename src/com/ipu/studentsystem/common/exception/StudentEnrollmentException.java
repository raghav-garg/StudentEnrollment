
package com.ipu.studentsystem.common.exception;

import com.ipu.studentsystem.common.util.StringUtil;

/**
 * Handles all the exceptions at the common module level
 * 
 * @author raghav
 * 
 */
public class StudentEnrollmentException extends Exception {

	/**
	 * Auto generated serialVersionUID for the class
	 */
	private static final long serialVersionUID = 3952614186228253376L;

	/**
	 * Default Constructor for the Exception. Records the trace from where the
	 * Exception is raised
	 */
	public StudentEnrollmentException() {
		super();
	}

	/**
	 * This exception wraps the Exceptions with the message raised by the user
	 * 
	 * @param message
	 *            : Message raised by the user
	 */
	public StudentEnrollmentException(String message) {
		super(message);
	}

	/**
	 * This exception wraps the Exceptions with the message raised by the user
	 * and the trace from the others exception
	 * 
	 * @param message
	 *            : message raised by the user
	 * @param exception
	 *            : exception which is traced as the cause of the Exception
	 */
	public StudentEnrollmentException(String message, Throwable exception) {
		super(StringUtil.concatenate(message, exception.getMessage()));
	}

	/**
	 * This exception wraps the Exceptions with the message raised by the user
	 * and the trace from the others exception
	 * 
	 * @param message
	 *            : message raised by the user
	 * @param exception
	 *            : exception which is traced as the cause of the Exception
	 */
	public StudentEnrollmentException(Throwable exception) {
		super(exception);
	}
}