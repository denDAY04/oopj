<HTML>
    <%@ page language="java" contentType="text/html" errorPage="error.jsp" %>

    <jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session">
    </jsp:useBean>
    <%
        if( idtestbean.getCustomerNumber()==0)
          response.sendRedirect("/Webpage/Login.jsp");
      %>
    <jsp:setProperty name="idtestbean" property="*"/>
    <HEAD>
        <TITLE>Account</TITLE>
        <STYLE>
            body {text-align:left;}
        </STYLE>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:black">Account Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <Table align="left">
            <TR>
                <FORM METHOD=GET ACTION="EditInformation.jsp">
                    <INPUT TYPE="submit" VALUE="Edit Information">
                </FORM>
            </TR>
            <TR>
                <FORM METHOD=GET ACTION="ViewJourneyHistory.jsp">
                    <INPUT TYPE="submit" VALUE="Journey History">
                </FORM>
            </TR>
            <TR>
                <FORM METHOD=GET ACTION="Logout.jsp">
                    <INPUT TYPE="submit" VALUE="Log out">
                </FORM>
            </TR>
        </Table>
            <TABLE align="CENTER">
                <TR>
                    <TD>First name: </TD>
                    <TD><jsp:getProperty name="idtestbean" property="firstName" /></TD>
                </TR>
                <TR>
                    <TD>Last name: </TD>
                    <TD><jsp:getProperty name="idtestbean" property="lastName" /></TD>
                </TR>
                <TR>
                    <TD>Email: </TD>
                    <TD><jsp:getProperty name="idtestbean" property="email" /></TD>
                </TR>
                <TR>
                    <TD>Customer Number: </TD>
                    <TD><jsp:getProperty name="idtestbean" property="customerNumber" /></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <!--<INPUT TYPE="submit" VALUE= "Sign Up">-->
    </BODY>
</HTML>