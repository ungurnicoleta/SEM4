<%@ page import="com.axtrm.jsp3.model.Users" %>
<%@ page import="com.axtrm.jsp3.model.Astronauts" %>
<%@ page import="com.axtrm.jsp3.model.Planets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account</title>
    <style>
        img:hover {
            opacity: 0.5;
        }

        .popup-overlay.active{
            visibility:visible;
        }

        .popup-content.active {
            visibility:visible;
        }

        .popup-overlay {
            visibility:hidden;
        }

        .popup-content {
            visibility:hidden;
        }

    </style>
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/ajax-utils.js"></script>
</head>
<body>
<%! Astronauts astronaut; %>
<%  astronaut = (Astronauts) session.getAttribute("user");
     if (astronaut != null)
        out.println("Welcome!");
%>
<%!    Planets planet1, planet2, planet3; %>

<%
    planet1 = (Planets) session.getAttribute("planet1");
    planet2 = (Planets) session.getAttribute("planet2");
    planet3 = (Planets) session.getAttribute("planet3");

    out.println(planet1.getColor());
%>

<br/>
<figure id="p1"
        style="
           display: block;
      width: 200px;
      height: 200px;
      margin: 30px auto 0;
      background-color: red;
      border-radius: 50%;
        "></figure>

<figure id="p2"
        style="
      width: 200px;
      height: 200px;
      margin: 30px auto 0;
      background-color: blue;
      border-radius: 50%;
      display: flow;
      justify-content: flex-end;
"></figure>
<figure id="p3"  style="
      display: block;
      width: 200px;
      height: 200px;
      margin: 30px auto 0;
      background-color: yellow;
      border-radius:50%;
        "></figure>

<button>Generate new</button>


<div id="dialog" title="Dialog Title">
    <p>Name: Planet1
    Description: The Red Planet</p>
</div>

<!--Creates the popup body-->
<div class="popup-overlay">
    <!--Creates the popup content-->
    <div class="popup-content">
        <h2>Pop-Up</h2>
        <p> This is an example pop-up that you can make using jQuery.</p>
        <!--popup's close button-->
        <button class="close">Close</button>
    </div>
</div>

<h2>jQuery Pop-Up Example</h2>
<button class="open">Open</button>

<script>
    // $(document).ready(function() {
    //     $("#p1").click(function(e) {
    //         e.preventDefault();
    //         $.ajax({
    //             type: "GET",
    //             url: "ProfileController",
    //             data:{action: 'getDetails', id: '1'},
    //             success:function (data) {
    //                 window.location.reload();
    //             }
    //         });
    //     });
    // });


    $(document).ready(function () {
        $("#p1").click(function () {
            $("#dialog").dialog({
                modal: true,
                height: 590,
                width: 1005,
                autoOpen: true
            });
        });
    });
    $(document).ready(function(){
        var noMore = 0;
        if(noMore !== 3)
            $("button").click(function(){
                $("#p3").css("background-color", "yellow");
                $("#p1").css("background-color", "pink");
                $("#p2").css("background-color", "black");
                noMore = 3;
            });
        else
            alert("No more planets");
    });
</script>

</body>
</html>