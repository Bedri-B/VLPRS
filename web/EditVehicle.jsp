<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/main.css" />
        <title>Edit Vehicle</title>
    </head>

    <body>
    <center class="flex">
        <div class=" c-white radius  w-25 ">
            <img src="png.png" height="100" />
            </br>

            <div class="w-f t-left">
                <a href="AdminLoginPage">
                    <div class="w-f padding btnn flex active" style="color:white">
                        <icons class="mrit bb">vpn_key</icons><b>Manage Users</b></div>
                </a>
                <a href="FindVehiclePage">
                    <div class="w-f padding btnn  flex" style="color:white">
                        <icons class="mrit bb">time_to_leave</icons>
                        <b>Find Vehicle</b></div>
                </a>
                <a href="AdminReportPage">
                    <div class="w-f padding btnn mrit flex " style="color:white">
                        <icons class="mrit bb">turned_in</icons><b>Report</b></div>
                </a>
                <a href="About.jps">
                    <div class="w-f padding btnn flex active" style="color:white">
                        <icons class="mrit bb">account_circle</icons><b>About</b></div>
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
                <div style="position: absolute;right: 0;" class="padding"><b class="padding">Hello Admin</b><a href="Logout" ><button class="white" style="color:black">LOGOUT</button></a></div>
            </div>
            <div class="mtop t-left padding">
                <h1 style="color:white">Manage Users</h1>
                </br>
                <center class="">
                    <div class="w-70 ">
                        <form method="post" action="EditVehicleInfo">
                            <input type="hidden" name="prevchasisno" value="${vehicle.chasisno}">
                            <input type="hidden" name="prevownerid" value="${vehicle.ownerid}">
                            <div class="d-black radius padding ${msg}">
                                <h1>Update Vehicle Information</h1>
                                <div class="w-f flex">
                                    <div class="w-50 mrit">
                                        <input  required type="text" class="w-f dark-input" name="chasisno" value="${vehicle.chasisno}" placeholder="Chasis Number" />
                                        <input  required type="number" class="w-f dark-input" name="motorno" value="${vehicle.motorno}" placeholder="Moter Number" />
                                        <input  required type="text" class="w-f dark-input" name="brand" value="${vehicle.brand}" placeholder="Brand" />
                                        <input  required type="date" class="w-f dark-input" name="prodyear" value="${vehicle.prodyear}" placeholder="Production year" />
                                        <input  required type="text" class="w-f dark-input" name="model" value="${vehicle.model}" placeholder="Model" />
                                        <select name="region" class="w-f padding dark-input">
                                            <option value="${vehicle.region}">${vehicle.region}</option>
                                            <c:forEach items="${regions}" var="region">
                                                <option value="${region}">${region}</option>
                                            </c:forEach>
                                        </select>
                                        <select name="code" class="w-f padding dark-input">
                                            <option value="0">Select Code(Default 2)</option>
                                            <option value="${vehicle.code}">${vehicle.code}</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                    <div class="w-50">
                                        <input  required type="number" class="dark-input w-f" name="seatsno" value="${vehicle.seatsno}" placeholder="Seats" />

                                        <input  required type="date" class="dark-input w-f" name="inspectionyear" value="${vehicle.inspectionyear}" placeholder="Inspection year" />
                                        <select name="fueltype" class="w-f padding dark-input">

                                            <option value="${vehicle.fueltype}">${vehicle.fueltype}</option>
                                            <option value="Diesel">Diesel</option>
                                            <option value="Benzene">Benzene</option>
                                            <option value="Kerosene">Kerosene</option>

                                        </select>
                                        <input  required type="number" class="dark-input w-f" name="horsepower" value="${vehicle.horsepower}" placeholder="Horse Power" />
                                        <input  required type="number" class="dark-input w-f" name="motorsize" value="${vehicle.motorsize}" placeholder="Motor size" />
                                        <input  required type="text"  class="dark-input w-f" name="city" value="${vehicle.city}" placeholder="City" />
                                    </div>
                                </div>

                            </div>
                            </br>
                            <div class="w-50">
                                <button type="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </center>
            </div>
            <center class="">

            </center>
        </div>
    </center>
</body>

</html>