function dibujarTabla(data) {
	var oTable = $('#tabla-principal').DataTable({
		data : data,
		destroy : true,
		columns : [ {
			title : 'Nombre',
			data : 'nombre'
		}, {
			title : 'Cedula',
			data : 'cedula'
		} ]
	});
}

function hacerPeticion(primero, cantidad) {
	$.ajax(
			{
				url : "http://localhost:8080/mspbs/rest/personas?primero="
						+ primero + "&cantidad=" + cantidad
			}).done(function(data) {
		console.log(data);
		dibujarTabla(data);
	});
}

function inicializarBotones() {
	var primero = 0;
	var cantidad = 20;
	$('#next').on('click', function() {
		primero += 2;
		hacerPeticion(primero, cantidad);
	})
	$('#previous').on('click', function() {
		primero -= 2;
		hacerPeticion(primero, cantidad);
	})
	$('#enviar').on('click', function() {
		var nombre = $('#nombre').val();
		var apellido = $('#apellido').val();
		var cedula = $('#cedula').val();
		console.log(nombre);
		console.log(apellido);
		$.ajax({
			url : 'http://localhost:8080/mspbs/rest/personas',
			headers : {
				'Content-Type' : 'application/json'
			},
			method : 'POST',
			dataType : 'json',
			data : JSON.stringify({ nombre : nombre, apellido : apellido, cedula : cedula }),
			success : function(data) {
				console.log('succes: ' + data);
				hacerPeticion(primero, cantidad);
			}
		});
	})
}

$(window).ready(function() {
	hacerPeticion(0, 2);
	inicializarBotones();
});