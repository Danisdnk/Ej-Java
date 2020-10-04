package Models;

import sample.Sistema;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {

    private Camarero camarero;
    private Cocinero cocinero;
    private List<Persona> personas;
    public Administrador(String usuario, String password) {
        super(usuario, password);
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero cam) {
        this.camarero = cam;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero coc) {
        this.cocinero = coc;
    }

    @Override
    public int trabajar() {
        int seguirCorriendo = 1;
        int cerrar = 0;


        personas = new ArrayList<>();

        while (cerrar==0) {
            int op;
            //region [OPCIONES DE MENU]
            do {
                op = EntradaSalida.leerInt(
                        "MENÚ ADMINISTRADOR\n\n"
                                + "[0] Salir\n"
                                + "[1] Cerrar Sesión\n"
                                + "[2] Cargar Nuevo cocinero\n"
                                + "[3] Cargar Nuevo camarero\n");
                //+ sp.obtenerListadoPiezas());
            } while (op < 0);

            //endregion

            if (op == 2)
            {
                return op;

            }
            else if (op == 3)
            {
                String usuario, password;
                usuario = EntradaSalida.leerString("Nombre de usuario del camarero.");
                password = EntradaSalida.leerPassword("Contraseña del camarero.");
                Camarero c = new Camarero(usuario, password);
                personas.add(c);
                listarPersonas(c);
                EntradaSalida.mostrarString("Se agregó correctamente " + c.getUsuario());

            }
            else if (op == 1)
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
