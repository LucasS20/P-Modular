import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada listaCandidatos = new ListaDuplamenteEncadeada();
        String arquivoHabilidades = "src/Habilidades.txt";
        String arquivoCandidatos = "src/Candidatos.txt";
        int numeroDeHabilidades = contadorNumeroLinhasArquivo(arquivoHabilidades);

        String[] vetorHabilidades = new String[contadorNumeroLinhasArquivo(arquivoHabilidades)];
        preencheVetorHabilidades(vetorHabilidades);

        encherLista(listaCandidatos, arquivoCandidatos, arquivoHabilidades);
        listaCandidatos.mostrar();

    }

    static void encherLista(ListaDuplamenteEncadeada listaCandidatos, String arquivoCandidatos, String arquivoHabilidades) throws IOException {
        for (int i = 0; i < contadorNumeroLinhasArquivo(arquivoCandidatos); i++) {
            Candidato candidatoParaInserir = new Candidato(contadorNumeroLinhasArquivo(arquivoHabilidades));
            candidatoParaInserir.preencherCandidato(candidatoParaInserir, lerLinha(arquivoCandidatos));
            listaCandidatos.inserirFim(candidatoParaInserir);
        }
    }


    static int contadorNumeroLinhasArquivo(String nomeArquivo) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(nomeArquivo));
        lnr.skip(Long.MAX_VALUE);
        int numeroDeLinhas = lnr.getLineNumber();
        return numeroDeLinhas;
    }

    static void preencheVetorHabilidades(String[] vetorHabilidades) throws IOException {

        for (int i = 0; i < vetorHabilidades.length; i++) {
            vetorHabilidades[i] = lerLinha("src/Habilidades.txt");
        }
    }

    static String lerLinha(String caminhoArquivo) throws IOException {
        FileInputStream stream = new FileInputStream(caminhoArquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        return linha;
    }

    static void imprimeVetor(String[] vetor) {
        System.out.println("Selecione a Habilidade");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i + 1) + " - " + vetor[i]);
        }
    }

}
