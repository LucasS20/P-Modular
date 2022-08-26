public class Microondas {
    //#region atributos

    private static int tempo;
    private static boolean porta;
    private static boolean ligado;

    //#endregion

    Microondas(String tempo) {
        this.init(tempo);
    }

//#region Metodos públicos


    /**
     * Método que abre a porta do microondas, caso ele não esteja ligado e a porta não esteja aberta
     */
    public void abrirPorta() {
        if (!ligado && !porta) {
            porta = true;
        } else {
            System.out.println("A porta não pode ser aberta");
        }
    }

    /**
     * fecha a porta do Microondas caso ela esteja aberta
     */
    public void fecharPorta() {
        if (porta) {
            porta = false;
        } else {
            System.out.println("A porta já está fechada");
        }

    }

    /**
     * Liga o Microondas caso a porta não esteja aberto, já esteja ligado, e o tempo seja maior que zero.
     */
    public void ligar() {
        if (!porta && !ligado && tempo > 0) {
            ligado = true;
        } else {
            System.out.println("Não é possivel ligar o microondas");
        }

    }

    /**
     * Desliga o Microondas
     */
    public void desligar() {
        ligado = false;
    }


    /**
     * Metodo para transformar o tempo no formato mm:ss em um numero inteiro com o total de segundos
     *
     * @param tempo Tempo que o Microondas terá no formato mm:ss
     */
    public void formataTempo(String tempo) {
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

    /**
     * Passa o tempo informado pelo usuário, e desliga em caso do tempo a passar for maior que o tempo restante do microondas.
     *
     * @param tempoSubtrair A quantidade de tempo que será passado do tempo total do Microondas
     */
    public void passarTempo(int tempoSubtrair) {
        if (tempoSubtrair <= tempo) {
            tempo -= tempoSubtrair;
        } else
            desligar();
    }

    //#endregion


    //#region metodosPrivados

    /**
     * método para inicializar os construtores do método
     *
     * @param tempo Tempo que o Microondas terá no formato mm:ss
     */
    private void init(String tempo) {
        formataTempo(tempo);
        porta = false;
        ligado = false;
    }


    //#endregion

//#region GETTERS

    public static int getTempo() {
        return tempo;
    }

    public static boolean isLigado() {
        return ligado;
    }

    public static boolean isPorta() {
        return porta;
    }

    //#endregion
}
