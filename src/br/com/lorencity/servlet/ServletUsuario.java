package br.com.lorencity.servlet;

import java.io.DataInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import br.com.lorencity.bo.BoUsuario;
import br.com.lorencity.generators.ModelPattern;
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
		
		System.out.println("Request recebida com sucesso.");
		
		DataInputStream din = new DataInputStream(request.getInputStream());
		String base64Json = din.readUTF();
		
		byte[] jsonByteArray = Base64.decodeBase64(base64Json);
		String jsonString = new String(jsonByteArray);
		
		JSONObject jsonRequest = new JSONObject(jsonString);
		String action = jsonRequest.getString("action");
		
		DadosDenuncia dadosDenuncia = ModelPattern.preencherModelo(jsonRequest);
				
		//BoUsuario boUsuario = new BoUsuario();
		//boUsuario.doServletAction(dadosDenuncia, action);
		
		//O usuário apenas insere dados, não necessita receber o retorno do método.

		response.setContentType("application/text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Enviado com sucesso!");
		
		System.out.println("Resposta enviada com sucesso.");
	}

}
