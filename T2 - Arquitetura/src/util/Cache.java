package util;

public class Cache {
	private int hit;
	private int miss;
	private Conjunto[] conjuntos;
	private int lengthBlocos;
	private int palavrasPBloco;
	private int way;
	
	/**
	 * Construtor padrão.
	 */
	public Cache() {}
	
	/**
	 * Construtor que recebe o número de blocos, o número de palavras por bloco e a way
	 * @param nBlocos
	 * @param palavrasPBloco
	 * @param way
	 */
	public Cache(int nBlocos, int palavrasPBloco, int way) {
		hit = 0;
		miss = 0;
		this.palavrasPBloco = palavrasPBloco;
		this.way = way;
		
		conjuntos = new Conjunto[way];
		
		this.lengthBlocos = nBlocos/way;
		
		for(int i = 0; i < conjuntos.length; i++)
			conjuntos[i] = new Conjunto(lengthBlocos, palavrasPBloco);
		
	}
	
	/**
	 * Recebe o endereco que devemos ler
	 * @param endereco
	 */
	public void operacao(int endereco) { //op = zero (ler)
		
		int end1 = endereco/4;
		int end2 = end1/palavrasPBloco;
		int tag = end2/way;
		boolean deuHit = false;
		
		int index = end2%lengthBlocos;
		
		Bloco[] vet = new Bloco[way];
		
		int i = 0;
		for(Conjunto x: conjuntos)
			vet[i++] = x.getBlocos()[index];
		
		for(Bloco x: vet)
			if(x.getV())
				if(x.getTag().equals(tag+"")) {
					hit++;
					deuHit = true;
					return;
				}
		if(!deuHit) {
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
		int blockOffset = end1%palavrasPBloco;
		int tag = end2/way;
		int aux = endereco;
		
		
		int index = end2%way;
		int indexConjunto = 0;
		
		if(conjuntos[indexConjunto].getBlocos()[index].getV())
			hit++;
		
		do {
			aux -= lengthBlocos;
			if(aux < 0) {
				conjuntos[indexConjunto].getBlocos()[index].setPalavra(valor+"", blockOffset);
				conjuntos[indexConjunto].getBlocos()[index].setV(true);
				conjuntos[indexConjunto].getBlocos()[index].setTag(tag+"");
			}
			indexConjunto++;
			if(indexConjunto > way-1)
				indexConjunto = 0;
		}while(aux > 0);
		
		
		
		
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
