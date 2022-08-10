import java.io.*;

public class Main {

    public static final String arquivoHabilidades = "src/Habilidades.txt";
    public static final String arquivoCandidatos = "src/Candidatos.txt";

    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada listaCandidatos = new ListaDuplamenteEncadeada();
        Habilidade[] vetorHabilidades = preencheVetorHabilidades();

        encherLista(listaCandidatos, vetorHabilidades);
        System.out.println("O melhor candidato para essa competência é: " + ListaDuplamenteEncadeada.retornaMelhor(retornaPosicaoVetor(vetorHabilidades, "Back-end"), listaCandidatos).getNome());
        System.out.println("O melhor nas duas competências" + ListaDuplamenteEncadeada.retornaMelhorDuas(retornaPosicaoVetor(vetorHabilidades, "Python"), retornaPosicaoVetor(vetorHabilidades, "Back-end"), listaCandidatos).getNome());
        System.out.println("O melhor em tudo: " + ListaDuplamenteEncadeada.retornaMelhorTudo(listaCandidatos).getNome());
    }

    static int retornaPosicaoVetor(Habilidade[] vetorHabilidades, String habilidade) {
        int posicaoHabilidade = 0;
        for (int i = 0; i < vetorHabilidades.length; i++) {
            if (vetorHabilidades[i].getNome().equals(habilidade)) {
                posicaoHabilidade = i;
            }
        }
        return posicaoHabilidade;
    }

    static ListaDuplamenteEncadeada encherLista(ListaDuplamenteEncadeada listaCandidatos, Habilidade[] vetorHabilidades) throws IOException {
        var leitor = new Leitor(arquivoCandidatos);
        var numeroLinhasArquivo = leitor.obterNumeroLinhasArquivo(arquivoCandidatos);
        for (int i = 0; i < numeroLinhasArquivo; i++) {
            Candidato candidatoParaInserir = new Candidato(vetorHabilidades.length);
            candidatoParaInserir.preencherCandidato(candidatoParaInserir, leitor.lerLinha());
            listaCandidatos.inserirFim(candidatoParaInserir);
        }
        return listaCandidatos;
    }

    static Habilidade[] preencheVetorHabilidades() throws IOException {
        var leitor = new Leitor(arquivoHabilidades);
        var habilidades = new Habilidade[leitor.obterNumeroLinhasArquivo(arquivoHabilidades)];

        for (int i = 0; i < habilidades.length; i++) {
            var habilidade = new Habilidade(leitor.lerLinha());
            habilidades[i] = habilidade;
        }
        return habilidades;
    }

    static void imprimeVetor(String[] vetor) {
        System.out.println("Selecione a Habilidade");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println((i + 1) + " - " + vetor[i]);
        }
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

