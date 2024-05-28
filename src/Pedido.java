import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private int idPedido;
    private List<Producto> productosSolicitados;
    private String estado;
    private Date fechaHora;

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.productosSolicitados = new ArrayList<>();
        this.estado = "pendiente";
        this.fechaHora = new Date();
    }

    public Pedido() {

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        if (idPedido <= 0) {
            throw new IllegalArgumentException("El ID del pedido debe ser mayor que cero");
        }
        this.idPedido = idPedido;
    }

    public List<Producto> getProductosSolicitados() {
        return productosSolicitados;
    }

    public void setProductosSolicitados(List<Producto> productosSolicitados) {
        if (productosSolicitados == null) {
            throw new NullPointerException("La lista de productos solicitados no puede ser nula");
        }
        this.productosSolicitados = productosSolicitados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del pedido no puede ser nulo o vacío");
        }
        this.estado = estado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        if (fechaHora == null) {
            throw new NullPointerException("La fecha y hora del pedido no puede ser nula");
        }
        this.fechaHora = fechaHora;
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new NullPointerException("El producto no puede ser nulo");
        }
        this.productosSolicitados.add(producto);
    }

    public void cambiarEstado(String nuevoEstado) {
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException("El nuevo estado del pedido no puede ser nulo o vacío");
        }
        this.estado = nuevoEstado;
    }

    public void mostrarInformacionPedido() {
        System.out.println("ID pedido: " + idPedido);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Productos solicitados:");
        if (productosSolicitados == null || productosSolicitados.isEmpty()) {
            System.out.println("No se han solicitado productos");
        } else {
            for (Producto producto : productosSolicitados) {
                System.out.println(" " + producto.getNombre() + " id: " + producto.getId() + " ");
            }
        }

    }
}