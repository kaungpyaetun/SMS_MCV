<%@ page import="java.util.*, model.Std" %>
<!DOCTYPE html>
<html>
<head><title>Student List</title></head>
<body>
    <h2>Students List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Course</th><th>Objective</th></tr>
        <%
            List<Std> list = (List<Std>) request.getAttribute("students");
            for (Std s : list) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getCourse() %></td>
            <td><%= s.getObjective() %></td>
        </tr>
        <% } %>
    </table>
    <br><a href="add.jsp">Add Student</a>
    <br><a href="delete.jsp">Delete Student</a>    
</body>
</html>
