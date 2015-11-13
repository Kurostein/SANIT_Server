/**
 * 
 */

//window.onload = gerarGraficoColuna;
var mapa;
var grafico = "";
var randomnb = function(){ return Math.round(Math.random()*300)};
var options = {
        responsive:true
    };

    var data = {
        labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
        datasets: [
            {
                label: "Dados primários",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb(), randomnb()]
            },
            {
                label: "Dados secundários",
                fillColor: "rgba(151,187,205,0.2)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 86, 27, 90, 200, 87, 20, 50, 20]
            }
        ]
    };               


function init(){
	 mapa = new google.maps.Map(document.getElementById('map'), {
			zoom: 10,
			center: {lat: -34.397, lng: 150.644},
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			scrollwheel: false
	});
}

function gerarGraficoLinha(){
	if(grafico != "")
		grafico.destroy();
		
    var ctx = document.getElementById("grafico1").getContext("2d");
    grafico = new Chart(ctx).Line(data, options);
}  

function gerarGraficoColuna(){
	if(grafico != "")
		grafico.destroy();
	
	var ctx = document.getElementById("grafico1").getContext("2d");
    grafico = new Chart(ctx).Bar(data, options); 
}          

function escolherGrafico(){
	var tipoGrafico = document.getElementById("escolhaTipoGrafico").value;
	
	if(tipoGrafico == "Barra"){
		gerarGraficoColuna();
	}
	else if(tipoGrafico == "Linha"){
		gerarGraficoLinha();
	}
	else
		alert("Escolha uma opção de grafico!");
}

function validarLogin() {
	var postID = document.getElementById("usuario").value;
	var postPass = document.getElementById("senha").value;
	
	if (postID == null || postID == '') {
		alert('Digite um usuario!');
	}else if (postPass == null || postPass == ''){
		alert('Digite uma senha!')
	}else{
		document.forms['login'].submit();
	}
}

function Logout(){
    document.getElementById("logout").submit();
}