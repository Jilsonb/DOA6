package miniProgect4;

import miniProjeto1.Autor;
import miniProjeto1.LivroDigital;
import miniProjeto2.Genero;

import java.util.ArrayList;
import java.util.List;

public class MangaDigital extends LivroDigital {

    private List<Byte> pages;
    private int currentPageIndex;

    public MangaDigital(Autor autor, String titulo, int id, float preco, Genero genero, int numPages) {
        super(autor, titulo, id, preco, genero);
        this.pages = new ArrayList<>(numPages);
        initializePages();
        this.currentPageIndex = 0;
    }

    private void initializePages() {
        // Adicione bytes representando cada página (implementação fictícia)
        for (int i = 0; i < pages.size(); i++) {
            pages.add((byte) i);
        }
    }

    public void changeDirection() {
        // Lógica para inverter a direção da leitura
        // (implementação fictícia)
    }

    public List<Byte> getPages() {
        return new ArrayList<>(pages);
    }

    public Byte getPage(int index) {
        if (index >= 0 && index < pages.size()) {
            return pages.get(index);
        } else {
            return null; // Ou lance uma exceção, dependendo dos requisitos
        }
    }

    public Byte getBookCover() {
        // Lógica para obter a capa do manga (implementação fictícia)
        return pages.isEmpty() ? null : pages.get(0);
    }

    public byte nextPage() {
        if (currentPageIndex < pages.size() - 1) {
            currentPageIndex++;
            return pages.get(currentPageIndex);
        } else {
            return -1; // Indicando que não há próxima página
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: MangaDigital";
    }

}
