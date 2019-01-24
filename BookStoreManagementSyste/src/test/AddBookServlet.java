package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AddBookServlet extends HttpServlet{
	public ServletContext sct;
	public Book b;
	public void init()throws ServletException{
		sct=this.getServletContext();
		b=new Book();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		HttpSession hs=req.getSession();
		if(hs!=null) {
			String BID=req.getParameter("BID");
			String BName=req.getParameter("BName");
			String BAuthor=req.getParameter("BAuthor");
			String BPublisher=req.getParameter("BPublisher");
			int BQty=Integer.parseInt(req.getParameter("BQty"));
			float BPrice=Float.parseFloat(req.getParameter("BPrice"));
			
			b.setBID(BID);
			b.setBName(BName);
			b.setBAuthor(BAuthor);
			b.setBPublisher(BPublisher);
			b.setBQty(BQty);
			b.setBPrice(BPrice);
			
			sct.setAttribute("bookref", b);
			
			pw.println("VERIFY the Book Details");
			pw.println("<a href='verify'>CLICK HERE</a>");
	
		}else {
			pw.println("Login to CONTINUE...............!");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.include(req, res);
		}
	}

}
