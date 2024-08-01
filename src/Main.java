import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estadio estadio = new Estadio(3);


        Localidad localidad1 = new Localidad(500, 250);
        Localidad localidad5 = new Localidad(300, 575);
        Localidad localidad10 = new Localidad(150, 1720);


        estadio.agregarLocalidad(localidad1);
        estadio.agregarLocalidad(localidad5);
        estadio.agregarLocalidad(localidad10);

        int numCompra = 1;
        int totalCaja = 0;

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        while (true) {
            System.out.println("Porfavor ingrese uno de los siguientes opciones: \n1. Comprar Tickets \n2. Revisar disponibilidad de asientos totales \n3. Revisar las disponibilidades en los diferentes sectores \n4. Revisar caja \n5. Salir \n ");
            int opc = sc.nextInt();

            switch (opc) {
                case 1:

                    Comprador comprador = new Comprador();
                    System.out.println("Ingrese su nombre: ");
                    comprador.setNombre_Compra(sc.next());
                    System.out.println("Ingrese su numero de teléfono: ");
                    comprador.setTelefono(sc.next());
                    System.out.println("Ingrese su presupuesto maximo: ");
                    comprador.setPresupuesto(sc.nextInt());

                    Venta venta = new Venta();
                    System.out.println("Cuántos boletos desea comprar?");
                    int cantidadBoletos = sc.nextInt();
                    comprador.setCant_boletos(cantidadBoletos);
                    if (cantidadBoletos > 6) {
                        System.out.println("No puede comprar más de 6 boletos");
                        break;
                    }

                    System.out.println("Seleccione uno de los locales: \n1. Localidad 1 / 250$  \n2. Localidad 5 / 575$  \n3. Localidad 10 / 1720$ \n");
                    Localidad localidadSeleccionada = null;
                    switch (sc.nextInt()) {
                        case 1:
                            localidadSeleccionada = localidad1;
                            break;
                        case 2:
                            localidadSeleccionada = localidad5;
                            break;
                        case 3:
                            localidadSeleccionada = localidad10;
                            break;
                        default:
                            System.out.println("Opción inválido");
                            break;
                    }

                    if (localidadSeleccionada == null) {
                        break;
                    }

                    if (localidadSeleccionada.getEspacio() >= cantidadBoletos) {
                        int totalCompra = cantidadBoletos * localidadSeleccionada.getPrecio();
                        if (totalCompra <= comprador.getPresupuesto()) {
                            venta.setLocalidad(localidadSeleccionada);
                            venta.setCantidadBoletos(cantidadBoletos);
                            localidadSeleccionada.setEspacio(localidadSeleccionada.getEspacio() - cantidadBoletos);

                            LocalDate fechaCompra = LocalDate.now();
                            numCompra += cantidadBoletos;
                            String numTicket = String.format("%s%d", fechaCompra.format(formatter), numCompra);
                            totalCaja += totalCompra;

                            Ticket ticket = new Ticket();
                            ticket.setFecha(java.sql.Date.valueOf(fechaCompra));
                            ticket.setNumero(numTicket);

                            System.out.println("**************************************************"
                                    + "\nFactura: "
                                    + "\nNombre: " + comprador.getNombre_Compra()
                                    + "\nTeléfono: " + comprador.getTelefono()
                                    + "\nCantidad de boletos: " + cantidadBoletos
                                    + "\nPrecio total: " + totalCompra
                                    + "\nNúmero de compra: " + numCompra
                                    + "\nFecha de compra: " + ticket.getFecha()
                                    + "\nNúmero de ticket: " + ticket.getNumero()
                                    + "\n***************************************************");
                        } else {
                            System.out.println("No tiene suficiente presupuesto para poder realizar la compra");
                        }
                    } else {
                        System.out.println("No hay disponibilidad en esta sección");
                    }
                    break;

                case 2:
                    System.out.println("La disponibilidad total es de: " + estadio.consultarDisponibilidadTotal() + " en el estadio");
                    break;

                case 3:
                    estadio.mostrarDisponibilidadPorSeccion();
                    break;

                case 4:
                    System.out.println("En la caja hay un total de: " + totalCaja);
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }
}