import java.util.Date;

public class Reserva {
    private int idReserva;
    private int numeroHabitacion;
    private String nombreHuesped;
    private Date fechaEntrada;
    private Date fechaSalida;

    public Reserva(int idReserva, int numeroHabitacion, String nombreHuesped, Date fechaEntrada, Date fechaSalida) {
        this.idReserva = idReserva;
        this.numeroHabitacion = numeroHabitacion;
        this.nombreHuesped = nombreHuesped;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    @Override
    public String toString() {
        return "Reserva ID: " + idReserva +
                ", Habitación: " + numeroHabitacion +
                ", Huésped: " + nombreHuesped +
                ", Fecha de entrada: " + fechaEntrada +
                ", Fecha de salida: " + fechaSalida;
    }
}
