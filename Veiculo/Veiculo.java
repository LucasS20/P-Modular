import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Veiculo {
//#region Atributos

    private String dataAquisicao;
    private double consumo;
    private double quilometragem;
    private  int numeroRotas;
   private  double mediaPorRota;

    private double precoAbastecimento;
    //#endregion
//#region Construtores
    public Veiculo(String dataAquisicao, double consumo, double quilometragem, int numeroRotas) {
        init(dataAquisicao, consumo, quilometragem, numeroRotas);
    }

    public Veiculo() {
        this.dataAquisicao = "01/01/2022";
        this.consumo = 0;
    }
//#endregion
//#region metodosPublicos
    public void atualizarData(String novaData) {
        if (validaData(novaData))
            this.dataAquisicao = novaData;
        else
            this.dataAquisicao = "01/01/2022";
    }

    public void atualizaConsumo(double novoConsumo) {
        if (validaNegativos(novoConsumo))
            this.consumo = novoConsumo;
        else consumo = 0;
    }
    public double calculaMediaPorRota() {
        return (this.quilometragem / this.numeroRotas);
    }

    public void atualizaKm(double kmTeste) {
        if (validaNegativos(kmTeste))
            this.quilometragem = kmTeste;
        else
            this.quilometragem = 0;
        this.precoAbastecimento = calculaPrecoAbastecimentoTotal();
        this.mediaPorRota = calculaMediaPorRota();
    }

    public void atualizaNumeroRotas(int numeroRotas) {
        if (validaNegativos(numeroRotas))
            this.numeroRotas = numeroRotas;
        else
            this.numeroRotas = 1;
    }
//endregion/
//#region metodosPrivados
    private static boolean validaData(String strDate) {
        String dateFormat = "dd/MM/uuuu";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static boolean validaNegativos(double numero) {
        return numero >= 0;
    }

    private void init(String dataAquisicao, double consumo, double quilometragem, int numeroRotas) {

        atualizarData(dataAquisicao);
        atualizaConsumo(consumo);
        atualizaKm(quilometragem);
        atualizaNumeroRotas(numeroRotas);
        mediaPorRota = calculaMediaPorRota();
        precoAbastecimento = calculaPrecoAbastecimentoTotal();
    }
    private double calculaPrecoAbastecimentoTotal() {
        double precoGasolina = 5.19;
        return this.quilometragem * precoGasolina;
    }

//#endregion
//#region Getters
    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public double getConsumo() {
        return consumo;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public int getNumeroRotas() {
        return numeroRotas;
    }

    public double getPrecoAbastecimento() {
        return precoAbastecimento;
    }

    public double getMediaPorRota() {
        return mediaPorRota;
    }
    //endregion
}