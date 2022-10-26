package main.java.middleware.communication;

import java.lang.reflect.Method;
import main.java.middleware.annotations.*;

/*
 * Classe que encapsula o middleware.
 * Amazena os métodos em hashmaps.
 * Inicia o servidor na port correta.
 */
public class Finance {

	// Salva objetos remotos	
	public String addMethods(Object object) {
		
		try {

			// Extrair a classe do objeto remoto
			Class<?> clazz = object.getClass();
			
			// Verifica se todos os métodos da classe tem anotações
			for (Method method : clazz.getDeclaredMethods()) {
				// Verfica se a anotação é um Get, Post, Put ou Delete:
				if (method.isAnnotationPresent(Get.class)) {
					method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
					RemoteObject.addMethodGet("GET" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Get.class).router(), method);	//Salva o método no hashmap (get + class route + method route)
				}else if (method.isAnnotationPresent(Post.class)) {
					method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
	                RemoteObject.addMethodPost("POST" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Post.class).router(), method);	//Salva o método no hashmap (post + class route + method route)            	
				}else if (method.isAnnotationPresent(Put.class)) {
					method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
	                RemoteObject.addMethodPut("PUT" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Put.class).router(), method);	//Salva o método no hashmap (put + class route + method route)           	
				}else if (method.isAnnotationPresent(Delete.class)) {
					method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
	                RemoteObject.addMethodDelete("DELETE" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Delete.class).router(), method);	//Salva o método no hashmap (delete + class route + method route)
	            }
			}
			
			RemoteObject.printConcurrentHashMap();
			return "método adicionado com sucesso";	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;				
	}
	
	// Inica o servidor na porta 'port'
	public void start(int port) {
		
		ServerRequestHandler server = new ServerRequestHandler(port);
		server.run();	// chama a função principal de ServerRequestHandler()
	}
}