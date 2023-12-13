import org.example.enumeradores.Resultado;

public class Equipo extends Jugador{
	
	private boolean autorizacion = true;
    private Resultado resultado;
	private String nombre;
	
	

	public Equipo(boolean autorizacion, Resultado resultado, String nombre) {
	super();
	this.autorizacion = autorizacion;
	this.nombre = nombre;
	this.resultado = resultado;
		
	}

	public boolean getAutorizacion() {
        return autorizacion;
    }
	
    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }
    
    public Resultado getResultado() {
        return resultado;
    }
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
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
	public String obtenerInformacion() {
		StringBuilder infoEquipo = new StringBuilder("Información del Equipo " + this.getNombre() + ":\n");
		
		// Mostrar la información de cada jugador en el equipo
		for (Jugador jugador : this.getJugadores()) {
			infoEquipo.append(jugador.toString()).append("\n");
		}
		
		return infoEquipo.toString();
	}

	public boolean AgregarJugador(String nombre, String posicion, int numeroCamiseta, int edad) {
	    Jugador nuevoJugador = new Jugador(nombre, posicion, numeroCamiseta, edad);
	    this.getJugadores().add(nuevoJugador);
	    return true;
	}
}