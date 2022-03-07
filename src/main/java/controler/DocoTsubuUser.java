package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
import model.UserList;
import model.dao.DAOFollow;

/**
 * Servlet implementation class DocoTsubuUser
 */
@WebServlet("/DocoTsubuUser")
public class DocoTsubuUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocoTsubuUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null) {
			HttpSession session=request.getSession();

			UserList ul = (UserList) session.getAttribute("ul");

			User u=(User)session.getAttribute("u");
			LoginLogic ll=new LoginLogic(ul);
			User y=ll.getUser(action);
			if(y.getId()!=u.getId()) {
			DAOFollow daof=new DAOFollow();
			daof.follow(u, y);
			u.findFF();}
			session.setAttribute("u", u);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
