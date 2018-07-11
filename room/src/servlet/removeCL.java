package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JC.*;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/removeCL")
public class removeCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CustomerNum = request.getParameter("CustomerNum");
		CustomerBeanCL cbcl = new CustomerBeanCL();
		boolean b = cbcl.Remove(CustomerNum);
		if(b){
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>;window.location.href='RoomINCharge/CustomerCharge.jsp';</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
