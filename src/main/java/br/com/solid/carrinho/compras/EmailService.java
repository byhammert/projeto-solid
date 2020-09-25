package br.com.solid.carrinho.compras;

public class EmailService {
	
	private static final String MENSAGEM_EMAIL = "Confirmação enviada por email.";
	
	public static String dispararEmail() {
		return MENSAGEM_EMAIL;
	}

}
