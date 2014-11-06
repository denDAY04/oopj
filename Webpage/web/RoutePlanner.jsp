<%-- 
    Document   : RoutePlanner
    Created on : Oct 31, 2014, 3:54:30 PM
    Author     : Rasmus
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<jsp:useBean id="RPBean" class="JPBeans.RPBean" scope="session">
</jsp:useBean>

<jsp:setProperty name="RPBean" property="*"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Route Planner</title>

        </script>
        
    </head>
    <body>
        
             <h1  align="CENTER">Enter Journey Details</h1>

        <FORM NAME="routeplanner" METHOD="POST" ACTION="RoutePlanner.jsp"> 
            <TABLE align="CENTER">
                <TR>
                    <TD>Year</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "year"
                               VALUE="<jsp:getProperty name="RPBean" property="year" />"></TD>
                </TR>
                <TR>
                    <TD>Month:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "month"
                               VALUE="<jsp:getProperty name="RPBean" property="month" />"></TD>
                </TR>
                <TR>
                    <TD>Day</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "day"
                               VALUE="<jsp:getProperty name="RPBean" property="day" />"></TD>
                </TR>
                <TR>
                    <TD>Hour</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "hour"
                               VALUE="<jsp:getProperty name="RPBean" property="hour" />"></TD>
                </TR>
                <TR>
                    <TD>Minute</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "minute"
                               VALUE="<jsp:getProperty name="RPBean" property="minute" />"></TD>
                </TR>
                <TR>
                    <TD>From:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "origin"
                               VALUE="<jsp:getProperty name="RPBean" property="origin" />"></TD>
                </TR>
                <TR>
                    <TD>To:</TD>
                    <TD><INPUT TYPE="text"
                               NAME= "destination"
                               VALUE="<jsp:getProperty name="RPBean" property="destination" />"></TD>
                </TR>
                <TR>
                    <TD></TD>
                    <TD><INPUT TYPE="test"
                               NAME="rpj"
                               VALUE="<jsp:getProperty name="RPBean" property="rpj" />"></TD>
                </TR>
            </TABLE>
            <BR><BR>
            <INPUT TYPE="submit" VALUE= "Find Journey">
        </FORM>

        <DIV id="route"></div>    

    </body>
</html>