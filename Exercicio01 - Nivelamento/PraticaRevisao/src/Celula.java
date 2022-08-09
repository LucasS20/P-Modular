class Celula {

	private Candidato item;
	private Celula anterior;
	private Celula proximo;

	public Celula(Candidato nova) {

		item = nova;
		anterior = null;
		proximo = null;
	}

	public Celula() {

		item = new Candidato();
		anterior = null;
		proximo = null;
	}

	public Candidato getItem() {
		return item;
	}

	public void setItem(Candidato item) {
		this.item = item;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

	public Celula getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
}
