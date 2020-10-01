# 3. LSP— Liskov Substitution Principle:

Princípio da substituição de Liskov — Uma classe derivada deve ser substituível por sua classe base.

	A definição da teoria diz:

	se S é um subtipo de T, então os objetos do tipo T, em um programa, podem ser substituídos pelos 
	objetos de tipo S sem que seja necessário alterar as propriedades deste programa.
	
	Exemplos de violação do LSP:
		Sobrescrever/implementar um método que não faz nada;
		Lançar uma exceção inesperada;
		Retornar valores de tipos diferentes da classe base;
		
	Seguir o LSP nos permite usar o polimorfismo com mais confiança.
	Podemos chamar nossas classes derivadas referindo-se à sua classe 
	base sem preocupações com resultados inesperados.