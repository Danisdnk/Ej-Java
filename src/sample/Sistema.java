package sample;
import Models.Administrador;
import Models.Cocinero;
import Models.EntradaSalida;
import Models.Persona;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sistema implements Serializable {


    private List<Persona> personas;
    private Cocinero cocinero;

    public Sistema() {
        personas = new ArrayList<>();

    }
    //region [Serializing]
    public Sistema deSerializar(String archivo) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(archivo);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        return s;
    }

    public void serializar(String archivo) throws IOException {
        FileOutputStream f = new FileOutputStream(archivo);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
    }
    //endregion

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    //region [Validar usuario Ingresado]
    public void arrancar() {
        int corriendo = 1;

        while (corriendo!=0) {
            Persona u = null;

            String usuario = EntradaSalida.leerString("Ingrese su usuario");
            String password = EntradaSalida.leerPassword("Ingrese password");

            for (Persona p : personas) {
                if (p.getUsuario().equals(usuario) && p.getPassword().equals(password)) {
                    u = p;
                }
            }
            if (u == null)
            {
                EntradaSalida.mostrarString("Usuario/contraseña inexistente");
            }
            else
                {
                corriendo = u.trabajar();
                }

            if (corriendo==2)
            {
                usuario = EntradaSalida.leerString("Nombre de usuario del cocinero.");
                password = EntradaSalida.leerPassword("Contraseña del cocinero.");
                Cocinero c = new Cocinero(usuario, password);
                personas.add(c);
                EntradaSalida.mostrarString("Se agregó correctamente " + c.getUsuario());
            }
        }
        EntradaSalida.mostrarString("Hasta mañana");
    }
    //endregion

    //region [Primer Arranque carga Administrador]
    public void inicializacion() {
        String usuario, password;

        EntradaSalida.mostrarString(
                "PRIMER ARRANQUE\n\n"
                        + "A continuación genere el usuario ADMINISTRADOR para el sistema."
        );

        usuario = EntradaSalida.leerString("Nombre de usuario del Administrador.");
        password = EntradaSalida.leerPassword("Contraseña del Administrador.");
        String jerarquia="Administrador";
        Administrador b = new Administrador(usuario, password);
        personas.add(b);

        EntradaSalida.mostrarString(
                "USUARIOS CARGADOS\n\n"
                        + "Ya puede ingresar al sistema. desde sistema java"
        );
    }
    //endregion
}
