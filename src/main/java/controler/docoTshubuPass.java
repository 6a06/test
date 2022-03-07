package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginLogic;
import model.User;
import model.UserList;

/**
 * Servlet implementation class docoTshubuPass
 */
@WebServlet("/docoTshubuPass")
public class docoTshubuPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public docoTshubuPass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/remenber.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	request.setCharacterEncoding("UTF-8");
		ServletContext application = this.getServletContext();
		UserList ul = (UserList) application.getAttribute("ul");
		String name = request.getParameter("name");
		LoginLogic ll = new LoginLogic(ul);
		if (ll.checkName(name)) {
			User u = ll.getUser(name);
			String msg = "ID：" + u.getName() + "のpass:" + u.getPass();
			u.setMsg(msg);
			request.setAttribute("u", u);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			rd.forward(request, response);

		} else {
			User u = new User();
			String msg = "このIDは存在しません";
			u.setMsg(msg);
			request.setAttribute("u", u);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			rd.forward(request, response);
		}

	}

}
