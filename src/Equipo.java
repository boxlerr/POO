import org.example.enumeradores.Resultado;

public class Equipo extends Jugador{
	
	private boolean autorizacion = true;
    private Resultado resultado;
	private String nombre;
	private int cantidadGolesEnElTorneo;
	

	public Equipo(boolean autorizacion, Resultado resultado, String nombre, int cantidadGolesEnElTorneo) {
	super();
	this.autorizacion = autorizacion;
	this.nombre = nombre;
	this.resultado = resultado;
	this.cantidadGolesEnElTorneo = cantidadGolesEnElTorneo;
		
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
	public int getCantidadGolesEnElTorneo() {
        return cantidadGolesEnElTorneo;
    }
    public void setCantidadGolesEnElTorneo(int cantidadGolesEnElTorneo) {
        this.cantidadGolesEnElTorneo = cantidadGolesEnElTorneo;
    }
    

	public boolean AgregarJugador(String nombre, String posicion, int numeroCamiseta, int edad) {
	    Jugador nuevoJugador = new Jugador(nombre, posicion, numeroCamiseta, edad);
	    this.getJugadores().add(nuevoJugador);
	    return true;
	}
	public void sumarGolesNuevos(int nuevosGoles) {
        this.cantidadGolesEnElTorneo += nuevosGoles;
    }

	public void GenerarEquipo() {
		String [] posicion = {"Delantero","Arquero","Defensa","Mediocampista"};		//generar jugador random
		for (int i = 0; i < 11; i++) {
			int aleatorio = (int)(Math.random()*4);
			this.getJugadores().add(new Jugador("Jugador: " + i,posicion[aleatorio],i,4));
		}
	}
	@Override
	public String toString() {
		return "  " + nombre + "  " ;
	}
}