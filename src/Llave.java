import java.util.LinkedList;

public class Llave {
	
    private LinkedList<Equipo> equiposDeLlave; //almacena los equipos
    private String nombreDeLlave;

    
    public Llave() { //constru vacio
    }

    // Constructor con parámetros. Se utiliza para crear una instancia de Llave e inicializar sus atributos
    public Llave(String nombredellave, LinkedList<Equipo> equiposDeLlave) {
        this.equiposDeLlave = equiposDeLlave; // Asigna la lista de equipos a la llave
        this.nombreDeLlave = nombredellave;   // Asigna el nombre a la llave
    }


    public LinkedList<Equipo> getEquiposDeLlave() {
        return equiposDeLlave;
    }

    
    public void setEquiposDeLlave(LinkedList<Equipo> equiposDeLlave) {
        this.equiposDeLlave = equiposDeLlave; // Actualiza la lista de equipos de la llave
    }


    public String getNombreDeLlave() {
        return nombreDeLlave;
    }

    // Método para armar la llave con equipos específicos de una lista general
    public void armarLlave(LinkedList<Equipo> listaGeneral, int indiceInicial){
        LinkedList<Equipo> equiposllaves= new LinkedList<>(); // Crea una nueva lista para los equipos de la llave

        // Bucle que recorre los equipos desde un índice inicial hasta el índice inicial más 4
        for(int i=indiceInicial; i<indiceInicial+4; i++){
            equiposllaves.add(listaGeneral.get(i)); // Añade equipos a la llave desde la lista general
        }
        this.equiposDeLlave = equiposllaves; // Establece los equipos de la llave
    }
}
