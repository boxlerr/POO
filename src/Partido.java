import javax.swing.JOptionPane;
import org.example.enumeradores.Resultado;
import java.util.Random;

public class Partido {
	private Equipo equipo1;
    private Equipo equipo2;
    private int gol1;
    private int gol2;
    private int duracion;
    private int id;
    private static int contador = 0;
    private int golesLocal = new Random().nextInt(1, 10);
    private int golesVisitante = new Random().nextInt(1, 10);

    public Partido() {
        // Constructor vacío utilizado en el código actual
    }

    public Partido(Equipo equipo1, int goleslocal, int golesVisitante, int duracion, Equipo equipo2, int gol1, int gol2) {
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

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante) {
        int intentos = 0;
     // Máximo número de intentos para desempatar un partido
        int maxIntentos = 3;
        
        // Bucle infinito para simular el partido hasta obtener un resultado
        while (true) {
            // Genera una cantidad aleatoria de goles para cada equipo entre 1 y 9
            int golesLocal = new Random().nextInt(1, 10);
            int golesVisitante = new Random().nextInt(1, 10);

            // Muestra el resultado provisional del partido
            JOptionPane.showMessageDialog(null,
                    equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);

            // Suma los goles al total del torneo para cada equipo
            equipoLocal.sumarGolesNuevos(golesLocal);
            equipoVisitante.sumarGolesNuevos(golesVisitante);

            // Comprueba si hay un ganador
            if (golesLocal > golesVisitante) {
                // Desautoriza al equipo perdedor para la siguiente ronda
                equipoVisitante.setAutorizacion(false);
                // Establece los resultados de los equipos
                equipoLocal.setResultado(Resultado.ganador);
                equipoVisitante.setResultado(Resultado.perdedor);
                // Muestra el ganador
                JOptionPane.showMessageDialog(null,
                        "Ganó " + equipoLocal.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoLocal;
            } else if (golesLocal < golesVisitante) {
                // Desautoriza al equipo perdedor para la siguiente ronda
                equipoLocal.setAutorizacion(false);
                // Establece los resultados de los equipos
                equipoLocal.setResultado(Resultado.perdedor);
                equipoVisitante.setResultado(Resultado.ganador);
                // Muestra el ganador
                JOptionPane.showMessageDialog(null,
                        "Ganó " + equipoVisitante.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoVisitante;
            } else {
                // Incrementa el contador de intentos en caso de empate
                intentos++;
                // Si se alcanza el máximo de intentos, se decide el ganador por sorteo
                if (intentos >= maxIntentos) {
                    JOptionPane.showMessageDialog(null, "Después de " + maxIntentos + " intentos, el partido sigue empatado. Se decide por sorteo.");
                    // Realiza un sorteo para decidir el ganador
                    boolean sorteo = new Random().nextBoolean();
                    JOptionPane.showMessageDialog(null,
                            "El ganador por sorteo es: " + (sorteo ? equipoLocal.getNombre() : equipoVisitante.getNombre()),
                            "Resultado Sorteo", JOptionPane.INFORMATION_MESSAGE);
                    return sorteo ? equipoLocal : equipoVisitante;
                }
                // Notifica que se jugará de nuevo en caso de empate
                JOptionPane.showMessageDialog(null,
                        "Empate, se jugará de nuevo entre " + equipoLocal.getNombre() + " y " + equipoVisitante.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    @Override
    public String toString() {
        return "Partido:\n" +"Equipo 1: " + equipo1.getNombre() + "\n" +"Equipo 2: " + equipo2.getNombre() + "\n" +"Goles Equipo 1: " + gol1 + "\n" +"Goles Equipo 2: " + gol2 + "\n" +"Duración: " + duracion + "\n" +"ID del partido: " + id;
    }
}
