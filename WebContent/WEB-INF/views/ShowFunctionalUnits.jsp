<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pennant.prodmtr.model.Dto.FunctionalUnitdto" %>
<%@ page import="com.pennant.prodmtr.model.Entity.FunctionalUnitId" %>
<%@ page import="com.pennant.prodmtr.model.Entity.FunctionalUnit" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Module" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .clickable-row:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }

        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>

   <script ">
    function createTask() {
        var modl_Id = $(this).find('.modl-id').text();
        var func_Id = $(this).find('.func-id').text();
        var desc = $(this).find('.funit-desc').text();
        var data = {
            modlId: modl_Id,
            funcId: func_Id,
            desc: desc,
            projId: '${pro_id}'
        };

        console.log(JSON.stringify(data));
        // Send the data using AJAX
        $.ajax({
            url: 'Task',
            type: 'POST',
            data: data,
            success: function(response) {
            	document.getElementById("bd").innerHTML = response;
            },
            error: function(error) {
                window.alert("Error");
                console.error('Error sending data:', error);
            }
        });
    }

    </script>
</head>
<body id="bd">
    <form action="sprints">
        <table>
            <tr>
                <th>Functional Unit id</th>
                <th>Module id</th>
                <th>Functional Description</th>
            </tr>
            <% 
            ArrayList<FunctionalUnitdto> funlist = (ArrayList<FunctionalUnitdto>) request.getAttribute("funlist");
            for (FunctionalUnitdto functionalUnit : funlist) {
                int modl_id = functionalUnit.getModl_id();
                int func_id = functionalUnit.getFunt_id();
                String desc = functionalUnit.getFunit_desc();
            %>
            <tr class="clickable-row" onclick="createTask.call(this)">
                <td class="modl-id"><%= modl_id %></td>
                <td class="func-id"><%= func_id %></td>
                <td class="funit-desc"><%= desc %></td>
            </tr>
            <% 
            }
            %>
        </table>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
