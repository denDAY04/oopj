<%@ page isErrorPage="true" %>
<HTML>
<HEAD>
<TITLE>Error</TITLE>
</HEAD>
<BODY>
<H1 ALIGN="CENTER">ERROR</H1>
<P><%= exception.toString() %></P><br>
<br>
<% exception.printStackTrace(response.getWriter()); %>
<br>
</BODY>
</HTML>