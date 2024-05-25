package src;

import java.util.Map;

public class FuncionalidadInforme {
    private GestionPedidos gestionPedidos;
    private Inventario inventario;

    public FuncionalidadInforme(GestionPedidos gestionPedidos, Inventario inventario) {
        this.gestionPedidos = gestionPedidos;
        this.inventario = inventario;
    }


    public void generarInformeVentas() {
        System.out.println("Informe de Ventas:");
        double totalVentas = 0.0;

        for (Pedido pedido : gestionPedidos.getPedidos().values()) {
            double totalPedido = 0.0;
            for (Producto producto : pedido.getProductosSolicitados()) {
                totalPedido += producto.getPrecio() * producto.getStock();
            }
            totalVentas += totalPedido;
            System.out.println("Pedido ID: " + pedido.getIdPedido() + "Estado: " + pedido.getEstado() + "Fecha y Hora: " + pedido.getFechaHora() + "Total Pedido: " + totalPedido);
        }

        System.out.println("total ventas: " + totalVentas);
    }
    public void generarInformeInventario() {
        System.out.println("Informe de Inventario:");
        for (Producto producto : inventario.Productos.values()) {
            System.out.println("Nombre: " + producto.getNombre() + "ID: " + producto.getId() + "Precio: " + producto.getPrecio() + "Stock: " + producto.getStock() + "Descripción: " + producto.getDescripcion());
        }
    }
}