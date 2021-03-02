<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

      <script>
                  function deleteConfirm(){
                	  
                	return  confirm("Records deleted once cannot be retrieved! Are you sure you want to delete?");
                  } 
                  

     </script>


</head>
<body>
                    <h2> View Contacts Here</h2>
    
                    <font color="green">${delsuccss}</font>
  
                    <a href="/"> +Add new Contact</a>
      <table border="1">
 
      <tr>    
              <th>Name</th>
              <th>Email</th>
              <th>Contact Number</th>
              <th>Action</th>
      </tr>
   
      <c:forEach items ="${contacts}" var="contact">
 
        <tr>
              <td>${contact.cname}</td>
            <td>${contact.cemail}</td>
             <td>${contact.cno}</td>
           
           <td>
                   <a href="editContact?id=${contact.id}">Edit</a>
                   <a href="deleteContact?id=${contact.id}" 
                                   onclick="return deleteConfirm()">Delete</a>
                
            </td> 
           
           
        </tr>
 
 
     </c:forEach>
 
 
 
 
 </table>
 
</body>
</html>