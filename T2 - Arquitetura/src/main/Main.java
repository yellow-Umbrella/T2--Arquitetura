package main;

import java.io.IOException;

import util.Cache;
import util.FileControl;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] leitura = FileControl.reader("trace.in"); //
		
		int nBlocos = Integer.parseInt(leitura[0]);
		int palavrasPBloco = Integer.parseInt(leitura[1]);
		int way = Integer.parseInt(leitura[2]);
		int instrucoes = Integer.parseInt(leitura[3]);
		
		Cache cache = new Cache(nBlocos, palavrasPBloco, way);

		for (int i = 4; i < instrucoes; i++) {
			cache.executa(leitura[i]);
		}
		
		System.out.println("Taxa de Hit: " + cache.getTaxaDeHit());
		System.out.println("Quantidade de vezes que precisamos ir a memoria principal: " + cache.getMiss());
	}

}
