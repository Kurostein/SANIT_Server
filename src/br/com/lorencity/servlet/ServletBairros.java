package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoBairros;

/**
 * Servlet implementation class ServletBairros
 */
@WebServlet("/ServletBairros")
public class ServletBairros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBairros() {
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
		String bairro = null;
		String responseString = null;
		
		BoBairros boBairros;
		
		try{
			boBairros = new BoBairros();
			
			switch (action) {
			case "inserir":
				bairro = request.getParameter("bairro");
				responseString = boBairros.inserir(bairro);
				break;
			case "remover":
				bairro = request.getParameter("bairro");
				responseString = boBairros.remover(bairro);
				break;
			case "atualizar":
				//faltando implementação
				
				responseString = boBairros.atualizar();
				break;
			case "consultarBairros":
				List<String> listaBairros;
				listaBairros = boBairros.consultarBairros();
				
				//setar no request
				break;
			case "consultarBairrosJson":
				responseString = boBairros.consultarBairrosJson();
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseString);
				
				break;
			default:
				responseString = "Filter Error";
				break;
			}
			
		}catch(RuntimeException e){
			responseString = e.getMessage();
			e.printStackTrace();
		}
		
		//retorno para a página e setar atributos
		System.out.println("Resposta enviada com sucesso.");

	}

}
