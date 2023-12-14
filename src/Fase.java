
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;


public class Fase {
	
    private int cantidadDeEquiposEnLlave;  //almacena equipos

    public Fase() { //constructor vaciooU
    }
    
    public Fase( int cantidadDeEquiposEnLlave) {
    	this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }
   
    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }
    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }
    
    //Rondas
    public void Torneo(Llave llaveIzquierda, Llave llaveDerecha) {
    	// Simula una ronda y obtiene los ganadores de la llave izquierda.
        LinkedList<Equipo> ganadoresIzquierda = simularRonda(llaveIzquierda, "Cuartos de Final - Llave Izquierda");
        // Simula una ronda y obtiene los ganadores de la llave derecha.
        LinkedList<Equipo> ganadoresDerecha = simularRonda(llaveDerecha, "Cuartos de Final - Llave Derecha");
        // Muestra un mensaje indicando que los cuartos de final han concluido.
        JOptionPane.showMessageDialog(null, "Los cuartos de final han concluido. Avanzando a las semifinales.", "Progreso del Torneo", JOptionPane.INFORMATION_MESSAGE);
        // Procede a las semifinales con los equipos ganadores.
        semifinal(ganadoresIzquierda, ganadoresDerecha);
    }


    public void semifinal(LinkedList<Equipo> ganadoresIzquierda, LinkedList<Equipo> ganadoresDerecha) {
    	// Simula las semifinales para la llave izquierda y obtiene los finalistas.
        LinkedList<Equipo> finalistasIzquierda = simularRonda(new Llave("Semifinal - Llave Izquierda", ganadoresIzquierda), "Semifinal - Llave Izquierda");
        // Simula las semifinales para la llave derecha y obtiene los finalistas.
        LinkedList<Equipo> finalistasDerecha = simularRonda(new Llave("Semifinal - Llave Derecha", ganadoresDerecha), "Semifinal - Llave Derecha");
        // Muestra un mensaje indicando que las semifinales han concluido.
        JOptionPane.showMessageDialog(null, "Las semifinales han concluido. Avanzando a la final.", "Progreso del Torneo", JOptionPane.INFORMATION_MESSAGE);
        // Procede a la final del torneo con los equipos finalistas.
        finalDelTorneo(finalistasIzquierda.getFirst(), finalistasDerecha.getFirst());
    }

    public void finalDelTorneo(Equipo equipo1, Equipo equipo2) {
    	// Muestra el partido de la final.
        mostrarPartido(equipo1, equipo2, "Final");
        // Simula el partido de la final y determina el ganador.
        Equipo ganador = new Partido().simularPartido(equipo1, equipo2);
        // Muestra el ganador del torneo.
        mostrarGanador(ganador);
    }

    private void mostrarGanador(Equipo ganador) {
    	JOptionPane.showMessageDialog(null, crearPanelEquipo(ganador), "El ganador del torneo es: " + ganador.getNombre() + " Campeon!!!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private LinkedList<Equipo> simularRonda(Llave llave, String tituloRonda) {
    	// Lista para almacenar los ganadores de la ronda.
        LinkedList<Equipo> ganadores = new LinkedList<>();
        // Bucle para simular cada partido de la ronda.
        for (int i = 0; i < llave.getEquiposDeLlave().size(); i += 2) {
            Equipo equipo1 = llave.getEquiposDeLlave().get(i);
            Equipo equipo2 = llave.getEquiposDeLlave().get(i + 1);
            // Muestra cada partido y su título.
            mostrarPartido(equipo1, equipo2, tituloRonda + " - Partido " + (i / 2 + 1));
            // Agrega el ganador del partido a la lista de ganadores.
            ganadores.add(new Partido().simularPartido(equipo1, equipo2));
        }
        return ganadores;
    }

    private JPanel crearPanelEquipo(Equipo equipo) {
    	// Panel para mostrar información del equipo.
    	JPanel panelEquipo = new JPanel(new BorderLayout());
    	// Carga el ícono del equipo basado en su nombre.
    	ImageIcon iconEquipo = loadImageIcon("/img/" + equipo.getNombre() + ".png");
    	// Si el ícono existe, lo agrega al panel.
    	if (iconEquipo != null) {
    		panelEquipo.add(new JLabel(iconEquipo), BorderLayout.CENTER);
    	}
    	// Agrega el nombre del equipo en la parte inferior del panel.
    	panelEquipo.add(new JLabel(equipo.getNombre(), SwingConstants.CENTER), BorderLayout.SOUTH);
    	
    	return panelEquipo;
    }
    private void mostrarPartido(Equipo equipo1, Equipo equipo2, String tituloPartido) {
    	// Panel principal para mostrar el partido.
        JPanel panel = new JPanel(new GridLayout(1, 3));
        // Agrega el panel del equipo 1.
        panel.add(crearPanelEquipo(equipo1));
        // Agrega un label con "VS" en el centro.
        panel.add(new JLabel("VS", SwingConstants.CENTER));
        // Agrega el panel del equipo 2.
        panel.add(crearPanelEquipo(equipo2));
        // Muestra el panel en un diálogo informativo.
        JOptionPane.showMessageDialog(null, panel, tituloPartido, JOptionPane.INFORMATION_MESSAGE);
    }



    private ImageIcon loadImageIcon(String path) { //lo mismo que en el main pero para acaXD
        try {
            return new ImageIcon(getClass().getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
