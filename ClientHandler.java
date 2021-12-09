import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ClientHandler implements Runnable {
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private JPanel msgPanel;
	private String User;
	private String RoomName;
	private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	
	public ClientHandler(Socket socket, String username, String roomname, JPanel MsgPanel) {
		clientHandlers.add(this);
		this.User = username;
		try {
			this.RoomName = roomname;
			this.msgPanel = MsgPanel;
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			TextMessage Joined = new TextMessage(User + " has Joined " + RoomName);
			broadcastMessage(Joined);
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
					if(!clientHandlers.contains(this)) {
						TextMessage sendOut = new TextMessage(messageToSend);
						msgPanel.add(sendOut);
						msgPanel.updateUI();
						clientHandler.bufferedWriter.write(messageToSend + "\n");
						clientHandler.bufferedWriter.newLine();
						clientHandler.bufferedWriter.flush();
					}
				}catch(IOException e) {
					closeAll(socket, bufferedReader, bufferedWriter);
				}
			}
	}
	
	public void broadcastMessage(TextMessage textable) {
		
		for(ClientHandler clientHandler: clientHandlers) {
			try {	
					clientHandler.msgPanel.add(textable);
					clientHandler.msgPanel.updateUI();
					clientHandler.bufferedWriter.write(textable.getMessage().getText());
					clientHandler.bufferedWriter.newLine();
					clientHandler.bufferedWriter.flush();
			}catch(IOException e) {
				closeAll(socket, bufferedReader, bufferedWriter);
			}
		}
}
	
	public void RemoveClientHandler() {
		clientHandlers.remove(this);
		broadcastMessage(new TextMessage(User + " has left the chat. \n"));
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