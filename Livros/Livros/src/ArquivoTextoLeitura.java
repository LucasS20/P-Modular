import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ArquivoTextoLeitura {
    FileReader arq;
    BufferedReader lerArq;

    ArquivoTextoLeitura(String caminho) throws FileNotFoundException {
        this.arq = new FileReader(caminho);
        this.lerArq = new BufferedReader(arq);
    }

    public String ler() throws IOException {
        String conteudo = "";
        String linha;

            linha = this.lerArq.readLine();


        if (conteudo.contains("Erro")) {
            return "";
        } else {
            return linha;
        }
    }


}
