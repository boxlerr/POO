import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

class Main {
	
	//Crear instancias de jugadores, equipos y el gestor de equipos.
	//Realizar pruebas de todas las operaciones implementadas, cómo agregar jugadores a un equipo, buscar un jugador por nombre, eliminar un equipo, etc.
	//Simular partidos entre equipos utilizando el método "jugarPartido".


	public static void main(String[] args) {
		
		GestorEquipo Chiki = new GestorEquipo();
		Chiki.getEquipos().add(new Equipo("River","Nuñez","river.jpg"));
		Chiki.getEquipos().add(new Equipo("Boca","La boca","boque.jpg"));
		Chiki.getEquipos().add(new Equipo("Racing","avellaneda",""));
		Chiki.getEquipos().add(new Equipo("Independiente","avellaneda",""));

		//Crear equipos que falten 
		
		//menu con opciones
		String [] opciones = {"Jugar partido","Salir"};
		int opcion = 0;
		do {
			
		opcion = JOptionPane.showOptionDialog(null, "Elegir", null, 0, 0, null, opciones, opciones);	

			switch (opcion) {
			case 0: 
				String[] equipos= new String[Chiki.getEquipos().size()];
				for (int i = 0; i < equipos.length; i++) {
					equipos[i]=Chiki.getEquipos().get(i).getNombre();
				}
				String menu = (String)JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("trav.jpg")),equipos, equipos[0]);
				Equipo selecionado=	Chiki.Buscar(menu);
					   menu = (String)JOptionPane.showInputDialog(null, "Menu", "Selección de equipos", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("trav.jpg")),equipos, equipos[0]);
				Equipo selecionado2=	Chiki.Buscar(menu);
				Partido nuevo = Chiki.JugarPartido(selecionado, selecionado2);
				if (nuevo!=null) {
					JOptionPane.showMessageDialog(null, nuevo);
				}
				
			break;
			case 1:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
			default:
				break;
			}
		
		
			
		} while (opcion!= 1);
	}

}
