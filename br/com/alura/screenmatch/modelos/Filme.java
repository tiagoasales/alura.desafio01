package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        
        String description = 
        """
            
            ********************************
             Filme: %s
             Ano de Lançamento: %s
            ********************************

        """;
        
        return String.format(description, this.getNome(), this.getAnoDeLancamento());
    }
}
