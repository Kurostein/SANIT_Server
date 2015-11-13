package br.com.lorencity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.lorencity.bo.BoGestor;
import br.com.lorencity.modelo.Gestor;



/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("action");
		
		Gestor gestor;
		BoGestor boGestor;
		
		if(act.equals("login")){
			gestor = new Gestor();
			boGestor = new BoGestor();
			
			gestor.setMatricula(Integer.parseInt(request.getParameter("matricula")));
			gestor.setSenha(request.getParameter("senha"));
			
			try{
				if(boGestor.checkLoginGestor(gestor)){
					HttpSession session = request.getSession(true);
					session.setAttribute("usuariologado", gestor.getMatricula());
					response.sendRedirect("/SANIT/Inicio.jsp");
				}else{
					String message = "Usuário ou senha inválidos.";
					request.setAttribute("responseMessage", message);
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				
			}catch(RuntimeException e){
				request.setAttribute("responseMessage", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		} else if(act.equals("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/SANIT/Login.jsp");
		}
	}

}
