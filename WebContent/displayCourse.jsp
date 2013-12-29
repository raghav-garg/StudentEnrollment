<%--
Display the course list of the student and the marks to be updated by the admin for the student
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validations.js"></script>
<link href="css/formStyle.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<s:if test="personID == 0">
<jsp:include page="menuHeader.jsp" />
</s:if>
<link href="css/tableStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<s:form action="addMarks" onsubmit="return validateMarksForm()">
		<h3>
			<s:text name="display.EnterMarks"></s:text>
		</h3>
		<s:hidden name="studentID" value="%{personID}" />
		<s:iterator value="courseMap">
			<s:hidden value="%{key.courseID}" name="courseID"></s:hidden>
			<s:if test="value >0 ">
				<s:textfield key='key.courseName' name="marks" value="%{value}" />
			</s:if>
			<s:else>
				<s:textfield key='key.courseName' name="marks" value="0" />
			</s:else>
		</s:iterator>
		<s:submit key="label.update" />
	</s:form>
</body>
</html>