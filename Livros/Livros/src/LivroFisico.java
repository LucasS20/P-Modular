public class LivroFisico extends Livro {


    int numeroPaginas;
    double capa;
    protected static final double PRECO_PAGINA = 0.03;

    LivroFisico(int codigo, String titulo, String autor, String tipoLivro, double precoBase, double capa, int copiasVendidas, int numeroPaginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.tipoLivro = tipoLivro;
        this.precoBase = precoBase;
        this.capa = capa;
        Livro.copiasVendidas = copiasVendidas;
        this.numeroPaginas = numeroPaginas;
        calculaPrecoVenda();
    }


    @Override
    protected void calculaPrecoVenda() {
        this.precoVenda = precoBase + (numeroPaginas * PRECO_PAGINA) + capa;
    }

}
