package main.java.middleware.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

public class Marshaller {
	
	
	// return a String given a array listh with elements [código HTTP,  mensagem HTTP, conteúdo]
	public String marshall(ArrayList<String> resposta) throws IOException {
		
        StringBuilder httpResponse = new StringBuilder();
        httpResponse.append("HTTP/1.1 "+resposta.get(0)+" "+resposta.get(1));
        httpResponse.append("\r\nServer: Finnance\r\nContent-Type: application/json; charset=iso=8859=1\r\nContent-Length:"+resposta.get(2).getBytes().length);
        httpResponse.append("\r\n\r\n");
        httpResponse.append(resposta.get(2));
        
       return httpResponse.toString();
        
        
		//ArrayList<String> contents = new ArrayList<String>();
		
		
	}
	
	
	// return a string array list with [method, route and body]
	public ArrayList<String> unmarshall(BufferedReader in) throws IOException {
		String method = "";
		String route = "";
		String body;
		JSONObject jbody;
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
