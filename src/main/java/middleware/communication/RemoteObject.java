package main.java.middleware.communication;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Acessa um objeto remoto na rede.
 */
public class RemoteObject {

	// Hashmap salva métodos get, post, put e delete
	private static ConcurrentHashMap<Object, Method> methodsGet = new ConcurrentHashMap<>();
	// Hashmap to save post methods
	private static ConcurrentHashMap<Object, Method> methodsPost = new ConcurrentHashMap<>();
	// Hashmap to save put methods
	private static ConcurrentHashMap<Object, Method> methodsPut = new ConcurrentHashMap<>();
	// Hashmap to save delete methods
	private static ConcurrentHashMap<Object, Method> methodsDelete = new ConcurrentHashMap<>();

	
	//Adiciona um objeto remoto ao hashmap (gets)
	public static void addMethodGet(Object key, Method obj) {
		methodsGet.put(key, obj);
		System.out.println(methodsGet.keySet());
	}
	
	//Adiciona um objeto remoto ao hashmap (posts)
	public static void addMethodPost(Object key, Method obj) {
		methodsPost.put(key, obj);
		System.out.println(methodsPost.keySet());

	}
	
	//Adiciona um objeto remoto ao hashmap (puts)
	public static void addMethodPut(Object key, Method obj) {
		methodsPut.put(key, obj);
		System.out.println(methodsPut.keySet());

	}
	
	//Adiciona um objeto remoto ao hashmap (deletes)
	public static void addMethodDelete(Object key, Method obj) {
		methodsDelete.put(key, obj);
		System.out.println(methodsDelete.keySet());
	}
	
	// Continue------------------------------------
	
	
	
	
	
}
