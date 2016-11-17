<%-- 
    Document   : failed
    Created on : Nov 11, 2016, 7:21:50 PM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Error : Beartooth Hiking Company</title>
        
        <jsp:useBean id="failed" class="kim_module10.Failed" scope="session" />
        <link href="js/mystylesheet.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <table border="1">
            <tr>
                <th>
                    <h2>Error: 
                        <% out.print(failed.getErrorMsgTitle());%> 
                    </h2> <br>
                </th>
            <tr>
                <td>
                    <h3><% out.print(failed.getErrorMsg()); %> 
                    </h3> <br>
                </td>
            </tr>
        </table>
    </body>
</html>
