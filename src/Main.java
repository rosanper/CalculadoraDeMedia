import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double[] numerosRecebidos;
        int quantidadeNumeros;
        double media = 0;

        System.out.println("Seja bem vindo a calculadora de médias!!");
        quantidadeNumeros = pegarQuantidadeNumeros(scan);

        numerosRecebidos = pegarNumerosRecebidos(scan,quantidadeNumeros);

        // Escolha do tipo de média que será calculada
        boolean opcaoValida = false;
        String opcaoEscolhida;
        do {
            System.out.println("Digite o tipo de média que você quer fazer: ARITMETICA ou HARMONICA");
            opcaoEscolhida = scan.nextLine();
            if (opcaoEscolhida.equalsIgnoreCase("ARITMETICA")){
                media = calcularMediaAritmetica(numerosRecebidos);
                opcaoValida = true;
            } else if (opcaoEscolhida.equalsIgnoreCase("HARMONICA")) {
                media = calcularMediaHarmonica(numerosRecebidos);
                opcaoValida = true;
            }else {
                System.out.println("Voce digitou uma opção inválida.");
            }
        } while (opcaoValida == false);

        // Calculo da média
        // Imprimir resultado
        System.out.println("Os números digitados foram:");
        for (double numero : numerosRecebidos) {
            System.out.println(numero);
        }
        System.out.println("A média que deseja ser calculada é a média: " + opcaoEscolhida.toUpperCase());
        System.out.println("A média " + opcaoEscolhida.toUpperCase() + " é " + media);



    }

    public static int pegarQuantidadeNumeros(Scanner scanner){
        System.out.println("Informe a quantidade de números que serão digitados:");
        int quantidadeNumeros = 0;
        try {
            quantidadeNumeros = scanner.nextInt();
            scanner.nextLine();
            if (quantidadeNumeros <= 0){
                System.out.println("O número digitado deve ser maior que 0");
                pegarQuantidadeNumeros(scanner);
            }
        } catch (InputMismatchException e){
            System.out.println("Você digitou uma entrada inválida");
            scanner.nextLine();
            pegarQuantidadeNumeros(scanner);
        }

        return quantidadeNumeros;
    }

    public static double lerNumero(Scanner scanner){
        double numero = 0;
        System.out.println("Digite um número: ");
        try {
            numero = scanner.nextDouble();
            scanner.nextLine();
            return numero;
        } catch (InputMismatchException e){
            System.out.println("Você digitou uma entrada inválida");
            scanner.nextLine();
            return lerNumero(scanner);
        }

    }

    public static double[] pegarNumerosRecebidos(Scanner scanner, int quantidade){
        double[] numeros = new double[quantidade];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = lerNumero(scanner);
        }
        return numeros;
    }

    public static double calcularMediaAritmetica(double[] numeros){
        double mediaAritmetica;
        double soma = 0;
        int quantidade = numeros.length;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        mediaAritmetica = soma/quantidade;
        return mediaAritmetica;
    }

    public static double calcularMediaHarmonica(double[] numeros){
        double mediaHarmonica;
        double soma = 0;
        int quantidade = numeros.length;
        for (int i = 0; i < numeros.length; i++) {
            soma += 1/numeros[i];
        }
        mediaHarmonica = quantidade/soma;
        return mediaHarmonica;
    }
}
