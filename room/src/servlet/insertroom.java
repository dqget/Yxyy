package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.roomBean;

/**
 * Servlet implementation class insertroom
 */
public class insertroom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// String str = new
		// String(request.getParameter("param").getBytes("iso8859-1"),"UTF-8");
		// String FloorNum = new
		// String(request.getParameter("FloorNum").getBytes("iso8859-1"),"utf-8");
		String FloorNum = request.getParameter("FloorNum");
		String RoomNum = request.getParameter("RoomNum");
		String RoomStandard = request.getParameter("RoomStandard");
		String RoomCharge = request.getParameter("RoomCharge");
		String RoomPosition = request.getParameter("RoomPosition");
		System.out.println(FloorNum);
		roomBean rb = new roomBean();
		rb.setRoomNum(RoomNum);
		rb.setFloorNum(FloorNum);
		rb.setRoomStandard(RoomStandard);
		rb.setRoomCharge(RoomCharge);
		rb.setRoomPosition(RoomPosition);
		if (rb.addRoom() == 1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('添加成功');window.location.href='./RoomCharge.jsp';</script>");
		}
	}

}
