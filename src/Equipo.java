import org.example.enumeradores.Resultado; //se importa el package de resultado //haciendo uso por primera vez de esto.

// La clase 'Equipo' extiende de 'Jugador', lo que significa que hereda características y comportamientos de la clase 'Jugador'.
public class Equipo extends Jugador {
    
    // Declaración de variables privadas de la clase 'Equipo'.
    private boolean autorizacion = true; // Esta variable indica si el equipo está autorizado para jugar.
    private Resultado resultado; // Variable que almacena el resultado del equipo (ganador, perdedor, etc.).
    private String nombre; // Nombre del equipo.
    private int cantidadGolesEnElTorneo; // Total de goles marcados por el equipo en el torneo.

    // Constructor de la clase 'Equipo'.
    public Equipo(boolean autorizacion, Resultado resultado, String nombre, int cantidadGolesEnElTorneo) {
        super(); // Llama al constructor de la clase padre (Jugador).
        this.autorizacion = autorizacion; // Inicializa la variable 'autorizacion'.
        this.nombre = nombre; // Inicializa la variable 'nombre'.
        this.resultado = resultado; // Inicializa la variable 'resultado'.
        this.cantidadGolesEnElTorneo = cantidadGolesEnElTorneo; // Inicializa la variable 'cantidadGolesEnElTorneo'.
    }

    public boolean getAutorizacion() {
        return autorizacion;
    }
    
    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }
    
    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadGolesEnElTorneo() {
        return cantidadGolesEnElTorneo;
    }

    public void setCantidadGolesEnElTorneo(int cantidadGolesEnElTorneo) {
        this.cantidadGolesEnElTorneo = cantidadGolesEnElTorneo;
    }

    public boolean AgregarJugador(String nombre, String posicion, int numeroCamiseta, int edad) {
        // Crea un nuevo jugador y lo agrega a la lista de jugadores heredada de 'Jugador'.
        Jugador nuevoJugador = new Jugador(nombre, posicion, numeroCamiseta, edad);
        this.getJugadores().add(nuevoJugador);
        return true; // Retorna true para indicar que el jugador fue agregado exitosamente.
    }

    public void sumarGolesNuevos(int nuevosGoles) {
        this.cantidadGolesEnElTorneo += nuevosGoles;
    }

    public void GenerarEquipo() {
        // Array con las posiciones posibles de los jugadores.
        String[] posicion = {"Delantero", "Arquero", "Defensa", "Mediocampista"};
        
        // Bucle para crear 11 jugadores con posiciones aleatorias.
        for (int i = 0; i < 11; i++) {
            int aleatorio = (int)(Math.random() * 4);
            this.getJugadores().add(new Jugador("Jugador: " + i, posicion[aleatorio], i, 4));
        }
    }

    @Override
    public String toString() {
        return "  " + nombre + "  ";
    }
}
