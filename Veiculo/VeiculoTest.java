import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class VeiculoTest {
    static Veiculo veiculo;

    @BeforeEach
    public void inicializaVeiculo() {
        veiculo = new Veiculo();
    }


    @Test
    public void criaComDataCorreta() {
        veiculo.atualizarData("20/04/2022");
        assertEquals("20/04/2022", veiculo.getDataAquisicao());
    }

    @Test
    public void criaComDataInvalida() {
        veiculo.atualizarData("31/02/2022");
        assertEquals("01/01/2022", veiculo.getDataAquisicao());
    }

    @Test
    public void atualizaDataInvalida() {
        veiculo.atualizarData("32/09/1964");
        assertEquals(veiculo.getDataAquisicao(), "01/01/2022");
    }

    @Test
    public void registrarConsumoValido() {
        double consumoTeste = 14.5;
        veiculo.atualizaConsumo(consumoTeste);
        assertEquals(veiculo.getConsumo(), consumoTeste);
    }

    @Test
    public void registrarConsumoInvalido() {
        double consumoTeste = -45.3;
        veiculo.atualizaConsumo(consumoTeste);
        assertEquals(0, veiculo.getConsumo());
    }

    @Test
    public void registraKmValida() {
        double kmTeste = 2189;
        veiculo.atualizaKm(kmTeste);
        assertEquals(2189, veiculo.getQuilometragem());
    }

    @Test
    public void registraKmInvalida() {
        double kmTeste = -2189;
        veiculo.atualizaKm(kmTeste);
        assertEquals(0, veiculo.getQuilometragem());
    }

    @Test
    public void somaQuilometragem() {
        double kmRota = 1000;
        veiculo.atualizaKm(veiculo.getQuilometragem() + kmRota);
        assertEquals(1000, veiculo.getQuilometragem());
    }

    @Test
    public void calculaMediaKmRotaCerta() {
        veiculo.atualizaNumeroRotas(3);
        veiculo.atualizaKm(1000);
        assertEquals(veiculo.getQuilometragem() / veiculo.getNumeroRotas(), veiculo.getMediaPorRota());
    }

    @Test
    public void calculaPrecoAbastecimentoCorreto() {
        double kmRota = 1000;
        veiculo.atualizaKm(kmRota);
        assertEquals(5190,veiculo.getPrecoAbastecimento());
    }


}
