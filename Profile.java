import java.util.*;
import javax.sound.sampled.*;
import java.io.*;

public class Profile extends UserActivity{
	private String Username;
	private String Password;
	private String url;
	private String profilePicture;
	private ArrayList<File> audioSaves;
	private ArrayList<Profile> Blocked;
	private ArrayList<Profile> FriendsList;
	private ArrayList<Server> favoriteChats;
	private ArrayList<Server> privateMessages;
	private ArrayList<Server> favoriteForums;
	
	
	public Profile() {
		super();

	}

	
	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	public File getAudioSaves() {
		Scanner input = new Scanner(System.in);
		int ch;
		System.out.println("Which audio Save would you like to choose?");
		for(int i = 0; i < audioSaves.size(); i++) {
			System.out.println("Save #" + i + ": " + audioSaves.get(i));
		}
		ch = input.nextInt();
		input.close();
		return audioSaves.get(ch);
	}


	public void getBlocked() {
		for(int i = 0; i < Blocked.size(); i++) {
			System.out.println(Username + " has blocked the following Users: ");
			System.out.println(Blocked.get(i));
		}
		
	}


	public Profile getFriendsList() {
		Scanner input = new Scanner(System.in);
		int ch;
		System.out.println("Which Friend would you like to choose?");
		for(int i = 0; i < FriendsList.size(); i++) {
			System.out.println("Save #" + i + ": " + FriendsList.get(i));
		}
		ch = input.nextInt();
		input.close();
		return FriendsList.get(ch);
	}


	public Server getFavoriteChats() {
		
		//use the get friends list body and substitute the array list name
		
		return favoriteChats;
	}


	public Server getPrivateMessages() {
		//use the get friends list body and substitute the array list name
		return privateMessages;
	}


	public Server getFavoriteForums() {
		//use the get friends list body and substitute the array list name
		return favoriteForums;
	}

	//Complete the body of the List Methods.
	public void AddToForumList(Server favoriteForums) {
		//use the arraylist.add() method to add another server to the arraylist
	}
	
	public void AddToPMList(Server privateMessages) {
		//use the arraylist.add() method to add another server to the arraylist
	}
	
	public void AddToChatList(Server favoriteChats) {
		//use the arraylist.add() method to add another server to the arraylist
	}
	
	public void AddToFriendsList(ArrayList<Profile> friendsList) {
		//use the arraylist.add() method to add another server to the arraylist
	}
	
	public void AddToBlockedList(ArrayList<Profile> blocked) {
		//use the arraylist.add() method to add another server to the arraylist
	}
	
	public void AddToAudioList(ArrayList<File> audioSaves) {
		//use the arraylist.add() method to add another server to the arraylist
	}
	
	public void RemoveFromForumList(ArrayList<Server> favoriteForums) {
		//use the arraylist.remove() method to add another server to the arraylist
	}
	
	public void RemoveFromPMList(ArrayList<Server> privateMessages) {
		
	}
	
	public void RemoveFromChatList(ArrayList<Server> favoriteChats) {
		
	}
	
	public void RemoveFromFriendsList(ArrayList<Profile> friendsList) {
		
	}
	
	public void RemoveFromBlockedList(ArrayList<Profile> blocked) {
		
	}
	
	public void RemoveFromAudioList(ArrayList<File> audioSaves) {
		
	}
	
	public void TraverseForumList(ArrayList<Server> favoriteForums) {
		
	}
	
	public void TraversePMList(ArrayList<Server> privateMessages) {
		
	}
	
	public void TraverseChatList(ArrayList<Server> favoriteChats) {
		
	}
	
	public void TraverseFriendsList(ArrayList<Profile> friendsList) {
		
	}
	
	public void TraverseBlockedList(ArrayList<Profile> blocked) {
		
	}
	
	public void TraverseAudioList(ArrayList<File> audioSaves) {
		
	}
	
}