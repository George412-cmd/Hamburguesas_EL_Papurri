console.log("formulario.js cargado");

function siguienteNumero() {
  return (Number(sessionStorage.getItem("ultimoNumeroPedido")) || 0) + 1;
}

const editando = JSON.parse(sessionStorage.getItem("pedidoEditando"));

const numeroPedido = editando ? Number(editando.numeroPedido) : siguienteNumero();

document.querySelector("#numeroPedido").value = numeroPedido;

if (editando) {
  document.querySelector("#nombreCliente").value = editando.nombreCliente;
  document.querySelector("#telefono").value      = editando.telefono;

  sessionStorage.removeItem("pedidoEditando");
}

document.querySelector(".formulario").addEventListener("submit", function (evento) {

  evento.preventDefault();


  const formulario = {
    numeroDePedido:   numeroPedido,
    NombreDelCliente: document.querySelector("#nombreCliente").value,
    NumeroDeTelefono: document.querySelector("#telefono").value
  };

  sessionStorage.setItem("formulario", JSON.stringify(formulario));

  const carrito = JSON.parse(sessionStorage.getItem("carrito")) || [];
  const pedidos = JSON.parse(sessionStorage.getItem("pedidos")) || [];

  pedidos.push({
    numeroPedido:  formulario.numeroDePedido,
    nombreCliente: formulario.NombreDelCliente,
    telefono:      formulario.NumeroDeTelefono,
    productos:     carrito
  });

  sessionStorage.setItem("pedidos", JSON.stringify(pedidos));
  sessionStorage.removeItem("carrito");


  if (!editando) {
    sessionStorage.setItem("ultimoNumeroPedido", String(numeroPedido));
  }

  console.log("Pedido " + numeroPedido + " registrado. Van " + pedidos.length + " en la cola.");

  window.location.href = "llegantes.html";
});
