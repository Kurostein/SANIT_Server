package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoBairros;
import br.com.lorencity.modelo.Bairro;

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
		
		String pagSelecionada = request.getParameter("pagSelecionada");
		String action = request.getParameter("action");
		
		Bairro bairro = null;
		String responseString = null;
		
		RequestDispatcher rd;
		
		BoBairros boBairros;
		List<Bairro> listaBairros;
		
		if(pagSelecionada != null && !pagSelecionada.equals("")){
			boBairros = new BoBairros();
			
			switch (pagSelecionada) {
			case "pagInserir":
				request.setAttribute("action", "inserir");
				rd = request.getRequestDispatcher("form-bairro.jsp");
				rd.forward(request, response);
				break;
			case "pagRemover":
				listaBairros = boBairros.listarBairros();
				
				request.setAttribute("action", "remover");
				request.setAttribute("listaBairros", listaBairros);
				rd = request.getRequestDispatcher("form-bairro.jsp");
				rd.forward(request, response);
				break;
			case "pagAtualizar":
				listaBairros = boBairros.listarBairros();
				
				request.setAttribute("listaBairros", listaBairros);
				request.setAttribute("action", "atualizar");
				rd = request.getRequestDispatcher("form-bairro.jsp");
				rd.forward(request, response);
				break;
			case "pagConsultar":
				listaBairros = boBairros.listarBairros();
				
				request.setAttribute("listaBairros", listaBairros);
				rd = request.getRequestDispatcher("form-bairro.jsp");
				rd.forward(request, response);
				break;
			default:
				break;
			}
		}else if(action != null && !action.equals("")){
			try{				
				boBairros = new BoBairros();
				
				switch (action) {
				case "inserir":
					bairro = new Bairro();
					bairro.setNome(request.getParameter("bairro"));
					responseString = boBairros.inserir(bairro);
					
					action = "inserir";
					
					request.setAttribute("action", action);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-bairro.jsp");
					rd.forward(request, response);
					break;
				case "remover":
					bairro = new Bairro();
					bairro.setNome(request.getParameter("bairro"));
					responseString = boBairros.remover(bairro);
					
					action = "remover";
					
					request.setAttribute("action", action);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-bairro.jsp");
					rd.forward(request, response);
					break;
				case "atualizar":
					bairro = new Bairro();
					bairro.setNome(request.getParameter("bairro"));
					bairro.setId(Integer.parseInt(request.getParameter("id")));
					responseString = boBairros.atualizar(bairro);
					
					listaBairros = boBairros.listarBairros();
					
					action = "atualizar";
					
					request.setAttribute("action", action);
					request.setAttribute("listaBairros", listaBairros);
					request.setAttribute("responseMessage", responseString);
					rd = request.getRequestDispatcher("form-bairro.jsp");
					rd.forward(request, response);
					break;
				case "listarProblemas":
					listaBairros = boBairros.listarBairros();
					
					request.setAttribute("listaBairros", listaBairros);
					rd = request.getRequestDispatcher("form-bairro.jsp");
					rd.forward(request, response);					
					break;
				case "consultarBairrosJson":
					responseString = boBairros.consultarBairrosJson();
					
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(responseString);
					
					break;
				case "consultarBairro":
					bairro = new Bairro();
					bairro.setId(Integer.parseInt(request.getParameter("id")));
					bairro = boBairros.consultarBairro(bairro);
					
					listaBairros = boBairros.listarBairros();
					
					action = "atualizar";
							
					request.setAttribute("listaBairros", listaBairros);
					request.setAttribute("bairro", bairro);
					request.setAttribute("action", action);
					rd = request.getRequestDispatcher("form-bairro.jsp");
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
				rd = request.getRequestDispatcher("form-bairro.jsp");
				rd.forward(request, response);
			}
		}
		
		System.out.println("Resposta enviada com sucesso.");
	}

}
