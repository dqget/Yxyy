package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.discountBean;
import jdbc.discountBpo;
import jdbc.roomBean;
import jdbc.roomBpo;

/**
 * Servlet implementation class updatediscount
 */
public class updatediscount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatediscount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String MemberType = request.getParameter("id");
		String mem = new String(MemberType.getBytes("iso8859-1"),"utf-8");
		discountBpo dib = new discountBpo();
		discountBean disb = dib.getdiscountbyid(mem);
		System.out.println(mem);
		request.setAttribute("disb",disb);
		request.getRequestDispatcher("/discount/updatediscount.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
