<%--
Menu Header included on each and every page which displays the menu on each and every page
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link href="css/menuStyle.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div id="menuBar">
<ul>
<li><a href="homeAction.action" class="option">Home </a></li>
<li><a href="courseViewAction.action" class="option">Enroll</a></li>
<li><a href="logoutAction.action" class="option">Logout</a></li>
</ul>
</div>
<br><br>
</body>
</html>