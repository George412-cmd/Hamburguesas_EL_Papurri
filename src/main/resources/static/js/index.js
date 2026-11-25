function hacerSeccion(productos, selector) {

  let html = "";

  for (const producto of productos) {
    html += `
      <li>
        <button class="producto" type="button"
                data-nombre="${producto.nombreCompleto}"
                data-precio="${producto.precio}"
                data-imagen="${producto.imagen}">
          <img class="producto__img" src="${producto.imagen}" alt="${producto.alt}">
          <span class="producto__nombre">${producto.nombre}</span>
          <span class="producto__precio">$${producto.precio}</span>
        </button>
      </li>
    `;
  }

  document.querySelector(selector).innerHTML = html;
}

hacerSeccion(hamburguesas, "#hamburguesas .productos");
hacerSeccion(combos,       "#combos .productos");
hacerSeccion(papas,        "#papas .productos");
hacerSeccion(aguas,        "#aguas .productos");


const carrito = JSON.parse(sessionStorage.getItem("carrito")) || [];

function hacerCarrito() {

  let html = "";
  let total = 0;
  let i = 0;

  for (const item of carrito) {
    html += `
      <li class="carrito__item">
        <img class="carrito__img" src="${item.imagen}" alt="">
        <div class="diver">
          <span class="carrito__nombre">${item.nombre}</span>
          <span class="carrito__precio">$${item.precio}</span>
        </div>
        <button class="carrito__quitar" type="button"
                data-indice="${i}"
                aria-label="Quitar ${item.nombre} del carrito">&times;</button>
      </li>
    `;

    total += item.precio;
    i++;
  }

  document.querySelector(".carrito__lista").innerHTML = html;
  document.querySelector(".carrito__total strong").textContent = "$" + total;

  const btn = document.querySelector("#btnContinuar");
  btn.disabled = (carrito.length === 0);

  sessionStorage.setItem("carrito", JSON.stringify(carrito));
}

document.querySelector(".catalogo").addEventListener("click", function (evento) {

  const tarjeta = evento.target.closest(".producto");
  if (!tarjeta) return;

  carrito.push({
    nombre: tarjeta.dataset.nombre,
    precio: Number(tarjeta.dataset.precio),
    imagen: tarjeta.dataset.imagen
  });

  hacerCarrito();
});

document.querySelector(".carrito__lista").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".carrito__quitar");
  if (!boton) return;

  const indice = Number(boton.dataset.indice);

  carrito.splice(indice, 1);
  hacerCarrito();
});

document.querySelector("#btnContinuar").addEventListener("click", function () {
  window.location.href = "formulario.html";
});

hacerCarrito();




document.querySelector(".secciones__lista").addEventListener("click", function (evento) {

  const boton = evento.target.closest(".secciones__btn");
  if (!boton) return;

  
  document.querySelector("#" + boton.dataset.seccion)
          .scrollIntoView({ behavior: "smooth", block: "start" });

  
  for (const b of document.querySelectorAll(".secciones__btn")) {
    b.setAttribute("aria-current", "false");
  }
  boton.setAttribute("aria-current", "true");
});
