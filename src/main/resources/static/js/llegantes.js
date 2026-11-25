console.log("llegantes.js cargado");




const pedidos = JSON.parse(sessionStorage.getItem("pedidos")) || [];




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
  let i = 0;

  for (const pedido of pedidos) {

    
    if ((pedido.listoParrilla && pedido.listoCocina) || pedido.cobrado) {
      i++;
      continue;
    }

    

    
    const marcaParrilla = pedido.listoParrilla ? "checked" : "";
    const marcaCocina   = pedido.listoCocina   ? "checked" : "";

    html += `
      <li>
        <article class="pedido">
          <div class="pedido__orden">
            <h2 class="pedido__codigo">${pedido.numeroPedido}</h2>
            <p class="pedido__detalle">${detalleDe(pedido.productos)}</p>
          </div>

          <p class="pedido__cliente">NC: ${pedido.nombreCliente}</p>

          <fieldset class="estado">
            <legend class="estado__titulo">Estado</legend>

            <div class="estado__opcion">
              <input type="checkbox" id="parrilla-${i}" data-indice="${i}"
                     data-tipo="parrilla" ${marcaParrilla}>
              <label for="parrilla-${i}">Listo parrilla</label>
            </div>

            <div class="estado__opcion">
              <input type="checkbox" id="cocina-${i}" data-indice="${i}"
                     data-tipo="cocina" ${marcaCocina}>
              <label for="cocina-${i}">Listo cocina</label>
            </div>
          </fieldset>

          <div class="pedido__acciones">
            <a class="boton boton--editar" href="index.html"
               data-indice="${i}">Editar</a>
            <button class="boton boton--eliminar" type="button"
                    data-indice="${i}">Eliminar</button>
          </div>
        </article>
      </li>
    `;

    i++;
  }

  
  if (pedidos.length === 0) {
    html = `<li class="pedidos__vacio">No hay pedidos en la cola.</li>`;
  }

  document.querySelector(".pedidos").innerHTML = html;

  
  sessionStorage.setItem("pedidos", JSON.stringify(pedidos));
}




document.querySelector(".pedidos").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".boton--eliminar");
  if (!boton) return;

  const indice = Number(boton.dataset.indice);

  
  
  if (!confirm("Eliminar el pedido de " + pedidos[indice].nombreCliente + "?")) return;

  pedidos.splice(indice, 1);
  hacerPedidos();
});




document.querySelector(".pedidos").addEventListener("change", function (evento) {

  const casilla = evento.target.closest('input[type="checkbox"]');
  if (!casilla) return;

  const indice = Number(casilla.dataset.indice);

  if (casilla.dataset.tipo === "parrilla") {
    pedidos[indice].listoParrilla = casilla.checked;
  } else {
    pedidos[indice].listoCocina = casilla.checked;
  }

  sessionStorage.setItem("pedidos", JSON.stringify(pedidos));

  
  if (pedidos[indice].listoParrilla && pedidos[indice].listoCocina) {
    console.log("Pedido " + pedidos[indice].numeroPedido + " listo: pasa a listos.html");
    hacerPedidos();
  }
});


hacerPedidos();




document.querySelector(".pedidos").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".boton--editar");
  if (!boton) return;

  const indice = Number(boton.dataset.indice);
  const pedido = pedidos[indice];

  
  sessionStorage.setItem("carrito", JSON.stringify(pedido.productos));

  
  sessionStorage.setItem("pedidoEditando", JSON.stringify({
    numeroPedido:  pedido.numeroPedido,
    nombreCliente: pedido.nombreCliente,
    telefono:      pedido.telefono
  }));

  
  pedidos.splice(indice, 1);
  sessionStorage.setItem("pedidos", JSON.stringify(pedidos));
});
