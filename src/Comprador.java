public class Comprador {
    private String Nombre_Compra;
    private String Telefono;
    private int Cant_boletos;
    private int Presupuesto;

    public void setNombre_Compra(String nombre_Compra) {
        Nombre_Compra = nombre_Compra;
    }

    public String getNombre_Compra() {
        return Nombre_Compra;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setCant_boletos(int cant_boletos) {
        Cant_boletos = cant_boletos;
    }

    public int getCant_boletos() {
        return Cant_boletos;
    }

    public void setPresupuesto(int presupuesto) {
        Presupuesto = presupuesto;
    }

    public int getPresupuesto() {
        return Presupuesto;
    }
}
