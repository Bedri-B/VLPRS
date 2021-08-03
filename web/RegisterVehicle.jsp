<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/main.css" />
        <title>Register Vehicle</title>
    </head>

    <body>
    <center class="flex">
        <div class=" c-white radius  w-25 ">
            <img src="png.png" height="100" />
            </br>

            <div class="w-f t-left">
                <a href="RegisterVehiclePage">
                    <div class="w-f padding btnn flex active" style="color:white">
                        <icons class="mrit bb">vpn_key</icons><b>Add Vehicle</b></div>
                </a>
                <a href="ManageVehicles">
                    <div class="w-f padding btnn  flex " style="color:white">
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
                <h1 style="color:white">Manage Users</h1>
                </br>
                <center class="">
                    <div class="w-70 ">
                        <form method="post" action="RegisterVehicle">
                            <div class="d-black radius padding ${msg}">
                                <h1>Enter Vehicle Information</h1>
                                <div class="w-f flex">
                                    <div class="w-50 ">
                                        <input  required type="text" class="w-f dark-input" name="chasisno" placeholder="Chasis Number" />
                                        <input  required type="number" class="w-f dark-input" name="motorno" placeholder="Moter Number" />
                                        <input  required type="text" class="w-f dark-input" name="brand" placeholder="Brand" />
                                        <input  required type="date" class="w-f dark-input" name="prodyear" placeholder="Production year" />
                                        <input  required type="text" class="w-f dark-input" name="model" placeholder="Model" />
                                        <select name="region" class="w-f padding dark-input">
                                            <c:forEach items="${regions}" var="region">
                                                <option value="${region}">${region}</option>
                                            </c:forEach>
                                        </select>
                                        <select name="code" class="w-f padding dark-input">
                                            <option value="2">Select Code(Default 2)</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                    <div class="w-50">
                                        <input  required type="number" class="dark-input w-f" name="seatsno" placeholder="Seats" />

                                        <input  required type="date" class="dark-input w-f" name="inspectionyear" placeholder="Inspection year" />
                                        <select name="fueltype" class="w-f padding dark-input">

                                            <option value="Diesel">SELECT FUEL TYPE(Default Diesel)</option>
                                            <option value="Diesel">Diesel</option>
                                            <option value="Benzene">Benzene</option>
                                            <option value="Kerosene">Kerosene</option>

                                        </select>

                                        <input  required type="number" class="dark-input w-f" name="horsepower" placeholder="Horse Power" />
                                        <input  required type="number" class="dark-input w-f" name="motorsize" placeholder="Motor size" />
                                        <input  required type="text" class="dark-input w-f" name="city" placeholder="City" />

                                    </div>
                                </div>

                            </div>
                            </br>
                            <div class="w-50">
                                <button type="submit">ADD VEHICLE</button>
                                <a href="#"><button>RESET</button></a>
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