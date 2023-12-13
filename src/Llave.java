import java.util.ArrayList;
import java.util.List;

public class Llave {
    private List<Equipo> equiposDeLlave;
    private String nombreDeLlave;

    //Constructores
    public Llave() {
    }
    public Llave(String nombredellave, List<Equipo> equiposDeLlave) {
        this.equiposDeLlave = equiposDeLlave;
        this.nombreDeLlave = nombredellave;
    }
    //Setters and getters
    public List<Equipo> getEquiposDeLlave() {
        return equiposDeLlave;
    }
    public void setEquiposDeLlave(List<Equipo> equiposDeLlave) {
        this.equiposDeLlave = equiposDeLlave;
    }

    public String getNombreDeLlave() {
        return nombreDeLlave;
    }
    public void setNombreDeLlave(String nombreDeLlave) {
        this.nombreDeLlave = nombreDeLlave;
    }

    public void armarLlave(List<Equipo> listaGeneral, int indiceInicial){
        List<Equipo> equiposllaves=new ArrayList<>();
    //Bucle para llenar las llaves

        for(int i=indiceInicial; i<indiceInicial+4;i++){
            equiposllaves.add(listaGeneral.get(i));
        }
        this.equiposDeLlave = equiposllaves;
    }
}
