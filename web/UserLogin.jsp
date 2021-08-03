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
        <div class="mtop c-white radius padding w-30 ">
            <img src="png.png" height="150" />
            </br>
            <!-- <h1 style="color:white">VEHICLE REGISTRATION</h1> -->

            <p style="color:white" class=" thin">This is the description of vehicle registration system this is temporary This is the description of vehicle registration system this is temporary This is the description of vehicle registration system this is temporary This is the description
                of vehicle registration system this is temporary</p>
            <div class="mtop flex justify w-f m-rit">
                <div class="text-c mrit" style="text-align:center;margin-right:10% !important">
                    <div class="radius-c white padding avatar"><b>f</b></div>

                </div>
                <div class="text-c " style="text-align:center">
                    <div class="radius-c white padding avatar"><b>t</b></div>

                </div>
            </div>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>
            </br>


        </div>
        <div class="w-80 white ">
            <center class="">
                ${msgX}
                <div class="white padding radius shadow w-30 mtop" style="margin-top:17%">
                    <h1 class="mtop">USER LOGIN</h1>
                    <form method="post" action="Login">
                        ${msg}
                        <input required class="w-f mtop" type="text" name="email" placeholder="email" />
                        <input required class="w-f" type="password" name="password" placeholder="password" />
                        <button type="submit" class="w-80 mtop" style="color:rgb(25, 80, 71);border-color:rgb(25, 80, 71)">LOGIN</button>
                    </form>
                </div>
            </center>
        </div>
    </center>
</body>

</html>