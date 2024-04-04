package br.com.alura.screenmatch.modelos;

public class Pessoa {

    private int id;

    private String nome;

    private int idade;
    
    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " Idade: " + this.getIdade();
    }
    
}
