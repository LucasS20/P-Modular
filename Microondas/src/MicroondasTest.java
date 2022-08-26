import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class MicroondasTest {

    Microondas microondas;

    @BeforeEach
    public void criarMicroondas() {
        microondas = new Microondas("1:30");
    }

    @Test
    void testarCriacaoMicroondas() {
        Assert.assertEquals(Microondas.getTempo(), 90);
    }
    @Test
    void testeAbrirPortaFuncionando(){
        microondas.ligar();
        microondas.abrirPorta();
        Assert.assertFalse(Microondas.isPorta());
    }

    @Test
    void testeLigarPortaAberta() {
        microondas.abrirPorta();
        microondas.ligar();
        Assert.assertFalse(Microondas.isLigado());
    }

    @Test
    void testeDesligarMicroondasTempo() {
        microondas.ligar();
        microondas.atualizaTempo("0:00");
        Assert.assertFalse(Microondas.isLigado());
    }


}