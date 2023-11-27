import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        GestorEquipo Chiki = new GestorEquipo();
        Chiki.getEquipos().add(new Equipo("Argentina", "argentina2.png"));
        Chiki.getEquipos().add(new Equipo("Brasil", "brasil.png"));
        Chiki.getEquipos().add(new Equipo("Uruguay", "uruguay.png"));
        Chiki.getEquipos().add(new Equipo("Chile", "chile.png"));
        Chiki.getEquipos().add(new Equipo("Mexico", "mexico.png"));
        Chiki.getEquipos().add(new Equipo("Peru", "peru.png"));
        Chiki.getEquipos().add(new Equipo("Bolivia", "bolivia.png"));
        Chiki.getEquipos().add(new Equipo("Venezuela", "venezuela.png"));

        JOptionPane.showMessageDialog(null, "Bienvenido al torneo de la Copa America");

        String[] opciones = {"Jugar partido", "Lista de Partidos", "Definir Grupos", "Buscar Equipo", "Gestión de Equipos", "Gestión de Jugadores", "Salir"};
        int opcion = 0;
        Equipo seleccionado1 = null;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Elegir", null, 0, 0, null, opciones, opciones);

            switch (opcion) {
                case 0:
                    if (Chiki.getEquipos().size() == 1) {
                        JOptionPane.showMessageDialog(null, "Es el ganador!" + Chiki.getEquipos().get(0).getNombre());
                    } else {
                        String[] equipos = new String[Chiki.getEquipos().size()];
                        for (int i = 0; i < equipos.length; i++) {
                            equipos[i] = Chiki.getEquipos().get(i).getNombre();
                        }

                        String menu = (String) JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("americaa.png")), equipos, equipos[0]);
                        seleccionado1 = Chiki.Buscar(menu);
                        menu = (String) JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("americaa.png")), equipos, equipos[0]);
                        seleccionado1.GenerarEquipo();
                        Equipo seleccionado2 = Chiki.Buscar(menu);
                        seleccionado2.GenerarEquipo();
                        Partido nuevo = Chiki.JugarPartido(seleccionado1, seleccionado2);
                        if (nuevo != null) {
                            JOptionPane.showMessageDialog(null, nuevo);
                            Chiki.getPartidos().add(nuevo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Partido no se agregó a la lista");
                        }
                    }
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, Chiki.verPartidos());
                    break;
                case 2:
                    Chiki.DefinirGrupos();
                    break;
                case 3:
                    
                    break;
                case 4:
                    //sección para gestionar equipos
                    String[] opcionesGestionEquipos = {"Agregar Equipo", "Eliminar Equipo", "Cantidad Total de Equipos", "Lista de Equipos", "Salir"};
                    int opcionGestionEquipos = 0;

                    do {
                        opcionGestionEquipos = JOptionPane.showOptionDialog(null, "Gestión de Equipos", null, 0, 0, null, opcionesGestionEquipos, opcionesGestionEquipos);

                        switch (opcionGestionEquipos) {
                            case 0:
                                String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del nuevo equipo:");
                                String imagenEquipo = JOptionPane.showInputDialog("Ingrese el nombre de la imagen del equipo:");
                                Equipo nuevoEquipo = new Equipo(nombreEquipo, imagenEquipo);
                                Chiki.AgregarEquipo(nuevoEquipo);
                                break;
                            case 1:
                                String nombreEliminarEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo a eliminar:");
                                Equipo equipoEliminar = Chiki.Buscar(nombreEliminarEquipo);
                                Chiki.EliminarEquipo(equipoEliminar);
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Cantidad total de equipos: " + Chiki.CantidadTotalEquipos());
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, Chiki.ObtenerListaEquipos());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Volviendo al menu...");
                                break;
                        }

                    } while (opcionGestionEquipos != 4);
                    break;
                case 5:
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
        } while (opcion != 6);
    }
}
