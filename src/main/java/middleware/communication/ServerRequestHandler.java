package main.java.middleware.communication;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// Fonte: https://medium.com/collabcode/projeto-lombok-escrevendo-menos-c%C3%B3digo-em-java-8fc87b379209

/*
 * Gerenciador de conexões e threads.
 * Recebe as mensagens da rede.
 * Envia as mensagens para o INVOKER.
 */
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ServerRequestHandler {

    private final int MAX_THREAD_NUMBER = Runtime.getRuntime().availableProcessors() / 2;
    private int SERVER_PORT = 7080;
    
    public ServerRequestHandler(int port) {
		this.SERVER_PORT = port;
	}


	/*
     * Aguarda conexões e cria uma thread para cada conexão.
     */
    public void run() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_THREAD_NUMBER);
        try {
            System.out.println("Server Request Handler iniciando na porta " + SERVER_PORT);
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while (true){
            	System.out.println("Aguardando por requisições de clientes...");
                Socket remote = serverSocket.accept();
                System.out.println("Conecção realizada!");
                executor.execute(new ServerHandler(remote));
                //System.out.println("\nDEBUG: método run() da classe ServerRequestHandler.");
            }
        } catch (IOException e) {
        	System.out.println("ERRO: problemas ao iniciar o Server Request Handler!");
        	e.printStackTrace();
        }
    }
	
    
    /*
     * Cria uma thread para cada conexão recebida para
     * instanciar o INVOKER para ter acesso ao recurso. 
     */
    @AllArgsConstructor
    private static class ServerHandler implements Runnable {
    	
        private Socket socket = new Socket();	// private final Socket ??
        private final Marshaller marshaller = new Marshaller();
        
        public ServerHandler(Socket remote) {
			this.socket = remote;
		}
        
		@Override
        public void run(){  
			
            try {
            	ArrayList<String> campos = new ArrayList();
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				ArrayList<String> resposta = new ArrayList<String>();

				
				
				Marshaller ml = new Marshaller();
				
				campos = ml.unmarshall(in);
				
				System.out.println("\n");
				System.out.println("Metodo: "+ campos.get(0));
				System.out.println("Rota: "+ campos.get(1));
				System.out.println("Body: "+ campos.get(2));


					
				
				Invoker invok = new Invoker();
				
				// campos é um request
				// resposta é uma String/response
				resposta = invok.invokar(campos);
				

				
				String httpResponse = marshaller.marshall(resposta);
				
				System.out.println(httpResponse);
                out.write(httpResponse);
                
                out.close();
                in.close();
                socket.close();
					
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
            
    }
	
}
