package condution;



public class AulaTeoria {
    private Professor professor;

    public AulaTeoria(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "AulaTeoria{" +
                "professor=" + professor +
                '}';
    }
}
