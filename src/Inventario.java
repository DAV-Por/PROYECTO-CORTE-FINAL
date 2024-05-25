import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  Inventario {
    public Map<Integer,Producto> Productos = new HashMap<>();
    public Inventario() {
        Productos = new HashMap<>();
        inventarioInicial();
    }

    private void inventarioInicial() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Producto Product1 = new Producto("Salsa de tomate",1011,2200,30,"Pasta elaborada principalmente a partir de pulpa de tomates");
        Producto Product2 = new Producto("Harina de trigo",1012,1800,40," polvo fino de origen vegetal que se obtiene de la molienda del trigo");
        Producto Product3 = new Producto("Barra de margarina",1013,3000,30,"mezcla de aceites compuestos mayoritariamente por grasas insaturadas");
        Producto Product4 = new Producto("Bonbonbum",1014,500,40,"caramelo relleno de chicle");
        Productos.put(Product1.getId(), Product1);Productos.put(Product2.getId(), Product2);Productos.put(Product3.getId(), Product3);Productos.put(Product4.getId(), Product4);
    }

    public void agregarProducto(int id,Producto producto){
        Productos.put(id, producto);
    }

    public Producto buscarProductoPorId(int Id){
        Boolean existe = Productos.containsKey(Id);
        return existe ? Productos.get(Id) : null;
    }
    public Producto buscarProductoPorNombre(Producto producto){
        Boolean existe = Productos.containsValue(producto);
        return existe ? Productos.get(producto) : null;
    }

    public void mostrarInventario(){
        for (Producto producto : Productos.values()) {
            System.out.println("\nNombre: "+ producto.getNombre() +"\nId: "+producto.getId()+"\nPrecio: "+producto.getPrecio()+"\nStock: "+producto.getStock()+"\nDescripcion: "+producto.getDescripcion());
        }
    }

    public void modificarPrecioProducto(int id, double nuevoPrecio) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            producto.setPrecio((int) nuevoPrecio);
            System.out.println("El precio del producto con Id:  "+ id +" ha sido modificado a: "+ nuevoPrecio);
        } else {
            System.out.println("No se encontró el producto con el Id:  "+ id);
        }
    }
    public void modificarstockProducto(int id, double nuevoStock){
        Producto producto = buscarProductoPorId(id);
        if (producto != null){
            producto.setStock((int)nuevoStock);
            System.out.println("El stock del producto con id:"+ id +" ha sido modificado a "+  nuevoStock);
        }else {
            System.out.println("No se encontró el producto con el Id:  "+ id);
        }
    }

    public void eliminarProducto (int id){


        Producto producto = buscarProductoPorId(id);
        if (producto != null){
            Productos.remove(id);
            System.out.println("El producto con id : " +id+ "Fue eliminado correctamente");
        }else{
            System.out.println("No se encontró el producto con el Id:  "+ id);
        }
    }
}
