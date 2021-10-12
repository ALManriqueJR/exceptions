package model.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//esse bloco permite que possa instanciar minha custom class passando uma msg para ela
	public DomainException(String msg) {
		super(msg);
		//msg armazenada na superclasse
	}
	
	// nesse caso deixando  DomainException como filha de Exception, se tem o suporte do compilador, pois ele cobra o tratamento de exceções dessa classe
	//Agr se fosse do tipo RuntimeException, ele não cobra o tratamento desse tipo de erro, mas em acontecendo o erro sem haver o tratamento adequado o programa quebra
	
	
}
