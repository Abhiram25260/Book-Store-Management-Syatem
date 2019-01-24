package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class FinalAddBookServlet extends HttpServlet{
	public ServletContext sct;
	public Book b;
	public Connection con;
	public void init()throws ServletException{
		sct=this.getServletContext();
		b=(Book)sct.getAttribute("bookref");
		con=DBConnection.getcon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into BookDetails values(?,?,?,?,?,?)");
			ps.setString(1, b.getBID());
			ps.setString(2, b.getBName());
			ps.setString(3, b.getBAuthor());
			ps.setString(4, b.getBPublisher());
			ps.setInt(5, b.getBQty());
			ps.setFloat(6, b.getBPrice());
			
			int k=ps.executeUpdate();
			
			if(k>0) {
				pw.println("BOOK ADDED SUCCESSFULLY.............!");
				RequestDispatcher rd=req.getRequestDispatcher("AddBook.html");
				rd.include(req, res);
			}
			
		}catch(Exception e) {
			pw.println(e.getStackTrace());
		}
	}

}
