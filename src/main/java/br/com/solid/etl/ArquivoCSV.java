package br.com.solid.etl;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArquivoCSV extends Arquivo  {
	
	private Logger logger = LoggerFactory.getLogger(ArquivoCSV.class);
	
	public List<Dado> lerAquivo(final String caminho) {
		logger.info("Iniciando leitura do arquivo CSV: " + caminho);
		
		try (Stream<String> stream = Files.lines(Paths.get(caminho), StandardCharsets.ISO_8859_1)) {
			dados = stream.map(linha -> linha.split(";"))
						  .map(coluna -> this.getDado(coluna[0], coluna[1], coluna[2]))
						  .collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Erro na leitura do arquivo CSV: " + caminho, e);
		}
		
		logger.info("Conteúdo: " + dados);
		logger.info("Finalizando leitura do arquivo CSV: " + caminho);
		
		return dados;
	}

}
