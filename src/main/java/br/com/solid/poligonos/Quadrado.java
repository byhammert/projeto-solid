package br.com.solid.poligonos;

public class Quadrado extends Forma {
	
	private Double altura;
	private Double largura;
	
	public void setAltura(Double altura) {
		this.altura = altura;
		this.largura = altura;
	}
	
	public void setLargura(Double largura) {
		this.altura = largura;
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public Double getLargura() {
		return largura;
	}
	
}
