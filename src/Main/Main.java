package Main;
import pedidoRestaurante.EstadoPedido;
import pedidoRestaurante.Pedido;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("Antonio Gonzalez");

        pedido.agregarArticulo("Pizza", 2, 10);
        pedido.agregarArticulo("Agua", 1, 1);
        pedido.agregarArticulo("Papas fritas", 2, 6);

        pedido.mostrarResumen();
        System.out.println("--------------------------");

        pedido.cambiarEstado(EstadoPedido.EN_PREPARACION);

        pedido.mostrarResumen();
        System.out.println("--------------------------");

        pedido.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);

        pedido.mostrarResumen();
        System.out.println("--------------------------");

        pedido.cambiarEstado(EstadoPedido.ENTREGADO);

        pedido.mostrarResumen();
        System.out.println("--------------------------");
    }
}