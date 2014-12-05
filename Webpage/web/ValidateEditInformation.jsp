<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session" />
<jsp:setProperty name="customer" property="*"/>
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
        <meta http-equiv="pragma" content="no-cache" />
        <title>Validating Information</title>
    </head>
    <BODY>
        <% if(customer.changeDetails() == true){
               response.sendRedirect("./AccountOverview.jsp");
           } else{
               response.sendRedirect("./EditInformation.jsp");
           }
        %>
    </BODY>
</html>
