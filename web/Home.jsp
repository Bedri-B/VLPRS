<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/main.css" />
    <title>VLPRS</title>
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
                    <div class="w-f padding btnn  flex " style="color:white">
                        <icons class="mrit bb">time_to_leave</icons>
                        <b>Manage Vehicles</b></div>
                </a>
                <a href="UserReportPage">
                    <div class="w-f padding btnn mrit flex" style="color:white">
                        <icons class="mrit bb">turned_in</icons><b>Report</b></div>
                </a>
                <a href="Index">
                    <div class="w-f padding btnn flex active" style="color:white">
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
                <div style="position: absolute;right: 0;" class="padding"><b class="padding">Hello ${user.info.firstname}</b><a href="Logout" ><button style="color:black" class="white">LOGOUT</button></a></div>
            </div>
            <div class="mtop t-left padding">

                ${msgX}

                <div class=" padding">
                    <div>
                        <icons style="color:white">chevron_left</icons>
                    </div>
                    </br>
                    <div class="padding radius black-card w-f mrit bb ">
                        <center>
                            <img src="png.png" height="150" />
                            </br>
                            <h1>VERSION 1.1.0</h1>
                            <p>Group Members</p>
                            </br>
                            <div>
                                <table>
                                    <tr>
                                        <td>NUMBER</td>
                                        <td>STUDENT NAME</td>
                                        <td>ID NUMBER</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Kayowak Melese</td>
                                        <td>RU3758/11</td>
                                    </tr>
                                </table>
                            </div>
                        </center>
                    </div>


                </div>
            </div>
            <center class="">

            </center>
        </div>
    </center>
</body>

</html>