<%--
This is the Page which displays the table of the courses and the marks of the student
which are enrolled in various courses
 --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/tableStyle.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menuHeader.jsp"/>
	<table border=2 id="studentTable">
		<tr id=headerRow>
			<th><s:text name="header.RollNumber"></s:text></th>
			<th><s:text name="header.FullName"></s:text></th>
			<th><s:text name="header.Courses"></s:text></th>
			<th><s:text name="header.Marks"></s:text></th>
			<th><s:text name="header.Action"></s:text></th>
			<th><s:text name="header.Action"></s:text></th>
		</tr>
		<s:iterator value="studentList">
			<tr>
				<td><s:property value="enrollmentNumber" /></td>
				<td><s:property value="firstName" /> <s:property
						value="lastName" /></td>
				<td colspan="2">
					<table width=100%>
						<s:iterator value="marksList">
							<tr>
								<td><s:property value="key.courseName" /></td>
								<td><s:if test='value>=0'>
										<s:property value="value" />
									</s:if></td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td><s:url action="deleteCourse" var="deleteUrl">
						<s:param name="personID">
							<s:property value="personID" />
						</s:param>
					</s:url> <a href='<s:property value="#deleteUrl"/>'> <s:text
							name="hyperlink.delete" />
				</a></td>

				<td><s:url action="courseForm" var="updateUrl">
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
	<a href="enterMarks.action"> <s:text name="link.EnterMarks" />
	</a>
	<hr />
</body>
</html>