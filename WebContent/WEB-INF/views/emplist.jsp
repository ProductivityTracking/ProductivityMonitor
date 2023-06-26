<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Project List</title>
    <style>
        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center; /* Center horizontally */
            align-items: center; /* Center vertically */
            max-width: 600px; /* Adjust the container width as needed */
            margin: 0 auto;
        }

        .card {
            width: 150px; /* Adjust the card size as needed */
            height: 150px; /* Make the cards square */
            margin: 10px;
            padding: 10px;
            background-color: #f8f9fa;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            cursor: pointer;
            transition: transform 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card-header {
            background-color: #e9ecef;
            padding: 5px 10px;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            margin-bottom: 10px;
            border-radius:10%;
        }

        .card-content {
            margin-bottom: 10px;
            border-radius:50%;
        }

        .card-content p {
            margin: 0;
        }

        .add-new-card {
            background-color: #a9a9a9; /* Adjust the color as needed */
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 30px;
        }

        .add-new-card:hover {
            background-color: #808080; /* Adjust the color as needed */
        }
        span{
            color: black;
            }
    </style>
</head>
<body>
    <h1>Project List</h1>

    <div class="card-container">
        <div class="card clickable-card add-new-card" onclick="createproject">
            <div class="card-header">
                <span>&#43;</span>
            </div>
        </div>
        <c:forEach items="${projectDto}" var="project">
            <div class="card clickable-card" onclick="projectDetails?projectId=${project.projectId}">
                <div class="card-header">
                    Project ID: ${project.projectId}
                </div>
                <div class="card-content">
                    <p>Project Name: ${project.projectName}</p>
                </div>
            </div>
        </c:forEach>
    </div>

    <script>
        const cards = document.querySelectorAll('.clickable-card');
        cards.forEach(card => {
            card.addEventListener('click', () => {
                window.location.href = card.getAttribute('onclick');
            });
        });
    </script>
</body>
</html>