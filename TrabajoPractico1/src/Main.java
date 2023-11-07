import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {
		
		GestorEquipo Chiki = new GestorEquipo();
		Chiki.getEquipos().add(new Equipo("River","Nuñez","river.jpg"));
		Chiki.getEquipos().add(new Equipo("Boca","La boca","boque.jpg"));
		Chiki.getEquipos().add(new Equipo("Racing","avellaneda",""));
		Chiki.getEquipos().add(new Equipo("Independiente","avellaneda",""));

		//Crear equipos que falten 
		
		//menu con opciones
		String[] equipos= new String[Chiki.getEquipos().size()];
		for (int i = 0; i < equipos.length; i++) {
			equipos[i]=Chiki.getEquipos().get(i).getNombre();
		}
		String opcion = (String)JOptionPane
				.showInputDialog(null, 
						"Menu", 
						"Selección de equipos", 
						JOptionPane.DEFAULT_OPTION, 
						new ImageIcon(
								Main.class.getResource("plf.png")),
						equipos, equipos[0]);
		Equipo selecionado=	Chiki.Buscar(opcion);
		if(selecionado!=null) {
			
			JOptionPane.showMessageDialog(null,selecionado,"",JOptionPane.DEFAULT_OPTION,new ImageIcon(Main.class.getResource(selecionado.getFoto()),null));
			if (selecionado.AgregarJugador(opcion, opcion, 0, 0)) {
				
			}
		}
	}

}
