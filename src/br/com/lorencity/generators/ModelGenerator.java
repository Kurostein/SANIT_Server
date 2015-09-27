package br.com.lorencity.generators;

import javax.servlet.http.HttpServletRequest;

import br.com.lorencity.modelo.DadosDenuncia;

public class ModelGenerator {
	/*recebe o HttpRequest e a Action, modela os dados de consulta ou inserção
	 * e retorna o modelo preenchido.
	 */
	
	private ModelGenerator(){
		
	}
	
	public static DadosDenuncia preencherModelo(HttpServletRequest request){
		//Preenche o objeto modelo com os dados enviados do request, e o retorna.

		DadosDenuncia modeloDados = new DadosDenuncia();
		
		
		return modeloDados;
	}
}
