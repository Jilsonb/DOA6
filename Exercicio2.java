import java.io.*;
public class Exercicio2 {

    // Exercício 1: Verificar se um número é primo
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Exercício 2: Criar uma matriz de primos
    public static int[] matrixOfPrime(int row, int column) {
        int[] primesMatrix = new int[row * column];
        int count = 0;
        int number = 2;

        while (count < row * column) {
            if (isPrime(number)) {
                primesMatrix[count] = number;
                count++;
            }
            number++;
        }

        return primesMatrix;
    }

    // Exercício 3: Ler e Escrever Matriz de Primos em Arquivos
    public static void matrixFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] dimensions = line.split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int columns = Integer.parseInt(dimensions[1]);

            int[] resultMatrix = matrixOfPrime(rows, columns);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        writer.write(resultMatrix[i * columns + j] + " ");
                    }
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso do Exercício 1
        int numberToCheck = 17;
        if (isPrime(numberToCheck)) {
            System.out.println(numberToCheck + " é primo.");
        } else {
            System.out.println(numberToCheck + " não é primo.");
        }

        // Exemplo de uso do Exercício 2
        int rows = 3;
        int columns = 4;
        int[] resultMatrix = matrixOfPrime(rows, columns);

        // Imprimir a matriz
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(resultMatrix[i * columns + j] + " ");
            }
            System.out.println();
        }

        // Exemplo de uso do Exercício 3
        matrixFromFile("input.txt");
    }
}
