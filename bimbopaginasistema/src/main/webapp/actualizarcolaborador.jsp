<%@ include file="index.jsp" %>

  <div class="container mt-5">
    <h2>Actualizar Colaborador</h2>
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
        <label for="edad">Edad:</label>
        <input type="number" class="form-control" id="edad" required>
      </div>
      <div class="form-group">
        <label for="correo">Correo electrónico:</label>
        <input type="email" class="form-control" id="correo" required>
      </div>
      <button type="submit" onclick="actualizarColaborador(obtenerValor('nombre'), obtenerValor('edad'), obtenerValor('correo'), obtenerValor('id'))" class="btn btn-primary">Enviar</button>
    </form>
  </div>