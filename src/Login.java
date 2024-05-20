package src;
import  java.util.Map;
import  java.util.HashMap;

public class Login {
    public Map <String, String> Usuarios = new HashMap<>();
    public Login() {
        Usuarios = new HashMap();
        Usuarios.put("admin", "admin123"); Usuarios.put("contador", "contador123"); Usuarios.put("bodeguero", "bodeguero123");

    }

    public Login(Map<String, String> usuarios) {
        this.Usuarios = usuarios;
    }

    public String Verificion(String variable) {
        return Usuarios.getOrDefault(variable, "");
    }


}
