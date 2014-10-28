<%-- 
    Document   : Login
    Created on : Oct 28, 2014, 10:27:29 AM
    Author     : Mathias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <BODY>
        <BR><BR><BR>
        <FORM METHOD=GET ACTION="AccountOverview.jsp">
            <TABLE>
                <TR>
                    <TD>Username:</TD>
                    <TD><INPUT TYPE="text" NAME= "start"></TD>
                </TR>
                <TR>
                    <TD>Password:</TD>
                    <TD><INPUT TYPE="password" NAME= "end"></TD>
                </TR>
            </TABLE>
            <INPUT TYPE="Submit" VALUE = "Login">
        </FORM>
        <P>Not registered yet? Press Sign Up.</P>
        <FORM METHOD=LINK ACTION="Customerinput.jsp">
            <INPUT TYPE="Submit" VALUE ="Sign Up">
        </FORM>
    </BODY>
</html>
