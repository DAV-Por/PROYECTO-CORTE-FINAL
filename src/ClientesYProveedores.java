
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ClientesYProveedores {
    public static class Cliente {
        private Map<Integer, Cliente> clientes = new HashMap<>();

        private int ID;
        private String nombre;
        private String apellido;
        private int edad;
        private String correo;
        private String telefono;
        private String direccion;
        private Pedido pedido;

        public Cliente(int ID, String nombre, String apellido, int edad, String correo, String telefono, String direccion, Pedido pedido) {
            this.ID = ID;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.correo = correo;
            this.telefono = telefono;
            this.direccion = direccion;
            this.pedido = pedido;
        }

        public void listaClientes () {
            ArrayList<Provedor> ListaClientes = new ArrayList();
            Cliente cliente01 = new Cliente(01, "Esteban", "Quito", 36, "estabanquito36@gmail.com", "3147964650", "Calle Quito 33", pedido);
            Cliente cliente02 = new Cliente(02, "Juan Jose", "Estrada", 45, "joseestrada34@gmail.com", "3205216478", "Calle 4# 33-44", pedido);
            Cliente cliente03 = new Cliente(03, "Johan", "Castañeda", 21, "elmaspaspi33@gmail.com", "3147951243", "Carrea 6#26-33", pedido);
            agregarCliente(cliente01); agregarCliente(cliente02); agregarCliente(cliente03);
        }

        public void eliminarCliente(int ID) {
            if (clientes.containsKey(ID)) {
                clientes.remove(ID);
            }
        }

        public void agregarCliente(Cliente cliente) {
            if (!clientes.containsKey(cliente.ID)) {
                clientes.put(cliente.ID, cliente);
            }
        }
    }
    public static class Provedor {
        private Map<Integer, Provedor> provedores = new HashMap<>();

        private int ID;
        private String nombre;
        private String apellido;
        private int edad;
        private String correo;
        private String telefono;
        private String direccion;
        private Pedido pedido;

        public Provedor(int ID, String nombre, String apellido, int edad, String correo, String telefono, String direccion, Pedido pedido) {
            this.ID = ID;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.correo = correo;
            this.telefono = telefono;
            this.direccion = direccion;
            this.pedido = pedido;
        }

        public void listaProvedor() {
            ArrayList<Cliente> ListaProvedor = new ArrayList();
            Provedor provedor01 = new Provedor(01, "Esteban", "Quito", 36, "estabanquito36@gmail.com", "3147964650", "Calle Quito 33", pedido);
            Provedor provedor02 = new Provedor(02, "Juan Jose", "Estrada", 45, "joseestrada34@gmail.com", "3205216478", "Calle 4# 33-44", pedido);
            Provedor provedor03 = new Provedor(03, "Johan", "Castañeda", 21, "elmaspaspi33@gmail.com", "3147951243", "Carrea 6#26-33", pedido);
            agregarProvedor(provedor01); agregarProvedor(provedor02); agregarProvedor(provedor03);
        }

        public void eliminarProveedor(int ID) {
            if (provedores.containsKey(ID)) {
                provedores.remove(ID);
                System.out.println("Provedor eliminado");
            }else {
                System.out.println("Proveedor No eliminado");
            }
        }

        public void agregarProvedor(Provedor provedor) {
            if (!provedores.containsKey(provedor.ID)) {
                provedores.put(provedor.ID, provedor);
            }
        }

    }

}

