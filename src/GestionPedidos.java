
import java.util.HashMap;
import java.util.Map;

public class GestionPedidos {
    private Map<Integer, Pedido> pedidos;

    public GestionPedidos() {
        this.pedidos = new HashMap<>();
        Pedido p1 = new Pedido(1);
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new NullPointerException("El pedido no puede ser nulo");
        }
        if (pedidos.containsKey(pedido.getIdPedido())) {
            throw new IllegalArgumentException("Ya existe un pedido con el ID " + pedido.getIdPedido());
        }
        pedidos.put(pedido.getIdPedido(), pedido);
        System.out.println("Pedido agregado con éxito. ID: " + pedido.getIdPedido());
    }

    public void enviarPedido(int idPedido) {
        Pedido pedido = new Pedido(1);
        if (pedido != null) {
            pedido.cambiarEstado("enviado");
            System.out.println("El pedido con id: " + idPedido + " ha sido enviado.");
        } else {
            System.out.println("no se encontroo el pedido : " + idPedido);
        }
    }

    public void entregarPedido(int idPedido) {
        Pedido pedido = this.pedidos.get(idPedido);
        if (pedido != null) {
            pedido.cambiarEstado("entregado");
            System.out.println("el pedido con id: " + idPedido + " ha sido entregado.");
        } else {
            System.out.println("no se encontro el pedido : " + idPedido);
        }
    }

    public void devolverPedido(int idPedido) {
        Pedido pedido = this.pedidos.get(idPedido);
        if (pedido != null) {
            pedido.cambiarEstado("devuelto");
            System.out.println("el pedido con id: " + idPedido + " ha sido devuelto.");
        } else {
            System.out.println("no se encontro el pedido : " + idPedido);
        }
    }

    public Map<Integer, Pedido> getPedidos() {
        return pedidos;

    }
}