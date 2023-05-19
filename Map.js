function initialize() {
    var gmap;
    var bounds = new google.maps.LatLngBounds();
    var mapOptions = {
        mapTypeId: 'roadmap'
    };
    gmap = new google.maps.Map(document.getElementById("gmap_canvas"), mapOptions);
    gmap.setTilt(45);
    var myLocations = [
        ['New delhi, INDIA', 28.610746852715387,77.21122741699219, 'New delhi, INDIA'],
        ['UPSC New delhi, INDIA', 28.60622574490014,77.22908020019531, 'Union Service Public New delhi, INDIA'],
        ['National Zoological Park, New Delhi India', 28.6730542, 77.3238588, 'National Zoological Park, Mathura Road, New Delhi, Delhi 110003, India'],
        ['India Gate,New delhi India',28.610295,77.230797,'India Gate,New delhi India']
    ];
    var infoPopupWindowContent = [];
    var temp =''
    for( let i = 0; i < myLocations.length; i++ ) {
       temp = ['<div class="info_content">' + '<h3>'+myLocations[i][0]+'</h3>' + '<p>'+myLocations[i][3]+'</p>' + '</div>'];
       infoPopupWindowContent.push(temp)}
    var infoPopupWindow = new google.maps.InfoWindow(), marker;
    for(let i = 0; i < myLocations.length; i++ ) {
        var position = new google.maps.LatLng(myLocations[i][1], myLocations[i][2]);
        bounds.extend(position);
        marker = new google.maps.Marker({
            position: position,
            map: gmap,
            title: myLocations[i][0]
        });google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
                infoPopupWindow.setContent(infoPopupWindowContent[i][0]);
                infoPopupWindow.open(gmap, marker);
            }
        })(marker, i));
        gmap.fitBounds(bounds);
    }
    var boundsListener = google.maps.event.addListener((gmap), '', function(event) {
        this.setZoom(12);
        google.maps.event.removeListener(boundsListener);
    });
 }
