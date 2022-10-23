package main.java.middleware.communication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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
                //executor.execute(new ServerHandler(remote));
                System.out.println("\nDEBUG: método run() da classe ServerRequestHandler.");
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
    	
        private final Socket socket;
        private final Marshaller marshaller = new Marshaller();
        
        @Override
        public void run() {        	
        	//        	
        }
        
        // Recupera e executa os comandos recebidos dos cliente.
        private ResponseMessage handleRequest(InternMessage internMessage){
            try {
            	Invoker inv = new Invoker();
                return inv.invokeRemoteObject(internMessage);
            } catch (Exception e) {
            	System.out.println("Erro ao recuperar dados do pacote recebido!");
				//JSONObject response = new JSONObject();
				//response.append("Error: ", "There was an error receiving the package.");
				//return new ResponseMessage("500", "Internal Server Error", response.toString());
				e.getStackTrace();
			}
        }        
    }
	
}
