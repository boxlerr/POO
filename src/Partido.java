import java.util.Random;
import javax.swing.JOptionPane;
import static org.example.enumeradores.Resultado.*;


public class Partido {
	

	private Equipo equipo1;
	private Equipo equipo2;
	private int gol1;
	private int gol2;
	private int duracion;
	private int id;
	private static int contador=0;
    private int golesLocal= new Random().nextInt(1,10);
    private int golesVisitante = new Random().nextInt(1,10);
	
    public Partido() { //para no usar los contructores
    }
    
	public Partido(Equipo equipo1, int goleslocal, int golesVisitante,int numerodeRonda, int cantidaddeequiposenRonda, int cantidadDeEquiposEnLlave, Equipo equipo2, int gol1, int gol2, int duracion) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.gol1 = gol1;
		this.gol2 = gol2;
		this.duracion = duracion;
		contador++;
		this.id = contador;
        this.golesLocal = goleslocal;
        this.golesVisitante = golesVisitante;
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
	
	public int getGoleslocal() {
        return golesLocal;
    }
    public void setGoleslocal(int goleslocal) {
        this.golesLocal = goleslocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
	
    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante) {
        int intentos = 0;
        int maxIntentos = 3; // Máximo número de intentos para desempate

        while (true) {
            int golesLocal = new Random().nextInt(1, 10);
            int golesVisitante = new Random().nextInt(1, 10);

            JOptionPane.showMessageDialog(null,
                    equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);

            equipoLocal.sumarGolesNuevos(golesLocal);
            equipoVisitante.sumarGolesNuevos(golesVisitante);

            if (golesLocal > golesVisitante) {
                equipoVisitante.setAutorizacion(false);
                equipoLocal.setResultado(ganador);
                equipoVisitante.setResultado(perdedor);
                JOptionPane.showMessageDialog(null,
                        "Ganó " + equipoLocal.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoLocal;
            } else if (golesLocal < golesVisitante) {
                equipoLocal.setAutorizacion(false);
                equipoLocal.setResultado(perdedor);
                equipoVisitante.setResultado(ganador);
                JOptionPane.showMessageDialog(null,
                        "Ganó " + equipoVisitante.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoVisitante;
            } else {
                intentos++;
                if (intentos >= maxIntentos) {
                    // Decide qué hacer en caso de empates repetidos
                    JOptionPane.showMessageDialog(null, "Después de " + maxIntentos + " intentos, el partido sigue empatado. Se decide por sorteo.");
                    boolean sorteo = new Random().nextBoolean();
                    JOptionPane.showMessageDialog(null,
                            "El ganador por sorteo es: " + (sorteo ? equipoLocal.getNombre() : equipoVisitante.getNombre()),
                            "Resultado Sorteo", JOptionPane.INFORMATION_MESSAGE);
                    return sorteo ? equipoLocal : equipoVisitante;
                }
                JOptionPane.showMessageDialog(null,
                        "Empate, se jugará de nuevo entre " + equipoLocal.getNombre() + " y " + equipoVisitante.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


	@Override
	public String toString() {
		return "Partido:"  + "\nEquipo 1: " + equipo1.getNombre() + "\nequipo2: " + equipo2.getNombre() + "\nGoles Team 1: " + gol1
				+ "\nGoles Team 2: " + gol2 + "\nDuraciòn: " + duracion + "\nId del partido " + id;
	}
	
	

	
}
