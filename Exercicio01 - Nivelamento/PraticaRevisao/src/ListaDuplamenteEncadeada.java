class ListaDuplamenteEncadeada {

    private Celula primeiro;
    private Celula ultimo;

    public Celula getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }

    public Celula getUltimo() {
        return ultimo;
    }

    public void setUltimo(Celula ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    private int tamanho;

    public ListaDuplamenteEncadeada() {

        Celula sentinela;

        sentinela = new Celula();
        primeiro = sentinela;
        ultimo = sentinela;

        tamanho = 0;
    }

    public boolean listaVazia() {
        return primeiro == ultimo;
    }

    public void inserir(Candidato novo, int posicao) throws Exception {

        Celula anterior, novaCelula, proximaCelula;

        if ((posicao >= 0) && (posicao <= tamanho)) {
            anterior = primeiro;
            for (int i = 0; i < posicao; i++)
                anterior = anterior.getProximo();

            novaCelula = new Celula(novo);

            proximaCelula = anterior.getProximo();

            anterior.setProximo(novaCelula);
            novaCelula.setProximo(proximaCelula);

            proximaCelula.setAnterior(novaCelula);
            novaCelula.setAnterior(anterior);

            if (posicao == tamanho)
                ultimo = novaCelula;

            tamanho++;

        } else
            throw new Exception("Não foi possível inserir o item na lista: a posição informada é inválida!");
    }

    public void inserirInicio(Candidato Candidato) {
        Celula novaCelula = new Celula(Candidato);

        primeiro.getProximo().setAnterior(novaCelula);
        novaCelula.setProximo(primeiro.getProximo());
        novaCelula.setAnterior(primeiro);
        primeiro.setProximo(novaCelula);

        tamanho++;
    }

    public void inserirFim(Candidato Candidato) {
        Celula novaCelula = new Celula(Candidato);

        ultimo.setProximo(novaCelula);
        novaCelula.setAnterior(ultimo);
        ultimo = novaCelula;

        tamanho++;
    }

    public Candidato remover(int posicao) throws Exception {
        Celula removida, ant, pro;

        if (!listaVazia()) {
            if (posicao <= tamanho) {
                removida = primeiro.getProximo();
                for (int i = 0; i < posicao; i++)
                    removida = removida.getProximo();

                if (!(removida == ultimo)) {
                    ant = removida.getAnterior();
                    pro = removida.getProximo();

                    ant.setProximo(pro);
                    pro.setAnterior(ant);

                    removida.setAnterior(null);
                    removida.setProximo(null);
                    return removida.getItem();
                } else
                    return removerFim();

            } else
                throw new Exception(
                        "Não foi possível remover o item " + posicao + " da lista: a lista não possui valores na posicao!");
        } else
            throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
    }

    public Candidato removerInicio() throws Exception {
        Celula removida;

        if (!listaVazia()) {

            removida = primeiro.getProximo();
            removida.getProximo().setAnterior(primeiro);
            primeiro.setProximo(removida.getProximo());

            removida.setAnterior(null);
            removida.setProximo(null);

            tamanho--;

            return removida.getItem();
        } else
            throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
    }

    public Candidato removerFim() throws Exception {
        Celula removida, penultima;

        if (!listaVazia()) {
            removida = ultimo;

            penultima = ultimo.getAnterior();
            penultima.setProximo(null);
            removida.setAnterior(null);

            ultimo = penultima;

            tamanho--;

            return (removida.getItem());
        } else
            throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
    }

    public void mostrar() throws Exception {
        Celula aux;
        int posicao = 0;

        if (!listaVazia()) {
            aux = primeiro.getProximo();
            while (aux != null) {
                System.out.print("[" + (posicao++) + "]");
                aux.getItem().imprimir();
                aux = aux.getProximo();
            }
        } else
            throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
    }


    static Candidato retornaMelhorTudo(ListaDuplamenteEncadeada lista) {
        Candidato melhorCandidato = lista.getUltimo().getItem();
        int maiorNota = 0;
        int totalCandidato = 0;
        Celula aux = lista.getUltimo();
        while (aux != lista.getPrimeiro()) {
            for (int i = 0; i < aux.getItem().competencias.length; i++) {
                totalCandidato = totalCandidato + aux.getItem().competencias[i];
            }
            if (totalCandidato > maiorNota) {
                maiorNota=totalCandidato;
                melhorCandidato=aux.getItem();
            }

            totalCandidato = 0;
            aux = aux.getAnterior();

        }

        return melhorCandidato;
    }


    static Candidato retornaMelhor(int posicaoVetorHabilidades, ListaDuplamenteEncadeada lista) {
        Candidato melhorCandidato = lista.getUltimo().getItem();
        int maiorNota1 = 0;

        Celula aux = lista.getPrimeiro().getProximo();
        while (aux != lista.getPrimeiro()) {
            if (maiorNota1 < aux.getItem().competencias[posicaoVetorHabilidades]) {
                maiorNota1 = aux.getItem().competencias[posicaoVetorHabilidades];
                melhorCandidato = aux.getItem();
            }
            aux = aux.getAnterior();
        }

        return melhorCandidato;
    }

    static Candidato retornaMelhorDuas(int posicaoVetorHabilidades, int posicaoVetorHabilidades2, ListaDuplamenteEncadeada lista) {
        Candidato melhorCandidato = lista.getUltimo().getItem();
        int maiorNota1 = 0, maiorNota2 = 0;

        Celula aux = lista.getPrimeiro().getProximo();
        while (aux != lista.getPrimeiro()) {
            if (maiorNota1 < aux.getItem().competencias[posicaoVetorHabilidades]) {
                maiorNota1 = aux.getItem().competencias[posicaoVetorHabilidades];
                melhorCandidato = aux.getItem();
            } else if (maiorNota1 == aux.getItem().competencias[posicaoVetorHabilidades]) {
                if (melhorCandidato.competencias[posicaoVetorHabilidades2] < aux.getItem().competencias[posicaoVetorHabilidades2]) {
                    melhorCandidato = aux.getItem();

                }
            }
            aux = aux.getAnterior();
        }

        return melhorCandidato;
    }


}
