package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.roomBean;
import jdbc.roomBpo;

/**
 * Servlet implementation class findroom
 */
public class findroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findroom() {
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
		roomBpo rbo = new roomBpo();
		String FloorNum = request.getParameter("FloorNum");
		String RoomStandard = request.getParameter("RoomStandard");
		if(FloorNum.length()==0 && RoomStandard.length()==0){
			List<roomBean> list = rbo.getRoom();
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			//request.setAttribute("list", list);
			response.sendRedirect("./roomInfor/findroom.jsp");
		}else if(FloorNum.length()!=0 && RoomStandard.length()==0){
			List<roomBean> list = rbo.getRoomByFn(FloorNum);
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			//request.setAttribute("list", list);
			response.sendRedirect("./roomInfor/findroom.jsp");
		}else if(FloorNum.length()==0 && RoomStandard.length() !=0){
			List<roomBean> list = rbo.getRoomByRs(RoomStandard);
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			//request.setAttribute("list", list);
			response.sendRedirect("./roomInfor/findroom.jsp");
		}else{
			List<roomBean> list = rbo.getRoomById(FloorNum, RoomStandard);
			HttpSession session = request.getSession();
			session.setAttribute("list",list);
			//request.setAttribute("list", list);
			response.sendRedirect("./roomInfor/findroom.jsp");
		}
	}

}
