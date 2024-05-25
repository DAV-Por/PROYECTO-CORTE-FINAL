package src;

import java.util.HashMap;
import java.util.Map;

public class GestionPedidos {
    private Map<Integer, Pedido> pedidos;

    public GestionPedidos() {
        this.pedidos = new HashMap<>();
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.put(pedido.getIdPedido(), pedido);
    }

    public void enviarPedido(int idPedido) {
        Pedido pedido = this.pedidos.get(idPedido);
        if (pedido != null) {
            pedido.cambiarEstado("enviado");
            System.out.println("El pedido con id: " + idPedido + " ha sido enviado.");
        } else {
            System.out.println("no se encontrooel pedido : " + idPedido);
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