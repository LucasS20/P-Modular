import java.util.ArrayList;

public class Autor {


    private String nome;
    private ArrayList<LivroFisico> listaObrasFisicas = new ArrayList<>();
    private ArrayList<LivroDigital> listaObrasDigitais = new ArrayList<>();
    private static double arrecadacaoTotal;
    private static final double DIREITO_AUTORAL = 0.08;

    Autor(String nome) {
        this.nome = nome;
    }


    public void adicionarAoAutorFisico(LivroFisico livro) {
        listaObrasFisicas.add(livro);
    }

    private double calculaArrecadacaoTotal() {
        double arrecadacaoTotal = 0;
        for (Livro obra : listaObrasFisicas) {
            arrecadacaoTotal += Livro.getCopiasVendidas() * obra.precoVenda;
        }
        for (Livro obra : listaObrasDigitais) {
            arrecadacaoTotal += Livro.getCopiasVendidas() * obra.precoVenda;
        }
        Autor.arrecadacaoTotal = arrecadacaoTotal;
        return arrecadacaoTotal;
    }

    public double arrecadacaoComLivro(String nomeLivro) {
        double arrecadacao = 0;
        for (Livro livro : listaObrasDigitais) {
            if (livro.titulo.equals(nomeLivro)) {
                arrecadacao += livro.precoVenda * Livro.getCopiasVendidas() * DIREITO_AUTORAL;
            }
        }
        for (Livro livro : listaObrasFisicas) {
            if (livro.titulo.equals(nomeLivro)) {
                arrecadacao += livro.precoVenda * Livro.getCopiasVendidas() * DIREITO_AUTORAL;
            }
        }
        return arrecadacao;
    }

    @Override
    public String toString() {
        String conteudo;
        conteudo = nome + listaObrasFisicas.toString() + listaObrasDigitais.toString() + calculaArrecadacaoTotal();
        return conteudo;
    }


    public String getNome() {
        return nome;
    }
}
