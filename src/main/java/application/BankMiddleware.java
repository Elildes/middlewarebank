package main.java.application;

import org.json.JSONObject;
import lombok.NoArgsConstructor;
import main.java.middleware.annotations.Get;
import main.java.middleware.annotations.Post;
import main.java.middleware.annotations.Put;
import main.java.middleware.annotations.Delete;
import main.java.middleware.annotations.RequestMap;
//import main.java.application.Bank;

/*
 * Implentada usando as anotações implementados pelo middleware.
 */

@NoArgsConstructor

@RequestMap(router = "/fin")
public class BankMiddleware {

/*
	// Adicionar saldo à conta
	@Post(router = "/add")
	public JSONObject add(JSONObject jsonObject) throws Throwable {

		// Teste: pegar variável JSon 
		Double var1 = jsonObject.getDouble("var1");
		System.out.println("\nDEBUG: O valor do var1 = " + var1);

		Double var2 = jsonObject.getDouble("var2");
		System.out.println("\nDEBUG: O valor de var2 = " + var2);

		//String str = jsonObject.getString(null);
		JSONObject result = new JSONObject();
		result.put("result", var1+var2);
		
		return result;
	}
*/
	
	// Adicionar conta bancária
	@Put(router = "/add")
	public JSONObject add(JSONObject jsonObject) throws Throwable {

		// pegar variável JSon: body = {"var1": "num_conta", "var2": "num_agencia"}
		String var1 = jsonObject.getString("var1");
		String var2 = jsonObject.getString("var2");

		// teste:
		System.out.println("\nDEBUG: O valor do var1 = " + var1);
		System.out.println("DEBUG: O valor de var2 = " + var2);

		// instância da classe de negócio
		BankDB dbBanco = BankDB.getInstance();

		Bank conta = new Bank();
		conta.setAgencia("1234");
		conta.setNumero("12000");
		dbBanco.addBank(conta);

		// retorno
		JSONObject result = new JSONObject();
		result.put("var1", var1);
		result.put("var2", var2);
		
		// Teste:
		System.out.println("DEBUG: array_contas em fin/add:\n" + BankDB.getInstance().listarBancos());
		String str = result.toString();
		System.out.println("DEBUG: result em fin/add: " + str);
		
		return result;
	}
	
	
	// fazer depósito bancário
	@Post(router = "/dep")
	public JSONObject dep(JSONObject jsonObject) throws Throwable {
		
		// ERRO: por causa de 3 var's?

		// pegar variável JSon: body = {"var1": "num_conta", "var2": "num_agencia", "var3": valor_dep}
		// antes: {"var1": "12000", "var2": "1234", "var3": 1000.00}
		// atual: {"var1": "12000", "var3": 1000.00}
		String var1 = jsonObject.getString("var1");
		//String var2 = jsonObject.getString("var2");
		Double var3 = jsonObject.getDouble("var3");

		// teste:
		System.out.println("\nDEBUG: O valor do var1 = " + var1);
		//System.out.println("\nDEBUG: O valor de var2 = " + var2);
		System.out.println("\nDEBUG: O valor de var3 = " + var3);
		
		// instância da classe de negócio
		BankDB dbBanco = BankDB.getInstance();
		
		Bank cc = new Bank();
		//cc =  dbBanco.buscaBank(var2, var1);
		cc =  dbBanco.buscaBank(var1);
		
		// Teste:
		//Boolean teste = getBanco().contains(numero);
		
		if(var3 > 0 && cc.getNumero() != "0") {
			cc.setSaldo(cc.getSaldo() + var3);
			System.out.printf("Deposito de R$ %.2f em Ag.: [%s], Conta: [%s] efetuado com sucesso!\n", var3, cc.getAgencia(), cc.getNumero());
		} else if (cc.getNumero().equalsIgnoreCase("0")) {
			System.out.printf("\nConta Bancária Agência: [%s], Conta: [%s] não existe!\n\n", cc.getAgencia(), cc.getNumero());
		} else {
			System.out.println("Valor igual ou menor que zero!");
		}

		// retorno
		JSONObject result = new JSONObject();
		result.put("var1", var1);
		//result.put("var2", var2);		// ??????????????
		result.put("var3", var3);
		
		return result;
	}
	
	
	// pegar saldo bancário
	@Get(router = "/sal")
	public JSONObject sal(JSONObject jsonObject) throws Throwable {
		
		// pegar variável JSon: body = {"var1": "num_conta", "var2": "num_agencia"}
		String var1 = jsonObject.getString("var1");
		String var2 = jsonObject.getString("var2");

		// teste:
		System.out.println("\nDEBUG: O valor do var1 = " + var1);
		System.out.println("\nDEBUG: O valor de var2 = " + var2);
		
		// instância da classe de negócio
		BankDB dbBanco = BankDB.getInstance();
		
		Bank cc = new Bank();
		//cc = dbBanco.buscaBank(var2, var1);
		cc = dbBanco.buscaBank(var1);

		Double saldo =  cc.getSaldo();
		
		// retorno
		JSONObject result = new JSONObject();
		result.put("var1", saldo);
		
		// teste:
		String str = result.toString();
		System.out.println("DEBUG: result em fin/sal: " + str);
		
		return result;
	}
	
	// fazer saque bancário
	@Post(router = "/sac")
	public JSONObject sac(JSONObject jsonObject) throws Throwable {
		
		// ERRO 3 var's??
		
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

		// ERRO: 3 var's ???
		
		// pegar variável JSon: body = ???
		
		// instância da classe de negócio
		BankDB dbBanco = BankDB.getInstance();
		dbBanco.getBanco().clear();
		
		// retorno
		JSONObject result = new JSONObject();
		result.put("var1", "delete");
		
		// teste:
		System.out.println("\n Size of array_banco: " + dbBanco.getBanco().size());

		return result;
	}	
}
