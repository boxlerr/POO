import java.time.LocalDateTime;

public class Partido {
	
	private LocalDateTime fechayhora;
	private Equipo equipo1;
	private Equipo equipo2;
	private int gol1;
	private int gol2;
	private int duracion;
	private int id;
	private static int contador=0;
	
	
	public Partido(LocalDateTime fechayhora, Equipo equipo1, Equipo equipo2, int gol1, int gol2, int duracion) {
		super();
		this.fechayhora = fechayhora;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.gol1 = gol1;
		this.gol2 = gol2;
		this.duracion = duracion;
		contador++;
		this.id = contador;
	}


	@Override
	public String toString() {
		return "Partido [fechayhora=" + fechayhora + ", equipo1=" + equipo1.getNombre() + ", equipo2=" + equipo2.getNombre() + ", gol1=" + gol1
				+ ", gol2=" + gol2 + ", duracion=" + duracion + ", id=" + id + "]";
	}
	
	

	
}
