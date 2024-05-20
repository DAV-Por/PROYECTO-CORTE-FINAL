package src;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Login login = new Login();
        Scanner sc = new Scanner(System.in);
        System.out.println("***************\n* Bienvedio/a *\n****************\n\n**********************\n* Por favor Logueate *\n**********************");
        System.out.println("\nUsuario: ");
        String usuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String contrasena = sc.nextLine();
        String vUsuario = login.Verificion(usuario);
        String vContra = login.Verificion(contrasena);
        if (vUsuario.equals("admin") && vContra.equals("admin123")){
            System.out.println("Usuario admin");
        }else {
            System.out.println("Usuario non admin");
        }

    }
}
