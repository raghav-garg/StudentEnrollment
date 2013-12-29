
<%--
This is the form for adding the student and enrolling him for courses.
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="validations.js"></script>
<link href="css/formStyle.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="title.addStudent"></s:text></title>
<sx:head />
</head>
<body>
	<jsp:include page="menuHeader.jsp" />

	<s:form action="addStudentAction" method="post" name="add" onsubmit="return validateAddForm()">
		<s:textfield required="true" key="student.firstName" />
		<s:textfield required="true" key="student.lastName" />
		<s:textfield required="true" key="student.residentAddress.houseNumber" />
		<s:textfield required="true" key="student.residentAddress.street" />
		<s:textfield required="true" key="student.residentAddress.city" />
		<s:textfield required="true" key="student.residentAddress.zipCode" />
		<s:textfield required="true" key="student.residentAddress.state" />
		<s:textfield required="true" key="student.residentAddress.country" />
		<sx:datetimepicker key="student.dateOfBirth"
			displayFormat="yyyy-MM-dd" required="true" />
		<table>
			<tr>
				<td><label for="courseID"><s:text name="label.Course"></s:text></label></td>
				<td><s:select name="courseID" list='courseList'
						listKey="courseID" listValue="courseName" multiple="true"
						required="true"   /></td>
			</tr>
			<tr>
				<td><s:submit key="label.add"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
</html>