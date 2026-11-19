package flyweight.app;

public class Obra {

    private String titulo;
    private String tipo;

    public Obra(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }
}
