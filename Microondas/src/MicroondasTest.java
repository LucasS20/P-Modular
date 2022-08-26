import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class MicroondasTest {

    Microondas microondas;

    @BeforeEach
    public void criarMicroondas() {
        microondas = new Microondas("5:00");
    }

    @Test
    public void testarCriacaoMicroondas() {
        Assert.assertEquals(Microondas.getTempo(), 300);
    }

    @Test
    public void abrirPorta() {
        microondas.abrirPorta();
        Assert.assertTrue(Microondas.isPorta());
    }

    @Test
    public void fecharPorta() {
        microondas.abrirPorta();
        microondas.fecharPorta();
        Assert.assertFalse(Microondas.isPorta());
    }

    @Test
    public void testeAbrirPortaFuncionando() {
        microondas.ligar();
        microondas.abrirPorta();
        Assert.assertFalse(Microondas.isPorta());
    }

    @Test
    public void testeLigarPortaAberta() {
        microondas.abrirPorta();
        microondas.ligar();
        Assert.assertFalse(Microondas.isLigado());
    }

    @Test
    public void atualizarTempofuncionamento() {
        microondas.formataTempo("5:00");
        Assert.assertEquals(Microondas.getTempo(), 300);
    }

    @Test
    public void testeDesligarMicroondasTempo() {
        microondas.ligar();
        microondas.formataTempo("0:00");
        Assert.assertFalse(Microondas.isLigado());
    }

    @Test
    public void passarTempoAte() {
        microondas.passarTempo(60);
        Assert.assertEquals(Microondas.getTempo(), 240);
    }


}