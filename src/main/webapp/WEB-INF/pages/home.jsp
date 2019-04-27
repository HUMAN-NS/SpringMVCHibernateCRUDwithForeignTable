<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Employee List</h1>
        <h3>
            <a href="newEmployee">New Employee </a><a href=""> Home</a>
        </h3>
        <table border="1">
 			<tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Action</th>
 			</tr>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
 
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.address}</td>
                    <td>${employee.telephone}</td>
                    <td><a href="editEmployee?id=${employee.id}">Edit</a>
                             <a href="deleteEmployee?id=${employee.id}">Delete</a>
                             	 <a href="newSalary?id=${employee.id}">Add Salary</a>
                             	  <a href="listSalary?id=${employee.id}">List Salary</a>
                             </td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
    
    
        
        <div align="center">
       <c:if test="${employee.name != null}">
         <h1>Salary List of Employee: ${employee.name}
        </h1>
        <table border="1">
         <tr>
            <th>Year</th>
            <th>Month</th>
            <th>Salary</th>
            <th>Action</th>
       </tr>
             <c:forEach var="salary" items="${listSalary}">
                <tr>
                    <td>${salary.year}</td>
                    <td>${salary.month}</td>
                    <td>${salary.salary}</td>
                    <td><a href="editSalary?id=${salary.id}&empid=${employee.id}">Edit</a>
                             <a href="deleteSalary?id=${salary.id}">Delete</a></td>
               </tr>
                </c:forEach>
          
        </table>
       </c:if>
         
    </div>

    
</body>
</html>