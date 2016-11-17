<%-- 
    Document   : success
    Created on : Nov 11, 2016, 6:44:56 PM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quote : Beartooth Hiking Company</title>
        
        <jsp:useBean id="success" class="kim_module10.Success" scope="session" />
        <link href="js/mystylesheet.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <table border=1>
            <tr>
                <td>
                    <h1>Tour : 
                        <% out.print(success.getHike());%>
                    </h1><br>
                </td>
            </tr>
            <tr>
                <td>
                    <h1>Beginning Date: 
                        <% out.print(success.getBookingDay().toString()); %>
                    </h1><br>
                    <h1>Duration: 
                        <% out.print(success.getDuration()); %> days
                    </h1><br>
                    <h1>Number of People: 
                        <% out.print(success.getNumOfPeople()); %>
                    </h1><br>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <h1>Cost : $
                        <% out.print(success.getCost()); %>
                    </h1><br>
                </td>
            </tr>
        </table>
    </body>
</html>
