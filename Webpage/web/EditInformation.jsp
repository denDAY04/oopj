<!DOCTYPE html>
<%@ page language="java" contentType="text/html" errorPage="error.jsp"%>
<jsp:useBean id="customer" class="Beans.CustomerBean" scope="session">
</jsp:useBean>
<!-- Check if the session has a Customer object, if not redirect to login page-->
<%
    if( customer.getCustomerNumber()==0)
      response.sendRedirect("./Login.jsp");
%>

<HTML>
    <HEAD>
        <TITLE>Edit Info</TITLE>
        <script type="text/javascript">
        //Function validate()
        //Validates the inputs in the 4 text fields are of valid syntax
	function validate(){
                //Variable to ensure no regularexpressions are violated
                var isValid = true;                                     

                //re1: Verifies a first name starts with capital letter, and
                //     may contain special character '-'. Accepts only A-Z
                var re1 = /^[A-Z][a-z]+([\-\][a-z]+)?$/;
		var RegularExpression1 = new RegExp(re1);
                //re2: Verifies one or more last names starts with capital 
                //     letter, and may contain special character '-'. 
                //     Accepts only A-Z.
                var re2 = /^([A-Z][a-z]+([\-,\s][A-Z][a-z]+)*)+/;
		var RegularExpression2 = new RegExp(re2);
                //re3: Verifies an email-address has the proper syntax
                var re3 = /^.+@.+[\.\][a-z]+$/;
		var RegularExpression3 = new RegExp(re3);
                //re4: Verifies that atleast 1 character are used for password
                var re4 = /^.+$/;
		var RegularExpression4 = new RegExp(re4);
                
                //Check regularexpression for firstName
		if(document.inputs.firstName.value.search(RegularExpression1) === -1){
			//If regularexpression is violated, mark field name with red
                        document.getElementById('fName').innerHTML = "<font color=\"red\">First Name:</font>";
			console.log("False");
			isValid = false;
		} else{
                        //Else, mark field name with black
			document.getElementById('fName').innerHTML = "<font color=\"black\">First Name:</font>";
                        console.log("True");
		}
                
                //Check regularexpression for lastName
                if(document.inputs.lastName.value.search(RegularExpression2) === -1){
			//If regularexpression is violated, mark field name with red
                        document.getElementById('lName').innerHTML = "<font color=\"red\">Last Name:</font>";
			console.log("False");
			isValid = false;
		} else{
                        //Else, mark field name with black
			document.getElementById('lName').innerHTML = "<font color=\"black\">Last Name:</font>";
                        console.log("True");
		}
                //Check regularexpression for email
                if(document.inputs.email.value.search(RegularExpression3) === -1){
			//If regularexpression is violated, mark field name with red
                        document.getElementById('mail').innerHTML = "<font color=\"red\">Email:</font>";
			console.log("False");
			isValid = false;
		} else{
                        //Else, mark field name with black
			document.getElementById('mail').innerHTML = "<font color=\"black\">Email:</font>";
                        console.log("True");
		}
                
                //Check regularexpression for password                
                if(document.inputs.password.value.search(RegularExpression4) === -1){
			//If regularexpression is violated, mark field name with red
                        document.getElementById('pwd').innerHTML = "<font color=\"red\">Password:</font>";
			console.log("False");
			isValid = false;
		} else{
                        //Else, mark field name with black
			document.getElementById('pwd').innerHTML = "<font color=\"black\">Password:</font>";
                        console.log("True");
		}
                
                //If no errors occured, the isValid == true, else false
                return isValid;
	}
	</script>
    </HEAD>
    <BODY>
        <BR><BR>
        <H1>
            <P STYLE="color:black">Edit Information</P>
        </H1>
        <BR>
        <!-- Pass all form entries to AccountOverview.jsp, and post properties if 
             function validate() returns true -->
        <FORM NAME="inputs" METHOD="POST" ACTION="ValidateEditInformation.jsp" onsubmit="return validate()">
            <!-- Each columns name is enclosed in a <DIV> block so the text can be manipulated
                 from the JavaScript function validate(). Default values for the input fields
                 are loaded from the customer bean.-->
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
                    <TD><font color="red"><jsp:getProperty name="customer" property="errorMessage3"/></TD>
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
                
        <!-- Pass all form entries to AccountOverview.jsp, no properties are set -->
        <FORM METHOD=LINK ACTION="AccountOverview.jsp">
            <INPUT TYPE="submit" VALUE= "Back">
        </FORM>
    </BODY>
</HTML>