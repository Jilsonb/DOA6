package condution;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static condution.ConexaoBancoDados.getConnection;

public class DatabaseManager {

    // ...

    // Método para inserir um professor no banco de dados
    public static void inserirProfessor(String nome) {
        String sql = "INSERT INTO professores (nome) VALUES (?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar o nome de um professor
    public static void atualizarNomeProfessor(int professorId, String novoNome) {
        String sql = "UPDATE professores SET nome = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, novoNome);
            preparedStatement.setInt(2, professorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um professor do banco de dados
    public static void excluirProfessor(int professorId) {
        String sql = "DELETE FROM professores WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, professorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para consultar todos os professores
    public static void consultarProfessores() {
        String sql = "SELECT * FROM professores";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                System.out.println("ID: " + id + ", Nome: " + nome);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
