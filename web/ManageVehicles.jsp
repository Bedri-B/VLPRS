<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/main.css" />
        <title>Manage Vehicles</title>
    </head>

    <body>
    <center class="flex">
        <div class=" c-white radius  w-25 nav ">
            <img src="png.png" height="100" />
            </br>

            <div class="w-f t-left">
                <a href="RegisterVehiclePage">
                    <div class="w-f padding btnn flex " style="color:white">
                        <icons class="mrit bb">vpn_key</icons><b>Add Vehicle</b></div>
                </a>
                <a href="ManageVehicles">
                    <div class="w-f padding btnn  flex active" style="color:white">
                        <icons class="mrit bb">time_to_leave</icons>
                        <b>Manage Vehicles</b></div>
                </a>
                <a href="UserReportPage">
                    <div class="w-f padding btnn mrit flex" style="color:white">
                        <icons class="mrit bb">turned_in</icons><b>Report</b></div>
                </a>
                <a href="Index">
                    <div class="w-f padding btnn flex " style="color:white">
                        <icons class="mrit bb">account_circle</icons><b>Profile</b></div>
                </a>
            </div>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>


        </div>
        <div class="w-80 green ">
            <div class="w-f p-rel">
                <div style="position: absolute;right: 0;" class="padding"><b class="padding">Hello ${user.info.firstname}</b><a href="Logout" ><button class="white" style="color:black">LOGOUT</button></a></div>
            </div>
            <div class="mtop t-left padding">
                <h1 style="color:white">Manage Vehicle</h1>
                </br>
                <center class="">
                    <div class="w-70 ">
                        <div class="d-black radius padding">
                            <icons>local_taxi</icons>
                            <h1>Choose Your Vehicle</h1>
                            <p>choose your vehicles owned by your own account</p>
                            </br>
                            <div class="w-f  t-left">
                                <c:forEach items="${vehicles}" var="vehicle">
                                    <div class="padding radius black-card w-f mrit">

                                        <div class="flex">
                                            <div class="border padding radius">${vehicle.plateno}</div>
                                        </div>
                                        <h1 class="w-50">${vehicle.brand} ${vehicle.model}</h1><br>
                                        <p>Production: ${vehicle.prodyear} </p>
                                        <p>Seats: ${vehicle.seatsno}</p>
                                        <p>Fuel: ${vehicle.fueltype}</p><br>
                                        <a href="VehicleInfo?chasisno=${vehicle.chasisno}"><button>SHOW MORE -></button></a>
                                    </div><br>

                                </c:forEach>
                            </div>
                            </br>

                        </div>
                </center>
            </div>
            <center class="">

            </center>
        </div>
    </center>
</body>

</html>