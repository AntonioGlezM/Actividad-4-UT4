package Main;
import pedidoRestaurante.EstadoPedido;
import pedidoRestaurante.Pedido;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("Antonio Gonzalez");

        pedido.agregarArticulo("Pizza", 2, 1500);
        pedido.agregarArticulo("Agua", 1, 800);
        pedido.agregarArticulo("Papas fritas", 2, 600);

        pedido.mostrarResumen();

        pedido.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido.cambiarEstado(EstadoPedido.ENTREGADO);

        pedido.mostrarResumen();
    }
}