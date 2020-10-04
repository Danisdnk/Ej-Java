package Models;

public class Camarero extends Persona {
    // private List<Cocinero> listaCocineros;
    public Camarero(String usuario, String password) {
        super(usuario, password);
    }

    @Override
    public int trabajar() {
        return 0;
    }

}