<HTML>
    <%@ page language="java" contentType="text/html"%>

    <jsp:useBean id="customer" class="Beans.CustomerBean">
    </jsp:useBean>
    <HEAD>
        <TITLE>Edit Info</TITLE>
        <STYLE>
            body {text-align:center;}
        </STYLE>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:black">Edit Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM METHOD=POST ACTION="AccountOverview.jsp">
            <TABLE align="CENTER">
                <TR>
                    <TD>First name: </TD>
                    <TD><INPUT TYPE="text"
                               NAME= "firstName"
                               VALUE="<jsp:getProperty name="customer" property="firstName" />"></TD>
                </TR>
                <TR>
                    <TD>Last name: </TD>
                    <TD><INPUT TYPE="text"
                               NAME= "lastName"
                               VALUE="<jsp:getProperty name="customer" property="lastName" />"></TD>
                </TR>
                <TR>
                    <TD>Email: </TD>
                    <TD><INPUT TYPE="text"
                               NAME= "email"
                               VALUE="<jsp:getProperty name="customer" property="email" />"></TD>
                </TR>
                <TR>
                    <TD>Password: </TD>
                    <TD><INPUT TYPE="password"
                               NAME= "password"></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <INPUT TYPE="submit" VALUE= "Save Changes">
        </FORM>
        <FORM METHOD=LINK ACTION="AccountOverview.jsp">
            <INPUT TYPE="submit" VALUE= "Back">
        </FORM>
    </BODY>
</HTML>