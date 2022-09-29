package main.java.application;

import java.util.HashMap;

//@NoArgsConstructor

@RequestMap(router = "/banco")
public class Bank {
	private HashMap<Integer, Float> contas = new HashMap<>();
	private String nome;

/*	
	public void HashMap<Integer, Float> getContas() {
		return contas;
	}
*/
	
	public void addContas(int numconta) {
		contas.put(numconta, 0.0f);
	}
	
/*	
	public void addContas(HashMap<Integer, Float> contas) {
		this.contas = contas;
	}
*/	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
