public class Localidad {
    private int Espacio;
    private int Precio;

    // Constructor
    public Localidad(int espacio, int precio) {
        Espacio = espacio;
        Precio = precio;
    }

    public void setEspacio(int espacio) {
        Espacio = espacio;
    }

    public int getEspacio() {
        return Espacio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public int getPrecio() {
        return Precio;
    }
}
