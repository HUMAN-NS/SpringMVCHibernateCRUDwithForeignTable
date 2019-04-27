<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Salary</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Salary</h1>
                <form:form action="saveSalary" method="post" modelAttribute="salary">
        <table>
           <form:hidden path="id"/>
            <form:hidden path="employee.id"/>
            
            <tr>
                <td>Year:</td>
                <td><form:input path="year" /></td>
            </tr>
            <tr>
                <td>Month:</td>
                <td><form:input path="month" /></td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td><form:input path="salary" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
  <%-- <%= request.getParameter("id") %> --%> 
       ${salary.id}
     ${salary.employee.id}
</body>
</html>