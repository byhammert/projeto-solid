package br.com.solid.etl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LeitorTest {
	
	private final static String ARQUIVO_CSV = "dados.csv";
	private final static String ARQUIVO_TXT = "dados.txt";
	
	@Test
	public void deve_ler_arquivo_csv() {
		List<Dado> dados = UtilParaTest.lerArquivo(ARQUIVO_CSV, new ArquivoCSV());
		
		assertThat(dados).isNotNull();
		assertThat(dados).isNotEmpty();
	}
	
	@Test
	public void deve_ler_arquivo_txt() {
		List<Dado> dados = UtilParaTest.lerArquivo(ARQUIVO_TXT, new ArquivoTXT());
		
		assertThat(dados).isNotNull();
		assertThat(dados).isNotEmpty();
	}
}
