package br.com.alura.screenmatch.modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Lista de titulos que será gerado um json ao final
        ArrayList<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

        // leitor da entrada de dados na console
        Scanner input = new Scanner(System.in);

        // escritor de arquivo
        FileWriter writer = new FileWriter("movies.json");

        System.out.println("Qual filme deseja buscar as informações?");
        var textSearch = input.nextLine();


        while (!textSearch.equalsIgnoreCase("exit")) {

            try {

                String endereco = "https://www.omdbapi.com/?t=" + textSearch + "&apikey=6585022c";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);

                //writer.write(json);
                titulos.add(meuTitulo);

                System.out.println("Qual filme deseja buscar as informações?");
                textSearch = input.nextLine();

            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {

            // grava o json dos títulos no arquivo
            writer.write(gson.toJson(titulos));

            System.out.println("Programa finalizou com sucesso!!!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
            writer.close();
        }
    }
}
