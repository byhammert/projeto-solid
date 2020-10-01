package br.com.solid;

import br.com.solid.carrinho.compras.SimuladorDeCompra;
import br.com.solid.etl.SimuladorDeLeituraDeArquivos;

public class Application {
	
	public static void main(String[] args) {
		SimuladorDeCompra.simular();
		SimuladorDeLeituraDeArquivos.sumular();
	}

}
