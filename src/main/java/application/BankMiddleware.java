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
	
	// fazer depósito bancário
	@Post(router = "/dep")
	public JSONObject dep(JSONObject jsonObject) throws Throwable {
		
		
		return jsonObject;
	}
	
	
	// pegar saldo bancário
	@Get(router = "/sal")
	public JSONObject sal(JSONObject jsonObject) throws Throwable {
		
//		Double var1 = jsonObject.getDouble("var1");
//		System.out.println("\nDEBUG: O valor do var1 = " + var1);
//
//		Double var2 = jsonObject.getDouble("var2");
//		System.out.println("\nDEBUG: O valor de var2 = " + var2);
//
//		//String str = jsonObject.getString(null);
//		JSONObject result = new JSONObject();
//		result.put("result", var1+var2);
//		
//		return result;
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
