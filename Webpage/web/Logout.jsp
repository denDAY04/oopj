

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session" />
<jsp:setProperty name="customer" property="customerNumber" value="0"/>
<jsp:setProperty name="customer" property="firstName" value=""/>
<jsp:setProperty name="customer" property="lastName" value=""/>
<jsp:setProperty name="customer" property="email" value=""/>
<jsp:setProperty name="customer" property="password" value=""/>
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <BODY>
        <% response.sendRedirect("./Login.jsp"); %>
    </BODY>
</html>
