<html>
<head>
<title>Customer Test Page</title>
</head>
<body>
<%@ page errorPage="error.jsp" %>

<jsp:useBean id="idtestbean" class="Beans.CustomerBean" scope="session" />

<%-- START --%>
<%
    out.println("");
    out.println("Running first program in JSP.");
%>
<%-- END --%>
<form method="post" action="HelloWorldExample">
<input type="text" name="username"/>
<input type="password" name="password"/>
<input type="submit" VALUE = "Click me!"/>
<br>
<jsp:getProperty name="idtestbean" property="name" />
<br>
<jsp:getProperty name="idtestbean" property="newcustomer"/>

</body>
</html>


CustomerTestConfirm