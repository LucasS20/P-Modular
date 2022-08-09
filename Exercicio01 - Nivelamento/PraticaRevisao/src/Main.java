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
        return lnr.getLineNumber();
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

    static void retornaMelhor(String habilidade, String[] vetorHabilidades, ListaDuplamenteEncadeada listaCandidatos) {
        int posicaoHabilidade = 0;
        for (int i = 0; i < vetorHabilidades.length; i++) {
            if (vetorHabilidades[i].equals(habilidade)) {
                posicaoHabilidade = i;
            }
        }
        int maiorNota = 0;
        Celula celula = listaCandidatos.getPrimeiro();
        Candidato melhorCandidato = new Candidato();

        while (celula.getProximo() != null) {
            if (celula.getItem().competencias[posicaoHabilidade] > maiorNota) {
                maiorNota = celula.getItem().competencias[posicaoHabilidade];
                melhorCandidato = celula.getItem();
            }
            celula = celula.getProximo();
        }
        System.out.println(melhorCandidato.nome);
    }


    static void retornaMelhor(String habilidade, String habilidade2, String[] vetorHabilidades, ListaDuplamenteEncadeada listaCandidatos) {
        int posicaoHabilidade1 = 0, posicaoHabilidade2 = 0;
        for (int i = 0; i < vetorHabilidades.length; i++) {
            if (vetorHabilidades[i].equals(habilidade)) {
                posicaoHabilidade1 = i;
            }
        }
        for (int i = 0; i < vetorHabilidades.length; i++) {
            if (vetorHabilidades[i].equals(habilidade2)) {
                posicaoHabilidade2 = i;
            }
        }
        int somaNotas = 0, maiorSoma = 0;

        Celula celula = listaCandidatos.getPrimeiro();
        Candidato melhorCandidato = new Candidato();

        while (celula.getProximo() != null) {
            if (celula.getItem().competencias[posicaoHabilidade1] + celula.getItem().competencias[posicaoHabilidade2] > maiorSoma) {
                melhorCandidato = celula.getItem();
            }
            celula = celula.getProximo();
        }
        System.out.println(melhorCandidato.nome);
    }


    static void retornaMelhorEmTudo(String habilidade, String[] vetorHabilidades, ListaDuplamenteEncadeada listaCandidatos) {

        int maiorPontuação = 0;

        Celula celula = listaCandidatos.getPrimeiro();
        Candidato melhorCandidato = new Candidato();

        while (celula.getProximo() != null) {
            int pontuacaoCandidato = 0;
            for (int i = 0; i < celula.getItem().competencias.length; i++) {
                pontuacaoCandidato += celula.getItem().competencias[i];
            }
            if (pontuacaoCandidato > maiorPontuação) {
                melhorCandidato = celula.getItem();
            }
            celula = celula.getProximo();
        }
        System.out.println(melhorCandidato.nome);

    }
}

