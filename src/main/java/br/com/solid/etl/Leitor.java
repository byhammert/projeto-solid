package br.com.solid.etl;

import java.util.List;

public class Leitor {

	private String diretorio;
	private String arquivo;
	private Arquivo tipoDeArquivo;
	
	public Leitor(String diretorio, String arquivo, Arquivo tipoDeArquivo) {
		super();
		this.diretorio = diretorio;
		this.arquivo = arquivo;
		this.tipoDeArquivo = tipoDeArquivo;
	}
	
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public List<Dado> lerArquivo() {
		final String caminho = String.format("%s/%s", diretorio, arquivo);
		return tipoDeArquivo.lerAquivo(caminho);
	}
	
}
