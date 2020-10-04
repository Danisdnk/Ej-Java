package Models;
import Models.Cocinero;
import java.io.Serializable;
import java.util.List;

public abstract class Persona implements Serializable {

    private String usuario;
    private String password;
    private List<Persona> personaList;

    public Persona(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;

    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public abstract int trabajar();

    public void listarPersonas(Persona p) {
        if (p != null) {
            personaList.add(p);
        }
    }


}
