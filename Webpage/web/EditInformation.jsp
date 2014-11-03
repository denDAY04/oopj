<HTML>
    <%@ page language="java" contentType="text/html"%>

    <jsp:useBean id="customer" class="Beans.CustomerBean" scope="session">
    </jsp:useBean>
    <HEAD>
        <TITLE>Edit Info</TITLE>
        <STYLE>
            body {text-align:center;}
        </STYLE>
        <script type="text/javascript">
	function validate(){
		//var re = /^[A-Z][a-z]+([\s,\-\]?[A-Z][a-z]+)*$/;
		//var re = /^[A-Z][a-z]+[\s,\-\]?[A-Z][a-z]+([\s,\-\]?[A-Z][a-z]+)+*$/;
                var re = /^[A-Z][a-z]+([\-\][a-z]+)?$/;
		var RegularExpression = new RegExp(re);
		if(document.inputs.firstName.value.search(RegularExpression) == -1){
			alert("No Match found");
			console.log("Test");
			return false;
		} else{
			alert("match found");
			console.log("Match found");
			return true; 
		}
	}
	</script>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:black">Edit Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM NAME="inputs" METHOD="POST" ACTION="AccountOverview.jsp">
            <TABLE align="CENTER">
                <TR>
                    <TD><DIV id="fName"><font color="black">First Name:</font></DIV></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "firstName"
                               VALUE="<jsp:getProperty name="customer" property="firstName" />"></TD>
                </TR>
                <TR>
                    <TD><DIV id="lName"><font color="black">Last Name:</font></DIV></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "lastName"
                               VALUE="<jsp:getProperty name="customer" property="lastName" />"></TD>
                </TR>
                <TR>
                    <TD><DIV id="mail"><font color="black">Email:</font></DIV></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "email"
                               VALUE="<jsp:getProperty name="customer" property="email" />"></TD>
                </TR>
                <TR>
                    <TD><DIV id="pwd"><font color="black">Password:</font></DIV></TD>
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