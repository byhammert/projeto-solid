package br.com.solid.models;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public enum Canal {

	IB("1"),
	MB("2");
	
	private final String codigoCanal;
	
	private Canal(String codigoCanal) {
		this.codigoCanal = codigoCanal;
	}
	
	public String getCodigoCanal() {
		return codigoCanal;
	}
	
	public static Canal ofCodigo(int value) {
		if(1 == value)
			return IB;
		if(2 == value)
			return MB;
		
		throw new IllegalArgumentException(String.format("Código (%s) do canal não reconhecido.", value));
	}
	
	public static Canal ofCodigo(String value) {
		Preconditions.checkArgument(StringUtils.isNotBlank(value), "Código do canal não pode ser branco.");
		return ofCodigo(Integer.valueOf(value));
	}
}
