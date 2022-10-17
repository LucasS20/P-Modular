import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Autor> autores = new ArrayList<>();
    private static ArrayList<LivroDigital> livrosDigitais = new ArrayList<>();
    private static ArrayList<LivroFisico> livrosFisicos = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {

        scanner = new Scanner(System.in);

        ArquivoTextoLeitura arquivoInput = new ArquivoTextoLeitura("src/LIVROS_PM.TXT");
        preencherLivros(arquivoInput);
        preencherAutores();
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Selecione uma opção");
        System.out.println("1 - Pesquisar Livro");
        System.out.println("2 - Pesquisar Autor");
        System.out.println("3 - Vender Livro");
        System.out.println("-1 para Sair");
        int inputUsuario = scanner.nextInt();
        escolhasMenu(inputUsuario);
    }

    private static void escolhasMenu(int inputUsuario) {
        Scanner scanner = new Scanner(System.in);
        switch (inputUsuario) {
            case 1 -> buscaDadosLivro();
            case 2 -> buscaDadosAutor();
            case 3 -> selecionaLivroVendido();
        }
    }

    private static void buscaDadosLivro() {
        System.out.println("Digite o nome do Livro");
        String nomeLivro = scanner.next();
        pesquisarLivro(nomeLivro);
    }

    private static void buscaDadosAutor() {
        System.out.println("Digite o nome do Autor");
        String nomeAutor = scanner.nextLine();
        pesquisarAutor(nomeAutor);

    }

    private static void selecionaLivroVendido() {
        System.out.println("Digite o nome do Livro a ser vendido");
        String nomeLivroVenda = scanner.nextLine();
        System.out.println("O livro foi vendido, a quantidade de copias vendidas agora é :" + venderLivro(nomeLivroVenda));
    }

    public static void pesquisarAutor(String nomeAutor) {
        for (Autor autor : autores) {
            if (autor.getNome().equals(nomeAutor)) {
                System.out.println(autor);
            }

        }
    }

    public static void pesquisarLivro(String nomeLivro) {

        for (LivroFisico livro : livrosFisicos) {
            if (livro.titulo.equals(nomeLivro)) {
                System.out.println(livro);
                break;
            }
        }
        for (LivroDigital livro : livrosDigitais) {
            if (livro.titulo.equals(nomeLivro)) {
                System.out.println(livro);
                break;
            }
        }
    }


    /**
     * Método que itera a quantidade de copias vendidas de um livro
     *
     * @param nomeLivro Titulo do livro
     */
    public static int venderLivro(String nomeLivro) {
        for (Livro livro : livrosFisicos) {
            if (livro.titulo.equals(nomeLivro)) {
                Livro.copiasVendidas += 1;
                break;
            }
        }
        return Livro.copiasVendidas;
    }

    private static void preencherAutores() {
        for (LivroFisico livro : livrosFisicos) {
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
        livrosFisicos.add(livro);
    }

    private static void insereComAutorRepetido(String[] vetorEntrada) {
        LivroFisico livro = new LivroFisico(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1], "ROWLING", vetorEntrada[2], Double.parseDouble(vetorEntrada[3]), Double.parseDouble(vetorEntrada[4]), Integer.parseInt(vetorEntrada[5]), Integer.parseInt(vetorEntrada[6]));
        livrosFisicos.add(livro);
    }

    private static void insereDigital(String[] vetorEntrada) {
        LivroDigital livro = new LivroDigital(Integer.parseInt(vetorEntrada[0]), vetorEntrada[1], vetorEntrada[2], vetorEntrada[3], Double.parseDouble(vetorEntrada[4]), Integer.parseInt(vetorEntrada[5]));
        livrosDigitais.add(livro);
    }
}
