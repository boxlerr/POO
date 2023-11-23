import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	
	//Atributos: nombre, ciudad, lista de jugadores (LinkedList<Jugador>).
	//Métodos:
	//Agregar un jugador a la lista.
	//Eliminar un jugador de la lista.
	//Buscar un jugador por nombre.
	//Obtener la cantidad total de jugadores en el equipo.
	//Obtener la lista de jugadores en el equipo.

	aca hago uso de la linkedlist
	
	private String nombre;
	private String ciudad;
	private String foto;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

	public Equipo(String nombre, String ciudad, String foto) {
	super();
	this.nombre = nombre;
	this.ciudad = ciudad;
	this.foto = foto;
	
}


	public boolean AgregarJugador(String nombre, String posicion, int numerodecamiseta, int edad) {
		for (Jugador jugador : jugadores) {
			if(jugador.getNumerodecamiseta()==numerodecamiseta) {
				JOptionPane.showMessageDialog(null, "No se pudo agregar");
				return false;
			}
		}
		jugadores.add(new Jugador(nombre,posicion,numerodecamiseta,edad));
		
		return true;
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
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", foto=" + foto + ", jugadores=" + jugadores + "]";
	}
	
	
	

	

}
