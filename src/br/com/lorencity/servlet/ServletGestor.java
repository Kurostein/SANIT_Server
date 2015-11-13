package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoBairros;
import br.com.lorencity.bo.BoGestor;
import br.com.lorencity.bo.BoProblemas;
import br.com.lorencity.modelo.Bairro;
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
		
		String pagSelecionada = request.getParameter("pagSelecionada");
		String action = request.getParameter("action");
		String responseString = null;
		
		List<Ocorrencia> listaOcorrencias;
		List<Estatistica> listaEstatisticas;
		List<Bairro> listaBairros;
		List<TipoDeProblema> listaProblemas;
		
		RequestDispatcher rd;
		
		BoGestor boGestor;
		BoBairros boBairros;
		BoProblemas boProblemas;
		
		if(pagSelecionada.equals("pagConsultar")){
			boBairros = new BoBairros();
			boProblemas = new BoProblemas();
			
			listaBairros = boBairros.listarBairros();
			listaProblemas = boProblemas.listarProblemas();

			request.setAttribute("listaBairros", listaBairros);
			request.setAttribute("listaProblemas", listaProblemas);
			rd = request.getRequestDispatcher("Consultas.jsp");
			rd.forward(request, response);
		}else if(action != null && !action.equals("")){	
			try{
				boGestor = new BoGestor();
				
				switch (action) {
				case "listarOcorrencias":
					listaOcorrencias = new ArrayList<Ocorrencia>();
					listaOcorrencias = boGestor.listarOcorrencias();
					
					request.setAttribute("listaOcorrencias", listaOcorrencias);
					rd = request.getRequestDispatcher("Consultas.jsp");
					rd.forward(request, response);
					break;
				case "consultarOcorrenciasPorBairro":
					Bairro bairro = new Bairro();
					bairro.setNome(request.getParameter("bairro"));
					
					listaOcorrencias = new ArrayList<Ocorrencia>();				
					listaOcorrencias = boGestor.consultarOcorrenciasPorBairro(bairro);
					
					request.setAttribute("listaOcorrencias", listaOcorrencias);
					rd = request.getRequestDispatcher("Consultas.jsp");
					rd.forward(request, response);
					break;
				case "consultarOcorrenciasPorProblema":
					TipoDeProblema problema = new TipoDeProblema();
					problema.setProblema(request.getParameter("problema"));
					
					listaOcorrencias = new ArrayList<Ocorrencia>();			
					listaOcorrencias = boGestor.consultarOcorrenciasPorProblema(problema);
					
					request.setAttribute("listaOcorrencias", listaOcorrencias);
					rd = request.getRequestDispatcher("Consultas.jsp");
					rd.forward(request, response);
					break;
				case "consultarNumeroDeOcorrenciasPorProblema":
					listaEstatisticas = boGestor.consultarNumeroDeOcorrenciasPorProblema();
					
					request.setAttribute("listaEstatisticas", listaEstatisticas);
					rd = request.getRequestDispatcher("Consultas.jsp");
					rd.forward(request, response);
					break;
				case "consultarNumeroDeOcorrenciasPorBairro":
					listaEstatisticas = boGestor.consultarNumeroDeOcorrenciasPorBairro();
					
					request.setAttribute("listaEstatisticas", listaEstatisticas);
					rd = request.getRequestDispatcher("Consultas.jsp");
					rd.forward(request, response);
					break;
				default:
					responseString = "Filter Error";
					break;
				}	
			}catch(RuntimeException e){
				responseString = e.getMessage();
				e.printStackTrace();
				
				request.setAttribute("responseMessage", responseString);
				rd = request.getRequestDispatcher("Consultas.jsp");
				rd.forward(request, response);
			}
		}
		System.out.println("Resposta enviada com sucesso.");
	}

}
