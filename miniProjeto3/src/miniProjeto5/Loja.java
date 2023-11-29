package miniProjeto5;

import miniProjeto1.Livro;
import miniProjeto2.Genero;
import miniProjeto1.LivroDigital;
import miniProjeto1.Autor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Loja<T extends Livro> {

    private List<T> itens;

    public Loja() {
        this.itens = new ArrayList<>();
    }

    // Método para carregar livros de um arquivo
    public void carregarLivrosDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Parse da linha para criar instâncias de Livro
                // Adapte conforme a estrutura do seu arquivo
                T livro = parseLinhaParaLivro(linha);
                if (livro != null) {
                    itens.add(livro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar itens disponíveis
    public void mostrarItensDisponiveis() {
        for (T item : itens) {
            System.out.println(item.toString());
        }
    }

    // Método para filtrar por autor
    public List<T> filtrarPorAutor(String autor) {
        return itens.stream()
                .filter(item -> item.getAutor().getNome().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    // Método para filtrar por gênero
    public List<T> filtrarPorGenero(Genero genero) {
        return itens.stream()
                .filter(item -> item.getGenero() == genero)
                .collect(Collectors.toList());
    }

    // Método para adicionar um novo item
    public void adicionarItem(T item) {
        itens.add(item);
    }

    // Método para atualizar um item existente
    public void atualizarItem(int indice, T novoItem) {
        if (indice >= 0 && indice < itens.size()) {
            itens.set(indice, novoItem);
        }
    }

    // Método para excluir um item
    public void excluirItem(int indice) {
        if (indice >= 0 && indice < itens.size()) {
            itens.remove(indice);
        }
    }

    // Método para fazer parse de uma linha para um livro (adaptar conforme necessário)
    private T parseLinhaParaLivro(String linha) {
        // Implementar o parse da linha para um livro
        // Exemplo: "autor;titulo;id;preco;genero"
        String[] partes = linha.split(";");
        if (partes.length == 5) {
            // Adaptar para o tipo específico de livro que você está usando
            // (por exemplo, LivroDigital ou MangaDigital)
            // Certifique-se de que as classes estendam a classe Livro
            return (T) new LivroDigital(new Autor(partes[0], partes[0], 1, 1), partes[1],
                    Integer.parseInt(partes[2]), Float.parseFloat(partes[3]), Genero.valueOf(partes[4].toUpperCase()));
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso da loja
        Loja<LivroDigital> lojaDigital = new Loja<>();
        lojaDigital.carregarLivrosDoArquivo("livros_digitais.txt");
        lojaDigital.mostrarItensDisponiveis();

        // Exemplo de filtragem por autor
        List<LivroDigital> livrosPorAutor = lojaDigital.filtrarPorAutor("AutorX");
        System.out.println("Livros por AutorX:");
        livrosPorAutor.forEach(System.out::println);

        // Exemplo de filtragem por gênero
        List<LivroDigital> livrosPorGenero = lojaDigital.filtrarPorGenero(Genero.DRAMA);
        System.out.println("Livros de Drama:");
        livrosPorGenero.forEach(System.out::println);

        // Exemplo de adição, atualização e exclusão de itens
        LivroDigital novoLivro = new LivroDigital(new Autor("NovoAutor", "NovoAutor", 2, 2), "NovoTitulo", 3, 3.99f, Genero.COMEDIA);
        lojaDigital.adicionarItem(novoLivro);
        System.out.println("Após adição do novo livro:");
        lojaDigital.mostrarItensDisponiveis();

        lojaDigital.atualizarItem(0, new LivroDigital(new Autor("AutorAtualizado", "AutorAtualizado", 4, 4), "TituloAtualizado", 4, 4.99f, Genero.TERROR));
        System.out.println("Após atualização do primeiro livro:");
        lojaDigital.mostrarItensDisponiveis();

        lojaDigital.excluirItem(1);
        System.out.println("Após exclusão do segundo livro:");
        lojaDigital.mostrarItensDisponiveis();
    }
}
