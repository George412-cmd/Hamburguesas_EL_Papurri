console.log("formulario.js cargado");

const editando = JSON.parse(sessionStorage.getItem("pedidoEditando"));

if (editando) {
  document.querySelector("#numeroPedido").value  = editando.numeroPedido;
  document.querySelector("#nombreCliente").value = editando.nombreCliente;
  document.querySelector("#telefono").value      = editando.telefono;

  sessionStorage.removeItem("pedidoEditando");
}

document.querySelector(".formulario").addEventListener("submit", async function (evento) {

  evento.preventDefault();

  const carrito = JSON.parse(sessionStorage.getItem("carrito")) || [];

  // TODO: confirmar con el backend la forma exacta de "productos" en el body
  const respuesta = await fetch("/api/pedidos", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      nombreCliente:   document.querySelector("#nombreCliente").value,
      telefonoCliente: document.querySelector("#telefono").value,
      productos:       carrito
    })
  });

  const pedidoCreado = await respuesta.json();

  sessionStorage.removeItem("carrito");

  console.log("Pedido creado:", pedidoCreado);

  window.location.href = "llegantes.html";
});
