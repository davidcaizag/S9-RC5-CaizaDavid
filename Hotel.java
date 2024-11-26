import java.util.List;
import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public boolean consultarDisponibilidad(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                return habitacion.isDisponible();
            }
        }
        return false; // Si no se encuentra la habitación
    }

    public boolean crearReserva(int numeroHabitacion, String nombreHuesped, java.util.Date fechaEntrada, java.util.Date fechaSalida) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion && habitacion.isDisponible()) {
                int idReserva = reservas.size() + 1; // Generar ID único para la reserva
                Reserva nuevaReserva = new Reserva(idReserva, numeroHabitacion, nombreHuesped, fechaEntrada, fechaSalida);
                reservas.add(nuevaReserva);
                habitacion.setDisponible(false); // Marcar la habitación como no disponible
                return true; // Reserva creada con éxito
            }
        }
        return false; // No se pudo crear la reserva (habitación no disponible o inexistente)
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
