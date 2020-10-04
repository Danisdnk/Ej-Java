package Models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Preparaciones implements Serializable {

    private String descripcion;
    private int precio;

    private List<Preparaciones> menu;

    public Preparaciones(String descripcion, int precio)
    {
        this.descripcion=descripcion;
        this.precio=precio;
    }


    public void agregarMenu(Preparaciones p) {
        if (p != null) {
            menu.add(p);
        }
    }

    public String mostrarMenu() {
        String lista = "";
        for (int i = 0; i < menu.size(); i++) {
            lista += "[" + (i + 2) + "] " + menu.get(i) + "\n";
        }
        return lista;
    }


}

