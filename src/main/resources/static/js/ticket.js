const pedidos = JSON.parse(sessionStorage.getItem("pedidos")) || [];
const indice  = Number(sessionStorage.getItem("pedidoACobrar")) || 0;
const pedido  = pedidos[indice];


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

function precioProductos(productos) {
  let suma = 0;
  for (const producto of productos) {
    suma += producto.precio;
  }
  return suma;
}


if (!pedido) {
                  
  document.querySelector(".ticket__nombreCliente").textContent = "Ticket no encontrado";
  document.querySelector(".ticket__datos").innerHTML =
    "<dd>No hay ningun pedido para mostrar.</dd>";

} else {

  document.querySelector(".ticket__nombreCliente").textContent = "Ticket de: " + pedido.nombreCliente;

  const fecha = new Date(pedido.cobradoEn);

  document.querySelector(".contenidof time").textContent = fechaCorta(fecha);
  document.querySelector(".contenidof time").setAttribute("datetime", fechaISO(fecha));

  document.querySelector(".contenidoh time").textContent = horaCorta(fecha);
  document.querySelector(".contenidoh time").setAttribute("datetime", horaCorta(fecha));

  document.querySelector(".contenidon").textContent   = pedido.numeroPedido;
  document.querySelector(".contenidonom").textContent = pedido.nombreCliente;

                 
  document.querySelector(".ticket__productos").innerHTML = detalleAgrupado(pedido.productos);

  document.querySelector(".contenidopt").textContent = "$" + precioProductos(pedido.productos);
  document.querySelector(".contenidope").textContent = "$" + pedido.precioExtra;
  document.querySelector(".tp strong").textContent    = "$" + pedido.total;
}