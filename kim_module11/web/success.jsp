<%-- 
    Document   : success
    Created on : Nov 17, 2016, 6:44:56 PM
    Author     : Justin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="kim_module11.Success"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results : Beartooth Hiking Company</title>
        
        <jsp:useBean id="results" class="kim_module11.Success" scope="session" />
        <link href="js/mystylesheet.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <table border=1>
            <tr>
                <td>
                    <h1>Search Results : Reserved Tour Information 
                    </h1><br>
                </td>
            </tr>
            <tr>
                <th>Date</th>
                <th>Location</th>
                <th>Guide Name</th>
                <th>Reservation First Name</th>
                <th>Reservation Last Name</th>
            </tr>
            <% ArrayList<Success> results = (ArrayList)session.getAttribute("results");
                for(Success success : results) { %>
                <tr>
                    <td><%= success.getDate() %></td>
                    <td><%= success.getLocation() %></td>
                    <td><%= success.getGuideName() %></td>
                    <td><%= success.getReservationFirst() %></td>
                    <td><%= success.getReservationLast() %></td>
                </tr>
                <% } %>
        </table>
    </body>
</html>
