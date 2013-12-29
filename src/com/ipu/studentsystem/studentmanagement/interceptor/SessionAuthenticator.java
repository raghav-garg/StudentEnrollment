
package com.ipu.studentsystem.studentmanagement.interceptor;

import java.util.HashMap;
import java.util.Map;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.constant.SessionAttribute;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * SessionAuthenticator authenticates the session of the user. The user can
 * access the resource only when the session is a valid one
 * 
 * @author raghav
 * 
 */
public class SessionAuthenticator extends AbstractInterceptor {

	/**
	 * Serial Version ID of the serialized class
	 */
	private static final long serialVersionUID = -8180289515547251793L;
	private Map<String, Object> sessionAttributes = new HashMap<String, Object>();

	/**
	 * This function is inherited from the class AbstractInterceptor. In this
	 * function we are checking that the session exists for the request that is
	 * made.
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String sessionValidator;
		setSession(invocation);
		String username = (String) sessionAttributes
				.get(SessionAttribute.USERNAME);
		String role = (String) sessionAttributes.get(SessionAttribute.ROLE);
		// A check for the session.
		if (username == null || role == null) {
			sessionValidator = RedirectionOutput.NO_SESSION;
		} else {
			sessionValidator = invocation.invoke();
		}
		return sessionValidator;
	}

	/**
	 * This method returns the session object associated with the Context
	 * 
	 * @param invocation
	 *            : ActionInvocation object
	 * @return : session Object
	 */
	private void setSession(ActionInvocation invocation) {
		sessionAttributes = invocation.getInvocationContext().getSession();
	}
}