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

    Candidato() {
        this.nome = "nome";
        competencias = new int[0];
    }

    Candidato(int numeroCompetencias) {  //Construtor
        this.nome = "nome";
        competencias = new int[numeroCompetencias];
    }

    Candidato preencherCandidato(Candidato objetoCandidato,String linhaInput) throws IOException {

        Candidato objetoPreenchido = null;


            String[] dadosCandidato = linhaInput.split(";");
            this.setNome(dadosCandidato[0]);

            for (int j = 0; j < dadosCandidato.length - 1; j++) {
                dadosCandidato[j] = dadosCandidato[j + 1];
            }
//FIM DA GAMBIARRA
            for (int j = 0; j < objetoCandidato.competencias.length; j++) {
                int pontosHabilidade = Integer.parseInt(dadosCandidato[j]);
                this.competencias[j] = pontosHabilidade;
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

