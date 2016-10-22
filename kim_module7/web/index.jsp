<%-- 
    Document   : index
    Created on : Oct 21, 2016, 3:15:40 AM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beartooth Hiking Company</title>
        <style>
            table {
                border: 1px solid black;
                border-spacing: 1px;
            }
            th {
                text-align: center;
            }
            td {
                padding: 5px;
                text-align: top, left;
            }
            h2 {
                text-align: center;
                color: red;
            }

        </style>            
    </head>
    <body>
        <form action="Module7" method=GET>
            <table width="600">
                <tr height="120">
                    <td background="./Beartooth002-01.jpg" align="center" colspan="3">
                        <h1 style="color:white">Welcome to Beartooth Hiking Company</h1>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="180">
                            <tr>
                                <th colspan="2">Input Beginning Date</th>
                            </tr>
                            <tr>
                                <td width="50">
                                    Year:  <br>
                                    Month: <br>
                                    Day:  <br>
                                </td> 
                                <td>
                                    <input type="text" name="year" size="5"><br>
                                    <input type="text" name="month" size="5"><br>
                                    <input type="text" name="day" size="5"><br>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table with="180">
                            <tr>
                                <th>Please Select Tour</hd>
                            </tr>
                            <tr>
                                <td>
                                    <input type="radio" name="tour" value="gardiner" checked/><label for="gardiner">Gardiner Lake</label><br>
                                    <input type="radio" name="tour" value="hellroaring"/><label for="hellroaring">Hellroaring Plateau</label><br>
                                    <input type="radio" name="tour" value="beaten"/><label for="beaten">Beaten Path</label><br>

                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="180" height="90">
                            <tr>
                                <th>Select Duration</th>
                            </tr>
                            <tr>
                                <td align="center">
                                    <select name="duration" action="Module7" method=GET>
                                        <option value="0">Duration</option>
                                        <option value="2">2 Days</option>
                                        <option value="3">3 Days</option>
                                        <option value="4">4 Days</option>
                                        <option value="5">5 Days</option>
                                        <option value="7">7 Days</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <input type="submit" value="Calculate Rate">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
