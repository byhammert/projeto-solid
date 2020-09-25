package br.com.solid.carrinho.compras;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.AbstractThrowableAssert;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;

import br.com.solid.util.MoedaUtil;

public class ItemTest {
	
	private static final String DESCRICAO_OBRIGATORIA = "Descrição obrigatória.";
	private static final String VALOR_OBRIGATORIO = "Valor obrigatório.";
	
	@Test
	public void deve_construir_item_com_valores_default() {
		final Item item = new Item();
		assertThat(item.getDescricao()).isEqualTo(StringUtils.EMPTY);
		assertThat(item.getValor()).isEqualTo(MoedaUtil.zero());
	}
	
	@Test
	public void deve_construir_item_com_valores_que_foram_passado_para_construtor() {
		final String descricao = "Teste";
		final Money valor = MoedaUtil.of("60.00");
		
		final Item item = new Item(descricao, valor);
		assertThat(item.getDescricao()).isEqualTo(descricao);
		assertThat(item.getValor()).isEqualTo(valor);
	}
	
	@Test
	public void test_get_and_Set() {
		final Item item = new Item();
		assertThat(item.getDescricao()).isEqualTo(StringUtils.EMPTY);
		assertThat(item.getValor()).isEqualTo(MoedaUtil.zero());
		
		final String descricao = "Teste";
		final Money valor = MoedaUtil.of("60.00");
		item.setDescricao(descricao);
		item.setValor(valor);
		
		assertThat(item.getDescricao()).isEqualTo(descricao);
		assertThat(item.getValor()).isEqualTo(valor);
	}
	
	@Test
	public void deve_retornar_erro_de_validacao() {
		assertInvalid(null, null, DESCRICAO_OBRIGATORIA);
		assertInvalid(StringUtils.EMPTY, null, DESCRICAO_OBRIGATORIA);
		assertInvalid("teste", null, VALOR_OBRIGATORIO);
		
	}
	
	private AbstractThrowableAssert<?, ?> assertInvalid(String descricao, Money valor, String mensagemEsperada) {
		return assertThatThrownBy(() -> {
			new Item(descricao, valor);
		})
		.isExactlyInstanceOf(IllegalArgumentException.class)
		.hasMessage(mensagemEsperada);
	}

}
