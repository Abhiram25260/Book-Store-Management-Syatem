package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet{
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getcon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String UName=req.getParameter("UName");
		String PWord=req.getParameter("PWord");
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from AdminDetailsP where UName=? AND PWord=?");
			ps.setString(1, UName);
			ps.setString(2, PWord);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession hs=req.getSession();
				hs.setAttribute("FName", rs.getString(3));
				RequestDispatcher rd=req.getRequestDispatcher("AdminLink.html");
				rd.include(req, res);
			}else {
				pw.println("Invalid UserName or Password please TRY AGAIN.....!");
				RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
				rd.include(req, res);
			}
		}catch(Exception e) {
			pw.println(e.getStackTrace());
		}
	}

}
