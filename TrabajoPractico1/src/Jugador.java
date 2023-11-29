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
	    // Verifica si ya existe un jugador con el mismo número de camiseta
	    for (Jugador jugador : this.getJugadores()) {
	        if (jugador.getNumerodecamiseta() == numerodecamiseta) {
	            JOptionPane.showMessageDialog(null, "No se pudo agregar el jugador. Ya existe un jugador con el mismo número de camiseta.");
	            return false;
	        }
	    }

	    // Añade el jugador a la lista de jugadores de la clase GestorEquipo
	    this.getJugadores().add(new Jugador(nombre, posicion, numerodecamiseta, edad));
	    return true;
	}


	public void modificarJugadorEnGestor(String nombre, String posicion, int numerodecamiseta, int edad) {
        setNombre(nombre);
        setPosicion(posicion);
        setNumerodecamiseta(numerodecamiseta);
        setEdad(edad);
        JOptionPane.showMessageDialog(null, "Información del jugador modificada exitosamente.");
    }

    
    public String obtenerInformacion() {
        return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
                + ", edad=" + edad + "]";
    }


    public static Jugador buscarJugadorPorNombre(List<Jugador> jugadores, String nombreJugador) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }
    
    public void eliminarJugador() {
        if (this.getJugadores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores disponibles para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //array para cuadro de diálogo
        String[] nombresJugadores = new String[this.getJugadores().size()];
        for (int i = 0; i < nombresJugadores.length; i++) {
            nombresJugadores[i] = this.getJugadores().get(i).getNombre();
        }
        // eligir jugador
        String nombreJugadorEliminar = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione un jugador para eliminar:",
                "Eliminar Jugador",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresJugadores,
                nombresJugadores[0]);

        if (nombreJugadorEliminar != null) {
            // busca el pj
            Jugador jugadorEliminar = Jugador.buscarJugadorPorNombre(this.getJugadores(), nombreJugadorEliminar);

            if (jugadorEliminar != null) {
                // si encuentra el pj lo borra
                this.getJugadores().remove(jugadorEliminar);
                JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el jugador.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    @Override
    public String toString() {
        return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
                + ", edad=" + edad + "]";
    }
}
