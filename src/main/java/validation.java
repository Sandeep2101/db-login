
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class validation extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

	protected  void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");
              PrintWriter out = response.getWriter();
              String mail = (String) request.getParameter("email");
              String pwd =  (String) request.getParameter("pass");
    try
    {
      // create our mysql database connection
      Class.forName("com.mysql.jdbc.Driver");
      Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/student","root","");
      String query = "SELECT * FROM reg";
      Statement st = con.prepareStatement(query);
      ResultSet rs = st.executeQuery(query);
      int flag=0;
     // out.println("before searching");
     rs.next();
      do
      {
       // out.println("list found");
        String email =(String)rs.getString("email");
        String pass = (String)rs.getString("password");
        String name =(String)rs.getString("name");
        if(email.equals(mail) && pass.equals(pwd))
        {
        out.println( "<html>");
        out.println("<body style=\" background-color: rgb(233, 177, 160) \">");
        out.println("<pre><h1 style=\"text-align: center\">WELCOME "+name+"</h1></pre>");
        out.println("</body>");
        out.println("</html>");
           //out.println("FOUND YOU");
           flag=1;
            break;
        }else
        {
            continue;
         }
        
      }while (rs.next());
      if(flag==0)
      {

        String path= "/regis.html";
        RequestDispatcher dispat =getServletContext().getRequestDispatcher(path);
        dispat.forward(request,response);
        /*out.println("<html>");
       out.println("<script>");
        out.println("alert(\"Login Failed\");");
        out.println("</script>");
        
        out.println("</html>");*/
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
              
              
      }
  }