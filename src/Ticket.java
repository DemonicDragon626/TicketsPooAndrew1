import java.util.Date;

public class Ticket {
    private String Numero;
    private Date Fecha;

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getNumero() {
        return Numero;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Date getFecha() {
        return Fecha;
    }
}
