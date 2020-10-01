package br.com.solid.etl;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArquivoTXT extends Arquivo {
	
	private Logger logger = LoggerFactory.getLogger(ArquivoTXT.class);
	
	public List<Dado> lerAquivo(final String caminho) {
		logger.info("Iniciando leitura do arquivo TXT: " + caminho);
		
		try (Stream<String> stream = Files.lines(Paths.get(caminho), StandardCharsets.ISO_8859_1)) {
			dados = stream.map(linha -> this.transformarLinhaParaDado(linha))
						  .collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("Erro na leitura do arquivo TXT: " + caminho, e);
		}
		
		logger.info("Conteúdo: " + dados);
		logger.info("Finalizando leitura do arquivo TXT: " + caminho);
		
		return dados;
	}

	public Dado transformarLinhaParaDado(final String linha) {
		final String cpf = linha.substring(0, 11);
		final String nome = linha.substring(11, 41);
		final String email = linha.substring(41);
		
		return getDado(nome, cpf, email);
	}
	
}
