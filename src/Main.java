// Importaciones de librerías Java para la interfaz gráfica.
import java.awt.BorderLayout; // Utilizado para el diseño de componentes en la ventana.
import javax.swing.ImageIcon; // Permite usar imágenes en la interfaz gráfica.
import javax.swing.JLabel; // Utilizado para mostrar texto o imágenes en la ventana.
import javax.swing.JOptionPane; // Permite crear ventanas emergentes para mostrar información o recibir entrada del usuario.
import javax.swing.JPanel; // Un contenedor que puede contener otros componentes gráficos.

public class Main {
    public static void main(String[] args) {
    	
    	// Crea un nuevo objeto 'torneito' de la clase GestorEquipo, que se encargará de manejar los equipos y partidos del torneo.
        GestorEquipo torneito = new GestorEquipo();
        torneito.getEquipos().add(new Equipo(false, null, "Argentina", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Brasil", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Uruguay", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Chile", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Mexico", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Peru", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Bolivia", 0));
        torneito.getEquipos().add(new Equipo(false, null, "Venezuela", 0));
       
        JOptionPane.showMessageDialog(null, "Bienvenido al torneo de la Copa America \n-Podras simular un torneo con la opcion Definir Grupos!"
        		+ "\n-Podras gestionar tus equipos! \n-Podras gestionar jugadores! \n-Ver el historial de tus partidos! \nJugar la Copa America!! ", "Copa America 2023", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Main.class.getResource("/img/americaa.png")));

        String[] opciones = {"Jugar Torneo","Jugar partido", "Lista de Partidos", "Definir Grupos", "Gestión de Equipos", "Gestión de Jugadores", "Salir"};
        int opcion = 0;// Variable para almacenar la opción seleccionada por el usuario.
        Equipo seleccionado1 = null; // Variable para almacenar un equipo seleccionado.

    do {
           opcion = JOptionPane.showOptionDialog(null, "Elegir", null, 0, 0, null, opciones, opciones);
           switch (opcion) {   
           case 0: //JUGAR TORNEO
        	   
        	   	Jugador jugador = new Jugador();  //creacion para elegir equipo
        	    jugador.elegirEquipo(torneito.getEquipos()); //lista de equipos
        	    Llave llaveDerecha = new Llave(); //creacion llave 1
        	    Llave llaveIzquierda = new Llave(); //creacion llave 2
        	    llaveDerecha.armarLlave(torneito.getEquipos(), 0);
        	    llaveIzquierda.armarLlave(torneito.getEquipos(), 4);

        	    Fase ronda = new Fase();
        	    ronda.Torneo(llaveIzquierda, llaveDerecha); //arranca torneo
        	   
          break;
           case 1:    //JUGAR DOPARTI
        	   
        	   JOptionPane.showMessageDialog(null, "Simula el torneo a tu gusto!");
        	   if (torneito.getEquipos().size() == 1) {   // Comprueba si solo queda un equipo en el torneo.
        	       JOptionPane.showMessageDialog(null, "El ganador es: " + torneito.getEquipos().get(0).getNombre() + "!!!!");
        	       
        	   } else {
        	       // Si hay más de un equipo, se crea un array para almacenar los nombres de los equipos.
        		   String[] equipos = new String[torneito.getEquipos().size()]; 
        	       for (int i = 0; i < equipos.length; i++) { // Llena el array con los nombres de los equipos usando un bucle for.
        	           equipos[i] = torneito.getEquipos().get(i).getNombre();
        	       }
        	       // Muestra un diálogo para seleccionar el primer equipo para el partido.
        	       String menu = (String) JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/americaa.png")), equipos, equipos[0]);
        	       // Busca el equipo seleccionado por el nombre y lo asigna a la variable 'seleccionado1'.
        	       seleccionado1 = torneito.Buscar(menu); 
        	       // Muestra de nuevo el diálogo para seleccionar el segundo equipo.
        	       menu = (String) JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/americaa.png")), equipos, equipos[0]);
        	       
        	       seleccionado1.GenerarEquipo(); // Genera una formación de jugadores para el equipo seleccionado1.
        	       Equipo seleccionado2 = torneito.Buscar(menu); // Busca el segundo equipo seleccionado por el nombre.
        	       seleccionado2.GenerarEquipo();  // Genera una formación de jugadores para el equipo seleccionado2.
        	       JPanel panel = new JPanel(new BorderLayout()); // Prepara un panel para mostrar los equipos en un formato gráfico.
        	       String imagePath1 = "/img/" + seleccionado1.getNombre() + ".png";
        	       ImageIcon iconEquipo1 = loadImageIcon(imagePath1); // Carga la imagen del primer equipo seleccionado.
        	       
        	       // Si la imagen existe, la agrega al panel.
        	       if (iconEquipo1 != null) {
        	           JLabel labelEquipo1 = new JLabel(iconEquipo1);
        	           panel.add(labelEquipo1, BorderLayout.WEST);
        	       }
        	   
        	       JLabel labelVS = new JLabel("VS"); // Agrega un texto 'VS' entre las imágenes de los equipos.
        	       panel.add(labelVS, BorderLayout.CENTER);

        	       // Carga la imagen del segundo equipo seleccionado.
        	       String imagePath2 = "/img/" + seleccionado2.getNombre() + ".png";
        	       ImageIcon iconEquipo2 = loadImageIcon(imagePath2); //loadimageicon al final del codigo
        	       // Si la imagen existe, la agrega al panel.
        	       if (iconEquipo2 != null) {
        	           JLabel labelEquipo2 = new JLabel(iconEquipo2);
        	           panel.add(labelEquipo2, BorderLayout.EAST);
        	       }
        	       // Muestra el panel con las imágenes de los equipos y el texto 'VS'.
        	       JOptionPane.showMessageDialog(null, panel, "Copa America 2023", JOptionPane.DEFAULT_OPTION);

        	       Partido nuevo = torneito.JugarPartido(seleccionado1, seleccionado2); // Juega un partido entre los dos equipos seleccionados y guarda el resultado en 'nuevo'.
        	       // Si se jugó un partido (nuevo no es null), muestra el resultado y lo agrega a la lista de partidos.
        	       if (nuevo != null) {
        	           JOptionPane.showMessageDialog(null, nuevo);
        	           torneito.getPartidos().add(nuevo);
        	       } else {
        	           JOptionPane.showMessageDialog(null, "Partido no se agregó a la lista");
        	       }

                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, torneito.verPartidos()); //HISTORIAL PARTIDOS del case 1
                    break;
                case 3:
                	torneito.DefinirGrupos();  //DEFINIR GRUPOS
                    break;
                case 4:       //GESTIONAR EQUIPO
                    String[] opcionesGestionEquipos = {"Agregar Equipo", "Eliminar Equipo", "Cantidad Total de Equipos",  "Salir"};
                    int opcionGestionEquipos = 0;
                    do {
                        opcionGestionEquipos = JOptionPane.showOptionDialog(null, "Gestión de Equipos", null, 0, 0, null, opcionesGestionEquipos, opcionesGestionEquipos);
                        switch (opcionGestionEquipos) {
                            case 0:
                                String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del nuevo equipo:"); //agregar equipo a la lista para jugar
                                Equipo nuevoEquipo = new Equipo(false, null, nombreEquipo, opcionGestionEquipos);
                                torneito.AgregarEquipo(nuevoEquipo);
                                break;
                            case 1:
                                torneito.EliminarEquipo();
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, torneito.CantidadTotalEquipos());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Volviendo al menu...");
                                break;
                        }
                    } while (opcionGestionEquipos != 3);
                    break;
                case 5: //GESTION DE JUGADOR.   
                    String[] opcionesGestionJugadores = {"Agregar Jugador a Equipo", "Modificar Jugador", "Eliminar Jugador", "Salir"};
                    int opcionGestionJugadores = 0;
                    do {
                        opcionGestionJugadores = JOptionPane.showOptionDialog(null, "Gestión de Jugadores", null, 0, 0, null, opcionesGestionJugadores, opcionesGestionJugadores);
                        switch (opcionGestionJugadores) {
                            case 0:                                  
                            	// Obtener nombres de equipos
                                String[] nombresEquipos = new String[torneito.getEquipos().size()];
                                for (int i = 0; i < nombresEquipos.length; i++) {
                                    nombresEquipos[i] = torneito.getEquipos().get(i).getNombre();
                                }
                                torneito.AgregarJugador(nombresEquipos);
                                break;
                            case 1:
                                torneito.modificarJugador();
                                break;
                            case 2:
                                torneito.eliminarJugador();
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
    
    }//solucion que encontre para poder jugar con los equipos agregadossss porfinnn 
    private static ImageIcon loadImageIcon(String path) {
        // Bloque 'try-catch' para manejar posibles errores durante la carga del archivo de imagen.
        try { //haciendo uso por primera vez de try-catch
            // Intenta cargar una imagen usando la ruta proporcionada.
            // 'Main.class.getResource(path)' busca el recurso en la misma ubicación que la clase 'Main'.
            return new ImageIcon(Main.class.getResource(path));
        } catch (Exception e) {
            // En caso de error, imprime la pila de llamadas del error para ayudar a diagnosticar el problema.
            e.printStackTrace();
            return null;
        }
    }
}
