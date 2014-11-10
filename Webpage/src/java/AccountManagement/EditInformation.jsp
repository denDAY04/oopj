<HTML>
    <%@ page language="java" contentType="text/html" errorPage="error.jsp"%>

    <jsp:useBean id="customer" class="Beans.CustomerBean" scope="session">
    </jsp:useBean>
    <%
        if( customer.getCustomerNumber()=="")
          response.sendRedirect("/Webpage/Login.jsp");
    %>
    <HEAD>
        <TITLE>Edit Info</TITLE>
        <STYLE>
            body {text-align:center;}
        </STYLE>
        <script type="text/javascript">
	function validate(){
                var isValid = true;
		//var re = /^[A-Z][a-z]+([\s,\-\]?[A-Z][a-z]+)*$/;
		//var re = /^[A-Z][a-z]+[\s,\-\]?[A-Z][a-z]+([\s,\-\]?[A-Z][a-z]+)+*$/;
                var re1 = /^[A-Z][a-z]+([\-\][a-z]+)?$/;
		var RegularExpression1 = new RegExp(re1);
                var re2 = /^([A-Z][a-z]+([\-,\s][A-Z][a-z]+)*)+/;
		var RegularExpression2 = new RegExp(re2);
                var re3 = /^.+@.+[\.\][a-z]+$/;
		var RegularExpression3 = new RegExp(re3);
                var re4 = /^.+$/;
		var RegularExpression4 = new RegExp(re4);
		if(document.inputs.firstName.value.search(RegularExpression1) === -1){
			
                        document.getElementById('fName').innerHTML = "<font color=\"red\">First Name:</font>";
			console.log("False");
			isValid = false;
		} else{
			document.getElementById('fName').innerHTML = "<font color=\"black\">First Name:</font>";
                        console.log("True");
		}
                
                if(document.inputs.lastName.value.search(RegularExpression2) === -1){
			
                        document.getElementById('lName').innerHTML = "<font color=\"red\">Last Name:</font>";
			console.log("False");
			isValid = false;
		} else{
			document.getElementById('lName').innerHTML = "<font color=\"black\">Last Name:</font>";
                        console.log("True");
		}
                
                if(document.inputs.email.value.search(RegularExpression3) === -1){
			
                        document.getElementById('mail').innerHTML = "<font color=\"red\">Email:</font>";
			console.log("False");
			isValid = false;
		} else{
			document.getElementById('mail').innerHTML = "<font color=\"black\">Email:</font>";
                        console.log("True");
		}
                
                if(document.inputs.password.value.search(RegularExpression4) === -1){
			
                        document.getElementById('pwd').innerHTML = "<font color=\"red\">Password:</font>";
			console.log("False");
			isValid = false;
		} else{
			document.getElementById('pwd').innerHTML = "<font color=\"black\">Password:</font>";
                        console.log("True");
		}
                return isValid;
	}
	</script>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1><P STYLE="color:black">Edit Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM NAME="inputs" METHOD="POST" ACTION="AccountOverview.jsp" onsubmit="return validate()">
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
                               NAME= "password"
                               VALUE="<jsp:getProperty name="customer" property="password" />"></TD>
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