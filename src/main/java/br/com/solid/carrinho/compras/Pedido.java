package br.com.solid.carrinho.compras;

import org.joda.money.Money;

import br.com.solid.util.MoedaUtil;

public class Pedido {
	private StatusPedido status;
	private CarrinhoCompras carrinhoCompras;
	
	public Pedido() {
		this.status = StatusPedido.ABERTO;
		this.carrinhoCompras = new CarrinhoCompras();
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public CarrinhoCompras getCarrinhoCompras() {
		return carrinhoCompras;
	}

	public Money getValorTotalPedido() {
		return atualizarValorTotalPedido();
	}
	
	public Money atualizarValorTotalPedido() {
		return carrinhoCompras.getItens().stream()
				.map((item) -> item.getValor())
				.reduce(MoedaUtil.zero(), (v1, v2) -> v1.plus(v2));
	}
	
	public boolean confirmarPedido() {
		boolean pedidoConfirmado = false;
		if(carrinhoCompras.validarCarrinho()) {
			this.status = StatusPedido.CONFIRMADO;
			pedidoConfirmado = true;
		}
		
		return pedidoConfirmado;
	}

	@Override
	public String toString() {
		return "Pedido [status=" + status + ", carrinhoCompras=" + carrinhoCompras + "]";
	}
	
}
