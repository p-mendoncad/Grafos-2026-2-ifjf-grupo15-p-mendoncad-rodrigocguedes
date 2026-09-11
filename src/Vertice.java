import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Vertice {
    private final String id;
    private final List<Aresta> arestas;

    public Vertice(String id) {
        this.id = id;
        this.arestas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    public List<Aresta> getArestas() {
        return Collections.unmodifiableList(arestas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(id, vertice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
