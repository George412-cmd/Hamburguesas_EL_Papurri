console.log("listos.js cargado");

let pedidos = [];

function detalleDe(productos) {

  const cuenta = {};
  for (const producto of productos) {
    cuenta[producto.nombre] = (cuenta[producto.nombre] || 0) + 1;
  }

  const partes = [];
  for (const nombre in cuenta) {
    partes.push(cuenta[nombre] + " " + nombre);
  }

  return partes.join(" &middot; ");
}

function hacerListos() {

  let html = "";

  for (const pedido of pedidos) {
    html += `
      <li>
        <article class="pedido pedido--listo">
          <div class="pedido__orden">
            <h2 class="pedido__codigo">${pedido.id}</h2>
            <p class="pedido__detalle">${detalleDe(pedido.productos)}</p>
          </div>

          <p class="pedido__cliente">NC: ${pedido.nombreCliente}</p>

          <a class="boton boton--principal boton--cobrar"
             href="cobro.html" data-id="${pedido.id}">Cobrar</a>
        </article>
      </li>
    `;
  }

  if (html === "") {
    html = `<li class="pedidos__vacio">No hay pedidos listos todavia.</li>`;
  }

  document.querySelector(".pedidos").innerHTML = html;
}

async function cargarListos() {
  // TODO: confirmar si "Listo" ya excluye los cobrados o si hace
  // falta otro filtro aparte una vez que exista el estado de pago
  const respuesta = await fetch("/api/pedidos?estado=Listo");
  pedidos = await respuesta.json();
  hacerListos();
}

document.querySelector(".pedidos").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".boton--cobrar");
  if (!boton) return;

  sessionStorage.setItem("pedidoACobrar", boton.dataset.id);
});

cargarListos();
