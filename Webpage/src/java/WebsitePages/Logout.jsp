

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session" />
<jsp:setProperty name="idtestbean" property="customerNumber" value="0"/>
<jsp:setProperty name="idtestbean" property="firstName" value=""/>
<jsp:setProperty name="idtestbean" property="lastName" value=""/>
<jsp:setProperty name="idtestbean" property="email" value=""/>
<jsp:setProperty name="idtestbean" property="password" value=""/>
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <BODY>
        <% response.sendRedirect("/Webpage/Login.jsp"); %>
    </BODY>
</html>
