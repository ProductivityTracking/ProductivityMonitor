<%@ page import="java.sql.*,com.pennant.prodmtr.model.Entity.Sprint,java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sprints</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        .sprint-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 30px;
        }

        .sprint-card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin: 10px;
            width: 250px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
            background-color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .sprint-card:hover {
            background-color: #f2f2f2;
        }

        .sprint-card h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .sprint-card p {
            margin: 5px 0;
        }

        .sprint-card.active {
            border-color: #00cc66;
        }

        .sprint-card.completed {
            border-color: #ff3300;
        }

        .add-sprint-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Sprints</h1>
<% List<Sprint> allSprints = (List<Sprint>) request.getAttribute("allSprints"); %>

<div class="sprint-container">
   <% //sprint.isActive()%>
    <% for (Sprint sprint : allSprints) { %>
        <div class="sprint-card <%= true ? "active" : "completed" %>"
             onclick="window.location.href='sprint_details?sprintId=<%= sprint.getSprintId() %>'">
            <h2>Sprint <%= sprint.getSprintId() %></h2>
            <p><strong>End Date:</strong> <%= sprint.getEndDate() %></p>
            <p><strong>Status:</strong> <%= sprint.getSprintStatus() %></p>
        </div>
    <% } %>
</div>


    <a class="add-sprint-link" href="add_sprint">Add Sprint</a>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>