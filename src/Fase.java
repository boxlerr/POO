
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

public class Fase {
    //Elementos privados
    private int numeroDeRonda;
    private int cantidadDeEquiposenRonda;
    private int cantidadDeEquiposEnLlave;
    //Constructores
    public Fase() {
    }
    public Fase(int numerodeRonda) {
        this.numeroDeRonda = numerodeRonda;
    }
    public Fase(int numerodeRonda, int cantidaddeequiposenRonda, int cantidadDeEquiposEnLlave) {
        this.numeroDeRonda = numerodeRonda;
        this.cantidadDeEquiposenRonda = cantidaddeequiposenRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }
    //Setters and getters
    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }
    public void setNumeroDeRonda(int numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposenRonda;
    }
    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposenRonda) {
        this.cantidadDeEquiposenRonda = cantidadDeEquiposenRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }
    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }
    //Remover equipos
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave = cantidadDeEquiposEnLlave;

        for(int i=0; i<contadorEquiposPorLlave; i++){
            Equipo auxiliar=equipos.get(i);
            if(!auxiliar.getAutorizacion()){
                equipos.remove(auxiliar);
                contadorEquiposPorLlave--;
            }
        }
    }
    //Rondas
    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha) {
        LinkedList<Equipo> ganadoresIzquierda = simularRonda(llaveIzquierda, "Cuartos de Final - Llave Izquierda");
        LinkedList<Equipo> ganadoresDerecha = simularRonda(llaveDerecha, "Cuartos de Final - Llave Derecha");
        JOptionPane.showMessageDialog(null, "Los cuartos de final han concluido. Avanzando a las semifinales.", "Progreso del Torneo", JOptionPane.INFORMATION_MESSAGE);
        semifinal(ganadoresIzquierda, ganadoresDerecha);
    }

    public void semifinal(LinkedList<Equipo> ganadoresIzquierda, LinkedList<Equipo> ganadoresDerecha) {
        LinkedList<Equipo> finalistasIzquierda = simularRonda(new Llave("Semifinal - Llave Izquierda", ganadoresIzquierda), "Semifinal - Llave Izquierda");
        LinkedList<Equipo> finalistasDerecha = simularRonda(new Llave("Semifinal - Llave Derecha", ganadoresDerecha), "Semifinal - Llave Derecha");
        JOptionPane.showMessageDialog(null, "Las semifinales han concluido. Avanzando a la final.", "Progreso del Torneo", JOptionPane.INFORMATION_MESSAGE);
        finalDelTorneo(finalistasIzquierda.getFirst(), finalistasDerecha.getFirst());
    }

    public void finalDelTorneo(Equipo equipo1, Equipo equipo2) {
        mostrarPartido(equipo1, equipo2, "Final");
        Equipo ganador = new Partido().simularPartido(equipo1, equipo2);
        mostrarGanador(ganador);
    }

    private LinkedList<Equipo> simularRonda(Llave llave, String tituloRonda) {
        LinkedList<Equipo> ganadores = new LinkedList<>();
        for (int i = 0; i < llave.getEquiposDeLlave().size(); i += 2) {
            Equipo equipo1 = llave.getEquiposDeLlave().get(i);
            Equipo equipo2 = llave.getEquiposDeLlave().get(i + 1);
            mostrarPartido(equipo1, equipo2, tituloRonda + " - Partido " + (i/2 + 1));
            ganadores.add(new Partido().simularPartido(equipo1, equipo2));
        }
        return ganadores;
    }

    private void mostrarPartido(Equipo equipo1, Equipo equipo2, String tituloPartido) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(crearPanelEquipo(equipo1));
        panel.add(new JLabel("VS", SwingConstants.CENTER));
        panel.add(crearPanelEquipo(equipo2));

        JOptionPane.showMessageDialog(null, panel, tituloPartido, JOptionPane.INFORMATION_MESSAGE);
    }

    private JPanel crearPanelEquipo(Equipo equipo) {
        JPanel panelEquipo = new JPanel(new BorderLayout());
        ImageIcon iconEquipo = loadImageIcon("/img/" + equipo.getNombre() + ".png");
        if (iconEquipo != null) {
            panelEquipo.add(new JLabel(iconEquipo), BorderLayout.CENTER);
        }
        panelEquipo.add(new JLabel(equipo.getNombre(), SwingConstants.CENTER), BorderLayout.SOUTH);
        return panelEquipo;
    }

    private void mostrarGanador(Equipo ganador) {
        JOptionPane.showMessageDialog(null, crearPanelEquipo(ganador), "El ganador del torneo es: " + ganador.getNombre() + "Campeon!!!", JOptionPane.INFORMATION_MESSAGE);
    }

    private ImageIcon loadImageIcon(String path) {
        try {
            return new ImageIcon(getClass().getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
