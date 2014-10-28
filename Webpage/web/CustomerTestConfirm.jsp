<HTML>
	<%@ page language="java" contentType="text/html"%>
        
<%@ page errorPage="error.jsp"%>        
        
	<jsp:useBean id="customer" class="Beans.CustomerBean">
		<jsp:setProperty name="customer" property="*" />
	</jsp:useBean>

	<HEAD> 
		<TITLE>Customer Bean Test</TITLE>
	</HEAD>
	<BODY>
		<CENTER>

		<H1>Customer</H1>
		<BR>
		<TABLE BGCOLOR="aqua">
			<TR>
				<TH BGCOLOR="orange">Field Name</TH>
				<TH BGCOLOR="orange">Value</TH>
			</TR>
			<TR>
				<TD>customerNumber</TD>
                                
				<TD><jsp:getProperty name="customer" property="customerNumber" /></TD>
			</TR>
			<TR>
				<TD>firstname</TD>
				<TD><jsp:getProperty name="customer" property="firstname" /></TD>
			</TR>
			<TR>
				<TD>lastname</TD>
				<TD><jsp:getProperty name="customer" property="lastname" /></TD>
			</TR>
			<TR>
				<TD>email</TD>
				<TD><jsp:getProperty name="customer" property="email" /></TD>
			</TR>
		</TABLE>
		<BR><BR>
		<FORM METHOD=GET ACTION="Acceptance.html">
			<INPUT TYPE="submit" VALUE="Confirm">
		</FORM>
		</CENTER>
	</BODY>
</HTML>




