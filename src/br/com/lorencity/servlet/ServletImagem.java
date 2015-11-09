package br.com.lorencity.servlet;

import java.io.DataInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lorencity.bo.BoImagem;

/**
 * Servlet implementation class ServletImagem
 */
@WebServlet("/ServletImagem")
public class ServletImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImagem() {
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
		
		System.out.println("Request recebida com sucesso.");
		
		//Get request stream
		DataInputStream din = new DataInputStream(request.getInputStream());
		String base64Image = din.readUTF();

		String imagePathResponse = null;
		BoImagem boImagem = new BoImagem();
		
		try{
			imagePathResponse = boImagem.adicionar(base64Image);
		}catch(RuntimeException e){
			imagePathResponse = e.getMessage();
			e.printStackTrace();
		}
		
		response.setContentType("application/text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(imagePathResponse);
		
		System.out.println("Resposta enviada com sucesso.");
	}

}
