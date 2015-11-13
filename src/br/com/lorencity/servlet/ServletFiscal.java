package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoFiscal;
import br.com.lorencity.modelo.Fiscal;

/**
 * Servlet implementation class ServletFiscal
 */
@WebServlet("/ServletFiscal")
public class ServletFiscal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiscal() {
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
		String pagSelecionada = request.getParameter("pagSelecionada");
		String responseString = null;
		
		RequestDispatcher rd;
		
		BoFiscal boFiscal;
		Fiscal fiscal = null;
		List<Fiscal> listaFiscais;
		
		if(pagSelecionada != null && !pagSelecionada.equals("")){
			boFiscal = new BoFiscal();
			
			switch (pagSelecionada) {
			case "pagInserir":
				request.setAttribute("action", "inserir");
				rd = request.getRequestDispatcher("form-fiscal.jsp");
				rd.forward(request, response);
				break;
			case "pagRemover":
				listaFiscais = boFiscal.listarFiscais();
				
				request.setAttribute("action", "remover");
				request.setAttribute("listaFiscais", listaFiscais);
				rd = request.getRequestDispatcher("form-fiscal.jsp");
				rd.forward(request, response);
				break;
			case "pagAtualizar":
				listaFiscais = boFiscal.listarFiscais();
				
				request.setAttribute("listaFiscais", listaFiscais);
				request.setAttribute("action", "atualizar");
				rd = request.getRequestDispatcher("form-fiscal.jsp");
				rd.forward(request, response);
				break;
			case "pagConsultar":
				listaFiscais = boFiscal.listarFiscais();
				
				request.setAttribute("listaFiscais", listaFiscais);
				rd = request.getRequestDispatcher("form-fiscal.jsp");
				rd.forward(request, response);
				break;
			default:
				break;
			}
		}else if(action != null && !action.equals("")){
			try{				
				boFiscal = new BoFiscal();
				
				switch (action) {
				case "inserir":
					fiscal = new Fiscal();
					fiscal.setNome(request.getParameter("nome"));
					fiscal.setCpf(request.getParameter("cpf"));
					fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
					fiscal.setSenha(request.getParameter("senha"));
					responseString = boFiscal.inserir(fiscal);
					
					action = "inserir";
					
					request.setAttribute("action", action);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-fiscal.jsp");
					rd.forward(request, response);
					break;
				case "remover":
					fiscal = new Fiscal();
					fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
					responseString = boFiscal.remover(fiscal);
					
					action = "remover";
					
					request.setAttribute("action", action);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("remove-fiscal.jsp");
					rd.forward(request, response);
					break;
				case "atualizar":
					fiscal = new Fiscal();
					fiscal.setNome(request.getParameter("nome"));
					fiscal.setCpf(request.getParameter("cpf"));
					fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
					fiscal.setSenha(request.getParameter("senha"));
					
					responseString = boFiscal.atualizar(fiscal);
					
					listaFiscais = boFiscal.listarFiscais();
					
					action = "atualizar";
					
					request.setAttribute("action", action);
					request.setAttribute("listaFiscais", listaFiscais);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-fiscal.jsp");
					rd.forward(request, response);
					break;
				case "listarFiscais":
					listaFiscais = boFiscal.listarFiscais();
					
					request.setAttribute("listaFiscais", listaFiscais);
					rd = request.getRequestDispatcher("form-fiscal.jsp");
					rd.forward(request, response);					
					break;
				case "consultarFiscal":
					fiscal = new Fiscal();
					fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
					fiscal = boFiscal.consultarFiscal(fiscal);
					
					listaFiscais = boFiscal.listarFiscais();
					
					action = "atualizar";
							
					request.setAttribute("listaFiscais", listaFiscais);
					request.setAttribute("fiscal", fiscal);
					request.setAttribute("action", action);
					rd = request.getRequestDispatcher("form-fiscal.jsp");
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
				rd = request.getRequestDispatcher("form-fiscal.jsp");
				rd.forward(request, response);
			}
		}

		System.out.println("Resposta enviada com sucesso.");
	}

}
