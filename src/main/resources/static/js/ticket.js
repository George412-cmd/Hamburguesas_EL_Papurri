console.log("ticket.js cargado");

function dosDigitos(n) {
  return String(n).padStart(2, "0");
}

function fechaISO(d) {
  return d.getFullYear() + "-" + dosDigitos(d.getMonth() + 1) + "-" + dosDigitos(d.getDate());
}

function fechaCorta(d) {
  return d.getDate() + "/" + (d.getMonth() + 1) + "/" + String(d.getFullYear()).slice(-2);
}

function horaCorta(d) {
  return dosDigitos(d.getHours()) + ":" + dosDigitos(d.getMinutes());
}

function detalleAgrupado(productos) {

  const cuenta = {};
  for (const producto of productos) {
    cuenta[producto.nombre] = (cuenta[producto.nombre] || 0) + 1;
  }

  let html = "";
  for (const nombre in cuenta) {
    html += `<li>${cuenta[nombre]} ${nombre}</li>`;
  }

  return html;
}

async function cargarTicket() {

  const id = Number(sessionStorage.getItem("pedidoACobrar")) || 0;

  const respuesta = await fetch("/api/pedidos/" + id);

  if (!respuesta.ok) {
    document.querySelector(".ticket__nombreCliente").textContent = "Ticket no encontrado";
    document.querySelector(".ticket__datos").innerHTML =
      "<dd>No hay ningun pedido para mostrar.</dd>";
    return;
  }

  const pedido = await respuesta.json();

  document.querySelector(".ticket__nombreCliente").textContent = "Ticket de: " + pedido.nombreCliente;

  // TODO: confirmar el campo real de fecha de cobro (se asume fechaListo)
  const fecha = new Date(pedido.fechaListo);

  document.querySelector(".contenidof time").textContent = fechaCorta(fecha);
  document.querySelector(".contenidof time").setAttribute("datetime", fechaISO(fecha));

  document.querySelector(".contenidoh time").textContent = horaCorta(fecha);
  document.querySelector(".contenidoh time").setAttribute("datetime", horaCorta(fecha));

  document.querySelector(".contenidon").textContent   = pedido.id;
  document.querySelector(".contenidonom").textContent = pedido.nombreCliente;

  document.querySelector(".ticket__productos").innerHTML = detalleAgrupado(pedido.productos);

  // TODO: confirmar que el backend expone subtotal/extras ya calculados
  document.querySelector(".contenidopt").textContent = "$" + pedido.subtotal;
  document.querySelector(".contenidope").textContent = "$" + pedido.extras;
  document.querySelector(".tp strong").textContent    = "$" + pedido.total;
}

cargarTicket();
