<%--
This form is used to update the details of the students. Modify his course list etc
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sx:head />
</head>
<body>
<jsp:include page="menuHeader.jsp"/>
	<s:form action="updateStudent" method="post" onsubmit="return validateAddForm()" name="add">
		<s:hidden key="student.enrollmentNumber" />
		<s:hidden key="student.personID" />
		<s:textfield key="student.firstName" required="true" />
		<s:textfield key="student.lastName" required="true" />
		<s:textfield key="student.residentAddress.houseNumber" required="true" />
		<s:textfield key="student.residentAddress.street" required="true" />
		<s:textfield key="student.residentAddress.city" required="true" />
		<s:textfield key="student.residentAddress.zipCode" required="true" />
		<s:textfield key="student.residentAddress.state" required="true" />
		<s:textfield key="student.residentAddress.country" required="true" />
		<sx:datetimepicker key="student.dateOfBirth"
			displayFormat="yyyy-MM-dd" required="true" />
		<s:select list="courseList" listKey="courseID" listValue="courseName"
			multiple="true" required="true" id="courses" name="courseID"
			key="label.Course" value="%{student.marksList.key}"/>
		<s:submit key="label.update" />
	</s:form>
</body>
</html>