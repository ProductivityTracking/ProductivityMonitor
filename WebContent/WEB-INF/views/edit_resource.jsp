<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Resource</title>
    <style>
    
    </style>
</head>
<body>
    <h1>Edit Resource</h1>

    <%-- Retrieve the user ID parameter from the URL --%>
    <% 
    String userID = request.getParameter("user_id");
    
    try {
        // JDBC code to fetch user information from the database based on the user ID
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sainath2@");
        Statement stmt = con.createStatement();
        
        // Construct the SQL query to retrieve user details
        String sqlQuery = "SELECT * FROM tarak_users WHERE user_empl_id = '" + userID + "'";
        
        ResultSet rs = stmt.executeQuery(sqlQuery);
        
        if (rs.next()) {
            // Retrieve user details from the result set
            String displayName = rs.getString("user_displayname");
            String employeeID = rs.getString("user_empl_id");
            String role = rs.getString("user_role");
            
            // Display a form to edit user details
    %>
            <form action="update_resource" method="post">
                <input type="hidden" name="userID" value="<%= userID %>">
                <label for="displayName">Display Name:</label>
                <input type="text" name="displayName" value="<%= displayName %>"><br><br>
                
                <label for="employeeID">Employee ID:</label>
                <input type="text" name="employeeID" value="<%= employeeID %>"><br><br>
                
                <label for="role">Role:</label>
                <input type="text" name="role" value="<%= role %>"><br><br>
                
                <input type="submit" value="Update">
            </form>
    <% 
        } else {
            // Display a message if user details are not found
            out.println("User details not found.");
        }
        
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>