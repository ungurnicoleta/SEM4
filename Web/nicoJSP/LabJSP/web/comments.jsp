<%@ page import="webubb.model.Comment" %>
<%@ page import="webubb.model.User" %>
<%@ page import="webubb.model.Topic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForestForum - View Topic</title>
        <style>
            .topic-name {
                background-color: pink;
                color: black;
                border-right: solid 1px black;
            }
        </style>
        <script src="js/jquery-2.2.3.js"></script>
        <script src="js/ajax-utils.js"></script>
    </head>
    <body>
        <%! User user; %>
        <%! Topic currentTopic; %>
        <%  user = (User) session.getAttribute("user");
            currentTopic = (Topic) session.getAttribute("selectedTopic");
            if (user != null) {
                //out.println("Welcome, "+user.getUsername() + "!");
        %>

        <section>
            <h2><%= currentTopic.getName()%> </h2>
            <h3><%= currentTopic.getDescription()%></h3>
        </section>


        <section><table id="comments-table"></table></section>
        <p style="height: 50px;"></p>


        <p style="height: 50px;"></p>
        <section id="new-comment-section">
            <span style="font-weight: bold; background-color: mediumseagreen">Comment!</span><br/>
            <table>
                <tr><td>Your comment: </td><td><input type="text" id="comment-text"></td></tr>
                <tr><td><button type="button" id="submit-comment-btn">Submit comment!</button></td><td></td></tr>
            </table>
        </section>


        <section id="submit-comment-result-section"></section>


        <p style="height: 50px;"></p>
        <section id="delete-comment-section">
            <span style="font-weight: bold; background-color: mediumseagreen">Delete one of your comments!</span><br/>
            <table>
                <tr><td>CommentID: </td><td><input type="text" id="comment-id"></td></tr>
                <tr><td><button type="button" id="delete-comment-btn">Delete comment!</button></td><td></td></tr>
            </table>
        </section>


        <section id="delete-comment-result-section"></section>


        <script>
            $(document).ready(function(){
                loadCommentsOfTopic(<%= currentTopic.getId() %>, function(comments) {
                    $("#comments-table").html("").append("<tr style='background-color: mediumseagreen'><td>Comment ID</td><td>Comment</td><td>Posted by user</td></tr>");
                    for(let c in comments) {
                        $("#comments-table").append("<tr><td>"+comments[c].id+"</td>" +
                            "<td>"+comments[c].text+"</td>" +
                            "<td>"+comments[c].author+"</td></tr>");
                    }
                });

                $("#submit-comment-btn").click(function() {
                    addComment(
                        '<%= currentTopic.getId() %>',
                        '<%= user.getUsername() %>',
                        $("#comment-text").val(),
                        function(response) {
                            $("#submit-comment-result-section").html(response);
                            $("#comment-text").val("");
                            loadCommentsOfTopic(<%= currentTopic.getId() %>, function(comments) {
                                $("#comments-table").html("").append("<tr style='background-color: mediumseagreen'><td>Comment ID</td><td>Comment</td><td>Posted by user</td></tr>");
                                for(let c in comments) {
                                    $("#comments-table").append("<tr><td>"+comments[c].id+"</td>" +
                                        "<td>"+comments[c].text+"</td>" +
                                        "<td>"+comments[c].author+"</td></tr>");
                                }
                            });
                        }
                    )
                });

                $("#delete-comment-btn").click(function() {
                    deleteComment(
                        '<%= user.getUsername() %>',
                        $("#comment-id").val(),
                        function(response) {
                            $("#delete-comment-result-section").html(response);
                            $("#comment-id").val("");
                            loadCommentsOfTopic(<%= currentTopic.getId() %>, function(comments) {
                                $("#comments-table").html("").append("<tr style='background-color: mediumseagreen'><td>Comment ID</td><td>Comment</td><td>Posted by user</td></tr>");
                                for(let c in comments) {
                                    $("#comments-table").append("<tr><td>"+comments[c].id+"</td>" +
                                        "<td>"+comments[c].text+"</td>" +
                                        "<td>"+comments[c].author+"</td></tr>");
                                }
                            });
                        }
                    )
                });
            });
        </script>
        <%
            }
        %>
    </body>
</html>
