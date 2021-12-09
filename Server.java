import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Server {
	private ServerSocket serverSocket;
	private String ServerName;
	private int counter = 0;
	
	public Server(JPanel MsgPanel, ArrayList<TextMessage> Msgs, String username , String roomname) throws IOException {
		this.ServerName = roomname;
		serverSocket = new ServerSocket(1235);
		System.out.println("Made ServerSocket");
		StartServer(MsgPanel, Msgs, username, roomname);
		System.out.println("End of Server Constructor");
	}
	
	public String getServerName() {
		return ServerName;
	}


	public void setServerName(String serverName) {
		ServerName = serverName;
	}

	public void setServerSocket(ServerSocket serversocket){
		this.serverSocket = serversocket;
	}
	
	public void StartServer(JPanel MsgPanel, ArrayList<TextMessage> Msgs, String username, String roomname) {
		try {
			while(!serverSocket.isClosed()){
				System.out.println("inside startserver in loop" + counter++);
				serverSocket.setSoTimeout(0);
				//Not Sure why the serversocket.accept() isn't connecting to any other sockets.
				Socket socket = serverSocket.accept();
				System.out.println("after socket");
				ClientHandler clientHandler = new ClientHandler(socket, username ,roomname, MsgPanel );
				System.out.println("after clienthandler");
				JoinedServer(MsgPanel, Msgs);
				Thread thread = new Thread(clientHandler);
				thread.start();				
			}	
		}catch (SocketTimeoutException STOE) {
			CloseServer();
			STOE.printStackTrace();
		}catch (IOException e){
			CloseServer();
			e.printStackTrace();
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
	
	public void JoinedServer(JPanel MsgPanel, ArrayList<TextMessage> Msgs) {
		TextMessage newUser = new TextMessage(this.getServerName() + ": has Connected a New Member to the Chat.");
		MsgPanel.add(newUser);
		MsgPanel.setFocusable(true);
		MsgPanel.updateUI();
		Msgs.add(newUser);
	}
}