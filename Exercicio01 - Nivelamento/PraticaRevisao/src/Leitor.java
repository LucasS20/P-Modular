import java.io.*;

public class Leitor {
    private final BufferedReader br;

    public Leitor(String caminhoArquivo) throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(caminhoArquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        br = new BufferedReader(reader);
    }

    String lerLinha() throws IOException {
        return br.readLine();
    }

    int obterNumeroLinhasArquivo(String nomeArquivo) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(nomeArquivo));
        lnr.skip(Long.MAX_VALUE);
        return lnr.getLineNumber();
    }
}
