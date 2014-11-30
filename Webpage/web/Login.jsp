

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session" />

<%
  if( idtestbean.getCustomerNumber()!=0)
    response.sendRedirect("./AccountOverview.jsp");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <BODY>
        <BR><BR><BR>
        <FORM METHOD=GET ACTION="ValidateLogin.jsp">
            <TABLE>
                <TR> <font color="red"><jsp:getProperty name="idtestbean" property="errorMessage" /></font></TR>
                <TR>
                    <TD>Username:</TD>
                    <TD><INPUT TYPE="text" NAME= "email"></TD>
                </TR>
                <TR>
                    <TD>Password:</TD>
                    <TD><INPUT TYPE="password" NAME= "password"></TD>
                </TR>
            </TABLE>
            <INPUT TYPE="Submit" VALUE = "Login">
        </FORM>
        <P>Not registered yet? Press Sign Up.</P>
        <FORM METHOD=LINK ACTION="SignUp.jsp">
            <INPUT TYPE="Submit" VALUE ="Sign Up">
        </FORM>
    </BODY>
</html>
