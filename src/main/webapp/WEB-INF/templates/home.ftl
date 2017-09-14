<head>
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript">

    </script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

</head>

<body>
<div id="map" style="width: 600px; height: 400px"></div>

<h6>Описание:</h6>
<label>
    <input id="description" type="text">
</label>
<input type="date" id="date">
</body>

<script type="text/javascript">
    $(document).ready(function () {
        var myMap;
        var myPlacemark;
        ymaps.ready(function () {
            myMap = new ymaps.Map("map", {
                center: [55.76, 37.64],
                zoom: 7
            });

            $.ajax({
                url: "/home/trip/all",
                cache: false,
                success: function (trips) {

                    trips.forEach(function (t) {
                        myPlacemark = new ymaps.Placemark([t.latitude, t.longitude], {
                            hintContent: t.lastName + " " + t.firstName + " ," + t.age,
                            balloonContent: t.phone + ", " + t.description + ", "+ t.date
                        });
                        myMap.geoObjects.add(myPlacemark);
                    });


                    myMap.events.add('click', function (e) {
                        var coords = e.get('coords');
                        var description = document.getElementById('description').value;
                        var date = document.getElementById('date').value;
                        if (description !== "" && date !== "") {
                            $.ajax('/home/trip/new/', {
                                type: 'POST',
                                data: {
                                    latitude: coords[0],
                                    longitude: coords[1],
                                    description: description,
                                    date: date
                                },
                                success: function (t) {
                                    myPlacemark = new ymaps.Placemark([t.latitude, t.longitude], {
                                        hintContent: t.lastName + " " + t.firstName + " ," + t.age,
                                        balloonContent: t.phone + ", " + t.description + ", "+ t.date
                                    });
                                    myMap.geoObjects.add(myPlacemark);
                                }
                            });
                        } else {
                            alert("Type description and date!");
                        }
                        document.getElementById('date').value = "";
                        document.getElementById('description').value = "";
                    });
                }
            });
        });


    });

</script>

