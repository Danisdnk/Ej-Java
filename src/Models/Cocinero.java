package Models;
import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

public class Cocinero extends Persona{

    // private List<Cocinero> listaCocineros;
    public Cocinero(String usuario, String password) {
        super(usuario, password);
    }

    private Preparaciones pr;
    public Preparaciones getPr() {
        return pr;
    }

    @Override
    public int trabajar() {

        int seguirCorriendo = 1;
        int cerrar = 0;

        while (cerrar==0) {
            int op;
            //region [OPCIONES DE MENU]
            do {
                op = EntradaSalida.leerInt(
                        "MENÚ COCINERO\n\n"
                                + "[0] Salir\n"
                                + "[1] Cerrar Sesión\n"
                                + "[2] Cargar Menu\n"
                                + "[3] Mostrar Menu\n");

            } while (op < 0);

            //endregion

            if (op == 2)
            {
                String descripcion = EntradaSalida.leerString("ingrese descripcion del producto.");
                Preparaciones p = new Preparaciones(descripcion,0);
                pr.agregarMenu(p);

                EntradaSalida.mostrarString("Se agregó correctamente " );
            }
            if (op == 3)
            {
                pr.mostrarMenu();
            }
            if (op == 1)
            {
                EntradaSalida.mostrarString("¡Hasta pronto!");
                cerrar = 1;
            } else {
                cerrar = 1;
                seguirCorriendo = 0;
            }
        }
        return seguirCorriendo;
    }

}
