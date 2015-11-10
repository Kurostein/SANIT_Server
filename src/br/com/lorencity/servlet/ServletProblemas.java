package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoProblemas;
import br.com.lorencity.modelo.TipoDeProblema;

/**
 * Servlet implementation class ServletProblemas
 */
@WebServlet("/ServletProblemas")
public class ServletProblemas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProblemas() {
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
		TipoDeProblema problema = null;
		String responseString = null;
		
		BoProblemas boProblemas;
		System.out.println(action);
		try{
			boProblemas = new BoProblemas();
			
			switch (action) {
			case "inserir":
				problema = new TipoDeProblema();
				problema.setProblema(request.getParameter("problema"));
				problema.setPrioridade(Integer.parseInt(request.getParameter("prioridade")));
				responseString = boProblemas.inserir(problema);
				break;
			case "remover":
				problema = new TipoDeProblema();
				problema.setProblema(request.getParameter("problema"));
				responseString = boProblemas.remover(problema);
				break;
			case "atualizar":
				//faltando implementação
				
				responseString = boProblemas.atualizar();
				break;
			case "consultarProblemas":
				List<TipoDeProblema> listaProblemas;
				listaProblemas = boProblemas.consultarProblemas();
				
				//setar no request
				break;
			case "consultarProblemasJson":
				responseString = boProblemas.consultarProblemasJson();
				
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
