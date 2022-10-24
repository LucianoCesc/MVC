<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% int idInsc = (int)request.getAttribute("idInsc");%>

<html> 
<body>
   <h1>Solicitud Generada Correctamente</h1>
  <p> Su codigo de inscripción es: <%=idInsc%></p>
</body>
</html>