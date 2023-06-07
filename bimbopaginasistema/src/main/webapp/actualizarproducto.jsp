<%@ include file="index.jsp" %>

  <div class="container mt-5">
    <h2>Actualizar Producto</h2>
    <form>
          <div class="form-group">
        <label for="nombre">ID:</label>
        <input type="number" class="form-control" id="id" required>
      </div>
      <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" class="form-control" id="nombre" required>
      </div>
      <div class="form-group">
        <label for="edad">Precio:</label>
        <input type="number" class="form-control" id="precio" required>
      </div>
      <div class="form-group">
        <label for="correo">Vendedor:</label>
        <input type="text" class="form-control" id="vendedor" required>
      </div>
                  <div class="form-group">
        <label for="correo">Sucursal:</label>
        <input type=text class="form-control" id="sucursal" required>
      </div>
      <button type="submit" onclick="actualizarProducto(obtenerValor('nombre'), obtenerValor('precio'), obtenerValor('vendedor'), obtenerValor('id'), obtenerValor('sucursal'))" class="btn btn-primary">Enviar</button>
    </form>
  </div>