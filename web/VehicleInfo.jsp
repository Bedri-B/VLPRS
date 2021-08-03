<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/main.css" />
        <title>Vehicle Info</title>
    </head>

    <body>
    <center class="flex">
        <div class=" c-white radius  w-25 ">
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
                <h1 style="color:white">
                    <icons>chevron_left</icons>
                </h1>
                </br>
                <center class="">
                    <div class="w-70 ">
                        <div class="d-black radius padding">
                            <icons>local_taxi</icons>
                            <div class="border padding radius w-25" style="background-color: #000;">${vehicle.plateno}</div>

                            </br>
                            <div class="w-f  t-left">
                                <div class="padding radius black-card w-f mrit">
                                    <table class="w-100">
                                        <td class="white c-black">Properties</td>
                                        <td class="white c-black">Values</td>
                                        <tr><td>Plate Number </td><td>${vehicle.plateno}</td></tr>
                                        <tr><td>Chasis Number </td><td>${vehicle.chasisno}</td></tr>
                                        <tr><td>Motor Number </td><td>${vehicle.motorno}</td></tr>
                                        <tr><td>Owner ID </td><td>${vehicle.ownerid}</td></tr>
                                        <tr><td>Brand </td><td>${vehicle.brand}</td></tr>
                                        <tr><td>Model </td><td>${vehicle.model}</td></tr>
                                        <tr><td>Production Year </td><td>${vehicle.prodyear}</td></tr>
                                        <tr><td>Seats Number </td><td>${vehicle.seatsno}</td></tr>
                                        <tr><td>Fuel Type </td><td>${vehicle.fueltype}</td></tr>
                                        <tr><td>Motor Size </td><td>${vehicle.motorsize}</td></tr>
                                        <tr><td>Horse Power </td><td>${vehicle.horsepower}</td></tr>
                                        <tr><td>Inspection Year </td><td>${vehicle.inspectionyear}</td></tr>
                                        <tr><td>Region </td><td>${vehicle.region}</td></tr>
                                        <tr><td>City </td><td>${vehicle.city}</td></tr>
                                        <tr><td>Code </td><td>${vehicle.code}</td></tr>

                                    </table>
                                    <center><a href="DeleteVehicle?chasisno=${vehicle.chasisno}"><button>DELETE VEHICLE INFO</button></a></center>
                                </div><br>
                            </div>
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