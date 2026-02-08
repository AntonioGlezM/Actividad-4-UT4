package pedidoRestaurante;

public class Pedido {
   private static int contadorPedidos = 1;
   private int idPedido;
   private String nombreCliente;
   private Articulo[] articulos;
   private int cantidadArticulos;
   private EstadoPedido estado;

   public Pedido(String var1) {
      this.idPedido = contadorPedidos++;
      this.nombreCliente = var1;
      this.articulos = new Articulo[5];
      this.cantidadArticulos = 0;
      this.estado = EstadoPedido.EN_PREPARACION;
   }

   public void agregarArticulo(String var1, int var2, double var3) {
      if (this.cantidadArticulos >= 5) {
         System.out.println("No se pueden agregar más de 5 artículos.");
      } else {
         this.articulos[this.cantidadArticulos] = new Articulo(var1, var2, var3);
         ++this.cantidadArticulos;
      }
   }

   public double calcularTotal() {
      double var1 = 0.0;

      for(int var3 = 0; var3 < this.cantidadArticulos; ++var3) {
         var1 += this.articulos[var3].getSubtotal();
      }

      return var1;
   }

   public void cambiarEstado(EstadoPedido var1) {
      switch (this.estado) {
         case EN_PREPARACION:
            if (var1 != EstadoPedido.LISTO_PARA_ENTREGAR && var1 != EstadoPedido.ENTREGADO) {
               System.out.println("No se puede retroceder el estado del pedido.");
            } else {
               this.estado = var1;
            }
            break;
         case LISTO_PARA_ENTREGAR:
            if (var1 == EstadoPedido.ENTREGADO) {
               this.estado = var1;
            } else {
               System.out.println("No se puede retroceder el estado del pedido.");
            }
            break;
         case ENTREGADO:
            System.out.println("No se puede cambiar, el pedido ya fue entregado.");
      }

   }
}
