
package com.ipu.studentsystem.studentmanagement.interceptor;

import java.util.Map;

import com.ipu.studentsystem.studentmanagement.constant.RedirectionOutput;
import com.ipu.studentsystem.studentmanagement.constant.SessionAttribute;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * LoginVerifier checks that the user should be allowed to make a login request.
 * It just checks whether the session already exists or not If the session
 * already exists. then user should not be allowed to make a login request else
 * should be redirected to its home page
 * 
 * @author raghav
 * 
 */
public class LoginVerifier extends AbstractInterceptor {

	/**
	 * SerializedVersionID of the serialized class
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Object> sessionMap;

	/**
	 * This function is validate the Login request that whether or not the user
	 * is allowed to make a rqeuest to the login page
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String loginVerifier;
		setSession(invocation);
		if (sessionMap.get(SessionAttribute.USERNAME) == null
				|| sessionMap.get(SessionAttribute.ROLE) == null) {
			loginVerifier = invocation.invoke();
		} else {
			loginVerifier = RedirectionOutput.SESSION_EXISTS;
		}
		return loginVerifier;
	}

	/**
	 * This method returns the session object associated with the Context
	 * 
	 * @param invocation
	 *            : ActionInvocation object
	 * @return : session Object
	 */
	private void setSession(ActionInvocation invocation) {
		sessionMap = invocation.getInvocationContext().getSession();
	}
}