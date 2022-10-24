package main.java.middleware.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Converte invocações remotas em fluxos de bytes.
 * O MARSALLER fornece um mecanismo genérico que não é
 * específico para nenhum tipo de objeto remoto específico.
 * Os REQUESTOR, INVOKER, and REQUEST HANDLERS usam o
 * MARSHALLER para recuperar as informações de invocação
 * contidas no fluxo de bytes da mensagem.
 */

public class Marshaller {
	
	public void Marshall() {}
	
	
	// return a string array list with [method, route and body]
	public ArrayList<String> Unmarshall(BufferedReader in) throws IOException {
		String method = "";
		String route = "";
		String body = "";
		ArrayList<String> contents = new ArrayList<String>();
		String line;
		while ((line = in.readLine()) != null) {
	        String[] div = line.split(" ");
	        method = div[0];
	        route = div[1];
			break;
		}
		
		String text;
		while ((text = in.readLine()) != null) {
		     if (text.isEmpty()) {
	                break;
	            }
	    }
		
        // read body
		body = in.readLine();
	
	    contents.add(method);
	    contents.add(route);
	    contents.add(body);
	    
	    
	    return contents;


		

		
		
	}

}
