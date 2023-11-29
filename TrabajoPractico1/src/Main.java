import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        GestorEquipo torneito = new GestorEquipo();
        torneito.getEquipos().add(new Equipo("Argentina"));
        torneito.getEquipos().add(new Equipo("Brasil"));
        torneito.getEquipos().add(new Equipo("Uruguay"));
        torneito.getEquipos().add(new Equipo("Chile"));
        torneito.getEquipos().add(new Equipo("Mexico"));
        torneito.getEquipos().add(new Equipo("Peru"));
        torneito.getEquipos().add(new Equipo("Bolivia"));
        torneito.getEquipos().add(new Equipo("Venezuela"));

        JOptionPane.showMessageDialog(null, "Bienvenido al torneo de la Copa America", "Copa America 2023", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Main.class.getResource("/img/americaa.png")));

        String[] opciones = {"Jugar partido", "Lista de Partidos", "Definir Grupos", "Gestión de Equipos", "Gestión de Jugadores", "Salir"};
        int opcion = 0;
        Equipo seleccionado1 = null;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Elegir", null, 0, 0, null, opciones, opciones);

            switch (opcion) {   
                case 0:    //jugar doparti
                    if (torneito.getEquipos().size() == 1) {
                        JOptionPane.showMessageDialog(null, "Es el ganador!" + torneito.getEquipos().get(0).getNombre());
                    } else {
                        String[] equipos = new String[torneito.getEquipos().size()];
                        for (int i = 0; i < equipos.length; i++) {
                            equipos[i] = torneito.getEquipos().get(i).getNombre();
                        }

                        String menu = (String) JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/americaa.png")), equipos, equipos[0]);
                        seleccionado1 = torneito.Buscar(menu);
                        menu = (String) JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/americaa.png")), equipos, equipos[0]);
                        seleccionado1.GenerarEquipo();
                        Equipo seleccionado2 = torneito.Buscar(menu);
                        seleccionado2.GenerarEquipo();
                        // usando función panel por primera vez
                        JPanel panel = new JPanel(new BorderLayout());
                        // se agrega imagen 1
                        String imagePath1 = "/img/" + seleccionado1.getNombre() + ".png";
                        ImageIcon iconEquipo1 = loadImageIcon(imagePath1);
                        if (iconEquipo1 != null) {
                            JLabel labelEquipo1 = new JLabel(iconEquipo1);
                            panel.add(labelEquipo1, BorderLayout.WEST); }
                        // se agrega texto
                        JLabel labelVS = new JLabel("VS");
                        panel.add(labelVS, BorderLayout.CENTER);
                        // imagen 2
                        String imagePath2 = "/img/" + seleccionado2.getNombre() + ".png";
                        ImageIcon iconEquipo2 = loadImageIcon(imagePath2);
                        if (iconEquipo2 != null) {
                            JLabel labelEquipo2 = new JLabel(iconEquipo2);
                            panel.add(labelEquipo2, BorderLayout.EAST);}
                        JOptionPane.showMessageDialog(null, panel, "Copa America 2023", JOptionPane.DEFAULT_OPTION);
                        Partido nuevo = torneito.JugarPartido(seleccionado1, seleccionado2);
                        
                        if (nuevo != null) {
                            JOptionPane.showMessageDialog(null, nuevo);
                            torneito.getPartidos().add(nuevo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Partido no se agregó a la lista");
                        }
                    }
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, torneito.verPartidos());
                    break;
                case 2:
                	torneito.DefinirGrupos();
                    break;
                case 3:
                    //sección para gestionar equipos
                    String[] opcionesGestionEquipos = {"Agregar Equipo", "Eliminar Equipo", "Cantidad Total de Equipos", "Lista de Equipos", "Salir"};
                    int opcionGestionEquipos = 0;

                    do {
                        opcionGestionEquipos = JOptionPane.showOptionDialog(null, "Gestión de Equipos", null, 0, 0, null, opcionesGestionEquipos, opcionesGestionEquipos);

                        switch (opcionGestionEquipos) {
                            case 0:
                                String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del nuevo equipo:");
                                Equipo nuevoEquipo = new Equipo(nombreEquipo);
                                torneito.AgregarEquipo(nuevoEquipo);
                                break;
                            case 1:
                                String nombreEliminarEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo a eliminar:");
                                Equipo equipoEliminar = torneito.Buscar(nombreEliminarEquipo);
                                torneito.EliminarEquipo(equipoEliminar);
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Cantidad total de equipos: " + torneito.CantidadTotalEquipos());
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, torneito.ObtenerListaEquipos());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Volviendo al menu...");
                                break;
                        }

                    } while (opcionGestionEquipos != 4);
                    break;
                case 4:
                    //gestion de jugadores
                    String[] opcionesGestionJugadores = {"Agregar Jugador a Equipo", "Modificar Jugador", "Eliminar Jugador", "Salir"};
                    int opcionGestionJugadores = 0;

                    do {
                        opcionGestionJugadores = JOptionPane.showOptionDialog(null, "Gestión de Jugadores", null, 0, 0, null, opcionesGestionJugadores, opcionesGestionJugadores);

                        switch (opcionGestionJugadores) {
                            case 0:
                                String nombre = JOptionPane.showInputDialog("Ingrese Nombre del Jugador");
                                String posicion = JOptionPane.showInputDialog("Ingrese Posicion del Jugador");
                                int numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Numero de Camiseta"));
                                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Edad del Jugador"));

                                if (seleccionado1.AgregarJugador(nombre, posicion, numeroCamiseta, edad)) {
                                    JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo agregar el jugador.");
                                }
                                break;
                            case 1:
                                String nombreModificar = JOptionPane.showInputDialog("Ingrese Nombre del Jugador a Modificar");
                                Jugador jugadorModificar = Jugador.buscarJugadorPorNombre(seleccionado1.getJugadores(), nombreModificar);

                                if (jugadorModificar != null) {
                                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese Nuevo Nombre");
                                    String nuevaPosicion = JOptionPane.showInputDialog("Ingrese Nueva Posicion");
                                    int nuevoNumeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nuevo Numero de Camiseta"));
                                    int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nueva Edad"));

                                    jugadorModificar.modificarJugador(nuevoNombre, nuevaPosicion, nuevoNumeroCamiseta, nuevaEdad);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontró el jugador a modificar.");
                                }
                                break;
                            case 2:
                                String nombreEliminar = JOptionPane.showInputDialog("Ingrese Nombre del Jugador a Eliminar");
                                int numeroCamisetaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Numero de Camiseta del Jugador a Eliminar"));

                                if (Jugador.eliminarJugador(seleccionado1.getJugadores(), nombreEliminar, numeroCamisetaEliminar)) {
                                    JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontró el jugador a eliminar.");
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Salir");
                                break;
                            default:
                                break;
                        }
                    } while (opcionGestionJugadores != 3);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Gracias por participar en el torneo de la Copa America");
                    break;
            }
        } while (opcion != 5);
    }
    private static ImageIcon loadImageIcon(String path) {   //solucion que encontre para poder jugar con los equipos agregadosssssssssssss porfinnn
        try {												//tuve q aplicarlo en main no pude agregarlo en una clase aparte
            return new ImageIcon(Main.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
