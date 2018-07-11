package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete_OtherFare_do
 */
@WebServlet("/Delete_OtherFare_do")
public class Delete_OtherFare_do extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_OtherFare_do() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum");
		
		String faretype=request.getParameter("faretype");
		Float fare=Float.parseFloat(request.getParameter("fare"));
		String OPtime=request.getParameter("optime");
		String ps=request.getParameter("ps");
			try {
				
				CRUDTest.deleteotherfare(rnum, faretype, OPtime);
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('添加成功');window.location.href='OtherFare.jsp';</script>");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('你的操作有误！');window.location.href='OtherFare.jsp';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('你的操作有误！');window.location.href='OtherFare.jsp';</script>");
			}finally{
				
				
			}
	}

}
