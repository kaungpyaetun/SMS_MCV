//Edit and testing git and github

package controller;
import dao_view.StdDAO;
import model.Std;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class StdServlet extends HttpServlet {
    private StdDAO dao;

    public void init() {
        dao = new StdDAO();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String delele = req.getParameter("action");
        String update = req.getParameter("modified");
        

        if ("delete".equals(delele)) {
            try {
                int id = Integer.parseInt(req.getParameter("sid"));
             String name = req.getParameter("dname");
              dao.deleteStudent(new Std(id, name,"",""));
              res.sendRedirect("list");
            } catch (Exception e) {
                res.getWriter().println("Delete Error: " + e.getMessage());
            }
            return;                     
        }else if("update".equals(update)) {
            try {
                int id = Integer.parseInt(req.getParameter("sid"));
             String name = req.getParameter("dname");
			  // dao.deleteStudent(new Std(id,"","",""));
             // dao.updateStudent(new Std(id, name, course, objective));
              res.sendRedirect("list");
            } catch (Exception e) {
                res.getWriter().println("Delete Error: " + e.getMessage());
            }
            return;                     
        }

        
      
        String name = req.getParameter("name");
        String course = req.getParameter("course");
        String objective = req.getParameter("objective");

        try {
           	int id = 0;
			dao.insertStudent(new Std(id, name, course, objective));
            res.sendRedirect("list");
        } catch (Exception e) {
            res.getWriter().println("Insert Error: " + e.getMessage());
        }
    }

    

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Std> students = dao.getAllStudents();
            req.setAttribute("students", students);
            RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            res.getWriter().println("List Error: " + e.getMessage());
        }
    }
}
