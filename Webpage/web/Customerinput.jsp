<HTML>
    <HEAD>
        <TITLE>Customer</TITLE>
        <STYLE>
            body {text-align:center;}
        </STYLE>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:red">Customer Details</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM METHOD=POST ACTION="CustomerTestConfirm.jsp">
            <TABLE>
                <TR>
                    
                    
                    <TD>customerNumber:</TD>
                    <TD><INPUT TYPE="text" NAME= "customerNumber"></TD>
                </TR>
                <TR>
                    <TD>firstname:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "firstname"></TD>
                </TR>
                <TR>
                    <TD>lastname:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "lastname"></TD>
                </TR>
                <TR>
                    <TD>email:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "email"></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <INPUT TYPE="submit" VALUE= "send details">
        </FORM>
    </BODY>
</HTML>