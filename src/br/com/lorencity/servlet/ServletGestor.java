package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.com.lorencity.bo.BoGestor;
import br.com.lorencity.modelo.Endereco;
import br.com.lorencity.modelo.Estatistica;
import br.com.lorencity.modelo.Ocorrencia;
import br.com.lorencity.modelo.TipoDeProblema;

/**
 * Servlet implementation class ServletGestor
 */
@WebServlet("/ServletGestor")
public class ServletGestor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestor() {
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
		String responseString = null;
		
		List<Ocorrencia> lista;
		List<Estatistica> listaEstatisticas;
		
		BoGestor boGestor;
		
		try{
			boGestor = new BoGestor();
			
			switch (action) {
			case "listarOcorrencias":
				lista = new ArrayList<Ocorrencia>();
				lista = boGestor.listarOcorrencias();
				
				request.setAttribute("listaOcorrencias", lista);
				break;
			case "consultarOcorrenciasPorBairro":
				Endereco endereco = new Endereco();
				endereco.setBairro(request.getParameter("bairro"));
				
				lista = new ArrayList<Ocorrencia>();				
				lista = boGestor.consultarOcorrenciasPorBairro(endereco);
				
				request.setAttribute("listaOcorrenciasPorBairro", lista);
				break;
			case "consultarOcorrenciasPorProblema":
				TipoDeProblema problema = new TipoDeProblema();
				problema.setProblema(request.getParameter("problema"));
				
				lista = new ArrayList<Ocorrencia>();			
				lista = boGestor.consultarOcorrenciasPorProblema(problema);
				
				request.setAttribute("listaOcorrenciasPorProblema", lista);
				break;
			case "consultarNumeroDeOcorrenciasPorProblema":
				listaEstatisticas = boGestor.consultarNumeroDeOcorrenciasPorProblema();
				
				request.setAttribute("listaEstatisticas", listaEstatisticas);
				break;
			case "consultarNumeroDeOcorrenciasPorBairro":
				listaEstatisticas = boGestor.consultarNumeroDeOcorrenciasPorBairro();
				
				request.setAttribute("listaEstatisticas", listaEstatisticas);
				break;
			default:
				responseString = "Filter Error";
				break;
			}
			
		}catch(RuntimeException e){
			responseString = e.getMessage();
			e.printStackTrace();
		}
		
		//retorno para a página e setar atributos (método com requestDispatcher)
		System.out.println("Resposta enviada com sucesso.");
	}

}
