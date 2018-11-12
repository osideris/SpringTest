<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Directory Home</title>
</head>
<body>
	<div align="center">
		<h1>Student Directory</h1>
		<h3>
			<a href="/StudentForm">New Student</a>
		</h3>
		<table border="1">
			<th>Name</th>
			<th>School Year</th>
			<th>Campus</th>
			<th>Student ID</th>
			<th>Entry Date</th>
			<th>Grade Level</th>
			<th>Action</th>

			<c:forEach var="student" items="${listStudent}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${student.name}</td>
					<td>${student.schoolYr}</td>
					<td>${student.campus }</td>
					<td>${student.studentID }</td>
					<td>${student.entryDate }</td>
					<td>${student.gradeLevel }</td>
					<td><a href="/editStudent?id=${student.studentID }">Edit</a> <a
						href="/deleteStudent?id=${student.studentID }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
