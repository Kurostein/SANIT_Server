package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

		System.out.println("request recebida!");
		
		String pagSelecionada = request.getParameter("pagSelecionada");
		String action = request.getParameter("action");
		
		TipoDeProblema problema = null;
		String responseString = null;
		
		RequestDispatcher rd;
		
		BoProblemas boProblemas;
		List<TipoDeProblema> listaProblemas;
		
		if(pagSelecionada != null && !pagSelecionada.equals("")){
			boProblemas = new BoProblemas();
			
			switch (pagSelecionada) {
			case "pagInserir":
				request.setAttribute("action", "inserir");
				rd = request.getRequestDispatcher("form-problema.jsp");
				rd.forward(request, response);
				break;
			case "pagRemover":
				listaProblemas = boProblemas.listarProblemas();
				
				request.setAttribute("action", "remover");
				request.setAttribute("listaProblemas", listaProblemas);
				rd = request.getRequestDispatcher("form-problema.jsp");
				rd.forward(request, response);
				break;
			case "pagAtualizar":
				listaProblemas = boProblemas.listarProblemas();
				
				request.setAttribute("listaProblemas", listaProblemas);
				request.setAttribute("action", "atualizar");
				rd = request.getRequestDispatcher("form-problema.jsp");
				rd.forward(request, response);
				break;
			case "pagConsultar":
				listaProblemas = boProblemas.listarProblemas();
				
				request.setAttribute("listaProblemas", listaProblemas);
				rd = request.getRequestDispatcher("form-problema.jsp");
				rd.forward(request, response);
				break;
			default:
				break;
			}
		}else if(action != null && !action.equals("")){
			try{				
				boProblemas = new BoProblemas();
				
				switch (action) {
				case "inserir":
					problema = new TipoDeProblema();
					problema.setProblema(request.getParameter("problema"));
					problema.setPrioridade(Integer.parseInt(request.getParameter("prioridade")));
					responseString = boProblemas.inserir(problema);
					
					action = "inserir";
					
					request.setAttribute("action", action);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-problema.jsp");
					rd.forward(request, response);
					break;
				case "remover":
					problema = new TipoDeProblema();
					problema.setProblema(request.getParameter("problema"));
					responseString = boProblemas.remover(problema);
					
					action = "remover";
					
					request.setAttribute("action", action);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-problema.jsp");
					rd.forward(request, response);
					break;
				case "atualizar":
					problema = new TipoDeProblema();
					problema.setProblema(request.getParameter("problema"));
					problema.setId(Integer.parseInt(request.getParameter("id")));
					problema.setPrioridade(Integer.parseInt(request.getParameter("prioridade")));
					responseString = boProblemas.atualizar(problema);
					
					listaProblemas = boProblemas.listarProblemas();
					
					action = "atualizar";
					
					request.setAttribute("action", action);
					request.setAttribute("listaProblemas", listaProblemas);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-problema.jsp");
					rd.forward(request, response);
					break;
				case "listarProblemas":
					listaProblemas = boProblemas.listarProblemas();
					
					request.setAttribute("listaProblemas", listaProblemas);
					rd = request.getRequestDispatcher("form-problema.jsp");
					rd.forward(request, response);					
					break;
				case "consultarProblemasJson":
					responseString = boProblemas.consultarProblemasJson();
					
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(responseString);
					
					break;
				case "consultarProblema":
					problema = new TipoDeProblema();
					problema.setId(Integer.parseInt(request.getParameter("id")));
					problema = boProblemas.consultarProblema(problema);
					
					listaProblemas = boProblemas.listarProblemas();
					
					action = "atualizar";
							
					request.setAttribute("listaProblemas", listaProblemas);
					request.setAttribute("problema", problema);
					request.setAttribute("action", action);
					rd = request.getRequestDispatcher("form-problema.jsp");
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
				rd = request.getRequestDispatcher("form-problema.jsp");
				rd.forward(request, response);
			}
		}
		
		System.out.println("Resposta enviada com sucesso.");

	}

}
