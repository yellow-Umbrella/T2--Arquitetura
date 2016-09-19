package util;

public class Bloco {
	
	private String[] palavra;
	private boolean v;
	private int tag;
	
	/**
	 * Construtor padrão.
	 */
	public Bloco() {}
	
	/**
	 * Construtor que recebe palavas por bloco
	 * @param palavrasPBloco
	 */
	public Bloco(int palavrasPBloco) {
		palavra = new String[palavrasPBloco];
	}

	/**
	 * Retorna um vetor de palavras
	 * @return
	 */
	public String[] getPalavra() {
		return palavra;
	}

	/**
	 * Set a palavra na posicao blockOffset.
	 * @param palavra
	 * @param blockOffset
	 */
	public void setPalavra(String palavra, int blockOffset) {
		this.palavra[blockOffset] = palavra;
	}

	/**
	 * Retorna bit de validade.
	 * @return
	 */
	public boolean getV() {
		return v;
	}

	/**
	 * Set bit de validade com valor v.
	 * @param v
	 */
	public void setV(boolean v) {
		this.v = v;
	}

	/**
	 * Retorna valor da tag.
	 * @return
	 */
	public int getTag() {
		return tag;
	}

	/**
	 * Set valor da tag.
	 * @param tag
	 */
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	

}
