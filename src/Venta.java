public class Venta {
    private Comprador Comprador;
    private Localidad Localidad;
    private int CantidadBoletos;


    public void setComprador(Comprador comprador) {
        Comprador = comprador;
    }

    public Comprador getComprador() {
        return Comprador;
    }

    public void setLocalidad(Localidad localidad) {
        Localidad = localidad;
    }

    public Localidad getLocalidad() {
        return Localidad;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        CantidadBoletos = cantidadBoletos;
    }

    public int getCantidadBoletos() {
        return CantidadBoletos;
    }

}

