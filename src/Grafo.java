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
}
