import javax.swing.JOptionPane;
import org.example.enumeradores.Resultado;
import java.util.Random;

public class Partido {

    public Partido() {
        // Constructor vacío necesario si no hay otros constructores definidos
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
                equipoLocal.setResultado(Resultado.ganador);
                equipoVisitante.setResultado(Resultado.perdedor);
                JOptionPane.showMessageDialog(null,
                        "Ganó " + equipoLocal.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoLocal;
            } else if (golesLocal < golesVisitante) {
                equipoLocal.setAutorizacion(false);
                equipoLocal.setResultado(Resultado.perdedor);
                equipoVisitante.setResultado(Resultado.ganador);
                JOptionPane.showMessageDialog(null,
                        "Ganó " + equipoVisitante.getNombre(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoVisitante;
            } else {
                intentos++;
                if (intentos >= maxIntentos) {
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
}
