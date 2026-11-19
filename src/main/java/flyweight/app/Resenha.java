package flyweight.app;

public class Resenha {

    private String autor;
    private String texto;
    private Obra obra;

    public Resenha(String autor, String texto, Obra obra) {
        this.autor = autor;
        this.texto = texto;
        this.obra = obra;
    }

    public Obra getObra() {
        return obra;
    }

    public String obterResenha() {
        return "Resenha{" +
                "autor='" + this.autor + '\'' +
                ", texto='" + this.texto + '\'' +
                ", obra='" + obra.getTitulo() + '\'' +
                ", tipo='" + obra.getTipo() + '\'' +
                '}';
    }
}
