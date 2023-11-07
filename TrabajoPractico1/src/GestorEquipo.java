import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipo {
	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();

	

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
	

}
