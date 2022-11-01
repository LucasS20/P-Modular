public class LivroDigital extends Livro {

    LivroDigital(int codigo, String titulo, String autor, String tipoLivro, double precoBase, int copiasVendidas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.tipoLivro = tipoLivro;
        this.precoBase = precoBase;
        this.copiasVendidas = copiasVendidas;
        calculaPrecoVenda();
    }

    protected void calculaPrecoVenda() {
        precoVenda = precoBase;
    }
}
