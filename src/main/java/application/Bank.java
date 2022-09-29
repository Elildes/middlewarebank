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
	
	@Post(router = "depositar")
	public void depositar(int numconta, float valor) {
		float atual = contas.get(numconta);
		contas.put(numconta, atual+valor)
	}
	
	@Get(router = "saldo")
	public float saldo(int numconta) {
		return contas.get(numconta);
	}
	
	
}
