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

    public int obterOrdem() {
        return vertices.size();
    }

    public int calcularGrau(Vertice vertice) {
        int grau = 0;
        for (Aresta aresta : vertice.getArestas()) {
            if (aresta.getDestino().equals(vertice)) {
                grau += 2;
            } else {
                grau += 1;
            }
        }
        return grau;
    }

    public int calcularGrauEntrada(Vertice vertice) {
        int grauEntrada = 0;
        for (Vertice v : vertices.values()) {
            for (Aresta aresta : v.getArestas()) {
                if (aresta.getDestino().equals(vertice)) {
                    grauEntrada++;
                }
            }
        }
        return grauEntrada;
    }

    public int calcularGrauSaida(Vertice vertice) {
        return vertice.getArestas().size();
    }
}
