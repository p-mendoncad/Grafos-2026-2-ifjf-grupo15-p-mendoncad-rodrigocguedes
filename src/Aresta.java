import java.util.Objects;

public class Aresta {
    private final Vertice destino;
    private final Double peso;

    public Aresta(Vertice destino, Double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getDestino() {
        return destino;
    }

    public Double getPeso() {
        return peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;
        return Objects.equals(destino, aresta.destino) && Objects.equals(peso, aresta.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destino, peso);
    }
}
