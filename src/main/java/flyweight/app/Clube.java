package flyweight.app;

import java.util.ArrayList;
import java.util.List;

public class Clube {

    private String nome;
    private List<Resenha> resenhas = new ArrayList<>();

    public Clube(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Resenha> getResenhas() {
        return resenhas;
    }

    public void publicarResenha(String autor, String texto, String tituloObra, String tipoObra) {
        Obra obra = ObraFactory.getObra(tituloObra, tipoObra);
        Resenha resenha = new Resenha(autor, texto, obra);
        resenhas.add(resenha);
    }

    public List<String> obterResenhas() {
        List<String> saida = new ArrayList<String>();
        for (Resenha resenha : this.resenhas) {
            saida.add(resenha.obterResenha());
        }
        return saida;
    }
}
