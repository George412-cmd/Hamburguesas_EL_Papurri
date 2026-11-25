console.log("llegantes.js cargado");

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

function hacerPedidos() {

  let html = "";

  for (const pedido of pedidos) {

    const marcaParrilla = pedido.confirmadoChef     ? "checked" : "";
    const marcaCocina   = pedido.confirmadoCocinero ? "checked" : "";

    html += `
      <li>
        <article class="pedido">
          <div class="pedido__orden">
            <h2 class="pedido__codigo">${pedido.id}</h2>
            <p class="pedido__detalle">${detalleDe(pedido.productos)}</p>
          </div>

          <p class="pedido__cliente">NC: ${pedido.nombreCliente}</p>

          <fieldset class="estado">
            <legend class="estado__titulo">Estado</legend>

            <div class="estado__opcion">
              <input type="checkbox" id="parrilla-${pedido.id}" data-id="${pedido.id}"
                     data-tipo="parrilla" ${marcaParrilla}>
              <label for="parrilla-${pedido.id}">Listo parrilla</label>
            </div>

            <div class="estado__opcion">
              <input type="checkbox" id="cocina-${pedido.id}" data-id="${pedido.id}"
                     data-tipo="cocina" ${marcaCocina}>
              <label for="cocina-${pedido.id}">Listo cocina</label>
            </div>
          </fieldset>

          <div class="pedido__acciones">
            <a class="boton boton--editar" href="index.html"
               data-id="${pedido.id}">Editar</a>
            <button class="boton boton--eliminar" type="button"
                    data-id="${pedido.id}">Eliminar</button>
          </div>
        </article>
      </li>
    `;
  }

  if (pedidos.length === 0) {
    html = `<li class="pedidos__vacio">No hay pedidos en la cola.</li>`;
  }

  document.querySelector(".pedidos").innerHTML = html;
}

async function cargarPedidos() {
  const respuesta = await fetch("/api/pedidos?estado=EnEspera");
  pedidos = await respuesta.json();
  hacerPedidos();
}

document.querySelector(".pedidos").addEventListener("click", async function (evento) {

  const boton = evento.target.closest(".boton--eliminar");
  if (!boton) return;

  const id     = Number(boton.dataset.id);
  const pedido = pedidos.find(p => p.id === id);

  if (!confirm("Eliminar el pedido de " + pedido.nombreCliente + "?")) return;

  await fetch("/api/pedidos/" + id, { method: "DELETE" });

  pedidos = pedidos.filter(p => p.id !== id);
  hacerPedidos();
});

document.querySelector(".pedidos").addEventListener("change", async function (evento) {

  const casilla = evento.target.closest('input[type="checkbox"]');
  if (!casilla) return;

  const id     = Number(casilla.dataset.id);
  const pedido = pedidos.find(p => p.id === id);

  // TODO: confirmar los nombres de endpoint con el backend
  // (PedidoRepository ya tiene confirmarChef/confirmarCocinero escritos)
  const endpoint = casilla.dataset.tipo === "parrilla" ? "confirmar-chef" : "confirmar-cocinero";
  await fetch("/api/pedidos/" + id + "/" + endpoint, { method: "PATCH" });

  if (casilla.dataset.tipo === "parrilla") {
    pedido.confirmadoChef = casilla.checked;
  } else {
    pedido.confirmadoCocinero = casilla.checked;
  }

  if (pedido.confirmadoChef && pedido.confirmadoCocinero) {
    console.log("Pedido " + pedido.id + " listo: pasa a listos.html");
    pedidos = pedidos.filter(p => p.id !== id);
    hacerPedidos();
  }
});

document.querySelector(".pedidos").addEventListener("click", async function (evento) {

  const boton = evento.target.closest(".boton--editar");
  if (!boton) return;

  const id     = Number(boton.dataset.id);
  const pedido = pedidos.find(p => p.id === id);

  sessionStorage.setItem("carrito", JSON.stringify(pedido.productos));

  sessionStorage.setItem("pedidoEditando", JSON.stringify({
    numeroPedido:  pedido.id,
    nombreCliente: pedido.nombreCliente,
    telefono:      pedido.telefonoCliente
  }));

  // TODO: decidir que debe hacer "editar" contra el backend real.
  // Aqui solo se borra (igual que antes se sacaba del array); falta
  // confirmar si eso es lo correcto o si deberia ser un PUT/PATCH.
  await fetch("/api/pedidos/" + id, { method: "DELETE" });
});

cargarPedidos();
