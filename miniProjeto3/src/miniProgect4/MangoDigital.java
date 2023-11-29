package miniProgect4;
import miniProjeto1.Autor;
import miniProjeto2.Genero;
import miniProjeto1.LivroDigital;

import java.util.ArrayList;
import java.util.List;

public class MangoDigital {
    private final Autor autor;
    private final int id;
    private final float preco;
    private final Genero genero;
    private final String titulo;
    private String URL;

    public MangoDigital(Autor autor, int id, float preco, Genero genero, String titulo, String url) {
        this.autor = autor;
        this.id = id;
        this.preco = preco;
        this.genero = genero;
        this.titulo = titulo;
        URL = url;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public float sizeMB() {
        // Implementação fictícia
        return 1.5f;
    }

    @Override
    public String toString() {
        return String.format("Autor: %s, Título: %s, ID: %d, Gênero: %s, Preço: %.2f, Tipo: LivroDigital",
                autor.getNome(), titulo, id, genero, preco);
    }
}

