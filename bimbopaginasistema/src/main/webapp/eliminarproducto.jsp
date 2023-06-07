<%@ include file="index.jsp" %>

  <div class="container mt-5">
    <h2>Eliminar producto</h2>
    <form>
      <div class="form-group">
        <label for="correo">ID:</label>
        <input type="number" class="form-control" id="id" required>
      </div>
      <button type="submit" onclick="eliminarProducto(obtenerValor('id'))" class="btn btn-primary">Enviar</button>
    </form>
  </div>