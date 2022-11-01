import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Autor> autores = new ArrayList<>();
    private static final ArrayList<Livro> livros = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        scanner = controiScannerSystemIn();
        inicializarDados();
        menu();
    }

    private static Scanner controiScannerSystemIn() {
        return new Scanner(System.in);
    }

    private static void inicializarDados() throws IOException {
        ArquivoTextoLeitura arquivoInput = new ArquivoTextoLeitura("src/LIVROS_PM.TXT");
        preencherLivros(arquivoInput);
        preencherAutores();
    }

    private static void menu() {
        int inputUsuario = 0;
        while (inputUsuario != -1) {
            printaMenu();
            inputUsuario = scanner.nextInt();
            escolhasMenu(inputUsuario);
        }

    }

    private static void printaMenu() {
        System.out.println("MENU");
        System.out.println("Selecione uma opção");
        System.out.println("1 - Pesquisar Livro");
        System.out.println("2 - Pesquisar Autor");
        System.out.println("3 - Vender Livro");
        System.out.println("-1 para Sair"); //trocar para esq
    }

    private static void escolhasMenu(int inputUsuario) {
        switch (inputUsuario) {
            case 1 -> buscaDadosLivro();
            case 2 -> buscaDadosAutor();
            case 3 -> selecionaLivroVendido();
        }
    }

    private static void buscaDadosLivro() {
        System.out.println("Digite o nome do Livro");
        scanner = controiScannerSystemIn();
        String nomeLivro = scanner.nextLine();
        pesquisarLivro(nomeLivro);
    }

    private static void buscaDadosAutor() {
        System.out.println("Digite o nome do Autor");
        scanner = controiScannerSystemIn();
        String nomeAutor = scanner.nextLine();
        pesquisarAutor(nomeAutor);
    }

    private static void selecionaLivroVendido() {
        System.out.println("Digite o nome do Livro a ser vendido");
        scanner = controiScannerSystemIn();
        String nomeLivroVenda = scanner.nextLine();
        venderLivro(nomeLivroVenda);
    }

    public static void pesquisarAutor(String nomeAutor) {

        Autor autor = autores.stream()
                .filter(a -> a.getNome().equals(nomeAutor))
                .findFirst()
                .orElse(null);

        if (autor != null)
            System.out.println(autor);
        else
            System.out.println("Nenhum autor foi encontrado");

    }

    public static void pesquisarLivro(String nomeLivro) {

        Livro livro = livros.stream()
                .filter(l -> l.titulo.equals(nomeLivro))
                .findFirst()
                .orElse(null);

        if (livro != null)
            System.out.println(livro);
        else
            System.out.println("O livro não foi encontrado");
    }


    /**
     * Método que itera a quantidade de cópias vendidas de um livro
     *
     * @param nomeLivro Titulo do livro
     */
    public static void venderLivro(String nomeLivro) {
        Livro livro = livros.stream()
                .filter(l -> l.titulo.equals(nomeLivro))
                .findFirst()
                .orElse(null);


        if (livro != null) {
            livro.copiasVendidas++;
            System.out.println("O livro foi vendido, a quantidade de copias vendidas agora é :" + livro.copiasVendidas);
        } else
            System.out.println("O livro não foi encontrado");

    }

    private static void preencherAutores() {
        for (Livro livro : livros) {
            Autor autor = new Autor(livro.autor);
            autores.add(autor);
        }
    }

    private static void preencherLivros(ArquivoTextoLeitura arquivoInput) throws IOException {
        String entrada = arquivoInput.ler();
        while (entrada != null) {
            String[] vetorEntrada = entrada.split(";");
            if (vetorEntrada.length == 6) {
                insereDigital(vetorEntrada);
            }
            if (vetorEntrada.length == 7) {
                insereComAutorRepetido(vetorEntrada);
            }
            if (vetorEntrada.length == 8) insereFisico(vetorEntrada);
            entrada = arquivoInput.ler();
        }

    }

    private static void insereFisico(String[] vetorEntrada) {
        LivroFisico livro = new LivroFisico(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1], vetorEntrada[2], vetorEntrada[3], Double.parseDouble(vetorEntrada[4]), Double.parseDouble(vetorEntrada[5]), Integer.parseInt(vetorEntrada[6]), Integer.parseInt(vetorEntrada[7]));
        livros.add(livro);
    }

    private static void insereComAutorRepetido(String[] vetorEntrada) {
        LivroFisico livro = new LivroFisico(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1], "ROWLING", vetorEntrada[2], Double.parseDouble(vetorEntrada[3]), Double.parseDouble(vetorEntrada[4]), Integer.parseInt(vetorEntrada[5]), Integer.parseInt(vetorEntrada[6]));
        livros.add(livro);
    }

    private static void insereDigital(String[] vetorEntrada) {
        LivroDigital livro = new LivroDigital(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1], vetorEntrada[2], vetorEntrada[3], Double.parseDouble(vetorEntrada[4]), Integer.parseInt(vetorEntrada[5]));
        livros.add(livro);
    }
}
