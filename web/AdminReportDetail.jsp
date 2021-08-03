<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/main.css" />
    <title>Report Details</title>
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


                <div class=" padding">
                    <div>
                        <icons style="color:white">chevron_left</icons>
                    </div>
                    </br>
                    <div class="padding radius black-card w-f mrit bb ">
                        <div class="flex radius-c white w-20">
                            <icons class="c-blue mrit">account_circle</icons>

                            <p><b style="color:black !important">${report.fullname}</b></p>
                        </div>
                        </br>
                        <h1>${report.title}</h1>
                         <p style="overflow-wrap: break-word;">${report.date}</p><br>
                        <p style="overflow-wrap: break-word;">${report.content}</p>
                    </div>


                </div>
            </div>
            <center class="">

            </center>
        </div>
    </center>
</body>

</html>