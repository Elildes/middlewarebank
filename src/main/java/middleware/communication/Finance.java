package main.java.middleware.communication;

import java.lang.reflect.Method;
import main.java.middleware.annotations.*;

/*
 * Classe que encapsula o middleware.
 * Amazena os métodos em xx.
 * Inicia o servidor na porta.
 */
public class Finance {

	// Coletando anotações	
	public String addMethods(Object object) {
		
		try {

			// Extract the remote object class
			Class<?> clazz = object.getClass();
			
			// Walks through all the methods of the class and checks if they have annotations
			for (Method method : clazz.getDeclaredMethods()) {
				// Verfica se a anotação é um Get, Post, Put ou Delete:
				if (method.isAnnotationPresent(Get.class)) {
					method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
					RemoteObject.addMethodGet("get" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Get.class).router(), method);	//Salva o método no hashmap (get + class route + method route)
				}else if (method.isAnnotationPresent(Post.class)) {
					method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
	                RemoteObject.addMethodPost("post" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Post.class).router(), method);	//Salva o método no hashmap (post + class route + method route)            	
				}//else if (method.isAnnotationPresent(Put.class)) {
					//method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
	                //RemoteObject.addMethodPut("put" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Put.class).router(), method);	//Salva o método no hashmap (put + class route + method route)           	
				}//else if (method.isAnnotationPresent(Delete.class)) {
					//method.setAccessible(true);		//permiti que o método seja acessado e invocado depois
	                //RemoteObject.addMethodDelete("delete" + clazz.getAnnotation(RequestMap.class).router() + method.getAnnotation(Delete.class).router(), method);	//Salva o método no hashmap (delete + class route + method route)
	            	//}
			//}
//		}
			return "método adicionado com sucesso";						
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;				
	}
}