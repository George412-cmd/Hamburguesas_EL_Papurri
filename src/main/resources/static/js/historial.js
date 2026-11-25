console.log("historial.js cargado");

const pedidos = JSON.parse(sessionStorage.getItem("pedidos")) || [];

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

function hacerHistorial() {

  let html = "";
  let i = 0;

  for (const pedido of pedidos) {


    if (!pedido.cobrado) {
      i++;
      continue;
    }

    const fecha = new Date(pedido.cobradoEn);

    html += `
      <tr>
        <td class="historial__fecha"><time datetime="${fechaISO(fecha)}">${fechaCorta(fecha)}</time></td>
        <td class="historial__horario"><time datetime="${horaCorta(fecha)}">${horaCorta(fecha)}</time></td>
        <th class="historial__pedido" scope="row">${pedido.numeroPedido}</th>
        <td class="historial__precio">$${pedido.total}</td>
        <td class="historial__cliente">${pedido.nombreCliente}</td>
        <td class="historial__ticket">
          <a class="boton boton--ticket" href="ticket.html" data-indice="${i}">Ticket</a>
        </td>
      </tr>
    `;

    i++;
  }


  if (html === "") {
    html = `<tr><td class="historial__vacio" colspan="6">Todavia no hay pedidos cobrados.</td></tr>`;
  }

  document.querySelector(".historial tbody").innerHTML = html;
}

document.querySelector(".historial tbody").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".boton--ticket");
  if (!boton) return;

  sessionStorage.setItem("pedidoACobrar", boton.dataset.indice);
});

hacerHistorial();
