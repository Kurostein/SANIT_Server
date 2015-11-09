package br.com.lorencity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.com.lorencity.bo.BoUsuario;
import br.com.lorencity.modelo.Endereco;
import br.com.lorencity.modelo.Ocorrencia;

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
		
		System.out.println("Request recebida com sucesso.");
		
		JSONObject jsonRequest = new JSONObject(request.getParameter("params"));
		String action = jsonRequest.getString("action");
				
		Ocorrencia ocorrencia = null;
		String responseString;
		
		try{
			if(action.equals("inserir")){
				ocorrencia = new Ocorrencia();
				ocorrencia.setEndereco(Endereco.preencherEndereco(jsonRequest));
				ocorrencia.setTipoProblema(jsonRequest.getString("tipoProblema"));
				ocorrencia.setImagePath(jsonRequest.getString("imagem"));
			}
			
			BoUsuario boUsuario = new BoUsuario();
			responseString = boUsuario.doServletAction(ocorrencia, action);
			
		}catch(RuntimeException e){
			responseString = e.getMessage();
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseString);
		
		System.out.println("Resposta enviada com sucesso.");
	}

}
