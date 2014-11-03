

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session" />

<%
  if( idtestbean.getCustomerNumber()!="")
    response.sendRedirect("/Webpage/AccountOverview.jsp");
%>
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
        <FORM METHOD=LINK ACTION="SignUp.jsp">
            <INPUT TYPE="Submit" VALUE ="Sign Up">
        </FORM>
    </BODY>
</html>
