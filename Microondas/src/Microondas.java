//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Microondas {
    private static int minutos;
    private static int segundos;
    private static boolean porta;
    private static boolean ligado;

    Microondas(int minutos, int segundos) {
        this.init(minutos, segundos);
    }

    private void init(int minutos, int segundos) {
        Microondas.minutos = minutos;
        Microondas.segundos = segundos;
        porta = false;
        ligado = false;
    }

    public void abrirPorta() {
        if (!ligado && !porta) {
            porta = true;
        } else {
            System.out.println("A porta não pode ser aberta");
        }

    }

    public void imprimirEstado() {
        System.out.println(minutos);
        System.out.println(segundos);
        System.out.println(porta);
        System.out.println(ligado);
    }

    public void ligar() {
        if (!porta && !ligado) {
            ligado = true;
        } else {
            System.out.println("O microondas não pode ser ligado pois a porta está aberta");
        }

    }

    public void desligar() {
        if (ligado) {
            ligado = false;
        } else {
            System.out.println("O microondas já está desligado");
        }

    }
}
