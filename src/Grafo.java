import java.util.Collection;
import java.util.Collections;

public class Grafo {
    private final boolean direcionado;
    private final boolean ponderado;

    public Grafo(boolean direcionado, boolean ponderado) {
        this.direcionado = direcionado;
        this.ponderado = ponderado;
    }

    public boolean isDirecionado() {
        return direcionado;
    }

    public boolean isPonderado() {
        return ponderado;
    }

    public boolean adicionarVertice(String id) {
        if (id == null || id.isBlank()) {
            return false;
        }
        if (vertices.containsKey(id)) {
            return false;
        }
        vertices.put(id, new Vertice(id));
        return true;
    }

    public Vertice obterVertice(String id) {
        return vertices.get(id);
    }

    public Collection<Vertice> getVertices() {
        return Collections.unmodifiableCollection(vertices.values());
    }
}
