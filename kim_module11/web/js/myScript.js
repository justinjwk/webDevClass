/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// this function check user input for number of people
// if user input is out of range (1-10) then print a valid message
function checkNumPeople() {
    var inpObj = document.getElementById("numPeople");
    if (inpObj.checkValidity() == false) {
        document.getElementById("checkNumPeopleMsg").innerHTML = inpObj.validationMessage;
    } else {
        document.getElementById("checkNumPeopleMsg").innerHTML = "Input OK";
    }
}

//
//var durationGardiner = [{name:'3days', value:'3'}, {name:'5days', value:'5'}];
//var durationHellroaring = [{name:'2days', value:'2'}, {name:'3days', value:'3'}, {name:'4days', value:'4'}];
//var durationBeaten = [{name:'5days', value:'5'}, {name:'7days', value:'7'}];
//
//$(document).ready( function() {
//    $('#gardinerId').bind('click', function() {
//      $('#durationId').empty();                              
//      $.each(durationGardiner, function(index, value) {
//        $('#durationId').append('<option value="'+value.value+'">'+value.name+'</option>');
//      });
//    });
//
//    $('#hellroaringId').bind('click', function(){
//      $('#durationId').empty();                              
//      $.each(durationHellroaring, function(index, value) {
//        $('#durationId').append('<option value="'+value.value+'">'+value.name+'</option>');
//      });
//    });
//    
//    $('#beatenId').bind('click', function(){
//      $('#durationId').empty();                              
//      $.each(durationBeaten, function(index, value) {
//        $('#durationId').append('<option value="'+value.value+'">'+value.name+'</option>');
//      });
//    });
//  });

  
//function checkDate() {
//    var x, text;
//    var year, month, day;
//    
//    
//    x = document.getElementById("date").value;
//    
//    if(x.length === 10) {
//        month = x.slice(0,2);
//        day = x.slice(3,5);
//        year = x.slice(6,10);
//    }
//    else {
//        month = x.slice(0,1);
//        day = x.slice(2,4);
//        year = x.slice(5,9);
//    }
//    
//    document.getElementById("dateMsg").innerHTML = day;
//}

