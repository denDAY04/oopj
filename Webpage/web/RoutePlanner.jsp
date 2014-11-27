<%-- 
    Document   : RoutePlanner
    Created on : Oct 31, 2014, 3:54:30 PM
    Author     : Rasmus
--%>
<%@ page errorPage="error.jsp" %>
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

        
        <script type="text/javascript">
        //Function validate()
	function validate(){
                var isValid = true;                                     

        //
        var stations = ["ballerup", "malmparken", "skovlunde","herlev","husum","islev","flintholm","valby","enghave","vesterport"];
                                                           
                              
                var originindex = stations.indexOf(document.getElementById('origin').value.toLowerCase());
		if (originindex === -1){
			//If violated, mark field name with red
                        document.getElementById('from').innerHTML = "<font color=\"red\">From</font>";
			console.log("False");
			isValid = false;
		} else{
                        //Else, mark field name with black
			document.getElementById('from').innerHTML = "<font color=\"black\">From</font>";
                        document.getElementById('originintid').value = originindex;
                        console.log("True");
		}
                var destinationindex = stations.indexOf(document.getElementById("destination").value.toLowerCase());
		if(destinationindex === -1){
			//If violated, mark field name with red
                        document.getElementById('to').innerHTML = "<font color=\"red\">to</font>";
			console.log("False");
			isValid = false;
		} else{
                        //Else, mark field name with black
			document.getElementById('to').innerHTML = "<font color=\"black\">to</font>";
                        document.getElementById('destinationintid').value = destinationindex;
                        console.log("True");
		}
                
                //If no errors occured, the isValid == true, else false
                return isValid;
	}
	</script>        
        
        
    </head>
    <body>
        
             <h1  align="CENTER">Enter Journey Details</h1>

        <FORM NAME="routeplanner" METHOD="POST" ACTION="RoutePlanner.jsp" onsubmit="return validate()"> 
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
                     <TD><DIV id="from"><font color="black">From</font></DIV></TD>
                     <TD><DIV id="to"><font color="black">to</font></DIV></TD>
                </TR>
                <TR>
                    
                    <TD><INPUT TYPE="text"
                               NAME= "origin"
                               ID ="origin"
                               VALUE="<jsp:getProperty name="RPBean" property="origin" />"></TD>
                    <TD><INPUT TYPE="text"
                               NAME= "destination"
                               ID ="destination"
                               VALUE="<jsp:getProperty name="RPBean" property="destination" />"></TD>
                </TR>
                <TR>
                    <TD><INPUT TYPE="hidden"
                               NAME="originint"
                               ID ="originintid"
                               ></TD>
                    <TD><INPUT TYPE="hidden"
                               NAME="destinationint"
                               ID ="destinationintid"
                               ></TD>
                    <TD><INPUT TYPE="hidden"
                               NAME="dorouteplanning"
                               VALUE=" "></TD>
                    
                    
                    <td><INPUT TYPE="submit" VALUE= "Find Journey"></td>
                </TR>
            </TABLE>
            <BR><BR>

        </FORM>

        <DIV id="route"></div>    

        <% if (RPBean.getNumberofwaypoints()>0){%>
        
        <h1  align="CENTER">Journey:</h1>
        <br>
        Number of zones: <jsp:getProperty name="RPBean" property="zonecount"/><br>
        Zones: <jsp:getProperty name="RPBean" property="zones"/><br>
        Price <jsp:getProperty name="RPBean" property="price"/><br>
        Duration <jsp:getProperty name="RPBean" property="totalduration"/><br>
        Number of changes <jsp:getProperty name="RPBean" property="changecount"/><br>
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
