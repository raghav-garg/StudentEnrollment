
package com.ipu.studentsystem.studentmanagement.action.student;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * This is used to invalidate the current session
 * 
 * @author raghav
 * 
 */
public class LogoutAction extends ActionSupport implements ServletRequestAware {

	/**
	 * Serial Version UID of the serialized class
	 */
	private static final long serialVersionUID = -5496228084629299231L;
	HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		request.getSession().invalidate();
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}