import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int inicial = 0, ultimo = 6;
        int[] vetorInteiros = new int[6];
        preencheVetor(vetorInteiros);
        System.out.println("Vetor Na posição normal");
        imprimeVetor(vetorInteiros);
        trocar(vetorInteiros, 0, 5);
        System.out.println("Vetor Invertido");
        imprimeVetor(vetorInteiros);
        somaElementoVetor(vetorInteiros);
    }

    //EXERCICIO 1

    private static void preencheVetor(int[] vetorInteiros) {

        Scanner ler = new Scanner(System.in);

        for (int posVetor = 0; posVetor < 6; posVetor++) { //Recebe os dados que serão colocados no vetor

            Random numeroAleatorio = new Random();
            int numeroInput;
            vetorInteiros[posVetor] = numeroInput = numeroAleatorio.nextInt(100);
        }
    }

    private static void imprimeVetor(int[] vetorInteiros) {
        for (int i = 0; i < vetorInteiros.length; i++) {
            System.out.print(" " + vetorInteiros[i] + "");
        }
    }

    static void trocar(int []vetorInteiros, int inicial, int fim) {
        int aux;
        if (inicial < fim) {
            aux = vetorInteiros[inicial];
            vetorInteiros[inicial] = vetorInteiros[fim];
            vetorInteiros[fim] = aux;
            trocar(vetorInteiros, inicial + 1, fim - 1);
        }
    }

    //EXERCICIO 02

    private static int[] somaElementoVetor(int[] vetorInteiros) {

        int tamanhoVetorSomado = (int) Math.ceil(vetorInteiros.length/2);
        int[] vetorSomado = new int[tamanhoVetorSomado];

        if (tamanhoPar(tamanhoVetorSomado)) {
            for (int i = 0; i < vetorSomado.length; i++) {
                vetorSomado[i] = vetorInteiros[i] + vetorInteiros[i + 1];
            }
        } else {
            for (int i = 0; i <= vetorSomado.length-2; i++) {
                vetorSomado[i] = vetorInteiros[i] + vetorInteiros[i + 1];
            }
            vetorSomado[vetorSomado.length - 1] = ((vetorInteiros.length - 1) * 2);
        }

        return vetorSomado;
    }

    static Boolean tamanhoPar(int tamanho) {
        if (tamanho % 2 == 0) {
            return true;
        }
        return false;
    }

}


