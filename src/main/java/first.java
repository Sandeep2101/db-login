import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

//@webServlet("/Register")

public class first extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String mobile = request.getParameter("mobile");
        try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/student","root","");

 //out.println("You are sucessfully connected");
        PreparedStatement ps=con.prepareStatement
                  ("insert into reg values(?,?,?,?)");

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, mobile);
        ps.setString(4, pass);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("<html>");
            out.println("<body style=\"background-color: rgb(220,250, 114)\">");
            out.println("<center><h2>SUCCESSFULLY REGISTERED<h2><center>");
            out.println("</body>");
            out.println("</html>");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
           //out.println("You ");
        }
	
      }
  }