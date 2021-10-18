import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String Username;
	private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	
	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.Username = bufferedReader.readLine();
			clientHandlers.add(this);
			broadcastMessage("Server: " + Username + " has entered the Fray! \n");
		} catch (IOException e) {
			closeAll(socket, bufferedReader, bufferedWriter);
		}	
	}
	
	@Override
	public void run() {
		String messageFromClient;
		
		while(socket.isConnected()) {
			try {
				messageFromClient = bufferedReader.readLine();
				broadcastMessage(messageFromClient);
			} catch(IOException e) {
				closeAll(socket, bufferedReader, bufferedWriter);
				break;
			}		
		}
	}
	
	public void broadcastMessage(String messageToSend) {
		
			for(ClientHandler clientHandler: clientHandlers) {
				try {	
					if(!clientHandler.Username.equals(Username)) {
						clientHandler.bufferedWriter.write(messageToSend + "\n");
						clientHandler.bufferedWriter.newLine();
						clientHandler.bufferedWriter.flush();
					}
				}catch(IOException e) {
					closeAll(socket, bufferedReader, bufferedWriter);
				}
			}
	}
	
	public void RemoveClientHandler() {
		clientHandlers.remove(this);
		broadcastMessage("Server: " + Username + " has left the chat. \n");
	}
	
	public void closeAll(Socket socket, BufferedReader bufferedreader, BufferedWriter bufferedwriter) {
		RemoveClientHandler();
		try {
			if(bufferedWriter != null) {
				bufferedWriter.close();
			}
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(socket != null) {
				socket.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}