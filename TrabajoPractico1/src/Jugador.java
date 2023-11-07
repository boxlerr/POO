
public class Jugador {
	
	private String nombre;
	private String posición;
	private int numerodecamiseta;
	private int edad;
	public Jugador(String nombre, String posición, int numerodecamiseta, int edad) {
		super();
		this.nombre = nombre;
		this.posición = posición;
		this.numerodecamiseta = numerodecamiseta;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosición() {
		return posición;
	}
	public void setPosición(String posición) {
		this.posición = posición;
	}
	public int getNumerodecamiseta() {
		return numerodecamiseta;
	}
	public void setNumerodecamiseta(int numerodecamiseta) {
		this.numerodecamiseta = numerodecamiseta;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posición=" + posición + ", numerodecamiseta=" + numerodecamiseta
				+ ", edad=" + edad + "]";
	}
	

}
