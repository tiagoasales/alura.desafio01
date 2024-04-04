import java.util.ArrayList;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Pessoa;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());
        //meuFilme.somaDasAvaliacoes = 10;
        //meuFilme.totalDeAvaliacoes = 1;
        //System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2009);
        outroFilme.setDuracaoEmMinutos(200);

        // CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        // calculadora.inclui(meuFilme);
        // calculadora.inclui(outroFilme);
        // calculadora.inclui(lost);
        // System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        //System.out.println(outroFilme);

        ArrayList<Filme> filmes = new ArrayList<>();

        filmes.add(meuFilme);
        filmes.add(outroFilme);
        System.out.println("Primeiro Filme do Array:" + filmes.get(0));

        //System.out.println(filmes);

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Pessoa danielle = new Pessoa(1, "Danielle Persoli", 42);
        Pessoa tiago = new Pessoa(2, "Tiago Sales", 40);
        Pessoa laura = new Pessoa(3, "Laura Cavalcante", 7);

        pessoas.add(danielle);
        pessoas.add(tiago);
        pessoas.add(laura);

        System.out.println("Tamanho da lista de Pessoas: " + pessoas.size());
        System.out.println("Primeira pessoa: " + pessoas.get(0));
        System.out.println(pessoas);
    }
}