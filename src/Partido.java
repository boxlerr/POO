import javax.swing.JOptionPane;

public class Partido {
	

	private Equipo equipo1;
	private Equipo equipo2;
	private int gol1;
	private int gol2;
	private int duracion;
	private int id;
	private static int contador=0;
	
	
	public Partido(Equipo equipo1, Equipo equipo2, int gol1, int gol2, int duracion) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.gol1 = gol1;
		this.gol2 = gol2;
		this.duracion = duracion;
		contador++;
		this.id = contador;
	}
	
	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGol1() {
		return gol1;
	}

	public void setGol1(int gol1) {
		this.gol1 = gol1;
	}

	public int getGol2() {
		return gol2;
	}

	public void setGol2(int gol2) {
		this.gol2 = gol2;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Partido.contador = contador;
	}
	
	public Equipo getGanador() {
        if (gol1 > gol2) {
            return equipo1;
        } else if (gol2 > gol1) {
            return equipo2;
        } else {
            return null; // Empate
        }
    }
	
	private static Equipo obtenerEquipoAleatorio(GestorEquipo torneito) {
        int indiceAleatorio = (int) (Math.random() * torneito.getEquipos().size());
        return torneito.getEquipos().get(indiceAleatorio);
    }
	
	
	public static Equipo jugarCuartosDeFinal(GestorEquipo torneito) {
        // Obtener equipos aleatorios para los cuartos de final
        Equipo equipoCuartos1 = obtenerEquipoAleatorio(torneito);
        Equipo equipoCuartos2 = obtenerEquipoAleatorio(torneito);
        Equipo equipoCuartos3 = obtenerEquipoAleatorio(torneito);
        Equipo equipoCuartos4 = obtenerEquipoAleatorio(torneito);

        // Jugar los partidos de cuartos de final
        Partido partidoCuartos1 = torneito.JugarPartido(equipoCuartos1, equipoCuartos2);
        Partido partidoCuartos2 = torneito.JugarPartido(equipoCuartos3, equipoCuartos4);

        JOptionPane.showMessageDialog(null, "Resultados Cuartos de Final:\n" + partidoCuartos1 + "\n" + partidoCuartos2);

        // Obtener el ganador directamente en lugar de usar obtenerGanador()
        Equipo ganadorCuartos1 = partidoCuartos1.getGanador();
        Equipo ganadorCuartos2 = partidoCuartos2.getGanador();

        return ganadorCuartos1 != null ? ganadorCuartos1 : ganadorCuartos2;
    }
	
	
	
	@Override
	public String toString() {
		return "Partido:"  + "\nEquipo 1: " + equipo1.getNombre() + "\nequipo2: " + equipo2.getNombre() + "\nGoles Team 1: " + gol1
				+ "\nGoles Team 2: " + gol2 + "\nDuraciòn: " + duracion + "\nId del partido " + id;
	}
	
	

	
}
