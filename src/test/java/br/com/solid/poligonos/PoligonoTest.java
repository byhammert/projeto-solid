package br.com.solid.poligonos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PoligonoTest {
	
	@Test
	public void quadrado() {
		Poligono poligono = new Poligono();
		poligono.setForma(new Quadrado());
		poligono.getForma().setAltura(10D);
		Double area = poligono.getArea();
		
		assertThat(area).isEqualTo(100D);
		
	}
	
	@Test
	public void quadrado2() {
		Poligono poligono = new Poligono();
		poligono.setForma(new Quadrado());
		poligono.getForma().setLargura(5D);
		Double area = poligono.getArea();
		
		assertThat(area).isEqualTo(25d);
		
	}
	
	@Test
	public void retangulo() {
		Poligono poligono = new Poligono();
		poligono.setForma(new Retangulo());
		poligono.getForma().setAltura(10d);
		poligono.getForma().setLargura(20d);
		
		Double area = poligono.getArea();
		
		assertThat(area).isEqualTo(200);
		
	}

}
