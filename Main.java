package miniProjeto2;



import miniProjeto1.Autor;
import miniProjeto1.Livro;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Autor saramago = new Autor("Jose", "Saramago", 123412312, 101);

        Livro livro = new Livro(saramago, "Terra do Pecado", 1, 19.99f, Genero.DRAMA);
        Livro b1 = new Livro(saramago, "Terra do Pecado", 3, 10, Genero.TERROR);
        Livro b2 = new Livro(saramago, "Claraboia", 4, 15, Genero.COMEDIA);
        Livro b3 = new Livro(saramago, "Todos os Nomes", 5, 20, Genero.FICCAO);

        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(livro);
        livros.add(b1);
        livros.add(b2);
        livros.add(b3);

        // Iteração sobre o ArrayList e impressão dos livros de drama
        for (Livro l : livros) {
            if (l.getGenero() == Genero.DRAMA) {
                System.out.println("Autor: " + l.getAutor().getNome());
                System.out.println("Título: " + l.getTitulo());
                System.out.println("ID: " + l.getId());
                System.out.println("Gênero: " + l.getGenero());
                System.out.println("Preço: " + l.getPreco());
                // Adicione outros atributos, se necessário
                System.out.println(); // Adicione uma linha em branco entre os livros
            }
        }
    }
}
