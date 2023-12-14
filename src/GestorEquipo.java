import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GestorEquipo {  //antes me obligaba a hacer herencia de jugador pero no se que toque que ahora no XDDD

	
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


	public Equipo Buscar(String nombre) {
		for (Equipo equipo : equipos) {
			if(equipo.getNombre().equals(nombre)) {
				return equipo;
			}
		}
		return null;
	}
	
	public Partido JugarPartido(Equipo equipo1, Equipo equipo2) {
	    if (equipo1.getNombre().equals(equipo2.getNombre())) {
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
	            } while (gol1 == gol2);
	            
	            if (gol1 > gol2) {
	                JOptionPane.showMessageDialog(null, "Ganó! " + equipo1.getNombre());
	                this.getEquipos().remove(this.getEquipos().indexOf(equipo2));
	            } else {
	                JOptionPane.showMessageDialog(null, "Ganó! " + equipo2.getNombre());
	                this.getEquipos().remove(this.getEquipos().indexOf(equipo1));
	            }
	            
	            // Crea un nuevo partido con los detalles correctos
	            Partido nuevoPartido = new Partido(equipo1, gol1, gol2, 90, equipo2, gol1, gol2);

	            // Agrega el partido a la lista de partidos
	            this.getPartidos().add(nuevoPartido);
	            
	            return nuevoPartido;    
	        } else {
	            JOptionPane.showMessageDialog(null, "Error: ambos equipos deben tener al menos 11 jugadores.");
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
	        lista.append(partido).append("\n");   //solucionar se repite
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
	
	
	public String CantidadTotalEquipos() { //haciendo uso por primera vez de StringBuilder y append
		// Se crea un objeto 'StringBuilder' llamado 'resultado'.
	    // Este objeto se utiliza para construir una cadena de texto
	    StringBuilder resultado = new StringBuilder("Cantidad total de equipos: " + this.getEquipos().size() + "\n");
	    // Se verifica si la lista de equipos no está vacía.
	    if (!this.getEquipos().isEmpty()) {
	        // Si hay equipos, se añade un título a la cadena 'resultado' usando el método 'append'.
	        resultado.append("-- Lista de Equipos --\n");
	        // Se recorre cada equipo en la lista de equipos.
	        for (Equipo equipo : this.getEquipos()) {
	            // Por cada equipo, se añade su representación como cadena (toString) a 'resultado'.
	            resultado.append(equipo).append("\n");
	        }
	    } else {
	        // Si la lista de equipos está vacía, se añade un mensaje indicando que no hay equipos.
	        resultado.append("No hay equipos registrados.");
	    }
	    return resultado.toString(); //retorna la cadena de texto
	}
	
	
	
	public boolean AgregarJugador(String[] nombresEquipos) {
	    // Mostrar cuadro de diálogo para seleccionar un equipo
	    String nombreEquipo = (String) JOptionPane.showInputDialog(null,"Seleccione un equipo:","Selección de equipos",JOptionPane.DEFAULT_OPTION,
	    		new ImageIcon(Main.class.getResource("/img/americaa.png")),nombresEquipos,nombresEquipos[0]);

	    // Buscar el equipo seleccionado
	    Equipo equipoSeleccionado = Buscar(nombreEquipo);

	    if (equipoSeleccionado != null) {
	        // Agregar jugador al equipo seleccionado
	        String nombre = JOptionPane.showInputDialog("Ingrese Nombre del Jugador");
	        String posicion = JOptionPane.showInputDialog("Ingrese Posición del Jugador");
	        int numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Número de Camiseta"));
	        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Edad del Jugador"));

	        // Utilizar la misma instancia de GestorEquipo para agregar el jugador
	        if (equipoSeleccionado.AgregarJugador(nombre, posicion, numeroCamiseta, edad)) {
	            JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente al equipo " + equipoSeleccionado.getNombre() + ".");
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo agregar el jugador.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Error: Equipo no seleccionado correctamente.");
	    }

	    return false;
	}
	
	
	public void modificarJugador() {
	    if (this.getEquipos().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay equipos disponibles para modificar jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Crear una lista de nombres de equipos
	    String[] nombresEquipos = new String[this.getEquipos().size()];
	    for (int i = 0; i < nombresEquipos.length; i++) {
	        nombresEquipos[i] = this.getEquipos().get(i).getNombre();
	    }

	    // Elegir un equipo
	    String nombreEquipo = (String) JOptionPane.showInputDialog(null,"Seleccione un equipo:","Selección de equipos",JOptionPane.DEFAULT_OPTION,
	            new ImageIcon(Main.class.getResource("/img/americaa.png")),nombresEquipos,nombresEquipos[0]);

	    // Buscar el equipo seleccionado
	    Equipo equipoSeleccionado = Buscar(nombreEquipo);

	    if (equipoSeleccionado != null) {
	        // Obtener la lista de jugadores del equipo seleccionado
	        LinkedList<Jugador> jugadoresEquipo = equipoSeleccionado.getJugadores();

	        if (!jugadoresEquipo.isEmpty()) {
	            // Crear una lista de nombres de jugadores
	            String[] nombresJugadores = new String[jugadoresEquipo.size()];
	            for (int i = 0; i < nombresJugadores.length; i++) {
	                nombresJugadores[i] = jugadoresEquipo.get(i).getNombre();
	            }

	            // Elegir un jugador
	            String nombreJugadorModificar = (String) JOptionPane.showInputDialog(null,"Seleccione un jugador para modificar:","Modificar Jugador",
	                    JOptionPane.QUESTION_MESSAGE,null,nombresJugadores,nombresJugadores[0]);

	            if (nombreJugadorModificar != null) {
	                // Buscar el jugador seleccionado en el equipo
	                Jugador jugadorModificar = Jugador.buscarJugadorPorNombre(jugadoresEquipo, nombreJugadorModificar);

	                if (jugadorModificar != null) {
	                    // Obtener nuevos datos del jugador
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
	                    JOptionPane.showMessageDialog(null, "No se encontró el jugador a modificar en el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "El equipo no tiene jugadores para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Error: Equipo no seleccionado correctamente.");
	    }
	}
	public void eliminarJugador() {
        if (this.getEquipos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos disponibles para eliminar jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear una lista de nombres de equipos
        String[] nombresEquipos = new String[this.getEquipos().size()];
        for (int i = 0; i < nombresEquipos.length; i++) {
            nombresEquipos[i] = this.getEquipos().get(i).getNombre();
        }

        // Elegir un equipo
        String nombreEquipo = (String) JOptionPane.showInputDialog(null,"Seleccione un equipo:","Selección de equipos",JOptionPane.DEFAULT_OPTION,new ImageIcon(Main.class.getResource("/img/americaa.png")),nombresEquipos,nombresEquipos[0]);

        // Buscar el equipo seleccionado
        Equipo equipoSeleccionado = Buscar(nombreEquipo);

        if (equipoSeleccionado != null) {
            // Obtener la lista de jugadores del equipo seleccionado
            LinkedList<Jugador> jugadoresEquipo = equipoSeleccionado.getJugadores();

            if (!jugadoresEquipo.isEmpty()) {
                // Crear una lista de nombres de jugadores
                String[] nombresJugadores = new String[jugadoresEquipo.size()];
                for (int i = 0; i < nombresJugadores.length; i++) {
                    nombresJugadores[i] = jugadoresEquipo.get(i).getNombre();
                }
                // eligo jugador
                String nombreJugadorEliminar = (String) JOptionPane.showInputDialog(null,"Seleccione un jugador para eliminar:","Eliminar Jugador",JOptionPane.QUESTION_MESSAGE,null,nombresJugadores,nombresJugadores[0]);

                if (nombreJugadorEliminar != null) {
                    //busca el jugador seleccionado
                    Jugador jugadorEliminar = Jugador.buscarJugadorPorNombre(jugadoresEquipo, nombreJugadorEliminar);

                    if (jugadorEliminar != null) {
                        // si encuentra el jugador lo borra
                        jugadoresEquipo.remove(jugadorEliminar);
                        JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el jugador en el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El equipo no tiene jugadores para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Equipo no seleccionado correctamente.");
        }
    }
}
	
	
