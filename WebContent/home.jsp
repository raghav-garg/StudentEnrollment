
<%--
This JSP is the Home Page for the administrator
The administrator gets the view of the enrolled students and their course list
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
Home Page for the admin
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/tableStyle.css" rel="stylesheet" type="text/css"/>
<title><s:text name="title.home"></s:text></title>
</head>
<body>
<jsp:include page="menuHeader.jsp"/>
	<!-- 
Student List in form of a table
 -->
	
	<table border=2 id="studentTable">
		<tr id="headerRow">
			<th><s:text name="header.RollNumber"></s:text></th>
			<th><s:text name="header.FullName"></s:text></th>
			<th><s:text name="header.ResidentAddress"></s:text></th>
			<th><s:text name="header.DateOfBirth"></s:text></th>
			<th><s:text name="header.Courses"></s:text></th>
			<th><s:text name="header.Action"></s:text></th>
			<th><s:text name="header.Action"></s:text></th>
		</tr>
		<s:iterator value="studentList">
			<tr>
				<td><s:property value="enrollmentNumber" /></td>
				<td><s:property value="firstName" /> <s:property
						value="lastName" /></td>
				<td><s:property value="residentAddress" /></td>
				<td><s:date  name="dateOfBirth" format="dd/MM/yyyy" /></td>
				<td>
					<table>
						<s:iterator value="marksList">
							<tr>
								<td><s:property value="key.courseName" /></td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td><s:url action="deleteStudent" var="deleteUrl">
						<s:param name="personID">
							<s:property value="personID" />
						</s:param>
					</s:url> <a href='<s:property value="#deleteUrl"/>'> <s:text
							name="hyperlink.delete" />
				</a></td>
			
			<td><s:url action="updateStudentForm" var="updateUrl">
						<s:param name="personID">
							<s:property value="personID" />
						</s:param>
					</s:url> <a href='<s:property value="#updateUrl"/>'> <s:text
							name="hyperlink.update" />
				</a></td>
			</tr>
		</s:iterator>
	</table>
	<hr />
	<a href="studentForm.action"> <s:text name="link.AddStudent" />
	</a>
	<hr />
</body>
</html>