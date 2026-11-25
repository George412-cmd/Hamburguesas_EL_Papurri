console.log("listos.js cargado");




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




function hacerListos() {

  let html = "";
  let i = 0;

  for (const pedido of pedidos) {

    
    
    const terminado = pedido.listoParrilla && pedido.listoCocina && !pedido.cobrado;

    if (!terminado) {
      i++;
      continue;
    }

    
    html += `
      <li>
        <article class="pedido pedido--listo">
          <div class="pedido__orden">
            <h2 class="pedido__codigo">${pedido.numeroPedido}</h2>
            <p class="pedido__detalle">${detalleDe(pedido.productos)}</p>
          </div>

          <p class="pedido__cliente">NC: ${pedido.nombreCliente}</p>

          <a class="boton boton--principal boton--cobrar"
             href="cobro.html" data-indice="${i}">Cobrar</a>
        </article>
      </li>
    `;

    i++;
  }

  
  if (html === "") {
    html = `<li class="pedidos__vacio">No hay pedidos listos todavia.</li>`;
  }

  document.querySelector(".pedidos").innerHTML = html;
}




document.querySelector(".pedidos").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".boton--cobrar");
  if (!boton) return;

  sessionStorage.setItem("pedidoACobrar", boton.dataset.indice);
});


hacerListos();
