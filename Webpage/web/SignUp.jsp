<!--Author: Mathias Nordahl-->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html" errorPage="error.jsp"%>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session" />
<%
  if( customer.getCustomerNumber()!=0)
    response.sendRedirect("../AccountOverview.jsp");
%>

<HTML>
    <HEAD>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <meta http-equiv="expires" content="0" />
        <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
        <meta http-equiv="pragma" content="no-cache" />
        <TITLE>Sign up</TITLE>
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
        </SCRIPT>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1>
            <P STYLE="color:black">Account Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <FORM NAME="inputs" METHOD=POST ACTION="ValidateSignUp.jsp" onsubmit="return validate()">
            <TABLE align="CENTER">
                <TR>
                    <TD><DIV id="fName"><font color="black">First Name:</font></DIV></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "firstName"></TD>
                </TR>
                <TR>
                    <TD><DIV id="lName"><font color="black">Last Name:</font></DIV></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "lastName"></TD>
                </TR>
                <TR>
                    <TD><DIV id="mail"><font color="black">Email: </font></DIV><font color="red"><jsp:getProperty name="customer" property="errorMessage2"/></font></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "email"></TD>
                </TR>
                <TR>
                    <TD><DIV id="pwd"><font color="black">Password:</font></DIV></TD>
                    <TD><INPUT TYPE="password"
                               NAME= "password"></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <INPUT TYPE="submit" VALUE= "Sign Up">
        </FORM>
    </BODY>
</HTML>