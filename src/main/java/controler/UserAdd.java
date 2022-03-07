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
import model.dao.DAOMutter;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/loginConfirm.jsp");
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
		String pass = request.getParameter("pass");
		User u = new User(name, pass);
		LoginLogic ll = new LoginLogic(ul);
		if (!(ll.checkUser(u))) {
			String msg = u.getMsg();
			msg += "このユーザーは登録できません";
			u.setMsg(msg);
			request.setAttribute("u", u);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			rd.forward(request, response);

		} else {
			DAOMutter daom=new DAOMutter();
			if(daom.add(ul, u)) {
				System.out.println("追加成功");
			}else {
				System.out.println("追加失敗");
			}
			daom.findAll(ul);
			application.setAttribute("ul", ul);
			request.setAttribute("u", u);
			u.setMsg("ユーザー名:" + u.getName() + "を登録しましたUID:"+u.getId());

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			rd.forward(request, response);

		}
	}

}
