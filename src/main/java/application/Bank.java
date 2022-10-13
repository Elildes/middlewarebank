package main.java.application;

import java.util.HashMap;

import main.java.middleware.annotations.Get;
import main.java.middleware.annotations.Post;
import main.java.middleware.annotations.RequestMap;
import main.java.middleware.annotations.JSONObject;

//@NoArgsConstructor

@RequestMap(router = "/banco")
public class Bank {
	private HashMap<Integer, Float> contas = new HashMap<>();
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addContas(int numconta) {
		contas.put(numconta, 0.0f);
	}
	
	@Post(router = "depositar")
	public void depositar(int numconta, float valor) {
		float atual = contas.get(numconta);
		contas.put(numconta, atual+valor);
	}
	
	//----JSon------------
	@Get(router = "saldo")
	public float saldo(int numconta) {
		return contas.get(numconta);
	}
	
	@Get(router = "saldo")
	public JSONObject saldo (JSONObject jsonObj) throws Throwable {
		
		//numconta = jsonObj.getInteger(key: xx) 
		
		return null;
		
	}
	
	
}

/* Dependências:
 * 
 * 1. JSon:
 * Fonte: https://github.com/stleary/JSON-java (Click here if you just want the latest release jar file)
 * Install: Project -> Properties -> Java Build Path -> Libraries -> Classpath - > Add External Jars ...
 * 
 */


