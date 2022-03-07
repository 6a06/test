package controler.lesson11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Losson11
 */
@WebServlet("/Losson11")
public class Losson11 extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Losson11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Integer count=0;
		ServletContext application=config.getServletContext();
		application.setAttribute("count", count);
		System.out.println("init()が実行されました");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		System.out.println("destroy()が実行されました");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()を実行");
		ServletContext application=this.getServletContext();
		Integer count=(Integer)application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/lesson11/Lesson11.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
