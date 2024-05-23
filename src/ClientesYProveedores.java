package src;
import java.util.ArrayList;

public class ClientesYProveedores {
    public class Cliente extends Producto {
        private String nombre;
        private String apellido;
        private int edad;
        private String correo;
        private String  telefono;
        private String direccion;

        public Cliente() {
        }

        public Cliente(String nombre, String apellido, int edad, String correo, String  telefono, String direccion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.correo = correo;
            this.telefono = telefono;
            this.direccion = direccion;

        }

        ArrayList <Cliente> clientes = new ArrayList() ;
        Cliente cliente = new Cliente("Esteban", "Quito", 36, "estabanquito36@gmail.com", "3147964650", "Calle Quito 33" );

    }
}
