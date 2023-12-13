import org.example.enumeradores.Resultado;

public class Equipo extends Jugador{
	
	private boolean autorizacion = true;
	private String nombre;
	private Resultado resultado;
    private int cantidadGolesEnElTorneo;
	

	public Equipo(boolean autorizacion, String nombre) {
	super();
	this.autorizacion = autorizacion;
	this.nombre = nombre;
		
	}

	public boolean getAutorizacion() {
        return autorizacion;
    }
	
    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }
    
	public String obtenerInformacion() {
        StringBuilder infoEquipo = new StringBuilder("Información del Equipo " + this.getNombre() + ":\n");

        // Mostrar la información de cada jugador en el equipo
        for (Jugador jugador : this.getJugadores()) {
            infoEquipo.append(jugador.toString()).append("\n");
        }

        return infoEquipo.toString();
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "  " + nombre + "  " ;
	}

	public boolean AgregarJugador(String nombre, String posicion, int numeroCamiseta, int edad) {
	    Jugador nuevoJugador = new Jugador(nombre, posicion, numeroCamiseta, edad);
	    this.getJugadores().add(nuevoJugador);
	    return true;
	}
}