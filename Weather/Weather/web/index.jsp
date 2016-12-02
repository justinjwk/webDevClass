<%--
    Document   : index
    Created on : Dec 15, 2007, 5:27:57 AM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weather Web Service</title>
    </head>
    <body>
        <h2>Weather Web Service</h2>
          <form action="http://localhost:8080/Weather/weather.jsp" method=GET>
            zip code: <input type="TEXT" name="zip"> <br /><br />
            <input type="SUBMIT">
        </form>
    </body>
</html>
