package main.java.application;

import main.java.middleware.communication.Finance;

/*
 * Classe principal
 */
public class Main {

	public static void main(String[] args) {
	
		Calculadora bb = new Calculadora();	// instância da classe de negócio
		Finance server = new Finance();				// instância do middleware
		server.addMethods(bb);		// adiciona anotações de métodos e salva no hashmaps
		server.start(7080);			// inicia o middleware na porta correta.		
	}

}
