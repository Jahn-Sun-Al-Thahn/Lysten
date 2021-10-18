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


	public ArrayList<File> getAudioSaves() {
		return audioSaves;
	}


	public ArrayList<Profile> getBlocked() {
		return Blocked;
	}


	public ArrayList<Profile> getFriendsList() {
		return FriendsList;
	}


	public ArrayList<Server> getFavoriteChats() {
		return favoriteChats;
	}


	public ArrayList<Server> getPrivateMessages() {
		return privateMessages;
	}


	public ArrayList<Server> getFavoriteForums() {
		return favoriteForums;
	}

	//Complete the body of the List Methods.
	public void AddToForumList(ArrayList<Server> favoriteForums) {
	
	}
	
	public void AddToPMList(ArrayList<Server> privateMessages) {
		
	}
	
	public void AddToChatList(ArrayList<Server> favoriteChats) {
		
	}
	
	public void AddToFriendsList(ArrayList<Profile> friendsList) {
		
	}
	
	public void AddToBlockedList(ArrayList<Profile> blocked) {
		
	}
	
	public void AddToAudioList(ArrayList<File> audioSaves) {
		
	}
	
	public void RemoveFromForumList(ArrayList<Server> favoriteForums) {
		
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