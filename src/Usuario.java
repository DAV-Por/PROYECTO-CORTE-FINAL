import java.util.ArrayList;

public class Usuario {
    String nombreUsuario, password;
    Rol rol;
    String login;
    private void usuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario administrador = new Administrador("Juan","Admin123",rol.ADMINISTRADOR);
        Usuario contador = new Contador("Felipe","Contador123",rol.CONTADOR);
        Usuario mercadero = new Mercadero("Cesar","Mercadero123", rol.MERCADERO);
    }

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }


    public boolean Login(String nombreUsuarioIngresado, String passwordIngresado) {
        if (nombreUsuarioIngresado.equals(nombreUsuario) && passwordIngresado.equals(password)) {
            System.out.println("Inicio de sesion exitoso\nBienvenido :" + nombreUsuario + " " + rol);
            return true;
        } else {
            return false;

        }
    }

    public enum Rol{
        ADMINISTRADOR, CONTADOR, MERCADERO
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
