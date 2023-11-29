import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorEquipo extends Jugador{  //tengo que usar herencia para poder modificar el jugador en gestion de jugador

	
	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	private LinkedList<Partido> partidos = new LinkedList<Partido>();

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
		} else {
			if (equipo1.getJugadores().size() >= 11 && equipo2.getJugadores().size() >= 11) {
				int gol1;
				int gol2;
				
				do {
					gol1 = (int)(Math.random()*6);
					gol2 = (int)(Math.random()*6);
					
					if (gol1 == gol2) {
						JOptionPane.showMessageDialog(null, "Empataron");   //hacer penales si se empata
					}
				} while(gol1 == gol2);
				
				int minutos = 90;
				
				if (gol1 > gol2) {
			        JOptionPane.showMessageDialog(null, "Ganó! " + equipo1.getNombre());
			        this.getEquipos().remove(this.getEquipos().indexOf(equipo2));
			    } else {
			        JOptionPane.showMessageDialog(null, "Ganó! " + equipo2.getNombre());
			        this.getEquipos().remove(this.getEquipos().indexOf(equipo1));
			    }
				
				Partido nuevoPartido = new Partido(equipo1, equipo2, gol1, gol2, minutos);
				this.getPartidos().add(nuevoPartido);
				
				return nuevoPartido;	
			} else {
				JOptionPane.showMessageDialog(null, "error");
				return null;
			}
		}
	}

	public void DefinirGrupos() {    // creación de grupos
		String grupoA = " Grupo A ";					
		String grupoB = " Grupo B ";		
		String grupoC = " Grupo C ";		
		String grupoD = " Grupo D ";
		
		int lista = this.getEquipos().size() / 2;			
		
		for (int i = 0; i < lista; i++) {	
			if (i % 2 == 0) {
				grupoA = grupoA + " - "+ this.getEquipos().get(i).getNombre();
			} else {
				grupoB = grupoB + " - "+ this.getEquipos().get(i).getNombre();
			}
		}
		
		for (int i = lista; i < this.getEquipos().size(); i++) {	
			if (i % 2 == 0) {
				grupoC = grupoC + " - " +this.getEquipos().get(i).getNombre();
			} else {
				grupoD = grupoD + " - " +this.getEquipos().get(i).getNombre();
			}
		}
		JOptionPane.showMessageDialog(null, "Crea grupos para simular un torneo!");
		JOptionPane.showMessageDialog(null, grupoA);
		JOptionPane.showMessageDialog(null, grupoB);
		JOptionPane.showMessageDialog(null, grupoC);
		JOptionPane.showMessageDialog(null, grupoD);
	}

	public String verPartidos() { //string para poder devolverlo como lista creo q esta bien
	    StringBuilder lista = new StringBuilder(partidos.isEmpty() ? "Lo siento, Debes jugar para ver el historial de partidos!\n" : "--Lista de Partidos--\n");

	    for (Partido partido : partidos) {
	        lista.append(partido).append("\n");
	    }

	    return lista.toString();
	}


	public void AgregarEquipo(Equipo nuevoEquipo) {
		this.getEquipos().add(nuevoEquipo);
		JOptionPane.showMessageDialog(null, "Equipo agregado exitosamente.");
	}


	public void EliminarEquipo() {
	    if (this.getEquipos().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay equipos disponibles para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    // array para cuadro de dialogo
	    String[] nombresEquipos = new String[this.getEquipos().size()];
	    
	    for (int i = 0; i < nombresEquipos.length; i++) {
	       nombresEquipos[i] = this.getEquipos().get(i).getNombre(); 
	    }
	    // elegir el equipoo con question message
	    String nombreEquipoEliminar = (String) JOptionPane.showInputDialog( null,"Seleccione un equipo para eliminar:","Eliminar Equipo",JOptionPane.QUESTION_MESSAGE,null,nombresEquipos,nombresEquipos[0]);
	    if (nombreEquipoEliminar != null) {
	    Equipo equipoEliminar = Buscar(nombreEquipoEliminar);
	   if (equipoEliminar != null) { //si se encontró el equipo eliminarlo
	         this.getEquipos().remove(equipoEliminar);
	         JOptionPane.showMessageDialog(null, "Equipo eliminado exitosamente.");
	   } else {
	         JOptionPane.showMessageDialog(null, "NO SE ENCONTRO", "Error", JOptionPane.ERROR_MESSAGE);
	       }
	  }
}
	
	
	public String CantidadTotalEquipos() {
	    StringBuilder resultado = new StringBuilder("Cantidad total de equipos: " + this.getEquipos().size() + "\n");

	    if (!this.getEquipos().isEmpty()) {
	        resultado.append("-- Lista de Equipos --\n");
	        for (Equipo equipo : this.getEquipos()) {
	            resultado.append(equipo).append("\n");
	        }
	    } else {
	        resultado.append("No hay equipos registrados.");
	    	}
	return resultado.toString();
}
	
	
	public String ObtenerListaEquipos() {
		StringBuilder listaEquipos = new StringBuilder("--Lista de Equipos-- \n");
		for(Equipo equipo : equipos) {
			listaEquipos.append(equipo).append("\n");
		}
	return listaEquipos.toString();
	}
	
	public void modificarJugador() {
	    if (this.getJugadores().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay jugadores disponibles para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    //array para cuadro de diálogo
	    String[] nombresJugadores = new String[this.getJugadores().size()];
	    for (int i = 0; i < nombresJugadores.length; i++) {
	        nombresJugadores[i] = this.getJugadores().get(i).getNombre();
	    }

	    // eligir jugador
	    String nombreJugadorModificar = (String) JOptionPane.showInputDialog(
	            null,
	            "Seleccione un jugador para modificar:",
	            "Modificar Jugador",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            nombresJugadores,
	            nombresJugadores[0]);

	    if (nombreJugadorModificar != null) {
	        // busca el jugador
	        Jugador jugadorModificar = Jugador.buscarJugadorPorNombre(this.getJugadores(), nombreJugadorModificar);

	        if (jugadorModificar != null) {
	            String nuevoNombre = JOptionPane.showInputDialog("Ingrese Nuevo Nombre");
	            String nuevaPosicion = JOptionPane.showInputDialog("Ingrese Nueva Posición");
	            int nuevoNumeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nuevo Número de Camiseta"));
	            int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nueva Edad"));

	            // Modificar los atributos del jugador
	            jugadorModificar.setNombre(nuevoNombre);
	            jugadorModificar.setPosicion(nuevaPosicion);
	            jugadorModificar.setNumerodecamiseta(nuevoNumeroCamiseta);
	            jugadorModificar.setEdad(nuevaEdad);

	            JOptionPane.showMessageDialog(null, "Información del jugador modificada exitosamente.");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontró el jugador a modificar.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	 }
}
	
	
