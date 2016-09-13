package util;

public class Conjunto {
	
	Bloco[] blocos;
	
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
	
	

}
