package dao_view;

import model.Std;
import java.sql.*;
import java.util.*;

public class StdDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/std";
    private final String jdbcUser = "root";
    private final String jdbcPass = "K@ung1997";

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
    }

    public void insertStudent(Std s) throws Exception {
        String sql = "INSERT INTO student(name, course, objective) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setString(3,s.getObjective());
            ps.executeUpdate();
        }
    }

    public void deleteStudent(Std s) throws Exception {
        String sql = "DELETE FROM student WHERE (id = ?) AND (name = ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

        	ps.setInt(1, s.getId());
        	ps.setString(2, s.getName());
            ps.executeUpdate();
        }
    }
    
    public List<Std> getAllStudents() throws Exception {
        List<Std> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Std(rs.getInt("id"), rs.getString("name"), rs.getString("course"), rs.getString("objective")));
            }
        }
        return list;
    }
    

//	public void updateStudent(Std std) {
//		// TODO Auto-generated method stub
//		
//	}
//////UPDATE `std`.`student` SET `objective` = 'aaaupdate' WHERE (`id` = '5');
///
    public void updateStudent(Std s) throws Exception {
        String sql = "UPDATE student(name, course, objective) SET (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setString(3,s.getObjective());
            ps.executeUpdate();
        }
    }
}
