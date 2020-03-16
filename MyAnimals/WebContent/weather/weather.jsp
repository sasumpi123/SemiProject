<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2,
.temp, .pressure, .wind-spd, .weather-descr, #altit, #latitude-val {
  font-size: 40px;
}


#cityname,
.temp {
  margin-top: 15px;
}

#city-name-wrapper {
  text-align: center;
  
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	  // geolocation enabled

	  if ("geolocation" in navigator) {
	    navigator.geolocation.getCurrentPosition(showcityname);

	    function showcityname(position) {
	      var lat = position.coords.latitude;
	      var longit = position.coords.longitude;
	      var altitude = position.coords.altitude;
	      var latitude_text = document.getElementById("latitude-val");
	      var altitude_text = document.getElementById("altit");
	      var city_name;
	      var temp;
	      var pressure;
	      var wind_speed;
	      var country_name;
	      var weather_description;
	      var apiKey = "0fcde51d43c81c13e57e8085693a9d85";

	      altitude_text.innerHTML = "Altitude is " + altitude;
	      latitude_text.innerHTML = "Latitude is " + lat;

	      $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + longit + "&appid=" + apiKey, function(data) {

	        city_name = data["name"];
	        country_name = data["sys"]["country"];
	        weather_description = data["weather"][0]["description"];
	        temp = data["main"]["temp"];
	        pressure = data["main"]["pressure"];
	        wind_speed = data["wind"]["speed"];

	        $("#cityname").html(city_name + " &#40;" + country_name + "&#41; " + "has " + weather_description);
	        $(".temp").html(temp);
	        $(".pressure").html(pressure + " mBar");
	        $(".wind-spd").html(wind_speed + " m/s");

	      })

	    }

	  }

	})
</script>
</head>
<body>
	
<div id="city-name-wrapper">
  <h2 class="text-center">Weather for:</h2>
  <h2 class="text-center" id="cityname"></h2>

  <div id="city-forecast">
    <p class="weather-descr col-xs-12"></p>
    <p class="temp col-xs-12"></p>
    <p class="pressure col-xs-12"></p>
    <p class="wind-spd col-xs-12"></p>
    <div id="altit"></div>
    <div id="latitude-val"></div>

    <!-- forecast  -->
  </div>
</div>
</body>
</html>