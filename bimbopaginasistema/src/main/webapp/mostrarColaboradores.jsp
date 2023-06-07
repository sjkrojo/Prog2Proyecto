<%@ include file="index.jsp" %>

<body>
  <div class="container">
    <h1>Tabla de Colaboradores</h1>
    <table id="tabla-colaboradores" class="table table-striped">
      <thead class="thead-dark">
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Edad</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
  </div>

  <script>
    function get_products() {
      var url = "http://localhost:8081/bimboapi/colaborador";
      var xhr = new XMLHttpRequest();
      xhr.open('GET', url, true);
      xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == 302) {
          var users = JSON.parse(xhr.responseText);
          // Obtener referencia a la tabla
          var tabla = document.getElementById("tabla-colaboradores");

          // Obtener referencia al cuerpo de la tabla
          var tbody = tabla.getElementsByTagName("tbody")[0];

          // Limpiar contenido existente en el cuerpo de la tabla
          tbody.innerHTML = "";

          // Recorrer los datos y generar filas de la tabla
          for (var i = 0; i < users.length; i++) {
            var user = users[i];

            // Crear una nueva fila
            var fila = document.createElement("tr");

            // Crear las celdas de la fila
            var celdaId = document.createElement("td");
            celdaId.textContent = user.id;

            var celdaNombre = document.createElement("td");
            celdaNombre.textContent = user.nombre;

            var celdaEdad = document.createElement("td");
            celdaEdad.textContent = user.edad;

            var celdaEmail = document.createElement("td");
            celdaEmail.textContent = user.email;

            // Agregar las celdas a la fila
            fila.appendChild(celdaId);
            fila.appendChild(celdaNombre);
            fila.appendChild(celdaEdad);
            fila.appendChild(celdaEmail);

            // Agregar la fila al cuerpo de la tabla
            tbody.appendChild(fila);
          }
        } else {
          console.error(users);
        }
      };
      xhr.send();
    }

    // Llamar a la función para obtener los productos y generar la tabla
    get_products();
  </script>
</body>