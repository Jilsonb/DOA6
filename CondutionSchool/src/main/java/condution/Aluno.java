package condution;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
@entity
public class Aluno {

    @ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private CategoriaCarta categoriaCarta;

        public Aluno(String nome, CategoriaCarta categoriaCarta) {
            this.nome = nome;
            this.categoriaCarta = categoriaCarta;
        }

        @Override
        public String toString() {
            return "Aluno{" +
                    "nome='" + nome + '\'' +
                    ", categoriaCarta=" + categoriaCarta +
                    '}';
        }



    public interface AlunoRepository extends JpaRepository<Aluno, Long> {
        // Métodos de consulta específicos podem ser adicionados aqui, se necessário
    }

}


