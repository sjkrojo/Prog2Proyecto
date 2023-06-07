<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Sistema de Manejo de Información Bimbo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
  <!-- Barra de navegación con el logo de Bimbo -->
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
      <img src="https://imgur.com/j4zG0zR.png" width="30" height="30" class="d-inline-block align-top"
        alt="Logo de Bimbo">
      Sistema de Manejo de Información Bimbo
    </a>
  </nav>

  <!-- Contenedor principal -->
  <div class="container mt-4">
    <h1 class="text-center">Opciones</h1>
    <div class="row mt-4">
      <div class="col-sm-6">
        <button id="agregarproducto" type="button" onclick="change_page('agregarproducto.jsp')"  class="btn btn-primary">Agregar producto</button>
        <button id="actualizarcolaborador" type="button" onclick="change_page('eliminarproducto.jsp')" class="btn btn-danger">Eliminar producto</button>
        <button id="actualizarcolaborador" type="button" onclick="change_page('actualizarproducto.jsp')" class="btn btn-warning">Actualizar producto</button>
        <button id="seleccionarinventario" type="button" onclick="change_page('seleccionarinventario.jsp')"  class="btn btn-info">Mostrar
          productos</button>
      </div>
      <div class="col-sm-6">
        <button id="generarpdf" type="button" onclick="generarPDF()" class="btn btn-success">Generar PDF</button>
        <button class="btn btn-secondary">Calcular costo inventario</button>
        <button id="actualizarcolaborador" type="button" onclick="change_page('actualizarcolaborador.jsp')" class="btn btn-warning"button class="btn btn-primary">Actualizar colaborador</button>
        <button id="agregarcolaborador" type="button" onclick="change_page('agregarcolaborador.jsp')" class="btn btn-info"button class="btn btn-primary">Agregar colaborador</button>
        <button id="eliminarcolaborador" type="button" onclick="change_page('eliminarcolaborador.jsp')" class="btn btn-danger">Eliminar colaborador</button>
        <button id="mostrarcolaboradores" type="button" onclick="change_page('mostrarColaboradores.jsp')" class="btn btn-info">Mostrar
          Colaboradores</button>
      </div>
    </div>
  </div>

  <script src="script.js"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>