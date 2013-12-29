<%--
Login Page Prompts for the username and the password of the user. A user must enter his username and poassword
to access the various resources
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validations.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/formStyle.css" rel="stylesheet" type="text/css" />
<title><s:text name="title.login" /></title>
</head>
<body>
	<s:form action="loginAction" method="post" validate="true"
		name="loginForm" onsubmit="return validateLoginForm()">
		<h3>
			<s:text name="header.login"></s:text>
		</h3>
		<s:textfield key="username" required="true" />
		<s:password key="password" required="true" />
		<s:textfield key="role" readonly="true" value="Admin" />
		<s:submit key="label.login" />
	</s:form>
</body>
</html>