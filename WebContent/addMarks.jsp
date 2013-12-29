
<%--
This is the JSP used for the menu of adding Marks of the students. When the 
admin prompts to the page he is displayed a Drop down to select the name of 
the student whose marks he wants to add

 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript">
	function submitForm() {
		document.marksForm.submit();
	}
</script>
</head>
<body>
	<jsp:include page="menuHeader.jsp" />
	<s:form action="enterMarks" name="marksForm">
		<s:select key="personID" list="studentList" listKey="personID"
			headerKey="0" headerValue="Select Name" onchange='submitForm()' />
	</s:form>
	<s:if test="personID > 0">
		<s:action name="courseForm" executeResult="true">
			<s:param name="personID">
				<s:property value="personID" />
			</s:param>
		</s:action>
	</s:if>
</body>
</html>