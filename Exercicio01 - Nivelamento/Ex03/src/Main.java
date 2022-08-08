import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("src/arquivo.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        int[] vetorInteiros;


        for (int i = 0; i < 3; i++) { //preenche o vetor com a linha do input de entrada

            String linha = br.readLine();
            String[] vetorTexto = linha.split(";");
            vetorInteiros = new int[vetorTexto.length];


            for (int j = 0; j < vetorTexto.length; j++) { // passa a string pra um vetor de inteiros
                int temp = Integer.parseInt(vetorTexto[j]);
                vetorInteiros[j] = temp;
            }
            inverterVetor(vetorInteiros);
            for (int j = 0; j < vetorTexto.length; j++) {
                System.out.print(vetorInteiros[j]+" ");
            }
            System.out.println(" ## ");
        }

    }

    public static int[] inverterVetor(int vet[]) {
        int temp;
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = vet[i];
                vet[i] = vet[j];
                vet[j] = temp;
            }
        }
        return vet;
    }
}
