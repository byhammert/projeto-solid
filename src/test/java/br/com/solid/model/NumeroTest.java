package br.com.solid.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

import br.com.solid.models.Numero;

public class NumeroTest {
	
	@Test
	public void of() {
		assertThat(Numero.of(100)).isEqualTo(Numero.of("100"));
	}
	
	@Test
	public void deve_lancarExcecao_quando_numero_invalido() {
		assertInvalidNumero(null, "numero não pode ser branco (%s).");
		assertInvalidNumero("", "numero não pode ser branco (%s).");
		assertInvalidNumero(" ", "numero não pode ser branco (%s).");
		assertInvalidNumero("-1", "numero invalido (%s).");
	}
	
	private AbstractThrowableAssert<?, ?> assertInvalidNumero(String numero, String msg) {
		return assertThatThrownBy(() -> {
			Numero.of(numero);
		})
		.isExactlyInstanceOf(IllegalArgumentException.class)
		.hasMessage(msg, numero);
	}

}
