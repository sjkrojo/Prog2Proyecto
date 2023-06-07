var sucursal = "";

function get_products() {
	var url = "http://localhost:8081/bimboapi/colaborador";
	var xhr = new XMLHttpRequest()
	xhr.open('GET', url, true)
	xhr.onload = function () {
	var users = JSON.parse(xhr.responseText);
	if (xhr.readyState == 4 && xhr.status == "302") {
		console.table(users);
	} else {
		console.error(users);
	}
}



xhr.send(url);
}


function get_productsSucursal( sucursal) {
	var url ="http://localhost:8081/bimboapi/producto/sucursal?sucursal="+sucursal;
	var xhr = new XMLHttpRequest()
	xhr.open('GET', url, true)
	xhr.onload = function () {
	var users = JSON.parse(xhr.responseText);
	if (xhr.readyState == 4 && xhr.status == "302") {
		console.table(users);
	} else {
		console.error(users);
	}
}

xhr.send(url);
}

function agregarColaborador(nombre, edad, correo ) {
 var url = "http://localhost:8081/bimboapi/colaborador?nombre=" + nombre + "&edad=" + edad + "&email=" + correo;

	var xhr = new XMLHttpRequest()
	xhr.open('POST', url, true)
	xhr.send(url);
}

function agregarProducto(nombre, vendedor, precio, sucursal) {
 var url = "http://localhost:8081/bimboapi/producto?nombre=" + nombre + "&precio=" + vendedor + "&vendedor=" + precio+ "&sucursal=" + sucursal;

	var xhr = new XMLHttpRequest()
	xhr.open('POST', url, true)
	xhr.send(url);
}

function actualizarColaborador(nombre, precio, vendedor,id ) {
 var url = "http://localhost:8081/bimboapi/producto/"+id+"?nombre="+nombre+"&precio="+precio+"&vendedor="+vendedor;

	var xhr = new XMLHttpRequest()
	xhr.open('PUT', url, true)
	xhr.send(url);
}

function actualizarProducto(nombre, edad, correo,id, sucursal ) {
 var url = "http://localhost:8081/bimboapi/producto/"+id+"?nombre="+nombre+"&edad="+edad+"&email="+correo+"&sucursal="+sucursal;

	var xhr = new XMLHttpRequest()
	xhr.open('PUT', url, true)
	xhr.send(url);
}

function eliminarColaborador(id ) {
 var url = "http://localhost:8081/bimboapi/colaborador/eliminar/"+id;

	var xhr = new XMLHttpRequest()
	xhr.open('DELETE', url, true)
	xhr.send(url);
}

function eliminarProducto(id ) {
 var url = "http://localhost:8081/bimboapi/producto/eliminar/"+id;

	var xhr = new XMLHttpRequest()
	xhr.open('DELETE', url, true)
	xhr.send(url);
}

   function obtenerValor(id) {
      var input = document.getElementById(id);
      var valor = input.value;
      return valor;
    }

function change_page(url) {
	window.location.href = url;
}

function generarPDF() {
  var doc = new jsPDF();
  doc.text("¡Hola, esto es un PDF generado desde mi página web!", 10, 10);
  doc.save("mi-archivo.pdf", { autoDownload: true });
}

function seleccionarCiudad(ciudad) {
	if(ciudad == "Pasto"){
		  change_page("mostrarProductosPasto.jsp");
	}
	
		if(ciudad == "Nariño"){
		  change_page("mostrarProductosNariño.jsp");
	}
	
		if(ciudad == "Caracas"){
		  change_page("mostrarProductosCaracas.jsp");
	}
	
		if(ciudad == "Villavicencio"){
		  change_page("mostrarProductosVillavicencio.jsp");
	}
}

