import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {
		
		GestorEquipo Chiki = new GestorEquipo();
		Chiki.getEquipos().add(new Equipo("River","Nuñez","river.jpg"));
		Chiki.getEquipos().add(new Equipo("Boca","La boca","boque.jpg"));
		Chiki.getEquipos().add(new Equipo("Racing","avellaneda",""));
		Chiki.getEquipos().add(new Equipo("Independiente","avellaneda",""));
		Chiki.getEquipos().add(new Equipo("Sacachispas","Villa Soldati","river.jpg"));
		Chiki.getEquipos().add(new Equipo("Moron","Moron","boque.jpg"));
		Chiki.getEquipos().add(new Equipo("Ferro","Caballito",""));
		Chiki.getEquipos().add(new Equipo("Velez","Liniers",""));
		

		//Crear equipos que falten 
		
		//menu con opciones
		String [] opciones = {"Jugar partido","Lista de Partidos","Definir Grupos","Buscar Equipo","Salir"};
		int opcion = 0;
		do {
			
		opcion = JOptionPane.showOptionDialog(null, "Elegir", null, 0, 0, null, opciones, opciones);	

			switch (opcion) {
			case 0: 
				if (Chiki.getEquipos().size()==1) {
					JOptionPane.showMessageDialog(null, "Es el ganador!" + Chiki.getEquipos().get(0).getNombre());
				}else{
					
				String[] equipos= new String[Chiki.getEquipos().size()];
				for (int i = 0; i < equipos.length; i++) {
					equipos[i]=Chiki.getEquipos().get(i).getNombre();
				}
				
				
					String menu = (String)JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("a.png")),equipos, equipos[0]);
					Equipo selecionado1 = Chiki.Buscar(menu);
					menu = (String)JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("a.png")),equipos, equipos[0]);
					selecionado1.GenerarEquipo();				
					Equipo selecionado2 = Chiki.Buscar(menu);
					//JOptionPane.showMessageDialog(null, selecionado1);
					selecionado2.GenerarEquipo();
					//JOptionPane.showMessageDialog(null, selecionado2);
					Partido nuevo = Chiki.JugarPartido(selecionado1, selecionado2); 
					if (nuevo!=null) {
						JOptionPane.showMessageDialog(null, nuevo);
						Chiki.getPartidos().add(nuevo);
					}else{
						JOptionPane.showMessageDialog(null, "Partido nmo se agrego a la lista");
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
				String[] equipos = new String [Chiki.getEquipos().size()];
				for (int i = 0; i < equipos.length; i++) {
					equipos[i]=Chiki.getEquipos().get(i).getNombre();
				}
				String menu = (String)JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("a.png")),equipos, equipos[0]);
				Equipo selecionado1=Chiki.Buscar(menu);
				JOptionPane.showMessageDialog(null, selecionado1);
				
				String [] opcionesEquipo = {"Agregar Jugador a Equipo","Salir"};
				int opcionequipo=0;
				do {
	
				//opcionequipo = JOptionPane.showOptionDialog(null, "Menu", menu, opcion, opcion, null, opcionesEquipo, opcionesEquipo[0]);
					opcionequipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Opcion"));
				switch (opcionequipo) {
				case 0:
					String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
					String posicion = JOptionPane.showInputDialog("Ingrese Posicion");
					String numero = JOptionPane.showInputDialog("Ingrese Numero");
					String edad = JOptionPane.showInputDialog("Ingrese Edad");

					
					if (selecionado1.AgregarJugador(nombre, posicion, Integer.parseInt(numero), Integer.parseInt(edad))) {
						JOptionPane.showMessageDialog(null, "Se agrego");
					}else{
						JOptionPane.showMessageDialog(null, "No se agrego");

					}
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Salir");
					break;
				default:
					break;
				}
				} while (opcionequipo!=1);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
			if () {
				
			}
		
		
			
		} while (opcion!= 1);
	}

}
