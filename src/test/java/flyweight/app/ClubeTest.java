package flyweight.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ClubeTest {

    @Test
    void deveRetornarResenhas() {
        Clube clube = new Clube("Clube de Ficção Científica");
        clube.publicarResenha("Ana", "Worldbuilding impecável", "Duna", "livro");
        clube.publicarResenha("Bruno", "Lento no começo", "Duna", "livro");
        clube.publicarResenha("Carla", "Melhor animação do ano", "Arcane", "série");

        List<String> saida = Arrays.asList(
                "Resenha{autor='Ana', texto='Worldbuilding impecável', obra='Duna', tipo='livro'}",
                "Resenha{autor='Bruno', texto='Lento no começo', obra='Duna', tipo='livro'}",
                "Resenha{autor='Carla', texto='Melhor animação do ano', obra='Arcane', tipo='série'}");

        assertEquals(saida, clube.obterResenhas());
    }

    @Test
    void deveRetornarTotalObras() {
        Clube clube = new Clube("Clube de Ficção Científica");
        clube.publicarResenha("Ana", "Worldbuilding impecável", "Duna", "livro");
        clube.publicarResenha("Bruno", "Lento no começo", "Duna", "livro");
        clube.publicarResenha("Davi", "Releitura obrigatória", "Duna", "livro");
        clube.publicarResenha("Carla", "Melhor animação do ano", "Arcane", "série");
        clube.publicarResenha("Elisa", "Trilha sonora incrível", "Arcane", "série");

        assertEquals(2, ObraFactory.getTotalObras());
    }

    @Test
    void resenhasDaMesmaObraDevemCompartilharObra() {
        Clube clube = new Clube("Clube de Ficção Científica");
        clube.publicarResenha("Ana", "Worldbuilding impecável", "Duna", "livro");
        clube.publicarResenha("Bruno", "Lento no começo", "Duna", "livro");

        assertSame(clube.getResenhas().get(0).getObra(), clube.getResenhas().get(1).getObra());
    }

    @Test
    void resenhasDeObrasDiferentesNaoDevemCompartilharObra() {
        Clube clube = new Clube("Clube de Ficção Científica");
        clube.publicarResenha("Ana", "Worldbuilding impecável", "Duna", "livro");
        clube.publicarResenha("Carla", "Melhor animação do ano", "Arcane", "série");

        assertNotSame(clube.getResenhas().get(0).getObra(), clube.getResenhas().get(1).getObra());
    }

    @Test
    void obraDeveSerCompartilhadaEntreClubes() {
        Clube ficcao = new Clube("Clube de Ficção Científica");
        Clube classicos = new Clube("Clube de Clássicos");
        ficcao.publicarResenha("Ana", "Worldbuilding impecável", "Duna", "livro");
        classicos.publicarResenha("Bruno", "Já é um clássico", "Duna", "livro");

        assertSame(ficcao.getResenhas().get(0).getObra(), classicos.getResenhas().get(0).getObra());
    }
}
