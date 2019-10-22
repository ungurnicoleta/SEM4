<%@ page import="mvcIntellijIdea.model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account</title>
    <style>
        #userProfile-table {
            border-collapse: collapse;
            width: 20%;
        }
        #userProfile-table, #userProfile-table th, #userProfile-table td {
            border: 1px solid black;
        }
        th {
            height: 40px;
        }
        th, td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
         #userProfile-img {
            float: right;
            position: relative;
            left: -20px;
            top: -120px;
        }
        img:hover {
            opacity: 0.5;
        }
    </style>
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/ajax-utils.js"></script>
</head>
<body>
<%! Users user; %>
<%  user = (Users) session.getAttribute("user");
     if (user != null)
        out.println("Welcome " + user.getUsername());
%>

<br/>
<label>Date</label>
<input type="text" id="date">

<label>Title</label>
<input type="text" id="title">

<label>Description</label>
<input type="text" id="description">

<label>URL</label>
<input type="text" id="url">

<button type="button" id ="add-content-btn">Add</button>
<section><table id="all-content-table"></table></section>
<button type="button" id ="recent-content-btn">Recent Content</button>
<section><table id="recent-content-table"></table></section>

<section id="add-section">
    <button type="button" id ="new-content-btn">New Content</button>
</section>
<button type="button" id ="submit-btn">Submit</button>

<script>
    $(document).ready(function() {
        var cnt = 0;
        $("#new-content-btn").click(function() {
            $("#all-content-table").append("<br><label>Title</label>\n" +
                "<input type=\"text\" id='title" + cnt + "'>\n" +
                "\n" +
                "<label>Description</label>\n" +
                "<input type=\"text\" id='description" + cnt + "'>\n" +
                "\n" +
                "<label>URL</label>\n" +
                "<input type=\"text\" id='url"+ cnt + "'>");
            cnt = cnt+1;
        });

        $("#submit-btn").click(function() {
            console.log(cnt);
            for(i=0; i<cnt; i++) {
                var title = $("#title" + i).val();
                var description = $("#description" + i).val();
                var url = $("#url" + i).val();
                $.ajax({
                    url : "ProfileController",
                    method: "POST",
                    data:{action: 'addContent', date: '2019-06-14', title: title, description: description, url: url},
                    success:function (data) {
                        window.location.reload();
                    }
                });
            }
            cnt = 0;
        });

        $("#add-content-btn").click(function() {
            var date = $("#date").val();
            var title = $("#title").val();
            var description = $("#description").val();
            var url = $("#url").val();
            console.log(title);
            $.ajax({
                url : "ProfileController",
                method: "POST",
                data:{action: 'addContent', date: date, title: title, description: description, url: url},
                success:function (data) {
                    window.location.reload();
                }
            });
        });

        $("#recent-content-btn").click(function() {
            $.ajax({
                url : "ProfileController",
                method: "GET",
                data:{action: 'recentContent'},
                success:function (data) {
                    console.log(data);
                    $("#recent-content-table").html(data);
                    $("#tr0").hide();
                    $("#tr1").hide();
                    $("#tr2").hide();
                    $("#tr3").hide();

                    setTimeout(function(){ $("#tr0").show(); }, 2000);
                    setTimeout(function(){ $("#tr1").show(); }, 4000);
                    setTimeout(function(){ $("#tr2").show(); }, 6000);
                    setTimeout(function(){ $("#tr3").show(); }, 8000);

                    setTimeout(function(){ $.ajax({
                        url : "ProfileController",
                        method: "GET",
                        data:{action: 'get'},
                        success:function (data) {
                            var y = document.getElementById("all-content-table").rows.length - 1;
                            console.log(y);
                            console.log(data);
                            if(y != data) {
                                alert("New content was added!");
                                setTimeout(function () {
                                    window.location.reload();
                                }, 1000);
                            }
                        }
                    }); }, 2000);
                }
            });
        });

            getAllProfiles(function (profiles) {
                $("#all-content-table").html("");
                $("#all-content-table").append("<tr style='background-color: mediumseagreen'><td>ID</td><td>Date</td>" +
                    "<td>Title</td><td>Description</td><td>URL</td><td>UserID</td><td>Delete</td></tr>");
                for(var p in profiles)
                    $("#all-content-table").append("<tr><td>" + profiles[p].id + "</td>" +
                        "<td>" + profiles[p].date + "</td>" +
                        "<td>" + profiles[p].title + "</td>" +
                        "<td>" + profiles[p].description + "</td>" +
                        "<td>" + profiles[p].url + "</td>" +
                        "<td>" + profiles[p].userid + "</td>" +
                        "<td><button class='delete' id='" + profiles[p].id + "'>Delete</button></td></tr>");
            });

        $(document).on('click', '.delete', function () {
            var id = $(this).attr("id");
            $.ajax({
                url : "ProfileController",
                method: "GET",
                data:{action: 'delete', id: id},
                success:function (data) {
                    window.location.reload();
                }
            });
        });

    });
</script>
</body>
</html>