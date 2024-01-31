package condution;


public class AulaPratica {
    private Professor professor;

    public AulaPratica(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "AulaPratica{" +
                "professor=" + professor +
                '}';
    }
}
