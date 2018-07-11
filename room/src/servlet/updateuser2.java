package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.userInfoBean;

/**
 * Servlet implementation class updateuser2
 */
public class updateuser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuser2() {
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
		String UserNum = request.getParameter("UserNum");
		String UserName = request.getParameter("UserName");
		String UserPassword = request.getParameter("UserPassword");
		String UserTrueName = request.getParameter("UserTrueName");
		userInfoBean uib = new userInfoBean();
		uib.setUserName(UserName);
		uib.setUserPassword(UserPassword);
		uib.setUserTrueName(UserTrueName);
		uib.setUserNum(UserNum);
		if(uib.updateinfo()==1){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('修改成功');window.location.href='Getuser';</script>");
		}
	}

}
