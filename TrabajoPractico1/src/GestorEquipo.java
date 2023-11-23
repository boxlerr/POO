import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipo {
	
	//Atributos: lista de equipos (LinkedList<Equipo>).
	//Métodos:
	//Jugar un partido contra otro equipo.
	//Agregar un equipo a la lista.
	//Eliminar un equipo de la lista.
	//Buscar un equipo por nombre.
	//Obtener la cantidad total de equipos.
	//Obtener la lista de equipos.

	
	
	
	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	private LinkedList<Partido> partidos= new LinkedList<Partido>();

	

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}


	@Override
	public String toString() {
		return "GestorEquipos [equipos=" + equipos + "]";
	}
	
	public Equipo Buscar(String nombre) {
		
		
		for (Equipo equipo : equipos) {
			if(equipo.getNombre().equals(nombre)) {
				return equipo;
			}
		}
		return null;
}
	public Partido JugarPartido (Equipo equipo1, Equipo equipo2) {
		
		if(equipo1.getNombre().equals(equipo2.getNombre())) {
			JOptionPane.showMessageDialog(null, "Los equipos deben ser diferentes");
		return null;
		}
		return new Partido (null, equipo2, equipo2, 0,0,0,0);	
		
	}
}