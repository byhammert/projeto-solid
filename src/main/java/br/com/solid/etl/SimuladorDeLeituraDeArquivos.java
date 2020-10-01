package br.com.solid.etl;

public class SimuladorDeLeituraDeArquivos {
	
	private final static String DIRETORIO = "src/main/resources/arquivos";
	private final static String ARQUIVO_CSV = "dados.csv";
	private final static String ARQUIVO_TXT = "dados.txt";
	
	public static void sumular() {
		lerArquivoCSV();
		lerArquivoTXT();
	}
	
	private static void lerArquivoCSV() {
		lerArquivo(ARQUIVO_CSV, new ArquivoCSV());
	}
	
	private static void lerArquivoTXT() {
		lerArquivo(ARQUIVO_TXT, new ArquivoTXT());
	}

	private static void lerArquivo(final String arquivo, Arquivo tipoArquivo) {
		final Leitor lerArquivo = new Leitor(DIRETORIO, arquivo, tipoArquivo);
		lerArquivo.lerArquivo();
	}
}
