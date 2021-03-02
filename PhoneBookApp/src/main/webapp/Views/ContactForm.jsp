<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome To Phonebook Application</h2>


<font color='green'>${sucssmsg}</font>

<font color='red'>${errmsg}</font>

<form:form action="addcontact" method="POST" modelAttribute="contactobjkey">
      <table>
          <tr>                                              
              <td>Contact Name:</td>
              <td><form:input path="cname" /></td>
              <form:hidden path="id"/>
          </tr>
          <tr>
              <td>Contact Email:</td>
              <td><form:input path="cemail" /></td>
          </tr>
          <tr>
              <td>Contact Number:</td>
              <td><form:input path="cno" /></td>
          </tr>
          <tr>
              <td>
                  <input type="submit" value="Save Contact" />
              </td>
          </tr>
      </table>
  </form:form>


<a href="/viewContacts"> View All Contacts</a>

 
</body>
</html>