package br.com.solid.carrinho.compras;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import br.com.solid.util.MoedaUtil;

public class PedidoTest {
	
	@Test
	public void deve_criar_carrinho_com_status_aberto() {
		final Pedido pedido = new Pedido();
		
		assertThat(pedido.getStatus()).isEqualTo(StatusPedido.ABERTO);
		assertThat(pedido.getValorTotalPedido()).isEqualTo(MoedaUtil.zero());
		assertThat(pedido.getCarrinhoCompras()).isNotNull();
		assertThat(pedido.getCarrinhoCompras().getItens()).isEmpty();
	}
	
	@Test
	public void deve_manter_status_aberto_ao_confirmar_pedido_com_carrinho_vazio() {
		final Pedido pedido = new Pedido();
		pedido.confirmarPedido();
		assertThat(pedido.getStatus()).isEqualTo(StatusPedido.ABERTO);
		assertThat(pedido.getValorTotalPedido()).isEqualTo(MoedaUtil.zero());
		assertThat(pedido.getCarrinhoCompras()).isNotNull();
		assertThat(pedido.getCarrinhoCompras().getItens()).isEmpty();
	}
	
	@Test 
	public void deve_alterar_status_ao_confirmar_pedido() {
		final Pedido pedido = new Pedido();
		
		final Item notebook = new Item();
		notebook.setDescricao("Notebook Gamer");
		notebook.setValor(MoedaUtil.of("6000.00"));
		
		final Item teclado = new Item();
		teclado.setDescricao("Teclado");
		teclado.setValor(MoedaUtil.of("60.00"));
		
		pedido.getCarrinhoCompras().adicinarItemNoCarrinho(notebook);
		pedido.getCarrinhoCompras().adicinarItemNoCarrinho(teclado);
		pedido.confirmarPedido();
		
		assertThat(pedido.getStatus()).isEqualTo(StatusPedido.CONFIRMADO);
		assertThat(pedido.getValorTotalPedido()).isEqualTo(MoedaUtil.of("6060.00"));
		assertThat(pedido.getCarrinhoCompras().getItens()).isNotEmpty();
		assertThat(pedido.getCarrinhoCompras().getItens()).hasSize(2);
		
	}

}
