package sample;
import Models.EntradaSalida;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        String archivoDatos = "bodegon.bin";
        Sistema s = new Sistema();

        try {
            s = s.deSerializar(archivoDatos);
        } catch (IOException | ClassNotFoundException ex) {
            s.inicializacion();
        } finally {
            s.arrancar();
        }

        try {
            s.serializar(archivoDatos);
        } catch (IOException ex) {
            EntradaSalida.mostrarString(ex.getMessage());
        }
    }

}
