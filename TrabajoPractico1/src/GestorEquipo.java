import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipo {
	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	private LinkedList<Partido> partidos= new LinkedList<Partido>();

	

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}

	
	
	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
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
	public Partido JugarPartido(Equipo equipo1, Equipo equipo2) {
		
		if(equipo1.getNombre().equals(equipo2.getNombre())) {
			JOptionPane.showMessageDialog(null, "Los equipos deben ser diferentes");
		return null;
		
		}else{
			if (equipo1.getJugadores().size()>=11 && equipo2.getJugadores().size()>=11 ) {
				
			int gol1;
			int gol2;
			
			do {
		gol1 = (int)(Math.random()*6);
		gol2 = (int)(Math.random()*6);
		if (gol1==gol2) {
		JOptionPane.showMessageDialog(null, "Empataron");   //hacer penales si se empata
		}
			}while(gol1==gol2);
			LocalDateTime fecha = LocalDateTime.now();		
			int minutos=90;
			if (gol1>gol2) {
				JOptionPane.showMessageDialog(null, "Ganó! " + equipo1.getNombre());
				this.getEquipos().remove(this.getEquipos().indexOf(equipo2));
			}else{
				JOptionPane.showMessageDialog(null, "Ganó! " + equipo2.getNombre());
				this.getEquipos().remove(this.getEquipos().indexOf(equipo1));
			}
			return new Partido (fecha, equipo1, equipo2, gol1, gol2,minutos);	
		}else{
			JOptionPane.showMessageDialog(null, "Jugadores Insuficientes");
			return null;
			}
		}
	}
		public void DefinirGrupos() {    //creacion de grupos
			
			String grupoA = "Grupo A";					
			String grupoB = "Grupo B";		
			String grupoC = "Grupo C";		
			String grupoD = "Grupo D";
			
			int lista = this.getEquipos().size()/2;			//primera mitad de lista
			for (int i = 0; i < lista; i++) {	
				if (i%2==0) {
					grupoA = grupoA+this.getEquipos().get(i).getNombre();
				}else{
					grupoB = grupoB+this.getEquipos().get(i).getNombre();

			}
		}
			for (int i = lista; i < this.getEquipos().size(); i++) {	//de la mitad a todo el size
				if (i%2==0) {
					grupoC = grupoC+this.getEquipos().get(i).getNombre();
				}else{
					grupoD = grupoD+this.getEquipos().get(i).getNombre();

			}
		}
			JOptionPane.showMessageDialog(null, grupoA);
			JOptionPane.showMessageDialog(null, grupoB);
			JOptionPane.showMessageDialog(null, grupoC);
			JOptionPane.showMessageDialog(null, grupoD);
	}
		public String verPartidos() {
			String lista="--Lista de Partidos-- \n";
			
			for(Partido partido : partidos) {
				lista=lista+partido+"\n";
			}
			return lista;
		}
	}