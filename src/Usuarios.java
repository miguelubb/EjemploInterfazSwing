import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuarios {
    //singleton
    private Map<String, String> usuarios;

    private static Usuarios instance=new Usuarios();
    public static Usuarios getInstance(){
        return instance;
    }
    private Usuarios() {
        this.usuarios = new HashMap<>();
    }

    public boolean validarUsuario(String usuario, String pass) {
       String pwd=usuarios.get(usuario);
       return pwd!=null && pwd.equals(pass);
    }
    public boolean registrarUsuario(String usuario, String pass) {
        if(usuarios.containsKey(usuario)) {
            return false;
        }
        usuarios.put(usuario, pass);
        return true;
    }

    public boolean cambiarContraseña(String usuario, String actual, String nueva) {
        if(validarUsuario(usuario, actual)) {
            usuarios.put(usuario, nueva);
            return true;
        }else{
            return false;
        }
    }
    public List<String> listarUsuarios() {
        return new ArrayList<>(usuarios.keySet());
    }
}
