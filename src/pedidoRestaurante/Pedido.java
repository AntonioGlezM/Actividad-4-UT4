package pedidoRestaurante;
public class Pedido {

    private static int contadorPedidos = 1;

    private int idPedido;
    private String nombreCliente;
    private Articulo[] articulos;
    private int cantidadArticulos;
    private EstadoPedido estado;

    public Pedido(String nombreCliente) {
        this.idPedido = contadorPedidos++;
        this.nombreCliente = nombreCliente;
        this.articulos = new Articulo[5];
        this.cantidadArticulos = 0;
        this.estado = EstadoPedido.EN_PREPARACION;
    }

    public void agregarArticulo(String nombre, int cantidad, double precioUnitario) {
        if (cantidadArticulos >= 5) {
            System.out.println("No se pueden agregar más de 5 artículos.");
            return;
        }

        articulos[cantidadArticulos] = new Articulo(nombre, cantidad, precioUnitario);
        cantidadArticulos++;
    }

    public double calcularTotal() {
        double total = 0;

        for (int i = 0; i < cantidadArticulos; i++) {
            total += articulos[i].getSubtotal();
        }

        return total;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        switch (estado) {
            case PEDIDO_RECIBIDO:
                if (nuevoEstado == EstadoPedido.EN_PREPARACION ||nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGAR || nuevoEstado == EstadoPedido.ENTREGADO) {
                    estado = nuevoEstado;
                } else {
                    System.out.println("No se puede retroceder el estado del pedido.");
                }
                break;

            case EN_PREPARACION:
                if (nuevoEstado == EstadoPedido.LISTO_PARA_ENTREGAR || nuevoEstado == EstadoPedido.ENTREGADO) {
                    estado = nuevoEstado;
                } else {
                    System.out.println("No se puede retroceder el estado del pedido.");
                }
                break;

            case LISTO_PARA_ENTREGAR:
                if (nuevoEstado == EstadoPedido.ENTREGADO) {
                    estado = nuevoEstado;
                } else {
                    System.out.println("No se puede retroceder el estado del pedido.");
                }
                break;

            case ENTREGADO:
                System.out.println("No se puede cambiar, el pedido ya fue entregado.");
                break;
        }
    }

}
