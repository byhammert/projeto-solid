package br.com.solid.poligonos;

public class Poligono {
	
	private Forma forma;

	public Forma getForma() {
		return forma;
	}

	public void setForma(Forma forma) {
		this.forma = forma;
	}
	
	public Double getArea() {
		return forma.getAltura() * forma.getLargura();
	}

}
