<HTML>
    <HEAD>
        <TITLE>Shopping Order</TITLE>
        <STYLE>
            body {text-align:center;}
        </STYLE>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:red">Order Details</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM METHOD=POST ACTION="Order.jsp">
            <TABLE>
                <TR>
                    <TD>Name:</TD>
                    <TD><INPUT TYPE="text" NAME= "name"></TD>
                </TR>
                <TR>
                    <TD>Address line1:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "addressLine1"></TD>
                </TR>
                <TR>
                    <TD>Address line2:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "addressLine2"></TD>
                </TR>
                <TR>
                    <TD>Address line3:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "addressLine3"></TD>
                </TR>
                <TR>

                    <TD>Post code:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "postCode"></TD>
                </TR>
                <TR>
                    <TD>Order item:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "orderItem"></TD>
                </TR>
                <TR>
                    <TD>Quantity:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "quantity"></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <INPUT TYPE="submit" VALUE= "Send order">
        </FORM>
    </BODY>
</HTML>