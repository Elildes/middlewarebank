package main.java.application;

import org.json.JSONObject;
import lombok.NoArgsConstructor;
import main.java.middleware.annotations.Get;
import main.java.middleware.annotations.Post;
import main.java.middleware.annotations.Put;
import main.java.middleware.annotations.Delete;
import main.java.middleware.annotations.RequestMap;

/*
 * Implentada usando as anotações implementados pelo middleware.
 */

@NoArgsConstructor

@RequestMap(router = "/fin")
public class BankMiddleware {

	// adicionar/criar conta bancária
	@Put(router = "/add")
	public JSONObject add(JSONObject jsonObject) throws Throwable {

		// Teste: pegar variável JSon 
		Double var = jsonObject.getDouble("var1");
		System.out.println("\nDEBUG: O valor do var = " + var);

		float a = jsonObject.getFloat("var2");
		System.out.println("\nDEBUG: O valor de float = " + a);

		//String str = jsonObject.getString(null);
		
		
		return jsonObject;
	}
	
	// fazer depósito bancário
	@Post(router = "/dep")
	public JSONObject dep(JSONObject jsonObject) throws Throwable {
		
		
		return jsonObject;
	}

	
/*
	public void deposita(String agencia, String numero, double valor) {
		Bank cc = new Bank();
		cc = buscaBank(agencia, numero);
		
		// Teste:
		//Boolean teste = getBanco().contains(numero);
		
		if(valor > 0 && cc.getNumero() != "0") {
			cc.setSaldo(cc.getSaldo() + valor);
			System.out.printf("Deposito de R$ %.2f em Ag.: [%s], Conta: [%s] efetuado com sucesso!\n", valor, cc.getAgencia(), cc.getNumero());
		} else if (cc.getNumero().equalsIgnoreCase("0")) {
			System.out.printf("\nConta Bancária Agência: [%s], Conta: [%s] não existe!\n\n", cc.getAgencia(), cc.getNumero());
		} else {
			System.out.println("Valor igual ou menor que zero!");
		}
	}

 */
	
	
	// pegar saldo bancário
	@Get(router = "/sal")
	public JSONObject sal(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}
	
	// fazer saque bancário
	@Post(router = "/sac")
	public JSONObject sac(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}

	// fazer trabsferência bancária
	@Post(router = "/tra")
	public JSONObject tra(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}
	
	// excluir conta bancária
	@Delete(router = "/del")
	public JSONObject del(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}	
}



// Testes: criar conta
//BankDB dbBB = BankDB.getInstance();

/*		Bank bb = new Bank();
bb.setAgencia("1234");
bb.setNumero("12000");
dbBB.addBank(bb);
*/

// Teste: deposita
/*		System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("1234", "12000"));
dbBB.deposita("1234", "12000", 1500.00);
System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("1234", "12000"));
*/

//Teste: saca
/*		System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("1234", "12000"));
dbBB.saca("1234", "12000", 1000.00);
System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("1234", "12000"));
*/		

// Testes: criar outra conta
//dbBB = BankDB.getInstance();

/*		Bank bdn = new Bank();
bdn.setAgencia("5678");
bdn.setNumero("13000");
dbBB.addBank(bdn);
*/

// Testes: transfere
/*		dbBB = BankDB.getInstance();
System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("1234", "12000"));
System.out.println("\nSaldo anterior de banco: R$ " + dbBB.saldo("5678", "13000"));
dbBB.transfere("1234", "12000", "5678", "13000", 400.00);
System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("1234", "12000"));
System.out.println("Saldo atual de banco: R$ " + dbBB.saldo("5678", "13000"));
*/		

// Testes: listar bancos
/*		dbBB = BankDB.getInstance();
System.out.println(dbBB.listarBancos());
*/
