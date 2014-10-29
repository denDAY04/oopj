<HTML>
    <HEAD>
        <TITLE>Customer</TITLE>
        <STYLE>
            body {text-align:center;}
        </STYLE>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:black">Account Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM METHOD=POST ACTION="TermsOfUse.jsp">
            <TABLE align="CENTER">
                <TR>
                    <TD>First name:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "firstName"></TD>
                </TR>
                <TR>
                    <TD>Last name:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "lastName"></TD>
                </TR>
                <TR>
                    <TD>Email:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "email"></TD>
                </TR>
                <TR>
                    <TD>Password:</TD>
                    <TD><INPUT TYPE="password"
                               NAME= "password"></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <INPUT TYPE="submit" VALUE= "Sign Up">
        </FORM>
    </BODY>
</HTML>