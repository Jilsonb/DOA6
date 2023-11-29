package miniProjeto2;

import miniProjeto1.Autor;
import miniProjeto1.LivroDigital;
import miniProjeto5.Loja;

public class Main {

    public static void main(String[] args) {
        // Criar alguns autores
        Autor autor1 = new Autor("Jilson", "Benjamim", 123456, 1001);
        Autor autor2 = new Autor("Wellington", "Oliveira", 654321, 1002);

        // Criar alguns livros digitais
        LivroDigital livro1 = new LivroDigital(autor1, "Java", 1, 19.99f, Genero.DRAMA);
        LivroDigital livro2 = new LivroDigital(autor2, "MySql", 2, 14.99f, Genero.COMEDIA);

        // Criar uma loja e adicionar os livros
        Loja<LivroDigital> lojaDigital = new Loja<>();
        lojaDigital.adicionarItem(livro1);
        lojaDigital.adicionarItem(livro2);

        // Mostrar todos os livros disponíveis na loja
        System.out.println("Livros disponíveis na loja:");
        lojaDigital.mostrarItensDisponiveis();

        // Filtrar por autor
        String autorFiltrar = "Autor1";
        System.out.println("\nLivros do autor " + autorFiltrar + ":");
        lojaDigital.filtrarPorAutor(autorFiltrar).forEach(System.out::println);

        // Filtrar por gênero
        Genero generoFiltrar = Genero.COMEDIA;
        System.out.println("\nLivros de gênero " + generoFiltrar + ":");
        lojaDigital.filtrarPorGenero(generoFiltrar).forEach(System.out::println);
    }
}
