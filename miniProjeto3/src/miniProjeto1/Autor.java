package miniProjeto1;
public class Autor {

    private final String primeiroNome;
    private final String ultimoNome;
    private final int nif;
    private final int idade;

    public Autor(String primeiroNome, String ultimoNome, int nif, int idade) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.nif = nif;
        this.idade = idade;
    }

    public Autor(String ultimoNome, int nif, int idade) {
        this.ultimoNome = ultimoNome;
        this.nif = nif;
        this.idade = idade;

        primeiroNome = null;
    }

    public String getNome() {
        return primeiroNome + " " + ultimoNome;
    }

    public int getNif() {
        return nif;
    }

    public int getIdade() {
        return idade;
    }
}

