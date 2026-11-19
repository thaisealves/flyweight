package flyweight.app;

import java.util.HashMap;
import java.util.Map;

public class ObraFactory {

    private static Map<String, Obra> obras = new HashMap<>();

    public static Obra getObra(String titulo, String tipo) {
        Obra obra = obras.get(titulo);
        if (obra == null) {
            obra = new Obra(titulo, tipo);
            obras.put(titulo, obra);
        }
        return obra;
    }

    public static int getTotalObras() {
        return obras.size();
    }
}
