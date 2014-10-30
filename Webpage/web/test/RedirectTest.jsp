<%-- 
    Document   : RedirectTest
    Created on : Oct 29, 2014, 12:00:36 PM
    Author     : Qess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session" />


<%
  if( idtestbean.getCustomerNumber()=="")
    response.sendRedirect("/Webpage/form.html");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
