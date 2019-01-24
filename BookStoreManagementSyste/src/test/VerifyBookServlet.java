package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class VerifyBookServlet extends HttpServlet{
	public ServletContext sct;
	public Book b;
	public void init()throws ServletException{
		sct=this.getServletContext();
		b=(Book)sct.getAttribute("bookref");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		HttpSession hs=req.getSession();
		if(hs!=null) {
			pw.println("-------------BOOK DETAILS--------------");
			pw.println("<br>BOOK ID: "+b.getBID());
			pw.println("<br>BOOK Name: "+b.getBName());
			pw.println("<br>BOOK AUTHOR: "+b.getBAuthor());
			pw.println("<br>BOOK PUBLISHER: "+b.getBPublisher());
			pw.println("<br>Avl QUANTITY: "+b.getBQty());
			pw.println("<br>PRICE: "+b.getBPrice());
			
			pw.println("<form action='finalB' method='Post'>");
			pw.println("<input type='submit' value='ADD'>");
			pw.println("</form>");
			
		}else {
			pw.println("Login to CONTINUE...............!");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.include(req, res);
		}
	}

}
