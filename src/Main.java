import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double[] numerosRecebidos;
        int quantidadeNumeros;
        double media = 0;

        // Leitura da quantidade de números
        System.out.println("Seja bem vindo a calculadora de médias!!");
        System.out.println("Informe a quantidade de números que serão digitados:");
        quantidadeNumeros = scan.nextInt();
        scan.nextLine();

        // Leitura dos números
        numerosRecebidos = lerNumeros(scan,quantidadeNumeros);

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

    public static double[] lerNumeros(Scanner scanner, int quantidade){
        double[] numeros = new double[quantidade];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite um número: ");
            numeros[i] = scanner.nextDouble();
            scanner.nextLine();
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
