package br.com.solid.models;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public class Numero extends ValueObject<Numero> {
	
	private final int numero;
	
	private Numero(int numero) {
		Preconditions.checkArgument(numero > 0, "numero invalido (%s).", numero);
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public static Numero of(String numero) {
		Preconditions.checkArgument(StringUtils.isNotBlank(numero), "numero não pode ser branco (%s).", numero);
		return new Numero(Integer.valueOf(numero));
	}
	
	public static Numero of(int numero) {
		return new Numero(numero);
	}

	@Override
	protected EqualsDelegate<Numero> createHashAndEqualsDelegate() {
		return EqualsDelegate.of(Numero.class).append(b -> b.getNumero());
	}

}
