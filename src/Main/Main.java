import pedidoRestaurante.EstadoPedido;
import pedidoRestaurante.Pedido;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("Juan Pérez");

        pedido.agregarArticulo("Hamburguesa", 2, 1500);
        pedido.agregarArticulo("Papas fritas", 1, 800);
        pedido.agregarArticulo("Gaseosa", 2, 600);

        pedido.mostrarResumen();

        pedido.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido.cambiarEstado(EstadoPedido.ENTREGADO);

        pedido.mostrarResumen();
    }
}