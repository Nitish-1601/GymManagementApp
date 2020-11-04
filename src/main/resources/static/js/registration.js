//function saveUserData()
//{
//    var xhttp = new XMLHttpRequest();
//    xhttp.open('POST', '/save-info');
//    xhttp.onload = function(){
//        var userdata = JASON.parse(xhttp.responseText);
//    };
//    xhttp.send();
//
//};

function saveUserData()
{
    let data = document.querySelectorAll('input');
    data.forEach(d => {
    console.log(d);
    });
}







//const $ = require('https://code.jquery.com/jquery-3.3.1.min.js');
//const saveUserData = () => {
//    var registration_data = document.getElementsByTagName('input');
//        const userRegistrationData = {};
//        userRegistrationData.firstName = registration_data[0].value;
//        userRegistrationData.lastName = registration_data[1].value;
//        userRegistrationData.password = registration_data[2].value;
//        userRegistrationData.age = registration_data[3].value;
//        userRegistrationData.emailId = registration_data[4].value;
//        userRegistrationData.phoneNumber = registration_data[5].value;
//
//        $.ajax({
//            url: '/save-info',
//            type: "POST",
//            data: userRegistrationData,
//            dataType: "json",
//            success: function (data) {
//                console.log(data);
//            },
//            error: function (error) {
//                console.log(`Error ${error}`);
//            }
//        });
//}
