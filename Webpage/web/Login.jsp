<!--Author: Mathias Nordahl-->
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session" />

<%
  if( customer.getCustomerNumber()!=0)
    response.sendRedirect("./AccountOverview.jsp");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
        <meta http-equiv="pragma" content="no-cache" />
        <title>Login</title>
    </head>
    <BODY>
        <BR><BR><BR>
        <FORM METHOD=GET ACTION="ValidateLogin.jsp">
            <TABLE>
                <TR> <font color="red"><jsp:getProperty name="customer" property="errorMessage" /></font></TR>
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
