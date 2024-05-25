
import java.util.Map;

public class Informe {


    private GestionPedidos gestionPedidos;
    private Inventario inventario;


    public Informe(GestionPedidos gestionPedidos, Inventario inventario) {
        this.gestionPedidos = gestionPedidos;
        this.inventario = inventario;
    }

    public void generarInformePedidos() {
        System.out.println("Informe de Pedidos:");
        for (Pedido pedido : gestionPedidos.getPedidos().values()) {
            pedido.mostrarInformacionPedido();

        }
    }

    public void generarInformeInventario() {
        System.out.println("Informe de Inventario:");
        inventario.mostrarInventario();
    }

}
