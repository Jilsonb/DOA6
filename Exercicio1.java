import java.util.Scanner;

public class Exercicio1 {

    // Exercício 1: Criar um método que não recebe nada, e retorna a soma de dois números inteiros
    public static int sum() {
        int a = 10;
        int b = 20;
        return a + b;
    }

    // Exercício 2: Criar um método sem retorno que recebe uma String e um inteiro, concatena ambos
    // e exibe essa concatenação na consola
    public static void concat(String str, int number) {
        System.out.println(str + number);
    }

    // Exercício 3: Criar um método que recebe dois números inteiros e verifica se eles são iguais.

    public static void compare() {
        // Lê os números do teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int c = sc.nextInt();
        System.out.println("Digite o segundo número: ");
        int d = sc.nextInt();

        if (c == d) {
            System.out.println("São iguais");
        } else {
            System.out.println("São diferentes");
        }
    }

    // Exercício Parte III: Criar um método que lê dois números e imprime os números entre o menor e o dobro do maior
    public static void parteIII() {
        // Lê os números do teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro para parteIII número: ");
        int x = sc.nextInt();
        System.out.println("Digite o segundo  para a parteIII número: ");
        int y = sc.nextInt();

        int menor, maior;
        if (x < y) {
            menor = x;
            maior = y;
        } else {
            menor = y;
            maior = x;
        }

        // Imprime os números na consola, começando do menor e terminando no dobro do maior
        for (int i = menor; i <= maior * 2; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Adiciona uma quebra de linha ao final
    }

    // Método principal
    public static void main(String[] args) {
        // Exercício 1
        int sumResult = sum();
        System.out.println("A soma é: " + sumResult);

        // Exercício 2
        concat("test", 1);

        // Exercício 3
        compare();

        // Exercício Parte III
        parteIII();
    }
}
