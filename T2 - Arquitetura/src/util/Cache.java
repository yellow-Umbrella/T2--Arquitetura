package util;

public class Cache {
	private int hit;
	private int miss;
	private Conjunto[] conjuntos;
	private int palavrasPBloco;
	private int way;
	
	/**
	 * Construtor padr�o.
	 */
	public Cache() {}
	
	/**
	 * Construtor que recebe o n�mero de blocos, o n�mero de palavras por bloco e a way
	 * @param nBlocos
	 * @param palavrasPBloco
	 * @param way
	 */
	public Cache(int nBlocos, int palavrasPBloco, int way) {
		hit = 0;
		miss = 0;
		this.palavrasPBloco = palavrasPBloco;
		this.way = way;
		
		conjuntos = new Conjunto[nBlocos/way];
		
		for(int i = 0; i < conjuntos.length; i++)
			conjuntos[i] = new Conjunto(way, palavrasPBloco);
		
	}
	
	/**
	 * Recebe o endereco que devemos ler
	 * @param endereco
	 */
	public void operacao(int endereco) { //op = zero (ler)
		
		int end1 = endereco/4;
		int end2 = end1/palavrasPBloco;
		int blockOffset = end1%way;
		int tag = end2/conjuntos.length;
		
		int index = end2%conjuntos.length;
		
		if(conjuntos[index].getBlocos()[blockOffset].getV()) {
			if(conjuntos[index].getBlocos()[blockOffset].getTag().equals(tag)) {
				hit++;
			}
		}
		else {
			miss++;
			operacao(endereco, 0);
		}
			
	}
	
	/**
	 * Recebe o endereco de onde devemos escrever e o valor que deve ser escrito
	 * @param endereco
	 * @param valor
	 */
	public void operacao(int endereco, int valor) { //op = 1 (escrever)
		
		int end1 = endereco/4;
		int end2 = end1/palavrasPBloco;
		int blockOffset = end1%way;
		int tag = end2/conjuntos.length;
		
		int index = end2%conjuntos.length;
		
			
		if(conjuntos[index].getBlocos()[blockOffset].getV()) {
			hit++;
		}
		else {
			conjuntos[index].getBlocos()[blockOffset].setTag(tag+"");
			conjuntos[index].getBlocos()[blockOffset].setV(true);
		}
		
	}

	/**
	 * Retorna quantidade de miss.
	 * @return
	 */
	public int getMiss() {
		return miss;
	}

	/**
	 * Retorna taxa de Hit.
	 * @return
	 */
	public String getTaxaDeHit() {
		return ((100*hit)/(hit + miss)) + "%";
	}

	/**
	 * Recebe uma string e executa a operacao contida nela
	 * @param string
	 */
	public void executa(String string) {
		String[] vetSplit = string.split(" ");
		
		if(vetSplit.length == 2)
			operacao(Integer.parseInt(vetSplit[1]));
		else if(vetSplit.length == 3)
			operacao(Integer.parseInt(vetSplit[1]), Integer.parseInt(vetSplit[2]));
	}

}
