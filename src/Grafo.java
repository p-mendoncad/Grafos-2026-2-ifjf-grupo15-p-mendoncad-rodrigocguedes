import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Grafo {
    private final boolean direcionado;
    private final boolean valorado;
    private final Map<String, Vertice> vertices;

    public Grafo(boolean direcionado, boolean valorado) {
        this.direcionado = direcionado;
        this.valorado = valorado;
        this.vertices = new LinkedHashMap<>();
    }

    public boolean isDirecionado() {
        return direcionado;
    }

    public boolean isValorado() {
        return valorado;
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

    public boolean adicionarAresta(String origemId, String destinoId, Double peso) {
        Vertice origem = vertices.get(origemId);
        Vertice destino = vertices.get(destinoId);

        if (origem == null || destino == null) {
            return false;
        }

        Double pesoAresta = valorado ? peso : null;
        origem.adicionarAresta(new Aresta(destino, pesoAresta));

        if (!direcionado && !origem.equals(destino)) {
            destino.adicionarAresta(new Aresta(origem, pesoAresta));
        }

        return true;
    }
}
