package br.com.lorencity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRedirect
 */
@WebServlet("/ServletRedirect")
public class ServletRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		RequestDispatcher rd;
		
		switch (action) {
		case "inserir":
			request.setAttribute("action", action);
			rd = request.getRequestDispatcher("form-problema.jsp");
			rd.forward(request, response);
			break;
		case "remover":
			request.setAttribute("action", action);
			rd = request.getRequestDispatcher("form-problema.jsp");
			rd.forward(request, response);
			break;
		case "atualizar":
			request.setAttribute("action", action);
			rd = request.getRequestDispatcher("form-problema.jsp");
			rd.forward(request, response);
			break;
		case "consultar":
			request.setAttribute("action", action);
			rd = request.getRequestDispatcher("form-problema.jsp");
			rd.forward(request, response);
			break;
		default:
			break;
		}
	}

}
