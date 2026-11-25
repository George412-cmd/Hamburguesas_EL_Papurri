console.log("cobro.js cargado");







function precioDelPedido() {

  const pedidos = JSON.parse(sessionStorage.getItem("pedidos")) || [];

  
  if (pedidos.length === 0) return 0;

  
  const indice = Number(sessionStorage.getItem("pedidoACobrar")) || 0;
  const pedido = pedidos[indice];

  
  if (!pedido) return 0;

  
  let suma = 0;
  for (const producto of pedido.productos) {
    suma += producto.precio;
  }

  return suma;
}

const precio = precioDelPedido();




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




document.querySelector(".pestanas").addEventListener("submit", function (evento) {

  evento.preventDefault();

  
  const panel      = evento.target.closest(".pestanas__panel");
  const esEfectivo = (panel.id === "panel-efectivo");

  const extra = esEfectivo
    ? Number(document.querySelector("#extraEfectivo").value)
    : Number(document.querySelector("#extraTransferencia").value);

  const pedidos = JSON.parse(sessionStorage.getItem("pedidos")) || [];
  const indice  = Number(sessionStorage.getItem("pedidoACobrar")) || 0;
  const pedido  = pedidos[indice];

  if (!pedido) return;

  
  pedido.cobrado     = true;
  pedido.formaDePago = esEfectivo ? "Efectivo" : "Transferencia";
  pedido.precioExtra = extra;
  pedido.total       = precio + extra;

  
  pedido.cobradoEn = new Date().toISOString();

  sessionStorage.setItem("pedidos", JSON.stringify(pedidos));

  console.log("Cobrado el pedido " + pedido.numeroPedido + ": $" + pedido.total);

  window.location.href = "ticket.html";
});
