public class TiendaControlador {
    private TiendaModelo modelo;
    private TiendaVista vista;

    public TiendaControlador(TiendaModelo modelo, TiendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            switch (opcion) {
                case "1":
                    vista.mostrarProductos(modelo.getProductosDisponibles());
                    break;

                case "2":
                    String nombre = vista.solicitarNombreProducto();
                    Producto prod = modelo.getProductosDisponibles().stream()
                            .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                            .findFirst().orElse(null);

                    if (prod != null) {
                        modelo.getCarrito().agregarProducto(prod);
                        vista.mostrarMensaje(" Producto agregado al carrito.");
                    } else {
                        vista.mostrarMensaje(" No existe ese producto en la tienda.");
                    }
                    break;

                case "3":
                    vista.mostrarProductos(modelo.getCarrito().getProductos());
                    vista.mostrarMensaje("Total: S/ " + modelo.getCarrito().calcularTotal());
                    break;

                case "4":
                    String eliminar = vista.solicitarNombreProducto();
                    modelo.getCarrito().eliminarProducto(eliminar);
                    vista.mostrarMensaje(" Producto eliminado del carrito (si existía).");
                    break;

                case "5":
                    double descuento = vista.solicitarDescuento();
                    double totalDescuento = modelo.aplicarDescuento(modelo.getCarrito().calcularTotal(), descuento);
                    vista.mostrarMensaje(" Total con descuento: S/ " + totalDescuento);
                    break;

                case "6":
                    double envio = modelo.calcularEnvio(modelo.getCarrito().calcularTotal());
                    vista.mostrarMensaje(" Costo de envío: S/ " + envio);
                    break;

                case "7":
                    modelo.realizarCompra();
                    vista.mostrarMensaje(" Compra realizada. El carrito se vació.");
                    break;

                case "8":
                    int num = 1;
                    for (var compra : modelo.getHistorialCompras()) {
                        vista.mostrarMensaje("\n Compra #" + num++);
                        vista.mostrarProductos(compra);
                    }
                    break;

                case "9":
                    String nuevoNombre = vista.solicitarNombreProducto();
                    double nuevoPrecio = vista.solicitarPrecioProducto();
                    modelo.agregarProductoTienda(nuevoNombre, nuevoPrecio);
                    vista.mostrarMensaje(" Producto agregado a la tienda.");
                    break;

                case "10":
                    vista.mostrarMensaje(" Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("10"));

        vista.cerrarScanner();
    }
}
