import java.util.List;

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

        // Obtener los ganadores directamente en lugar de usar obtenerGanador()
        Equipo ganadorCuartos1 = partidoCuartos1.getGanador();
        Equipo ganadorCuartos2 = partidoCuartos2.getGanador();

        // Retornar una lista con los equipos ganadores
        return (ganadorCuartos1 != null && ganadorCuartos2 != null) ? (Equipo) List.of(ganadorCuartos1, ganadorCuartos2) : null;
    }

    public static Equipo jugarSemifinal(GestorEquipo torneito, List<Equipo> ganadoresCuartos) {
        if (ganadoresCuartos == null || ganadoresCuartos.size() < 2) {
            return null; // No hay suficientes equipos para jugar la semifinal
        }

        // Obtener equipos aleatorios para la semifinal
        Equipo equipoSemi1 = ganadoresCuartos.get(0);
        Equipo equipoSemi2 = ganadoresCuartos.get(1);

        // Jugar el partido de semifinal
        Partido partidoSemi = torneito.JugarPartido(equipoSemi1, equipoSemi2);

        JOptionPane.showMessageDialog(null, "Resultado Semifinal:\n" + partidoSemi);

        // Obtener el ganador directamente en lugar de usar obtenerGanador()
        Equipo ganadorSemi = partidoSemi.getGanador();

        return ganadorSemi;
    }

    public static Equipo jugarFinal(GestorEquipo torneito, Equipo ganadorSemi1, Equipo ganadorSemi2) {
        if (ganadorSemi1 == null || ganadorSemi2 == null) {
            return null; // No hay suficientes equipos para jugar la final
        }

        // Obtener equipos para la final
        Equipo equipoFinal1 = ganadorSemi1;
        Equipo equipoFinal2 = ganadorSemi2;

        // Jugar el partido de la final
        Partido partidoFinal = torneito.JugarPartido(equipoFinal1, equipoFinal2);

        JOptionPane.showMessageDialog(null, "Resultado Final:\n" + partidoFinal);

        // Obtener el ganador directamente en lugar de usar obtenerGanador()
        Equipo campeon = partidoFinal.getGanador();

        return campeon;
    }
	
	
	
	@Override
	public String toString() {
		return "Partido:"  + "\nEquipo 1: " + equipo1.getNombre() + "\nequipo2: " + equipo2.getNombre() + "\nGoles Team 1: " + gol1
				+ "\nGoles Team 2: " + gol2 + "\nDuraciòn: " + duracion + "\nId del partido " + id;
	}
	
	

	
}
