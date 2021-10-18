import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	Socket socket;
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;
	String Username;
	
	public Client(Socket socket, String Username) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.Username = Username;
			
		}catch(IOException e) {
			closeAll(socket, bufferedReader, bufferedWriter);
		}
	}
	
	public void SendMessage() {
		try {
			bufferedWriter.write(Username);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			Scanner InputMessage = new Scanner(System.in);
			while(socket.isConnected()) {
				String messageToSend =  InputMessage.nextLine();
				bufferedWriter.write(Username + ": " + messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			InputMessage.close();
		}catch(IOException e) {
			closeAll(socket, bufferedReader, bufferedWriter );
		}
	}
	
	public void ListenForMessage() {
		new Thread(new Runnable() {
			@Override
			public void run(){
				String msgFromGroupChat;
				while(socket.isConnected()) {
					try {
						msgFromGroupChat = bufferedReader.readLine();
						System.out.print("\n" + msgFromGroupChat);
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
	
	public static void main(String[] arg) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter username for the GroupChat: ");
		String Username = keyboard.nextLine();
		Socket socket = new Socket("localhost", 1234);
		Client client = new Client(socket, Username);
		client.ListenForMessage();
		client.SendMessage();
	}
}