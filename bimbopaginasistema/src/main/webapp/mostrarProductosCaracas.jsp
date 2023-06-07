<%@ include file="seleccionarinventario.jsp" %>

<body>
  <div class="container">
    <h1>Tabla de Productos</h1>
    <table id="tabla-productos" class="table table-striped">
      <thead class="thead-dark">
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Precio</th>
          <th>Vendedor</th>
          <th>Sucursal</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
  </div>

  <script>
  function get_productsSucursal(sucursal) {
	  var url = "http://localhost:8081/bimboapi/producto/sucursal?sucursal=" + sucursal;
	  var xhr = new XMLHttpRequest();
	  xhr.open('GET', url, true);
	  xhr.onload = function () {
	    if (xhr.readyState == 4 && xhr.status == 302) {
	      var users = JSON.parse(xhr.responseText);
	      var tabla = document.getElementById("tabla-productos");
	      var tbody = tabla.getElementsByTagName("tbody")[0];
	      tbody.innerHTML = "";

	      for (var i = 0; i < users.length; i++) {
	        var user = users[i];
	        var fila = document.createElement("tr");

	        var celdaId = document.createElement("td");
	        celdaId.textContent = user.id;

	        var celdaNombre = document.createElement("td");
	        celdaNombre.textContent = user.nombre;

	        var celdaPrecio = document.createElement("td");
	        celdaPrecio.textContent = user.precio;

	        var celdaVendedor = document.createElement("td");
	        celdaVendedor.textContent = user.vendedor;

	        var celdaSucursal = document.createElement("td");
	        celdaSucursal.textContent = user.sucursal;

	        fila.appendChild(celdaId);
	        fila.appendChild(celdaNombre);
	        fila.appendChild(celdaPrecio);
	        fila.appendChild(celdaVendedor);
	        fila.appendChild(celdaSucursal);

	        tbody.appendChild(fila);
	      }
	    } else {
	      console.error(users);
	    }
	  };
	  xhr.send();
	}

	get_productsSucursal("Caracas");
  </script>
</body>