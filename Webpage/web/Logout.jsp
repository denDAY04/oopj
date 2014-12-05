<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session" />
<jsp:setProperty name="customer" property="customerNumber" value="0"/>
<jsp:setProperty name="customer" property="firstName" value=""/>
<jsp:setProperty name="customer" property="lastName" value=""/>
<jsp:setProperty name="customer" property="email" value=""/>
<jsp:setProperty name="customer" property="password" value=""/>
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
        <meta http-equiv="pragma" content="no-cache" />
        <title>Logout</title>
    </head>
    <BODY>
        <% response.sendRedirect("./Login.jsp"); %>
    </BODY>
</html>
