package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
import model.UserList;
import model.dao.DAOMutter;

/**
 * Servlet implementation class docoTsubu
 */
@WebServlet("/docoTsubu")
public class docoTsubu extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext application = this.getServletContext();
		UserList ul = (UserList) application.getAttribute("ul");
		if(ul==null) {
			System.out.println("初期化しまーす");
			ul = new UserList();
			DAOMutter daom=new DAOMutter();
			daom.findAll(ul);
			application.setAttribute("ul", ul);
		}
		String action = request.getParameter("action");
		if (action != "logout" || action == null) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		UserList ul = (UserList) application.getAttribute("ul");
		LoginLogic ll = new LoginLogic(ul);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User nu = ll.checkLogin(name, pass);
		if (nu.getName() != "error") {
			HttpSession session = request.getSession();
			//ログイン成功
			session.setAttribute("u", nu);
			session.setAttribute("ul", ul);
			System.out.println(nu.getId());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/submitLogin.jsp");
			rd.forward(request, response);

		} else {//ログイン失敗

			request.setAttribute("u", nu);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/failLogin.jsp");
			rd.forward(request, response);
		}

	}

}
