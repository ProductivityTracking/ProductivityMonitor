<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sprint List</title>
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
        tr:hover {
            background-color: #f5f5f5;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Sprint List</h1>

    <table>
        <thead>
            <tr>
                <th>Sprint ID</th>
                <th>Sprint</th>
            </tr>
        </thead>
        <tbody>
            <% 
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            String url = "jdbc:postgresql://localhost:5432/postgres"; // Replace with your PostgreSQL connection URL
            String user = "postgres"; // Replace with your PostgreSQL username
            String password = "Sainath2@"; // Replace with your PostgreSQL password

            try {
                // Establish database connection
                conn = DriverManager.getConnection(url, user, password);

                // Prepare the SQL statement
                String sprintQuery = "SELECT sprint_id, sprint_name FROM s4_sprint"; // Replace with your actual table name and column names
                pstmt = conn.prepareStatement(sprintQuery);

                // Execute the query
                rs = pstmt.executeQuery();

                // Iterate through the result set and generate table rows
                while (rs.next()) {
                    String sprintId = rs.getString("sprint_id");
                    String sprintName = rs.getString("sprint_name");
            %>
            <tr class="clickable-row" onclick="location.href='sprint_details';">
                <td><%= sprintId %></td>
                <td><%= sprintName %></td>
            </tr>
            <%
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close database resources
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            %>
        </tbody>
    </table>

   
   
</body>
</html>
