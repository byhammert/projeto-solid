package br.com.solid.etl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ArquivoCSVTest {
	
	private final static String ARQUIVO_CSV = "dados.csv";
	
	@Test
	public void deve_ler_arquivo_csv() {
		List<Dado> dados = UtilParaTest.lerArquivo(ARQUIVO_CSV, new ArquivoCSV());
		
		assertThat(dados).isNotNull();
		assertThat(dados).isNotEmpty();
	}
	
	

}
