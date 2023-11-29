package miniProjeto1;

import miniProjeto2.Genero;

// Classe concreta LivroDigital
public class LivroDigital extends Livro {

    private String URL;

    public LivroDigital(Autor autor, String titulo, int id, float preco, Genero genero) {
        super(autor, titulo, id, preco, genero);
    }

    @Override
    public void metodoAbstrato() {
        // Implementação específica para LivroDigital
        System.out.println("Método abstrato implementado em LivroDigital");
    }

    @Override
    public String getURL() {
        return null;
    }

    @Override
    public double sizeMB() {
        return 0;
    }

    public void setURL(String url) {
        this.URL = url;
    }
}
