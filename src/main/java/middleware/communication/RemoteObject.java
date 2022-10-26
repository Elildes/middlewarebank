package main.java.middleware.communication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;

/*
 * Acessa um objeto remoto na rede.
 */
public class RemoteObject {

	// Hashmap salva métodos get, post, put e delete:
	private static ConcurrentHashMap<String, Method> methodsGet = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<String, Method> methodsPost = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<String, Method> methodsPut = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<String, Method> methodsDelete = new ConcurrentHashMap<>();


	public static void printConcurrentHashMap(){
		System.out.println("All get methods:");
		methodsGet.forEach((k,v)-> System.out.println(k));
		System.out.println("\nAll Post methods");
		methodsPost.forEach((k,v)-> System.out.println(k));
		System.out.println("\nAll Put methods");
		methodsPut.forEach((k,v)-> System.out.println(k));
		System.out.println("\nAll Delete methods");
		methodsDelete.forEach((k,v)-> System.out.println(k));
		System.out.println("\n");
	}
	
	//Adiciona um objeto remoto ao hashmap (gets)
	public static void addMethodGet(String key, Method obj) {
		methodsGet.put(key, obj);
	}
	
	//Adiciona um objeto remoto ao hashmap (posts)
	public static void addMethodPost(String key, Method obj) {
		methodsPost.put(key, obj);
	}
	
	//Adiciona um objeto remoto ao hashmap (puts)
	public static void addMethodPut(String key, Method obj) {
		methodsPut.put(key, obj);
	}
	
	//Adiciona um objeto remoto ao hashmap (deletes)
	public static void addMethodDelete(String key, Method obj) {
		methodsDelete.put(key, obj);
	}
	
	// retorna um array list com código HTTP, mensagem HTTP e Conteúdo
	public static ArrayList<String> instanciate(String chave, JSONObject json) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {


		if(methodsPost.containsKey(chave)){
			ArrayList<String> retorno = new ArrayList<String>();
			Method metodo = methodsPost.get(chave);
			Class<?> clazz = metodo.getDeclaringClass();
			Object instance = clazz.getDeclaredConstructor().newInstance();
			JSONObject obj = (JSONObject) metodo.invoke(instance, json);
			retorno.add("200");
			retorno.add("Sucesso");
			retorno.add(obj.toString());
			return retorno;
			
			}
//		
//		if(methodsGet.containsKey(chave)){
//			ArrayList<String> retorno = new ArrayList<String>();
//			Method metodo = methodsPost.get(chave);
//			Class<?> clazz = metodo.getDeclaringClass();
//			Object instance = clazz.getDeclaredConstructor().newInstance();
//			JSONObject obj = (JSONObject) metodo.invoke(instance, json);
//			retorno.add("200");
//			retorno.add("Sucesso");
//			retorno.add(obj.toString());
//			return retorno;
//			
//			}
		
		//complete
		
		
		
		
		
		
		return null;
		
		

		//ArrayList<String> array = new ArrayList<String>();
		
}
	
}
