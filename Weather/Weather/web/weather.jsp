<%--
    Document   : weather
    Created on : Dec 15, 2007, 2:33:33 PM
    Author     : evansrb1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="weather" class="com.rbevans.Weather" scope="session" />
<jsp:setProperty name="weather" property="zipCode" param="zip" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weather for Zip Code <jsp:getProperty name="weather" property="zipCode" /></title>
    </head>
    <body>
        <h2>Here is the weather for zip code <jsp:getProperty name="weather" property="zipCode" /></h2>
        Forecast: <img src=<jsp:getProperty name="weather" property="weatherImageURL"/> align="left" hspace="10"/> <br />
        Today's date: <jsp:getProperty name="weather" property="day" /> <br />
        High Temp: <jsp:getProperty name="weather" property="maxTemp" /> <br />
        Low Temp: <jsp:getProperty name="weather" property="minTemp" /> <br />
    </body>
</html>
