import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Java");

        // Crear habitaciones
        hotel.agregarHabitacion(new Habitacion(101));
        hotel.agregarHabitacion(new Habitacion(102));
        hotel.agregarHabitacion(new Habitacion(103));

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Sistema de Gestión de Hotel ---");
            System.out.println("1. Consultar disponibilidad");
            System.out.println("2. Crear una reserva");
            System.out.println("3. Ver todas las reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    // Consultar disponibilidad
                    System.out.print("Ingrese el número de la habitación: ");
                    int numeroHabitacion = scanner.nextInt();
                    boolean disponible = hotel.consultarDisponibilidad(numeroHabitacion);
                    if (disponible) {
                        System.out.println("La habitación " + numeroHabitacion + " está disponible.");
                    } else {
                        System.out.println("La habitación " + numeroHabitacion + " no está disponible.");
                    }
                    break;

                case 2:
                    // Crear una reserva
                    System.out.print("Ingrese el número de la habitación: ");
                    int habitacionReserva = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingrese el nombre del huésped: ");
                    String nombreHuesped = scanner.nextLine();
                    System.out.print("¿Cuántos días se quedará?: ");
                    int diasEstancia = scanner.nextInt();

                    // Calcular fechas
                    Date fechaEntrada = new Date(); // Fecha actual
                    Date fechaSalida = new Date(System.currentTimeMillis() + diasEstancia * 86400000L); // Fecha de salida calculada

                    boolean reservaCreada = hotel.crearReserva(habitacionReserva, nombreHuesped, fechaEntrada, fechaSalida);
                    if (reservaCreada) {
                        System.out.println("Reserva creada con éxito para la habitación " + habitacionReserva + ".");
                        System.out.println("Fecha de entrada: " + fechaEntrada);
                        System.out.println("Fecha de salida: " + fechaSalida);
                    } else {
                        System.out.println("No se pudo crear la reserva. La habitación no está disponible o no existe.");
                    }
                    break;

                case 3:
                    // Mostrar todas las reservas
                    System.out.println("Reservas actuales:");
                    for (Reserva reserva : hotel.getReservas()) {
                        System.out.println(reserva);
                    }
                    break;

                case 4:
                    // Salir del programa
                    continuar = false;
                    System.out.println("Gracias por usar el sistema de gestión de hotel.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
