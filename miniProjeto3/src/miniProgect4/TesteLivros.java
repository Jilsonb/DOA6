package miniProgect4;

import miniProjeto1.Autor;
import miniProjeto1.LivroDigital;
import miniProjeto2.Genero;
import miniProjeto1.Livro;
public class TesteLivros {

    public static void main(String[] args) {
        Autor autorSaramago = new Autor("Jose", "Saramago", 123412312, 101);

        // Criando instâncias das classes
        LivroDigital livroDigital = new LivroDigital(autorSaramago, "Terra do Pecado", 1, 19.99f, Genero.DRAMA);
        livroDigital.setURL("http:Jilsonbenjamim@facebook.com");

        MangaDigital mangaDigital = new MangaDigital(autorSaramago, "Manga Title", 2, 15.99f, Genero.AVENTURA, 50);

        // Testando polimorfismo
        Livro livroPolimorfismo = mangaDigital; // MangaDigital é um tipo de LivroDigital
        LivroDigital livroDigitalPolimorfismo = livroDigital; // LivroDigital é um tipo de Livro

        // Impressão das instâncias na consola
        System.out.println("Detalhes do Livro Digital:");
        System.out.println(livroDigital.toString());
        System.out.println();

        System.out.println("Detalhes do Manga Digital:");
        System.out.println(mangaDigital.toString());
        System.out.println();

        // Utilizando polimorfismo para imprimir detalhes
        System.out.println("Detalhes do Livro (polimorfismo):");
        imprimirDetalhes(livroPolimorfismo);
        System.out.println();

        System.out.println("Detalhes do Livro Digital (polimorfismo):");
        imprimirDetalhes(livroDigitalPolimorfismo);
    }

    // Método para imprimir detalhes usando polimorfismo
    private static void imprimirDetalhes(Livro livro) {
        System.out.println(livro.toString());

        // Verifica se o livro é uma instância de MangaDigital
        if (livro instanceof MangaDigital) {
            MangaDigital manga = (MangaDigital) livro;
            System.out.println("Capa do Manga: " + manga.getBookCover());
            System.out.println("Próxima Página: " + manga.nextPage());
        }
    }
}
