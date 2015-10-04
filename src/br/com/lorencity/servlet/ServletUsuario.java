package br.com.lorencity.servlet;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoUsuario;
import br.com.lorencity.generators.ModelGenerator;
import br.com.lorencity.modelo.DadosDenuncia;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletUsuario() {
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
		// TODO Auto-generated method stub
		/*
		DadosDenuncia dadosDenuncia = ModelGenerator.preencherModelo(request);
		String action = request.getParameter("action");
		
		BoUsuario boUsuario = new BoUsuario();
		boUsuario.doServletAction(dadosDenuncia, action);
		*/
		//O usuário apenas insere dados, não necessita receber o retorno do método.
		/*
		String cpf = request.getParameter("cpf");
		String tipo = request.getParameter("tipoProblema");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		
		System.out.println(cpf+tipo+endereco+cep);
		*/
		System.out.println("Teste: "+request.getParameter("hello"));
		
		response.setContentType("application/text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Enviado");
		
		//request.getParameterMap() retorna um Map<String, String>
	}

}
