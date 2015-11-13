/**
 * 
 */

function todasOcorrencias(){
	 var tabela = document.createElement("table");
	 var laco = document.createElement("c:forEach");
	 var tr = document.createElement("tr");
	 var td = document.createElement("td");
	 
	 laco.setAttribute('var','ocorrencia');
	 laco.setAttribute('items','${listaOcorrencias}');
	 td.innerHTML = "${}";
	 
	 tr.appendChild(td);
	 laco.appendChild(tr);
	 tabela.appendChild(laco);
	
	 

	
	document.getElementById("tabela").appendChild(tabela);
}

function ocorrenciaBairro(){
	
}

function ocorrenciaProblema(){

}

function numeroProblema(){

}

function numeroBairro(){

}


