import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JPanel;


public class Client {
	Socket socket;
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;
	String Username;
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public Client(String username, JPanel MsgPanel, String InputMessage) throws UnknownHostException, IOException {
		try {
			this.Username = username;
			this.socket = new Socket("localhost", 1235);
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException e) {
			closeAll(socket, bufferedReader, bufferedWriter);
		}

	}
	
	public void SendMessage(JPanel MsgPanel, String InputMessage) {
		try {
			while(socket.isConnected()) {
				/*There is some kind of loop that keeps happening 
				 * and never prints out the message onto the msgPanel
				 */
				System.out.println("Before textmsg");
				TextMessage text = new TextMessage(InputMessage);
				MsgPanel.add(text);
				System.out.println("after textMessage before bufferwriter");
				bufferedWriter.write(InputMessage);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				System.out.println("after buff writers");
			}
		}catch(IOException e) {
			closeAll(socket, bufferedReader, bufferedWriter );
		}
	}
	
	public void ListenForMessage(JPanel MsgPanel) {
		new Thread(new Runnable() {
			@Override
			public void run(){
				String msgFromGroupChat;
				while(socket.isConnected()) {
					try {
						msgFromGroupChat = bufferedReader.readLine();
						TextMessage newMessage = new TextMessage(msgFromGroupChat);
						MsgPanel.add(newMessage);
					}catch(IOException e) {
						closeAll(socket, bufferedReader, bufferedWriter);
					}
				} 
			}
		}).start();
	}
	
	public void closeAll(Socket socket, BufferedReader bufferedreader, BufferedWriter bufferedwriter) {
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