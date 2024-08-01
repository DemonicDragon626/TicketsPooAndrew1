public class Estadio {
    private String Nombre;
    private int CapacidadTotal;
    private Localidad[] Localidades;
    private int NumLocalidades;


    public Estadio(int capacidad) {
        Localidades = new Localidad[capacidad];
        NumLocalidades = 0;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        CapacidadTotal = capacidadTotal;
    }

    public int getCapacidadTotal() {
        return CapacidadTotal;
    }

    public void agregarLocalidad(Localidad localidad) {
        if (NumLocalidades < Localidades.length) {
            Localidades[NumLocalidades] = localidad;
            NumLocalidades++;
        }
    }

    public int consultarDisponibilidadTotal() {
        int totalDisponibilidad = 0;
        for (int i = 0; i < NumLocalidades; i++) {
            totalDisponibilidad += Localidades[i].getEspacio();
        }
        return totalDisponibilidad;
    }

    public void mostrarDisponibilidadPorSeccion() {
        for (int i = 0; i < NumLocalidades; i++) {
            System.out.println("Sección " + (i + 1) + ": " + Localidades[i].getEspacio() + " boletos disponibles");
        }
    }
}
