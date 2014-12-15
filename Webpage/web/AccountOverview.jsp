<!--Author: Mathias Nordahl-->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html" errorPage="error.jsp" %>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session">
</jsp:useBean>
<%
    if( customer.getCustomerNumber()==0)
      response.sendRedirect("./Login.jsp");
%>
<jsp:setProperty name="customer" property="errorMessage" value=""/>
<jsp:setProperty name="customer" property="errorMessage3" value=""/>
<jsp:setProperty name="customer" property="*"/>
    
<HTML>
    <HEAD>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
        <meta http-equiv="pragma" content="no-cache" />
        <TITLE>Account</TITLE>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1>
            <P STYLE="color:black">Account Information</P>
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
        <BR><BR><BR>
            <TABLE align="Left">
                <TR>
                    <TD>First name: </TD>
                    <TD><jsp:getProperty name="customer" property="firstName" /></TD>
                </TR>
                <TR>
                    <TD>Last name: </TD>
                    <TD><jsp:getProperty name="customer" property="lastName" /></TD>
                </TR>
                <TR>
                    <TD>Email: </TD>
                    <TD><jsp:getProperty name="customer" property="email" /></TD>
                </TR>
                <TR>
                    <TD>Customer Number: </TD>
                    <TD><jsp:getProperty name="customer" property="customerNumber" /></TD>
                </TR>
            </TABLE>
            <BR><BR>
    </BODY>
</HTML>