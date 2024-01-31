package condution;

import java.util.ArrayList;
import java.util.List;

public class EscolaConducao {
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<AulaTeoria> aulasTeoria;
    private List<AulaPratica> aulasPratica;

    public EscolaConducao() {
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.aulasTeoria = new ArrayList<>();
        this.aulasPratica = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void agendarAulaTeoria(AulaTeoria aulaTeoria) {
        aulasTeoria.add(aulaTeoria);
    }

    public void agendarAulaPratica(AulaPratica aulaPratica) {
        aulasPratica.add(aulaPratica);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<AulaTeoria> getAulasTeoria() {
        return aulasTeoria;
    }

    public List<AulaPratica> getAulasPratica() {
        return aulasPratica;
    }

    public static void main(String[] args) {
        // Initialize database tables using DatabaseManager


        EscolaConducao escola = new EscolaConducao();

        Professor profTeoria = new Professor("João Teórico");
        Professor profPratica = new Professor("Maria Prática");

        escola.adicionarProfessor(profTeoria);
        escola.adicionarProfessor(profPratica);

        Aluno aluno1 = new Aluno("Alice", CategoriaCarta.AMADORA);
        Aluno aluno2 = new Aluno("Bob", CategoriaCarta.PESADA);

        escola.adicionarAluno(aluno1);
        escola.adicionarAluno(aluno2);

        AulaTeoria aulaTeoria1 = new AulaTeoria(profTeoria);
        AulaTeoria aulaTeoria2 = new AulaTeoria(profTeoria);

        AulaPratica aulaPratica1 = new AulaPratica(profPratica);
        AulaPratica aulaPratica2 = new AulaPratica(profPratica);

        escola.agendarAulaTeoria(aulaTeoria1);
        escola.agendarAulaTeoria(aulaTeoria2);
        escola.agendarAulaPratica(aulaPratica1);
        escola.agendarAulaPratica(aulaPratica2);

        System.out.println("Professores: " + escola.getProfessores());
        System.out.println("Alunos: " + escola.getAlunos());
        System.out.println("Aulas de Teoria: " + escola.getAulasTeoria());
        System.out.println("Aulas Práticas: " + escola.getAulasPratica());
    }
}

