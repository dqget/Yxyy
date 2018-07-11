package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jdbc.roomBean;
import jdbc.roomBpo;

/**
 * Servlet implementation class updateroom2
 */
public class updateroom2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateroom2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String RoomCharge = request.getParameter("RoomCharge");
		String RoomStatus = request.getParameter("RoomStatus");
		String DateTime = request.getParameter("datetime");
		String RoomNum  = request.getParameter("RoomNum");
		roomBean rbn = new roomBean();
		rbn.setDateTime(DateTime);
		rbn.setRoomCharge(RoomCharge);
		rbn.setRoomNum(RoomNum);
		rbn.setRoomStatus(RoomStatus);
		if(rbn.updateroom()==1){
			roomBpo rbo = new roomBpo();
			rbo.insertrecordById(RoomNum, "u001", DateTime);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('修改成功');window.location.href='Getroom';</script>");
		}
	}

}
