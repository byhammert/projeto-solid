package br.com.solid.carrinho.compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
	
	private List<Item> itens;
	
	public CarrinhoCompras() {
		super();
		this.itens = new ArrayList<>();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void adicinarItemNoCarrinho(Item item) {
		itens.add(item);
	}
	
	public boolean validarCarrinho() {
		return !itens.isEmpty();
	}

	@Override
	public String toString() {
		return "CarrinhoCompras [itens=" + itens + "]";
	}
	
	

}
