public abstract class Livro {


    protected int codigo;
    protected String titulo;
    protected String autor;

    protected String tipoLivro;
    protected double precoBase;
    protected double precoVenda;
    protected static int copiasVendidas;

    protected abstract void calculaPrecoVenda();

    public static int getCopiasVendidas() {
        return copiasVendidas;
    }

    @Override
    public String toString() {
        String conteudo;
        conteudo = codigo + "|" + titulo + "|" + autor + "|" + precoVenda;
        return conteudo;
    }
}
