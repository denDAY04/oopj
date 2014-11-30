

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session" />
<jsp:setProperty name="idtestbean" property="*"/>


   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validating Login</title>
    </head>
    <BODY>
        <% if(idtestbean.signUp() == true){
               response.sendRedirect("./TermsOfUse.jsp");
           } else{
               response.sendRedirect("./SignUp.jsp");
           }
        %>
    </BODY>
</html>
