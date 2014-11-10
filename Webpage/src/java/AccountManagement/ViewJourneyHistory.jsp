<HTML>
    <%@ page language="java" contentType="text/html" errorPage="error.jsp"%>

    <jsp:useBean id="journey" class="Beans.JourneyBean" scope = "page"/>
    <jsp:useBean id="customerBean" class="Beans.CustomerBean" scope="session" />
    <jsp:setProperty name="journey" property="customerNumber" value="<%=customerBean.getCustomerNumber()%>"/>
    <jsp:setProperty name="journey" property="index" value="${param.index}"/>
    <%
        if( customer.getCustomerNumber()=="")
          response.sendRedirect("/Webpage/Login.jsp");
    %>
    
    <HEAD>
        <TITLE>Recent Journeys</TITLE>
        <STYLE>
            body {text-align:left;}
        </STYLE>
    </HEAD>
    <BODY>
        Customer number: <jsp:getProperty name="journey" property="customerNumber"/><br>
        index is :  <jsp:getProperty name="journey" property="index"/>
        <BR><BR>
        <H1><P STYLE="color:black">Journey History</P>
        </H1>
        <BR>
        <BR>
        displaying  <jsp:getProperty name="journey" property="displayFrom"/> to <jsp:getProperty name="journey" property="displayTo"/>
        <div>
            <table id="journeys" border="1" style="width:50%">
                <tr>
                    <th>Date</th>
                    <th>Start Zone</th>
                    <th>Zones</th>
                    <th>Price</th>
                </tr>
                <% for (int row = 1; row <= journey.getListSize(); row++) { %>
                <TR>
                    <TD> <jsp:getProperty name="journey" property="nextStarttime"/> </TD>
                    <TD> <jsp:getProperty name="journey" property="nextStartzone"/> </TD>
                    <TD> <jsp:getProperty name="journey" property="nextNumberofzones"/> </TD>
                    <TD> <jsp:getProperty name="journey" property="nextPrice"/> </TD>
                        <jsp:setProperty name="journey" property="next" value=""/>
                </TR>
                        <% }%>
            </table>
            <br>
            <table>
                <tr>
                    <TD>
                        <form action="ViewJourneyHistory.jsp">
                            <input type="submit" value="previous journeys">
                            <input type="hidden" name="index" value="<%=journey.getprevIndex()%>">
                        </form>
                    </TD>
                    <TD>
                        <form action="ViewJourneyHistory.jsp">
                            <input type="submit" value="Next journeys">
                            <input type="hidden" name="index" value="<%=journey.getNextIndex()%>">
                        </form>   
                    </TD>
                </tr>
            </table>
        </div>      
</BODY>
</HTML>