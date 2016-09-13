package util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileControl {

	/**
	 * Retorna um vetor de String com todos os elementos continos no arquivo do endereco
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String[] reader(String path) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line;
		int length = 0;
		
		while ((line = in.readLine()) != null) {
        	length++;
        }
		
		in = new BufferedReader(new FileReader(path));
		String[] vet = new String[length];
		int i = 0;
        while ((line = in.readLine()) != null) {
        	vet[i] = line;
        	i++;
        }
        in.close();
        return vet;
    }
	
	/**
	 * Escreve no arquivo do endereco todos os elementos contidos no vetor
	 * @param path
	 * @param vet
	 * @throws IOException
	 */
	public static void writer(String path) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path));
		int[] vet = {1, 2, 3};
		
		for (int i = 0; i < vet.length; i++) {
			out.write(vet[i] + "");
			if (i != vet.length - 1)
				out.newLine();
			out.flush();
		}
		
		out.close();
	}
}