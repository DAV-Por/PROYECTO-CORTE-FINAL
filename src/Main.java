import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Llamar al array de usuarios
        Usuario[] usuarios = {new Usuario("Juan", "Admin123", Usuario.Rol.ADMINISTRADOR),
                new Usuario("Felipe", "Contador123", Usuario.Rol.CONTADOR),
                new Usuario("Cesar", "Mercadero123", Usuario.Rol.MERCADERO)};

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese su nombre de usuario y contraseña
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuarioIngresado = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String passwordIngresado = scanner.nextLine();

        // Verificar si el usuario existe y la contraseña es correcta
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.Login(nombreUsuarioIngresado, passwordIngresado)) {
                usuario = u;

            }
        }

        // Si el usuario existe y la contraseña es correcta, mostrar un mensaje de bienvenida y realizar diferentes acciones dependiendo del rol del usuario
        if (usuario != null) {
            System.out.println("Inicio de sesión exitoso! Bienvenido " + usuario.getNombreUsuario() + ".");
            System.out.println("Su rol es: " + usuario.getRol());
            switch (usuario.getRol()) {
                case ADMINISTRADOR:
                    System.out.println("Acciones disponibles para el rol ADMINISTRADOR:");
                    // Aquí puedes agregar acciones específicas para el administrador
                    break;
                case CONTADOR:
                    System.out.println("Acciones disponibles para el rol CONTADOR:");
                    // Aquí puedes agregar acciones específicas para el contador
                    break;
                case MERCADERO:
                    System.out.println("Acciones disponibles para el rol MERCADERO:");
                    // Aquí puedes agregar acciones específicas para el mercadero
                    break;
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos, vuelvelo a intentar mas tarde");
        }
    }
}