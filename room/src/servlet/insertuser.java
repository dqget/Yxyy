package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.userInfoBean;

/**
 * Servlet implementation class insertuser
 */
public class insertuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertuser() {
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
		String UserType = request.getParameter("UserType");
		String UserPassword = request.getParameter("UserPassword");
		String UserTrueName = request.getParameter("UserTrueName");
		String Age = request.getParameter("Age");
		String Sex = request.getParameter("Sex");
		userInfoBean uib = new userInfoBean();
		uib.setUserNum(UserNum);
		uib.setUserName(UserName);
		uib.setUserType(UserType);
		uib.setUserPassword(UserPassword);
		uib.setUserTrueName(UserTrueName);
		uib.setAge(Age);
		uib.setSex(Sex);
		if(uib.addUser()==1){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('添加成功');window.location.href='./UserCharge.jsp';</script>");
		}
	}

}
