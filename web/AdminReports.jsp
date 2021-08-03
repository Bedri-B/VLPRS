<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/main.css" />
        <title>Reports</title>
    </head>

    <body>
    <center class="flex">
        <div class=" c-white radius  w-25 ">
            <img src="png.png" height="100" />
            </br>

            <div class="w-f t-left">
                <a href="AdminLoginPage">
                    <div class="w-f padding btnn flex" style="color:white">
                        <icons class="mrit bb">vpn_key</icons><b>Manage Users</b></div>
                </a>
                <a href="FindVehiclePage">
                    <div class="w-f padding btnn  flex" style="color:white">
                        <icons class="mrit bb">time_to_leave</icons>
                        <b>Find Vehicle</b></div>
                </a>
                <a href="AdminReportPage">
                    <div class="w-f padding btnn mrit flex active" style="color:white">
                        <icons class="mrit bb">turned_in</icons><b>Report</b></div>
                </a>
                <a href="AdminAbout.jsp">
                    <div class="w-f padding btnn flex " style="color:white">
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
                <div class="padding">
                    <h1 style="color:white">Report</h1>
                    <p>reports sent from users</p>
                </div>

                <div class=" padding">
                    <c:forEach items="${reports}" var="report">
                        <a href="AdminReportDetail?ID=${report.reportid}">
                        <div class="padding radius black-card w-f mrit bb brit">
                            <icons class="c-yellow">account_circle</icons>

                            <p><b>${report.fullname}</b></p>
                            <p>${report.title}</p>
                        </div>
                        </a>
                        <br>
                    </c:forEach>
                </div>
            </div>
            <center class="">

            </center>
        </div>
    </center>
</body>

</html>