package br.com.lorencity.servlet;

import java.io.IOException;
import java.util.List;

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
		Fiscal fiscal = null;
		String responseString = null;
		
		BoFiscal boFiscal;
		
		try{
			boFiscal = new BoFiscal();
			
			switch (action) {
			case "inserir":
				fiscal = new Fiscal();
				fiscal.setNome(request.getParameter("nome"));
				fiscal.setCPF(request.getParameter("cpf"));
				fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
				fiscal.setSenha(request.getParameter("senha"));
				responseString = boFiscal.inserir(fiscal);
				break;
			case "remover":
				fiscal = new Fiscal();
				fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
				responseString = boFiscal.remover(fiscal);
				break;
			case "atualizar":
				fiscal = new Fiscal();
				fiscal.setCPF(request.getParameter("cpf"));
				fiscal.setNome(request.getParameter("nome"));
				fiscal.setMatricula(Integer.parseInt(request.getParameter("matricula")));
				fiscal.setSenha(request.getParameter("senha"));
				break;
			case "consultarFiscais":
				List<Fiscal> listaFiscais;
				listaFiscais = boFiscal.consultarFiscais();
				
				//setar no request
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
