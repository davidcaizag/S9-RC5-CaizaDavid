import java.util.List;
import java.util.ArrayList;

class Habitacion {
    private int numero;
    private boolean disponible;

    public Habitacion(int numero) {
        this.numero = numero;
        this.disponible = true; // Por defecto, las habitaciones están disponibles
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}