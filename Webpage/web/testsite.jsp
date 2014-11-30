<%-- 
    Document   : testsite
    Created on : Nov 30, 2014, 10:29:43 PM
    Author     : Qesss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="testbean.test" scope="session">
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Test</title>
        <script language="javascript">
//http://www.snip2code.com/Snippet/18734/
            function toggle(elementId) {
                var ele = document.getElementById(elementId);
                if (ele.style.display === "block") {
                    ele.style.display = "none";
                }
                else {
                    ele.style.display = "block";
                }
            }
        </script>

    </head>
    <body>


   
        
            <% for (int row = 1; row <= 10; row++) { %>

            <a id="displayText" href="javascript:toggle('<jsp:getProperty name="bean" property="counter"/>');">Details:</a>
            <br>
            <div id="<jsp:getProperty name="bean" property="counter"/>" style="display: none" href="javascript:toggle();"> 
            <table  border="0" style="width:50%">
                <TR>	
                    <TD>
                        Station 1
                    </TD>
                </TR>
                <TR>
                    <TD>
                        Station 2
                    </TD>
                </TR>
             </table>
            </div>
            
          <!--  <jsp:setProperty name="bean" property="counter" value=" "/>-->
                <% }%>
       




    </body>
</html>
