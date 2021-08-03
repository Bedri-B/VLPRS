<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/main.css" />
    <title>User Report</title>
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
                    <div class="w-f padding btnn  flex " style="color:white">
                        <icons class="mrit bb">time_to_leave</icons>
                        <b>Manage Vehicles</b></div>
                </a>
                <a href="UserReportPage">
                    <div class="w-f padding btnn mrit flex active" style="color:white">
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
                <h1 style="color:white">Send Report(Feedback) to The Admin</h1>
                </br>
                <center class="">
                    <div class="w-70 ">
                        <form method="post" action="UserReport">
                            <div class="black-card radius padding">
                                <form method="POST" action="UserReport">
                                    <input type="text" class="w-f dark-input" name="header" placeholder="title" />
                                    <textarea rows="10" class="radius w-f padding dark-input" name="description" placeholder="Description"></textarea>
                                    <button>SUBMIT</button>
                                </form>
                            </div>
                        </form>
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