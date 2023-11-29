public class Equipo extends Jugador{
	
	private String nombre;
	

	public Equipo(String nombre) {
	super();
	this.nombre = nombre;
		
}

	public void GenerarEquipo() {
		
		String [] posicion = {"Delantero","Arquero","Defensa","Mediocampista"};		//generar jugador random
		for (int i = 0; i < 11; i++) {
			int aleatorio = (int)(Math.random()*4);
			this.getJugadores().add(new Jugador("Jugador: " + i,posicion[aleatorio],i,4));
		}
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