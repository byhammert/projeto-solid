package br.com.solid.carrinho.compras;

import org.apache.commons.lang3.StringUtils;
import org.joda.money.Money;

import com.google.common.base.Preconditions;

import br.com.solid.util.MoedaUtil;

public class Item {
	
	private static final String DESCRICAO_OBRIGATORIA = "Descrição obrigatória.";
	private static final String VALOR_OBRIGATORIO = "Valor obrigatório."; 
	
	private String descricao;
	private Money valor;
	
	public Item() {
		this.descricao = "";
		this.valor = MoedaUtil.zero();
	}
	
	public Item(String descricao, Money valor) {
		Preconditions.checkArgument(StringUtils.isNotBlank(descricao), DESCRICAO_OBRIGATORIA);
		Preconditions.checkArgument(valor != null, VALOR_OBRIGATORIO);
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Money getValor() {
		return valor;
	}
	public void setValor(Money valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Item [descricao=" + descricao + ", valor=" + valor + "]";
	}
	
}
