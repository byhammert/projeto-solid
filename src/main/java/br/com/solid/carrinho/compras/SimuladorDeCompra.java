package br.com.solid.carrinho.compras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.solid.util.MoedaUtil;

public class SimuladorDeCompra {
	
	private static final Logger logger = LoggerFactory.getLogger(SimuladorDeCompra.class);
	private static final String MENSAGEM_ERROR = "Status do pedido aberto.";
	
	public static void simular() {
		logger.info("Iniciando um novo Pedido...");
		final Pedido pedido = new Pedido();
		logger.info(pedido.toString());

		logger.info("Adicionando Item no carrinho...");
		final Item notebook = getItem();
		pedido.getCarrinhoCompras().adicinarItemNoCarrinho(notebook);
		logger.info(pedido.toString());
		
		logger.info("Confirmando Pedido...");
		pedido.confirmarPedido();
		logger.info(pedido.toString());

		logger.info("Enviando confirmação do pedido por e-mail...");	
		disparandoEmail(pedido);
	}

	private static Item getItem() {
		final Item notebook = new Item();
		notebook.setDescricao("Notebook Gamer");
		notebook.setValor(MoedaUtil.of("6000.00"));
		return notebook;
	}
	
	private static void disparandoEmail(final Pedido pedido) {
		String mensagemDeConfirmacao = MENSAGEM_ERROR;
		if (pedido.confirmarPedido())
			mensagemDeConfirmacao = EmailService.dispararEmail();
		
		logger.info(mensagemDeConfirmacao);
	}

}
