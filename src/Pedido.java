package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    //ola
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

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Producto> getProductosSolicitados() {
        return productosSolicitados;
    }

    public void setProductosSolicitados(List<Producto> productosSolicitados) {
        this.productosSolicitados = productosSolicitados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }


    public void agregarProducto(Producto producto) {
        this.productosSolicitados.add(producto);
    }


    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }


    public void mostrarInformacionPedido() {
        System.out.println("id pedido: " + idPedido);
        System.out.println("estado: " + estado);
        System.out.println("fecha y hora: " + fechaHora);
        System.out.println("productos solicitados:");
        for (Producto producto : productosSolicitados) {
            System.out.println(" " + producto.getNombre() + " id: " + producto.getId() + " ");
        }
    }
}