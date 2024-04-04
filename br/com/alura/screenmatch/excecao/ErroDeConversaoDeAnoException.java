package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {

    private String mensagem;

    public ErroDeConversaoDeAnoException(String mensagem){
        super(mensagem);
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
