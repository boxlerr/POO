import javax.swing.JOptionPane;

import java.util.LinkedList;
import java.util.List;

public class Jugador {

    private String nombre;
    private String posicion;
    private int numerodecamiseta;
    private int edad;
    private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

    public Jugador(String nombre, String posicion, int numerodecamiseta, int edad) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numerodecamiseta = numerodecamiseta;
        this.edad = edad;
    }
    
    public Jugador() {
	}

	// Métodos de set individuales
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getNumerodecamiseta() {
        return numerodecamiseta;
    }

    public int getEdad() {
        return edad;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setNumerodecamiseta(int numerodecamiseta) {
        this.numerodecamiseta = numerodecamiseta;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public boolean AgregarJugador(String nombre, String posicion, int numerodecamiseta, int edad) {
	    for (Jugador jugador : getJugadores()) {
	        if (jugador.getNumerodecamiseta() == numerodecamiseta) {
	            JOptionPane.showMessageDialog(null, "No se pudo agregar");
	            return false;
	        }
	    }
	    getJugadores().add(new Jugador(nombre, posicion, numerodecamiseta, edad));
	    return true;
	}


    // Método para modificar la información del jugador
    public void modificarJugador(String nombre, String posicion, int numerodecamiseta, int edad) {
        setNombre(nombre);
        setPosicion(posicion);
        setNumerodecamiseta(numerodecamiseta);
        setEdad(edad);
        JOptionPane.showMessageDialog(null, "Información del jugador modificada exitosamente.");
    }

    // Método para obtener información del jugador
    public String obtenerInformacion() {
        return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
                + ", edad=" + edad + "]";
    }

    // Método para buscar un jugador por nombre en una lista de jugadores
    public static Jugador buscarJugadorPorNombre(List<Jugador> jugadores, String nombreJugador) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }
    // Método para eliminar un jugador por nombre o número de camiseta
    public static boolean eliminarJugador(List<Jugador> jugadores, String nombreJugador, int numeroCamiseta) {
        Jugador jugadorAEliminar = null;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador) || jugador.getNumerodecamiseta() == numeroCamiseta) {
                jugadorAEliminar = jugador;
                break;
            }
        }
        if (jugadorAEliminar != null) {
            jugadores.remove(jugadorAEliminar);
            JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el jugador.");
            return false;
        }
    }

    // Método toString para obtener información del jugador
    @Override
    public String toString() {
        return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
                + ", edad=" + edad + "]";
    }
}
