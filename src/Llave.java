import java.util.LinkedList;
import java.util.List;

public class Llave {
    private LinkedList<Equipo> equiposDeLlave;
    private String nombreDeLlave;

    //Constructores
    public Llave() {
    }
    public Llave(String nombredellave, LinkedList <Equipo> equiposDeLlave) {
        this.equiposDeLlave = equiposDeLlave;
        this.nombreDeLlave = nombredellave;
    }
    //Setters and getters
    public List<Equipo> getEquiposDeLlave() {
        return equiposDeLlave;
    }
    public void setEquiposDeLlave(LinkedList <Equipo> equiposDeLlave) {
        this.equiposDeLlave = equiposDeLlave;
    }

    public String getNombreDeLlave() {
        return nombreDeLlave;
    }
    public void setNombreDeLlave(String nombreDeLlave) {
        this.nombreDeLlave = nombreDeLlave;
    }

    public void armarLlave(LinkedList<Equipo> listaGeneral, int indiceInicial){
    	LinkedList<Equipo> equiposllaves= new LinkedList<>();
    //Bucle para llenar las llaves

        for(int i=indiceInicial; i<indiceInicial+4;i++){
            equiposllaves.add(listaGeneral.get(i));
        }
        this.equiposDeLlave = equiposllaves;
    }
}
