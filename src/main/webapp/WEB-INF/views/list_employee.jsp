<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
      <%@ include file="menu.jsp" %>
        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Nmae</th>
<th>Email</th>
<th>Mobile</th>
<th>Delete</th>
<th>Update</th>

</tr>
 <c:forEach items ="${employees }"  var = "emp">
 <tr>
<td>${emp.name}</td>
<td>${emp.email}</td>
<td>${emp.mobile}</td>
<td><a href="delete?id=${emp.id }">delete</a></td>
<td><a href="update?id=${emp.id }">update</a></td>

</tr>
      </c:forEach>
</table>

</body>
</html>