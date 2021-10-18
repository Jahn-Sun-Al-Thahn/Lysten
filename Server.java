import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private String ServerName;
	
	public Server(ServerSocket serversocket) {
		this.serverSocket = serversocket;
	}
	
	public String getServerName() {
		return ServerName;
	}


	public void setServerName(String serverName) {
		ServerName = serverName;
	}


	public void StartServer() {
		try {
			while(!serverSocket.isClosed()){
				Socket socket = serverSocket.accept();
				System.out.println(this.getServerName() + ": has Connected a New Member to the System.");
				ClientHandler clientHandler = new ClientHandler(socket);
				Thread thread = new Thread(clientHandler);
				thread.start();				
			}	
		} catch (IOException e){
			CloseServer();
		}
		
	}
	
	public void CloseServer() {
		try {
			if(serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] arg) throws IOException{
		ServerSocket serversocket = new ServerSocket(1234);
		Server server = new Server(serversocket);
		server.StartServer();
	}
	
}