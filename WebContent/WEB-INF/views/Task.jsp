<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.pennant.prodmtr.model.view.FunctionalTask" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.pennant.prodmtr.model.Entity.User" %>
<!DOCTYPE html>
<html>
<head>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <title>Task Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            box-sizing: border-box;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="datetime-local"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        textarea {
            height: 100px;
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        @media (max-width: 600px) {
            .container {
                max-width: 100%;
                padding: 10px;
            }
        }
    </style>
</head>
<body>



    <div class="container">
        <h2>Task Form</h2>
        <form action="TaskAdded" method="post">
            <% FunctionalTask ft = (FunctionalTask) request.getAttribute("funtask"); %>
            <input type="hidden" id="moduleId" name="moduleId" value="<%= ft != null ? ft.getModlId() : "" %>">
            <input type="hidden" id="taskDescription" name="taskDescription" value="<%= ft != null ? ft.getDesc() : "" %>">
            <input type="hidden" id="projectId" name="projectId" value="<%= ft != null ? ft.getProjId() : "" %>">
            
            
             
            <label for="taskName">Task Name:</label>
            <input type="text" id="taskName" name="taskName" required>

            <label for="taskCreationDateTime">Creation Date and Time:</label>
            <input type="datetime-local" id="taskCreationDateTime" name="taskCreationDateTime" required>

            <label for="taskCategory">task Category :</label>
            <input type="text" id="taskCategory" name="taskCategory" required>
            
            
              <label for="taskType">Task Type:</label>
<select id="taskType" name="taskType" required>
 <option disabled selected hidden>TaskType</option>
  <option value="IND">INDV</option>
  <option value="SPR">SPRN</option>
</select>


                     <label for="taskCreator">Task Creater:</label>
                    <select class="form-control" id="taskCreator" name="taskCreator" >
                    <option disabled selected hidden>taskCreator</option>
                    <c:forEach items="${users}" var="user">
                        <option value="${user.getUserId()}">${user.getUserDisplayName()}</option>
                    </c:forEach>
                </select>
                   
                   <label for="taskType">Reference Task</label>  
                <select class="form-control" id="referencedTaskId" name="referencedTaskId" >
                    <option disabled selected hidden>Referenced Task</option>
                    <c:forEach items="${tasks}" var="task">
                        <option value="${task.getTaskId()}">${task.getTaskName()}</option>
                    </c:forEach>
                </select>
           
            

            <label for="numberOfHoursRequired">Number of Hours Required:</label>
            <input type="number" id="numberOfHoursRequired" name="numberOfHoursRequired" required>

            <label for="taskExpectedDateTime">Expected Completion Date and Time:</label>
            <input type="datetime-local" id="taskExpectedDateTime" name="taskExpectedDateTime">

           
                <label for="taskSupervisor">Task Supervisor:</label>
                <select class="form-control" id="taskSupervisorId" name="taskSupervisorId" >
                    <option disabled selected hidden>Task Supervisor:</option>
                    <c:forEach items="${users}" var="user">
                        <option value="${user.getUserId()}">${user.getUserDisplayName()}</option>
                    </c:forEach>
                </select>
        
           
            <input type="hidden" id="taskStatus" name="taskStatus" value="InProgress">
             
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>