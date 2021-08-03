<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/main.css" />
        <title>Dashboard</title>
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
                <a href="AdminAbout.jsp">
                    <div class="w-f padding btnn flex" style="color:white">
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
                <div style="position: absolute;right: 0;" class="padding"><b class="padding">Hello Admin</b><a href="Logout" ><button style="color:black" class="white">LOGOUT</button></a></div>
            </div>
            <div class="mtop t-left padding">

                ${msgX}

                <h1 style="color:white">Manage Users</h1>
                </br>
                <center class="">
                    <div class="w-50">
                        <table class="w-f">
                            <tr>
                                <td>Email</td>
                                <td>Status</td>
                                <td>ACTION</td>
                            </tr>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <th>${user.email}</th>
                                    <th>active</th>
                                    <th >
                                        <a href="DeleteUser?userid=${user.userid}"> <button class="mrit  blue-b">DELETE</button></a>
                                    </th>
                                </tr>
                            </c:forEach>
                        </table>
                        </br>
                    </div>
                </center>
            </div>

            <div class="mtop t-left padding">
                <h1 style="color:white">Manage Vehicles</h1>
                </br>
                <center class="">
                    <div class="w-f">
                        <table class="w-f">
                            <tr>
                                <td>Chasis Number</td>
                                <td>Owner</td>
                                <td class="w-20">Brand</td>
                                <td >Model</td>
                                <td class="w-20">License Plate</td>
                                <td>ACTION</td>
                            </tr>
                            <c:forEach items="${vehicles}" var="vehicle">
                                <tr>
                                    <th>${vehicle.chasisno}</th>
                                    <th>${vehicle.ownerid}</th>
                                    <th>${vehicle.brand}</th>
                                    <th class="w-20">${vehicle.model}</th>
                                    <th>${vehicle.plateno}</th>
                                    <th class="flex">
                                        <c:choose>
                                            <c:when test="${vehicle.plateno == 'Pending'}">
                                                <a href="ApprovePlate?chasisno=${vehicle.chasisno}" class="mrit"> <button class="mrit radius-lil">Approve</button></a>
                                            </c:when>
                                            <c:otherwise>
                                               <button class="mrit radius-lil" disabled>Approve</button>
                                            </c:otherwise>
                                        </c:choose>
                                        <a href="EditVehicleInfoPage?chasisno=${vehicle.chasisno}" class="mrit"> <button class="mrit  blue-b">Edit</button></a>

                                        <a href="DeleteVehicle?chasisno=${vehicle.chasisno}"> <button class="mrit  blue-b">Delete</button></a>
                                    </th>
                                </tr>
                            </c:forEach>

                        </table>
                        </br>
                        <div class="w-50">
                            <a href="FindVehiclePage" ><button>Find Vehicle</button></a>
                        </div>
                    </div>
                </center>
            </div>
            <center class="">

            </center>
        </div>
    </center>
</body>

</html>