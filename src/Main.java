package src;
import java.util.Map;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Login login = new Login();
        Map <String, String> logins = login.base();

        Scanner sc = new Scanner(System.in);
        System.out.println("***************\n* Bienvedio/a *\n****************\n\n**********************\n* Por favor Logueate *\n**********************");
        System.out.println("\nUsuario: ");
        String usuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String contrasena = sc.nextLine();
        boolean logueado = false;
        for (Map.Entry <String, String> entry : logins.entrySet()) {
            if (entry.getKey().equals(usuario) && entry.getValue().equals(contrasena)) {
                logueado = true;
                break;
            }
        }
        if (logueado) {
            System.out.println("Usuario logueado");
        }else {
            System.out.println("Usuario incorrecto, vuelva a intentarlo");
        }



    }
}