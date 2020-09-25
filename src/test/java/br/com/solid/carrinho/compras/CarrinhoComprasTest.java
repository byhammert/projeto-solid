package br.com.solid.carrinho.compras;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import br.com.solid.util.MoedaUtil;

public class CarrinhoComprasTest {
	
	@Test
	public void deve_criar_carrinho_com_lista_de_itens_vazia() {
		final CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		assertThat(carrinhoCompras.getItens()).isEmpty();
	}
	
	@Test
	public void deve_adicionar_Itens_no_carrinho() {
		final CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		carrinhoCompras.adicinarItemNoCarrinho(this.getItem());
		assertThat(carrinhoCompras.getItens()).isNotEmpty();
		assertThat(carrinhoCompras.getItens()).hasSize(1);
		
	}
	
	@Test 
	public void deve_validar_carrinho() {
		final CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		carrinhoCompras.adicinarItemNoCarrinho(this.getItem());
		
		assertThat(carrinhoCompras.validarCarrinho()).isTrue();
		
	}
	
	@Test 
	public void nao_deve_validar_carrinho() {
		final CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		
		assertThat(carrinhoCompras.validarCarrinho()).isFalse();
		
	}
	
	private Item getItem() {
		final Item notebook = new Item();
		notebook.setDescricao("Notebook Gamer");
		notebook.setValor(MoedaUtil.of("6000.00"));
		
		return notebook;
	}

}
