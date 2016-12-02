<%-- 
    Document   : index
    Created on : Nov 11, 2016, 6:39:14 PM
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Beartooth Hiking Company</title>
        <link href="js/mystylesheet.css" rel="stylesheet" type="text/css" />
        <script src="js/myScript.js"></script>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
        
        <!-- This script is for updating duration dropbox based on tour selection -->
        <script>
            
            var durationGardiner = [{name:'Click', value:'0'}, {name:'3 days', value:'3'}, {name:'5 days', value:'5'}];
            var durationHellroaring = [{name:'Click', value:'0'}, {name:'2 days', value:'2'}, {name:'3 days', value:'3'}, {name:'4 days', value:'4'}];
            var durationBeaten = [{name:'Click', value:'0'}, {name:'5 days', value:'5'}, {name:'7 days', value:'7'}];

            $(document).ready( function() {
                // if Gardiner is selected
                $('#gardinerId').bind('click', function() {
                  $('#durationId').empty();                              
                  $.each(durationGardiner, function(index, value) {
                    $('#durationId').append('<option value="'+value.value+'">'+value.name+'</option>');
                  });
                });
                // if Helloaring is selected
                $('#hellroaringId').bind('click', function(){
                  $('#durationId').empty();                              
                  $.each(durationHellroaring, function(index, value) {
                    $('#durationId').append('<option value="'+value.value+'">'+value.name+'</option>');
                  });
                });
                // if Beaten is selected
                $('#beatenId').bind('click', function(){
                  $('#durationId').empty();                              
                  $.each(durationBeaten, function(index, value) {
                    $('#durationId').append('<option value="'+value.value+'">'+value.name+'</option>');
                  });
                });
              });
        </script>
        <script language="javascript" type="text/javascript" src="js/datetimepicker.js">
        //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
        //Script featured on JavaScript Kit (http://www.javascriptkit.com)
        //For this script, visit http://www.javascriptkit.com 
        </script>
  

    </head>
    <body class="main" text="#000000" link="#0000EE" vlink="#551A8B" alink="#FF0000">
    <center>
        <div id="top">
            <div id="banner">
                <img id="bannerImg" width="800" src="images/Beartooth002-01.jpg" />
                <p id="bannerText">Welcome to Beartooth Hiking Company</p>
            </div>
        </div>
        <div id="middle">
            <table border="2">
                <caption align="bottom">* All hikes have a 50% surcharge for Sat/Sun hikes</caption>
                <tr>
                    <td colspan="2" align="center" height="15px"><b>Tour List & Options</b></td> 
                </tr>
                <tr>
                    <td align="center"><img src="images/BeartoothIslandLakeTrail_0326_800x600.jpg" alt="image for gardiner lake" width="300" height="150"/><br/>
			<i><b>Gardiner Lake</b></i>
                    </td>
                    <td>
			<ul>
                            <li>Length : 3 or 5 days</li>
                            <li>Level : Intermediate</li>
                            <li>Cost : $40/day</li>
			</ul>
                    </td>
                </tr>
                <tr>
                    <td align="center"><img src="images/clay_butte_06.jpg" alt="image for hellroaring pateau" width="300" height="150"/><br/>
			<i><b>Hellroaring Plateau</b></i>
                    </td>
                    <td>
			<ul>
                            <li>Length : 2, 3, or 4 days</li>
                            <li>Level : Easy</li>
                            <li>Cost : $35/day</li>
			</ul>
                    </td>
                </tr>
                <tr>
                    <td align="center">
			<img src="images/BeartoothView_800x600.jpg" alt="image for beaten path" width="300" height="150"/><br/>
			<i><b>Beaten Path</b></i>
                    </td>
                    <td>
			<ul>
                            <li>Length : 5 or 7 days</li>
                            <li>Level : Difficult</li>
                            <li>Cost : $45/day</li>
			</ul>
                    </td>
                </tr>
            </table>
        </div>
        <div id="bottom">
            <form action="Controller" method=POST>
                <table width="800">
                    <tr height="120">
                        <td align="center">
                            <h1 style="color:white">Search Reserved Tour</h1>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <table width="600">
                                <tr>
                                    <th>Input Beginning Date</th>
                                </tr>
                                <tr>
                                    <td align="center">
                                        <input type="Text" id="date" name="dateInput" maxlength="40" size="35">
                                        <a href="javascript:NewCal('date','MMddyyyy')">
                                        <img src="images/cal.gif" width="18" height="18" border="0" alt="Pick a date"></a>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <input type="submit" value="Search" onclick="checkNumPeople()">
                            <input type="reset" value="Reset">
                        </td>
                    </tr>
                </table>
            </form>
            For additional information, click the link <a href="http://www.wilderness.net/index.cfm?fuse=NWPS&amp;sec=wildView&amp;WID=1"/>wilderness.net</td>
        </div>
    </center>
    </body>
</html>

