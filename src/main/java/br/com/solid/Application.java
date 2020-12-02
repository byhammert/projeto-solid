package br.com.solid;

import java.util.Arrays;
import java.util.List;

public class Application {
	
	public static void main(String[] args) {
//		SimuladorDeCompra.simular();
//		SimuladorDeLeituraDeArquivos.sumular();
		
		List<String> list = null;
		
		System.out.println(teste(list));
	}
	
	private static String teste(List<String> list) {
		final String semPrioridade = "Sem Prioridade";
		String tipoPrioridade = semPrioridade;
		if(list != null)
			tipoPrioridade = list.stream()
									.filter(livro -> livro.equals("Java"))
									.findFirst()
									.orElse(semPrioridade);
		
		return tipoPrioridade;
	}
	
	
//	public String getPrioridadeFornecedor(Material material) {
//		final String semPrioridade = "Sem Prioridade";
//		String tipoPrioridade = semPrioridade;
//		FornecedorPrioritario fornecedorPrioritario = fornecedorPrioritarioService.buscaPorMaterial(material);
//		if(fornecedorPrioritario != null) {
//			tipoPrioridade = fornecedorPrioritario.getItens().stream()
//															 .filter(forn -> forn.getFornecedor().equals(fornecedor))
//															 .findFirst()
//															 .orElse(semPrioridade);
//		}
//		return tipoPrioridade;
//	}
	
	
	
	
	

}
