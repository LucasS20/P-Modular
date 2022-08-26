public class Microondas {

    private static int tempo;
    private static boolean porta;
    private static boolean ligado;

    Microondas(String tempo) {
        this.init(tempo);
    }

    private void init(String tempo) {
        atualizaTempo(tempo);
        porta = false;
        ligado = false;
    }

    public void atualizaTempo(String tempo) {
        String[] tempoInput = tempo.split(":");
        int[] vetorTempo = new int[tempoInput.length];
        for (int i = 0; i < tempoInput.length; i++) {
            vetorTempo[i] = Integer.parseInt(tempoInput[i]);
        }
        Microondas.tempo = vetorTempo[0] * 60 + vetorTempo[1] % 60;
        if (Microondas.tempo <= 0) {
            desligar();
        }
    }

    public void abrirPorta() {
        if (!ligado && !porta) {
            porta = true;
        } else {
            System.out.println("A porta não pode ser aberta");
        }
    }

    public void fecharPorta() {
        if (porta) {
            porta = false;
        } else {
            System.out.println("A porta não pode ser aberta");
        }

    }

    public void ligar() {
        if (!porta && !ligado) {
            ligado = true;
        } else {
            System.out.println("Não é possivel ligar o microondas");
        }

    }

    public void desligar() {
        ligado = false;
    }


    //GETTERS

    public static int getTempo() {
        return tempo;
    }

    public static boolean isLigado() {
        return ligado;
    }

    public static boolean isPorta() {
        return porta;
    }
}
