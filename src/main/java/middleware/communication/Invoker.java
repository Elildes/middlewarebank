package main.java.middleware.communication;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.JSONObject;

public class Invoker {
	
	// essa função deve receber um ArrayList de [método, rota e body]
	// e retornar um ArrayList de [code, message, conteudo]
	// com o objeto invocado
	public ArrayList<String> invokar(ArrayList<String> intern) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		ArrayList<String> resposta = new ArrayList<String>();

		
		String method_plus_route = intern.get(0)+intern.get(1);
		
		
		JSONObject jbody = new JSONObject(intern.get(2));
		
		
		resposta = RemoteObject.instanciate(method_plus_route, jbody);
		
	
		return resposta;
}

}