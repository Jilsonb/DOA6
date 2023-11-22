import java.util.Scanner;

public class JogoGalo {

    private static char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        exibirTabuleiro();

        while (true) {
            jogar(scanner);
            exibirTabuleiro();

            if (verificarVencedor()) {
                System.out.println("O jogador " + jogadorAtual + " venceu!");
                break;
            } else if (tabuleiroCompleto()) {
                System.out.println("O jogo terminou em empate!");
                break;
            }

            trocarJogador();
        }

        scanner.close();
    }

    private static void exibirTabuleiro() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    private static void jogar(Scanner scanner) {
        int linha, coluna;

        do {
            System.out.print("Jogador " + jogadorAtual + ", informe a linha (0, 1, 2): ");
            linha = scanner.nextInt();
            System.out.print("Jogador " + jogadorAtual + ", informe a coluna (0, 1, 2): ");
            coluna = scanner.nextInt();
        } while (!jogadaValida(linha, coluna));

        tabuleiro[linha][coluna] = jogadorAtual;
    }

    private static boolean jogadaValida(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
            System.out.println("Jogada inválida. Tente novamente.");
            return false;
        }
        return true;
    }

    private static void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    private static boolean verificarVencedor() {
        // Verifica linhas, colunas e diagonais
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true; // Linhas
            }
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true; // Colunas
            }
        }
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true; // Diagonal principal
        }
        return tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual; // Diagonal secundária
    }

    private static boolean tabuleiroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
