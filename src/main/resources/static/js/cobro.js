console.log("cobro.js cargado");

let precio   = 0;
let pedidoId = null;

async function cargarPedido() {

  pedidoId = Number(sessionStorage.getItem("pedidoACobrar")) || 0;

  const respuesta = await fetch("/api/pedidos/" + pedidoId);
  const pedido    = await respuesta.json();

  // TODO: confirmar que el backend expone "subtotal" ya calculado
  precio = pedido.subtotal;

  recalcular();
}

const barra   = document.querySelector(".pestanas__barra");
const botones = document.querySelectorAll(".pestanas__btn");
const paneles = document.querySelectorAll(".pestanas__panel");

barra.addEventListener("click", function (evento) {

  const boton = evento.target.closest(".pestanas__btn");
  if (!boton) return;

  for (const b of botones) {
    b.setAttribute("aria-selected", "false");
  }
  boton.setAttribute("aria-selected", "true");

  for (const p of paneles) {
    p.hidden = true;
  }

  const idPanel = boton.getAttribute("aria-controls");
  document.querySelector("#" + idPanel).hidden = false;
});

function recalcular() {

  const extraTransferencia = Number(document.querySelector("#extraTransferencia").value);

  document.querySelector('output[name="precio"]').textContent = "$" + precio;
  document.querySelector('output[name="totalTransferencia"]').textContent =
    "$" + (precio + extraTransferencia);

  const extraEfectivo = Number(document.querySelector("#extraEfectivo").value);
  const pago          = Number(document.querySelector("#pago").value);

  const totalEfectivo = precio + extraEfectivo;
  const devuelve      = pago - totalEfectivo;

  document.querySelector('output[name="totalEfectivo"]').textContent = "$" + totalEfectivo;

  if (devuelve < 0) {
    document.querySelector('output[name="devuelve"]').textContent =
      "Faltan $" + (totalEfectivo - pago);
  } else {
    document.querySelector('output[name="devuelve"]').textContent = "$" + devuelve;
  }
}

document.querySelector(".pestanas").addEventListener("input", recalcular);

recalcular();
cargarPedido();

document.querySelector(".pestanas").addEventListener("submit", async function (evento) {

  evento.preventDefault();

  const panel      = evento.target.closest(".pestanas__panel");
  const esEfectivo = (panel.id === "panel-efectivo");

  const extra = esEfectivo
    ? Number(document.querySelector("#extraEfectivo").value)
    : Number(document.querySelector("#extraTransferencia").value);

  // TODO: confirmar el endpoint y el body exacto que espera el backend para cobrar
  await fetch("/api/pedidos/" + pedidoId + "/cobrar", {
    method: "PATCH",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      formaDePago: esEfectivo ? "Efectivo" : "Transferencia",
      precioExtra: extra
    })
  });

  console.log("Cobrado el pedido " + pedidoId);

  window.location.href = "ticket.html";
});
