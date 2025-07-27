<!DOCTYPE html>
<html>
<head><title>Delete Student</title></head>
<body>
    <h2>Delete Student</h2>
      <form action="student" method="post">
        <input type="hidden" name="action" value="delete">
        
        Id: <input type="text" name="sid"><br><br>
      Name: <input type="text" name="dname"><br><br>
        <input type="submit" value="Delete">
    </form>   
    <br>
        <a href="add.jsp">Add Students</a>
    <br><a href="student">View All Student</a>
</body>
</html>
