var map;
var marker;

function load_map() {
    geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(19.4321514, -99.1331887);
    var mapOptions = {
        zoom: 12,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
}

function buscar() {
    if (marker) {
        marker.setMap(null);
    }
    // Obtenemos la dirección y la asignamos a una variable
    var address = build_address();
    geocoder.geocode({'address': address}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            marker = new google.maps.Marker({
                map: map,
                draggable: true,
                animation: google.maps.Animation.DROP,
                position: results[0].geometry.location
            });
            google.maps.event.addListener(marker, 'dragend', function () {
                document.getElementById("txtcoordx").value = this.getPosition().lng();
                document.getElementById("txtcoordy").value = this.getPosition().lat();
            });
            if (results[0].geometry.viewport) {
                map.fitBounds(results[0].geometry.viewport);
            }
            document.getElementById("txtcoordx").value = results[0].geometry.location.lng();
            document.getElementById("txtcoordy").value = results[0].geometry.location.lat();
        } else {
            alert("Geocode no pudo realizar su funcion por: " + status);
        }
    });
}

function build_address() {
    var address;
    var calle1 = document.getElementById("txtcalle1").value;
    var calle2 = document.getElementById("txtcalle2").value;
    var colonia = document.getElementById("txtcolonia").value;
    var sel = document.getElementById("slcdeleg");
    if(sel){
        var delegacion = sel.options[sel.selectedIndex].text;
    }
    else{
        var delegacion = document.getElementById("txtdeleg").value;
    }

    if ((calle1) && (calle2) && (colonia) && (delegacion)) {
        address = calle1 + " y " + calle2 + ", " + colonia + ", " + delegacion;
    }
    else if ((!calle1) && (calle2) && (colonia) && (delegacion)) {
        address = calle2 + ", " + colonia + ", " + delegacion;
    }
    else if ((calle1) && (!calle2) && (colonia) && (delegacion)) {
        address = calle1 + ", " + colonia + ", " + delegacion;
    }
    else if ((calle1) && (calle2) && (!colonia) && (delegacion)) {
        address = calle1 + " y " + calle2 + ", " + delegacion;
    }
    else if ((calle1) && (calle2) && (colonia) && (!delegacion)) {
        address = calle1 + " y " + calle2 + ", " + colonia;
    }
    else if ((!calle1) && (!calle2) && (colonia) && (delegacion)) {
        address = colonia + ", " + delegacion;
    }
    else if ((!calle1) && (calle2) && (!colonia) && (delegacion)) {
        address = calle2 + ", " + delegacion;
    }
    else if ((!calle1) && (calle2) && (colonia) && (!delegacion)) {
        address = calle2 + ", " + colonia;
    }
    else if ((calle1) && (!calle2) && (!colonia) && (delegacion)) {
        address = calle1 + ", " + delegacion;
    }
    else if ((calle1) && (!calle2) && (colonia) && (!delegacion)) {
        address = calle1 + ", " + colonia;
    }
    else if ((calle1) && (calle2) && (!colonia) && (!delegacion)) {
        address = calle1 + " y " + calle2;
    }
    else if ((calle1) && (!calle2) && (!colonia) && (!delegacion)) {
        address = calle1;
    }
    else if ((!calle1) && (calle2) && (!colonia) && (!delegacion)) {
        address = calle2;
    }
    else if ((!calle1) && (!calle2) && (colonia) && (!delegacion)) {
        address = colonia;
    }
    else if ((!calle1) && (!calle2) && (!colonia) && (delegacion)) {
        address = delegacion;
    }
    
    return address;
}
