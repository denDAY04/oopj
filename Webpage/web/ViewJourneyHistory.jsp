<HTML>
    <%@ page language="java" contentType="text/html"%>

    <jsp:useBean id="journey" class="Beans.JourneyBean" scope = "page"/>


    <jsp:useBean id="customerBean" class="Beans.CustomerBean" scope="session" />

    <jsp:setProperty name="journey" property="customerNumber" value="<%=customerBean.getCustomerNumber()%>"/>
    <jsp:setProperty name="journey" property="index" value="${param.index}"/>



    <!--    id = Specifies the name of the scripting variable (and associated page scope attribute) that will be made available with the value of the specified property.
        
        name = Specifies the attribute name of the bean whose property is accessed to define a new page scope attribute (if property is also specified) or the attribute name of the bean that is duplicated with the new reference created by this tag (if property is not also specified). This attribute is required unless you specify a value attribute or nested body content.
        
       property = Specifies the name of the property to be accessed on the bean specified by name. This value may be a simple, indexed, or nested property reference expression. If not specified, the bean identified by name is given a new reference identified by id.
    -->


    <HEAD>
        <TITLE>Recent Journeys</TITLE>
        <STYLE>
            body {text-align:left;}
        </STYLE>
        <script language="javascript" type="text/javascript">
            // Create table.
            /*var table = document.createElement('table');
             
             function updateTable() {
             // Create table.
             //var table = document.getElementById('table');
             // Insert New Row for table at index '0'.
             for(r=1; r<=10; r++){
             var row = table.insertRow(r);
             for(c=0; c<5; c++){
             // Insert New Column for Row1 at index '0'.
             var col = row.insertCell(c);
             col.innerHTML = 'Somedata';
             }
             }
             // Append Table into div.
             var div = document.getElementById('divTable');
             div.appendChild(table);
             }
             
             function createTable() {
             
             // Apply CSS for table
             table.setAttribute('class', 'article');
             
             // Create an empty <thead> element and add it to the table:
             var header = table.createTHead();
             
             // Create an empty <tr> element and add it to the first position of <thead>:
             var row1 = header.insertRow(0);     
             
             // Insert New Column for Row1 at index '0'.
             var row1col1 = row1.insertCell(0);
             row1col1.innerHTML = 'Date/Time';
             // Insert New Column for Row1 at index '1'.
             var row1col2 = row1.insertCell(1);
             row1col2.innerHTML = 'Start Destination';
             // Insert New Column for Row1 at index '2'.
             var row1col3 = row1.insertCell(2);
             row1col3.innerHTML = 'Start Zone';
             // Insert New Column for Row1 at index '3'.
             var row1col4 = row1.insertCell(3);
             row1col4.innerHTML = 'Zones';
             // Insert New Column for Row1 at index '4'.
             var row1col5 = row1.insertCell(4);
             row1col5.innerHTML = 'Price';
             // Append Table into div.
             var div = document.getElementById('divTable');
             div.appendChild(table);
             }*/
        </script>
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
    </form>        
</BODY>
</HTML>