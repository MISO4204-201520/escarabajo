		var map, currentPositionMarker;
		var source, destination;
        var directionsDisplay;
        var directionsService = new google.maps.DirectionsService();
		var initTime, finalTime;
        var realSource, realDestination;
		
		google.maps.event.addDomListener(window, 'load', function () {
            new google.maps.places.SearchBox(document.getElementById('txtSource'));
            new google.maps.places.SearchBox(document.getElementById('txtDestination'));
            directionsDisplay = new google.maps.DirectionsRenderer({ 'draggable': true });
        });

        function GetRoute() {
            var bogota = new google.maps.LatLng(4.598889, -74.080833);
            var mapOptions = {
                zoom: 12,
                center: bogota,
				mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map = new google.maps.Map(document.getElementById('dvMap'), mapOptions);
            directionsDisplay.setMap(map);
            directionsDisplay.setPanel(document.getElementById('dvPanel'));
			
            //*********DIRECCIONES Y RUTAS**********************//
            source = document.getElementById("txtSource").value;
            destination = document.getElementById("txtDestination").value;

            var request = {
                origin: source,
                destination: destination,
                travelMode: google.maps.TravelMode.DRIVING
            };
            directionsService.route(request, function (response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                }
            });

            //*********DISTANCIA Y DURACIÓN**********************//
            var service = new google.maps.DistanceMatrixService();
            service.getDistanceMatrix({
                origins: [source],
                destinations: [destination],
                travelMode: google.maps.TravelMode.DRIVING,
                unitSystem: google.maps.UnitSystem.METRIC,
                avoidHighways: false,
                avoidTolls: false
            }, function (response, status) {
                if (status == google.maps.DistanceMatrixStatus.OK && response.rows[0].elements[0].status != "ZERO_RESULTS") {
                    var distance = response.rows[0].elements[0].distance.text;
                    var duration = response.rows[0].elements[0].duration.text;
                    var dvDistance = document.getElementById("dvDistance");
                    dvDistance.innerHTML = "";
                    dvDistance.innerHTML += "Distancia Estimada: " + distance + "<br />";
                    dvDistance.innerHTML += "Duración Estimada: " + duration;

                } else {
                    alert("No es posible encontrar un camino.");
                }
            });
        }
		
		function StartRoute(){
			initTime = new Date().getTime();
			if(navigator.geolocation){
				navigator.geolocation.getCurrentPosition(function (p) {
					realSource = p;
				});
				var opts = {
					enableHighAccuracy: true,
					timeout			  : Infinity,
					maximumAge		  : 0
				}
				navigator.geolocation.watchPosition(displayAndWatch, CurrentLocationFailure, opts);
			}
			else {
				alert('Geo Location no es soportada por el explorador.');
			}
			
		}
		
		function EndRoute(){
			finalTime = new Date().getTime();
			if(navigator.geolocation){
				navigator.geolocation.getCurrentPosition(function (p) {
					realDestination = p;
					var realDistance = google.maps.geometry.spherical.computeDistanceBetween(realSource, realDestination);
			
					var dvDistance = document.getElementById("dvDistance");
					dvDistance.innerHTML += "<br/>";
					dvDistance.innerHTML += "Distancia Real: " + realDistance + "<br />";
					dvDistance.innerHTML += "Duración Real: " + ((finalTime-initTime)/1000) + " seg";
				});
				
			}
			else {
				alert('Geo Location no es soportada por el explorador.');
			}	
			var realDistance = google.maps.geometry.spherical.computeDistanceBetween(realSource, realDestination);
		}

		function setCurrentPosition(pos) {
			//currentPositionMarket.setMap(null);
			currentPositionMarker = new google.maps.Marker({
				map: map,
				position: new google.maps.LatLng(
					pos.coords.latitude,
					pos.coords.longitude
				),
				title: "Current Position"
			});
			map.panTo(new google.maps.LatLng(
					pos.coords.latitude,
					pos.coords.longitude
				));
		}

		function displayAndWatch(position) {
			// set current position
			setCurrentPosition(position);
			// watch position
			watchCurrentPosition();
		}

		function watchCurrentPosition() {
			var positionTimer = navigator.geolocation.watchPosition(
				function (position) {
					setMarkerPosition(
						currentPositionMarker,
						position
					);
				});
		}

		function setMarkerPosition(marker, position) {
			marker.setPosition(
				new google.maps.LatLng(
					position.coords.latitude,
					position.coords.longitude)
			);
		}

		
		/*function ShowCurrentLocation(p){
			var myLatLng = new google.maps.LatLng(p.coords.latitude, p.coords.longitude);
			
			var mapTemp = document.getElementById("dvMap");
			/*var mapOptions={
				zoom:10,
				center:myLatLng,
				mapTypeId:google.maps.MapTypeId.ROAD
			};
			
			map = new google.maps.Map(mapTemp, mapOptions);
			
			currentPositionMarker.setPosition(myLatLng);
			
			google.maps.event.addListener(currentPositionMarker, "click", function (e) {
				var infoWindow = new google.maps.InfoWindow();
				infoWindow.setContent(currentPositionMarker.title);
				infoWindow.open(mapTemp, currentPositionMarker);
			});
		}*/
		
		function CurrentLocationFailure(){
				var errorType={
					0:"Error Desconocido",
					1:"Permisos negados por el usuario",
					2:"Ubicación del usuario no disponible",
					3:"Time out"
				};
					 
				var errMsg = errorType[error.code];
					 
				if(error.code == 0 || error.code == 2){
					errMsg = errMsg+" - "+error.message;
				}
		}