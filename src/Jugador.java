import javax.swing.JOptionPane;

import java.util.LinkedList;


public class Jugador {

    private String nombre;
    private String posicion;
    private int numerodecamiseta;
    private Equipo equipoSeleccionado;
    private int edad;
    private int puntaje;
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

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setNumerodecamiseta(int numerodecamiseta) {
        this.numerodecamiseta = numerodecamiseta;
    }
    
    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }
    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }
    
    public int getEdad() {
    	return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void modificarJugadorEnGestor(String nombre, String posicion, int numerodecamiseta, int edad) {
	    // Actualiza el nombre del jugador.
	    setNombre(nombre);
	    // Actualiza la posición del jugador.
	    setPosicion(posicion);
	    // Actualiza el número de camiseta del jugador.
	    setNumerodecamiseta(numerodecamiseta);
	    // Actualiza la edad del jugador.
	    setEdad(edad);
	    // Muestra un mensaje indicando que la información del jugador se actualizó con éxito.
	    JOptionPane.showMessageDialog(null, "Información del jugador modificada exitosamente.");
	}


    public static Jugador buscarJugadorPorNombre(LinkedList<Jugador> jugadores, String nombreJugador) {
    	// Recorre la lista de jugadores.
        for (Jugador jugador : jugadores) {
            // Compara el nombre del jugador actual con el nombre buscado, ignorando mayúsculas y minúsculas.
            if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                // Si encuentra una coincidencia, devuelve ese jugador.
                return jugador;
            }
        }
        // Si no encuentra ninguna coincidencia, devuelve null.
        return null;
    }
  

    public void elegirEquipo(LinkedList<Equipo> listaDeEquipos) {
    	// Inicia un mensaje con la lista de equipos disponibles.
        String listadeEquiposenMensaje = "Equipos: \n";
        // Agrega cada equipo y su número en la lista al mensaje.
        for (int i = 0; i < listaDeEquipos.size(); i++) {
            listadeEquiposenMensaje += (i + 1) + ". " + listaDeEquipos.get(i).getNombre() + "\n";
        }
        // Muestra el mensaje con los equipos disponibles.
        JOptionPane.showMessageDialog(null, listadeEquiposenMensaje, "Selección de equipo.", JOptionPane.INFORMATION_MESSAGE);
        
        int indiceEquipos;
        // Solicita al usuario que ingrese el número del equipo que desea elegir.
        do {
            indiceEquipos = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingresa el número del equipo que quieres seleccionar: ",
                    "Ingrese un valor", JOptionPane.INFORMATION_MESSAGE)) - 1;
        // Verifica que el número ingresado sea válido. Si no lo es, solicita otro número.
        } while (indiceEquipos < 0 || indiceEquipos >= listaDeEquipos.size());
        
        // Muestra un mensaje confirmando el equipo seleccionado.
        JOptionPane.showMessageDialog(null, "Seleccionaste a: " + listaDeEquipos.get(indiceEquipos).getNombre());
        // Establece el equipo seleccionado como el equipo del jugador actual.
        this.equipoSeleccionado = listaDeEquipos.get(indiceEquipos);
    }

    @Override
    public String toString() {
    	return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
    			+ ", edad=" + edad + "]";
    }
}
