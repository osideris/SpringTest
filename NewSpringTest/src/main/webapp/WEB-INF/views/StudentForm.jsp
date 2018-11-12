<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Student</title>
</head>
<body>
	<!--  <td>${student.name}</td>
					<td>${student.schoolYr}</td>
					<td>${student.campus }</td>
					<td>${student.studentId }</td>
					<td>${student.entryDate }</td>
					<td>${student.gradeLevel }</td>-->
	<div align="center">
		<h1>New/Edit Student</h1>
		<form:form action="saveStudent" method="POST"
			modelAttributes="student" action="/saveStudent">
			<table>
				<form:hidden path="studentId" />
				<tr>
					<td><form:label path="name">Student Name:</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="schoolYr">School Year:</form:label></td>
					<td><form:input path="schoolYr" /></td>
				</tr>
				<tr>
					<td><form:label path="campus">Campus:</form:label></td>
					<td><form:input path="campus" /></td>
				</tr>
				<tr>
					<td><form:label path="entryDate">Entry Date:</form:label></td>
					<td><form:input path="entryDate" /></td>
				</tr>
				<tr>
					<td><form:label path="gradeLevel" >Grade Level:</form:label></td>
					<td><form:input path="gradeLevel" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>