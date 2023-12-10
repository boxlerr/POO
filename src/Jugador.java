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

    @Override
    public String toString() {
        return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
                + ", edad=" + edad + "]";
    }
}
