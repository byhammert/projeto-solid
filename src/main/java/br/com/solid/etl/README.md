#2. OCP — Open-Closed Principle:

Princípio Aberto-Fechado — Uma entidade de software, tais como classes, módulos, funções e etc, devem  
sempre estar abertos para extensão, mas fechados para modificação, ou seja, quando novos comportamentos 
e recursos precisam ser adicionados no software, devemos estender e não alterar o código fonte original.

##O que é uma alteração?
Ocorre quando por exemplo, precisamos acessar uma classe já existente para incluir comportamentos ou 
para modificar comportamentos.
Em outras palavras para incluir métodos ou modificar os métodos da classe.

##O que é uma expansão?
Uma expansão de código requer uma conduta de abstração mais sofisticada no momento em que estamos implementando 
as classes.
Ou seja, é necessário pensar em como as nossas classes serão capazes de serem estendidas de modo que quando 
um novo comportamento for necessário que a classe já existente seja estendida ao invés de ser modificada.

Portanto repare que o princípio aberto fechado está sugerindo que você deve pensar em extensibilidade antes 
de implementar os seus códigos.


No pacote br.com.solid.etl

Temos classes menores, sendo utilizadas de modo coeso e atendendo dois dos princípio do SOLID, o de responsabilidade única
e o princípio de aberto e fechado.

