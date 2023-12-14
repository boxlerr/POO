import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;

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
    
    public void sumarPuntos() {
        if (equipoSeleccionado.getAutorizacion()) {
            puntaje++;
        }
    }
  
    @Override
    public String toString() {
        return "\nJugador [nombre=" + nombre + ", posición=" + posicion + ", numerodecamiseta=" + numerodecamiseta
                + ", edad=" + edad + "]";
    }

    public void elegirEquipo(List<Equipo> listaDeEquipos) {
        String listadeEquiposenMensaje = "Equipos: \n";
        //Nos da la lista de equipos disponibles
        for (int i = 0; i < listaDeEquipos.size(); i++) {
            listadeEquiposenMensaje += (i + 1) + ". " + listaDeEquipos.get(i).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, listadeEquiposenMensaje, "Selección de equipo.", JOptionPane.INFORMATION_MESSAGE);
        //Nos pide que ingresemos que equipos queremos elegir
        int indiceEquipos;
        do {
            indiceEquipos = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingresa el número del equipo que quieres seleccionar: ",
                    "Ingrese un valor", JOptionPane.INFORMATION_MESSAGE)) - 1;
        } while (indiceEquipos < 0 || indiceEquipos >= listaDeEquipos.size());
        JOptionPane.showMessageDialog(null, "Seleccionaste a: " + listaDeEquipos.get(indiceEquipos).getNombre());
        this.equipoSeleccionado = listaDeEquipos.get(indiceEquipos);
    }

}
