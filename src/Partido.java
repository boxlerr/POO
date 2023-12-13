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
        JOptionPane.showMessageDialog(null,
                equipoLocal.getNombre() + " " + this.getGoleslocal() + " - " + this.getGolesVisitante() + " " + equipoVisitante.getNombre(),
                "Resultado", JOptionPane.INFORMATION_MESSAGE);

        equipoLocal.sumarGolesNuevos(this.getGoleslocal());
        equipoVisitante.sumarGolesNuevos(this.getGolesVisitante());

        //Aquí tendremos las 3 opciones que puede tener nuestro torneo:
        // gana equipo local, empate o gana visitante.

        if (this.golesLocal > this.golesVisitante) {
            equipoVisitante.setAutorizacion((false));
            equipoLocal.setResultado(ganador);
            equipoVisitante.setResultado(perdedor);
            JOptionPane.showMessageDialog(null,
                    "Ganó " + equipoLocal.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return equipoLocal;
        }
        else if (this.golesLocal == this.golesVisitante) {
            JOptionPane.showMessageDialog(null,
                    "Se jugara el desempate entre " + equipoLocal.getNombre() + " - " + equipoVisitante.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
            equipoLocal.setResultado(empate);
            equipoVisitante.setResultado(empate);
            simularPartido(equipoLocal, equipoVisitante);
        }
        else {
            equipoLocal.setAutorizacion(false);
            equipoLocal.setResultado(perdedor);
            equipoVisitante.setResultado(ganador);
            JOptionPane.showMessageDialog(null,
                    "Ganó " + equipoVisitante.getNombre(),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
            return equipoVisitante;
        }
        return null;
    }

	@Override
	public String toString() {
		return "Partido:"  + "\nEquipo 1: " + equipo1.getNombre() + "\nequipo2: " + equipo2.getNombre() + "\nGoles Team 1: " + gol1
				+ "\nGoles Team 2: " + gol2 + "\nDuraciòn: " + duracion + "\nId del partido " + id;
	}
	
	

	
}
