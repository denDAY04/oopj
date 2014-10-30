<HTML>
    <%@ page language="java" contentType="text/html"%>

    <jsp:useBean id="journey" class="Beans.CustomerBean">
    </jsp:useBean>
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
        <BR><BR>
        <H1><P STYLE="color:black">Journey History</P>
        </H1>
        <BR>
        <!-- Pass all form entries to Order.jsp ? -->
        <form id="form1" runat="server" method="POST" action="ViewJourneyHistory.jsp">
<!--        <div>
            <input type="button" value="Create Table" onclick="createTable()" />
            <input type="button" value="Update Table" onclick="updateTable()" />
        </div>
        <div id="divTable">
        </div>-->
            <div>
                <INPUT type="submit" value="Show more journeys">
            </div>
            <BR>
            <div>
                <table id="journeys" border="1" style="width:50%">
                    <tr>
                        <th>Date</th>
                        <th>Start Destination</th> 
                        <th>Start Zone</th>
                        <th>Zones</th>
                        <th>Price</th>
                    </tr>
                    <% for(int row=1; row <= 10; row++) { %>
                        <TR>
                    <%      for(int col=1; col<=5; col++) { %>
                                <TD> (<%=col%>, <%=row%>) </TD>
                            <% } %>
                        </TR>
                    <% } %>
                </table>

        
            </div>
        </form>        
    </BODY>
</HTML>