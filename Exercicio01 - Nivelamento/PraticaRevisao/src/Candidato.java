import java.io.*;

public class Candidato {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    String nome;
    int[] competencias;

    public Candidato() {
        this.nome = "nome";
        competencias = new int[0];
    }

    public Candidato(int numeroCompetencias) {  //Construtor
        this.nome = "nome";
        competencias = new int[numeroCompetencias];
    }

    Candidato preencherCandidato(Candidato objetoCandidato, String linhaInput) throws IOException {

        Candidato objetoPreenchido = null;


        String[] dadosCandidato = linhaInput.split(";");
        this.setNome(dadosCandidato[0]);

        for (int i = 0; i < dadosCandidato.length - 1; i++) {
            dadosCandidato[i] = dadosCandidato[i + 1];
        }
        for (int i = 0; i < objetoCandidato.competencias.length; i++) {
            int pontosHabilidade = Integer.parseInt(dadosCandidato[i]);
            this.competencias[i] = pontosHabilidade;
        }
        objetoPreenchido = objetoCandidato;

        return objetoPreenchido;
    }

    void imprimir() {
        System.out.println(this.getNome());
        for (int i = 0; i < this.competencias.length; i++) {
            System.out.println(this.competencias[i]);
        }
    }

}

