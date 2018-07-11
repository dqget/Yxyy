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
 * Servlet implementation class addCL
 */
@WebServlet("/correctCL")
public class correctCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public correctCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		CustomerBeanCL cbcl = new CustomerBeanCL();
		String CustomerNum = request.getParameter("CustomerNum");
		String CustomerName = request.getParameter("CustomerName");
		String CustomerIDNum = request.getParameter("CustomerIDNum");
		String CustomerBD = request.getParameter("CustomerBD");
		String CustomerSex = request.getParameter("CustomerSex");
		String CustomerTel = request.getParameter("CustomerTel");
		String CustomerMail = request.getParameter("CustomerMail");
		String MemberNum = request.getParameter("MemberNum");
		String CustomerStatus = request.getParameter("CustomerStatus");
		String CheckInTime = request.getParameter("CheckInTime");
		String CheckOutTime = request.getParameter("CheckOutTime");
		if(cbcl.Correct(CustomerNum,CustomerName,CustomerIDNum,CustomerBD,CustomerSex,CustomerTel,CustomerMail,MemberNum,CustomerStatus,CheckInTime,CheckOutTime)){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('修改成功');window.location.href='RoomINCharge/RoomIn.jsp';</script>");

		}
	}

}
