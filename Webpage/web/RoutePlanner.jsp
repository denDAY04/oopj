<%-- 
    Document   : RoutePlanner
    Created on : Oct 31, 2014, 3:54:30 PM
    Author     : Rasmus
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="false" %>

<!DOCTYPE html>

<jsp:useBean id="RPBean" class="JPBeans.RPBean" scope="session">
</jsp:useBean>

<jsp:setProperty name="RPBean" property="*"/>
<jsp:setProperty name="RPBean" property="nextwaypoint" value="0"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Route Planner</title>

        </script>
        
    </head>
    <body>
        
             <h1  align="CENTER">Enter Journey Details</h1>

        <FORM NAME="routeplanner" METHOD="POST" ACTION="RoutePlanner.jsp"> 
            <TABLE align="CENTER" style="width:50%">
                <TR>
                    <TD>Year</TD>
                    <TD>Month:</TD>
                    <TD>Day</TD>
                    <TD>Hour</TD>
                    <TD>Minute</TD>

                </TR>
                <TR>
                    <TD><INPUT TYPE="text"
                               NAME= "year"
                               VALUE="<jsp:getProperty name="RPBean" property="year" />"></TD>
                
                    <TD><INPUT TYPE="text"
                               NAME= "month"
                               VALUE="<jsp:getProperty name="RPBean" property="month" />"></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "day"
                               VALUE="<jsp:getProperty name="RPBean" property="day" />"></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "hour"
                               VALUE="<jsp:getProperty name="RPBean" property="hour" />"></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "minute"
                               VALUE="<jsp:getProperty name="RPBean" property="minute" />"></TD>
                </TR>
                <TR>
                <br>
                     <TD>From:</TD>
                     <TD>To:</TD>
                </TR>
                <TR>
                    
                    <TD><INPUT TYPE="text"
                               NAME= "origin"
                               VALUE="<jsp:getProperty name="RPBean" property="origin" />"></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "destination"
                               VALUE="<jsp:getProperty name="RPBean" property="destination" />"></TD>
                </TR>
                <TR>
                    <TD></TD>
                    <TD><INPUT TYPE="hidden"
                               NAME="dorouteplanning"
                               VALUE=" "></TD>
                    <td>            <INPUT TYPE="submit" VALUE= "Find Journey"></td>
                </TR>
            </TABLE>
            <BR><BR>

        </FORM>

        <DIV id="route"></div>    

        <% if (RPBean.getNumberofwaypoints()>0){%>
        
        <h1  align="CENTER">Journey:</h1>
        <br>
        Number of zones: <jsp:getProperty name="RPBean" property="zonecount"/><br>
        zones: <jsp:getProperty name="RPBean" property="zones"/><br>
        price <jsp:getProperty name="RPBean" property="price"/><br>
        duration <jsp:getProperty name="RPBean" property="totalduration"/><br>
        number of changes <jsp:getProperty name="RPBean" property="changecount"/><br>
        <br>
   
             <table id="journeyplanner" border="0" style="width:50%">
                <% for (int row = 1; row <= RPBean.getNumberofwaypoints(); row++) { %>
                <TR>
                    <TD><jsp:getProperty name="RPBean" property="time"/></TD>
                    <TD> <jsp:getProperty name="RPBean" property="waypointtransport"/> </TD>
                    
                    <!--<jsp:getProperty name="RPBean" property="nextwaypoint"/>-->
                </TR>
                        <% }%>
            </table>
        <% }%>
    </body>
</html>
