package util;

public class Conjunto {
	
	Bloco[] blocos;
	private int fifo = 0;
	private int way;

	/**
	 * Construor padrão.
	 */
	public Conjunto() {}
	
	/**
	 * Construtor que recebe tamanho e palavras por bloco.
	 * @param tamanho
	 * @param palavrasPBloco
	 */
	public Conjunto(int tamanho, int palavrasPBloco) {
		this.way = tamanho;
		blocos = new Bloco[tamanho];
		
		for(int i = 0; i < blocos.length; i++) {
			blocos[i] = new Bloco(palavrasPBloco);
		}
		
	}

	/**
	 * Retorna vetor de blocos.
	 * @return
	 */
	public Bloco[] getBlocos() {
		return blocos;
	}

	/**
	 * Set vetor de blocos.
	 * @param blocos
	 */
	public void setBlocos(Bloco[] blocos) {
		this.blocos = blocos;
	}
	
	public void plusFifo() {
		this.fifo++;
		if(this.fifo >= way)
			this.fifo = 0;
	}
	
	public int getFifo() {
		return fifo;
	}

	public void setFifo(int fifo) {
		this.fifo = fifo;
	}

	public int getWay() {
		return way;
	}

	public void setWay(int way) {
		this.way = way;
	}
	
	
	

}
