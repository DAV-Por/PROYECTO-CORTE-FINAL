package src;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ClientesYProveedores {
    public class Cliente{
        private int ID;
        private String nombre;
        private String apellido;
        private int edad;
        private String correo;
        private String  telefono;
        private String direccion;
        private Pedido pedido;

        public Cliente() {
        }

        public Map<Integer, Pedido> Clientes = new HashMap<Integer, Pedido>();

        public Cliente(int ID, String nombre, String apellido, int edad, String correo, String  telefono, String direccion, Pedido pedido) {
            this.ID = ID;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.correo = correo;
            this.telefono = telefono;
            this.direccion = direccion;
            Clientes = new HashMap<Integer, Pedido>();
            this.pedido = pedido;
            listaClientes();
        }

        public void listaClientes () {
            ArrayList<Cliente> ListaClientes = new ArrayList();
            Cliente cliente01 = new Cliente(01, "Esteban", "Quito", 36, "estabanquito36@gmail.com", "3147964650", "Calle Quito 33", pedido);
            Cliente cliente02 = new Cliente(02, "Juan Jose", "Estrada", 45, "joseestrada34@gmail.com", "3205216478", "Calle 4# 33-44", pedido);
            Cliente cliente03 = new Cliente(03, "Johan", "Castañeda", 21, "elmaspaspi33@gmail.com", "3147951243", "Carrea 6#26-33", pedido);
            Clientes.put(cliente01.ID, pedido); Clientes.put(cliente02.ID, pedido); Clientes.put(cliente03.ID, pedido);
        }

        public void eliminarCliente(int ID) {
            Clientes.remove(ID);
        }



    }
}
