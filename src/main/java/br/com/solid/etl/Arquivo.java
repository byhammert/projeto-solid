package br.com.solid.etl;

import java.util.ArrayList;
import java.util.List;

public abstract class Arquivo {
	
	protected List<Dado> dados = new ArrayList<>();
	
	public abstract List<Dado> lerAquivo(final String caminho);
	
	public void addDado(final String cpf, final String nome, final String email) {
		dados.add(this.getDado(nome, cpf, email));
	}
	
	public Dado getDado(final String nome, final String cpf, final String email) {
		final Dado dado = new Dado(nome.trim(), cpf.trim(), email);
		return dado;
	}

}
