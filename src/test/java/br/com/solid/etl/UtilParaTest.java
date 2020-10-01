package br.com.solid.etl;

import java.util.List;

public class UtilParaTest {
	
	private final static String DIRETORIO = "src/test/resources/arquivos";
	
	public static List<Dado> lerArquivo(final String arquivo, Arquivo tipoArquivo) {
		final Leitor lerArquivo = new Leitor(DIRETORIO, arquivo, tipoArquivo);
		return lerArquivo.lerArquivo();
	}

}
