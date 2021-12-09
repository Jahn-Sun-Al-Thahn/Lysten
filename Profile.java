import java.util.*;
import java.awt.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class Profile extends JPanel {
	//Class Variables
	private String Username;
	private String Password;
	private String url;
	private String Describe;
	private static String profilePicture = "C://Users//Althon Johnson//Pictures//Saved Pictures//Background Images//Sun Wukong";
	private ArrayList<String> userImages;
	private ArrayList<File> audioSaves;
	private ArrayList<Profile> Blocked;
	private ArrayList<Profile> FriendsList;
	private ArrayList<Server> favoriteChats;
	private ArrayList<Server> privateMessages;
	private ArrayList<Server> favoriteForums;
	
	
	//Metadata
	private String dateJoined;
	private String lastActive;
	private int totalPosts;
	private int totalForumsCreated;
	private int totalDirectChats;
	private int upVotes;
	private int downVotes;
	
	//GUI Items
	JLabel UsernameButton;
	ImageIcon userPhotoIcon;
	JButton Friends;
	JButton Photos;
	JButton DMs;
	JFormattedTextField Description;
	JButton AudioSaves;
	JButton favChatsButton;
	JButton favForumsButton;
	JLabel favorites;
	

	public Profile() {
		super();
		this.dateJoined = "" + LocalDate.now();
		this.lastActive = "";
		this.totalPosts = 0;
		this.totalForumsCreated = 0;
		this.totalDirectChats = 0;
		this.upVotes = 0;
		this.downVotes = 0;
		this.userImages = null;
		
		this.setBounds(0, 0, 545,643);
		this.setVisible(true);
		this.setLayout(new GridLayout(9,1));
		this.setBackground(Color.gray);
		
		UsernameButton = new JLabel(Username);
		UsernameButton.setSize(45,30);
		UsernameButton.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		UsernameButton.setText(Username);
		UsernameButton.setAlignmentX(LEFT_ALIGNMENT);
		
		userPhotoIcon = new ImageIcon();
		
		Friends = new JButton("FriendsList");
		Friends.setSize(45,30);
		Friends.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		Photos = new JButton("Photos");
		Photos.setSize(45,30);
		Photos.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		DMs = new JButton("Messages");
		DMs.setSize(45,30);
		DMs.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		Description = new JFormattedTextField();
		
		AudioSaves = new JButton("Saved Audio");
		AudioSaves.setSize(45,30);
		AudioSaves.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		favChatsButton = new JButton("Favorite Chats");
		favChatsButton.setSize(45,30);
		favChatsButton.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		favForumsButton = new JButton("Favorite Forums");
		favForumsButton.setSize(45,30);
		favForumsButton.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		favorites = new JLabel();
		favorites.setSize(45,30);
		favorites.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		this.add(UsernameButton);
		
		//this.add(userPhotoIcon.getImage()); Figure out how to make Image show.
		GridLayout MenuButtonBars = new GridLayout(1,3);
		GridLayout GridVisSA = new GridLayout(2,8);
		GridLayout GridVisFM = new GridLayout(1,3);
		GridLayout GridVisCH = new GridLayout(1,3);
		
		JPanel GridMB = new JPanel();
		GridMB.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		GridMB.setSize(535,40);
		GridMB.setLayout(MenuButtonBars);
		GridMB.add(Friends);
		GridMB.add(Photos);
		GridMB.add(DMs);
		GridMB.setVisible(true);
		this.add(GridMB);
		this.add(Description);
		
		JPanel GridSA = new JPanel();
		GridSA.setLayout(GridVisSA);
		GridSA.setVisible(true);
		GridSA.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		GridSA.setSize(535,40);
		this.add(GridSA);
		
		JPanel GridFM = new JPanel();
		GridFM.setLayout(GridVisFM);
		GridFM.setVisible(true);
		GridFM.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		GridFM.setSize(535,40);
		
		JPanel GridCH = new JPanel();
		GridCH.setLayout(GridVisCH);
		GridCH.setVisible(true);
		GridCH.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		GridCH.setSize(535,40);
		
		GridMB.add(Friends);
		GridMB.add(Photos);
		GridMB.add(DMs);
		this.add(Description);
		this.add(AudioSaves);
		this.add(GridSA);
		this.add(favorites);
		this.add(favForumsButton);
		this.add(GridFM);
		this.add(favChatsButton);
		this.add(GridCH);

		
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

	public static String getProfilePicture() {
		return profilePicture;
	}

	public static void setProfilePicture(String profile) {
		profilePicture = profile;
	}

	public File getAudioSaves() {
		Scanner input = new Scanner(System.in);
		int ch;
		System.out.println("Which audio Save would you like to choose?");
		for (int i = 0; i < audioSaves.size(); i++) {
			System.out.println("Save #" + i + ": " + audioSaves.get(i));
		}
		ch = input.nextInt();
		input.close();
		return audioSaves.get(ch);
	}

	public void getBlocked() {
		for (int i = 0; i < Blocked.size(); i++) {
			System.out.println(Username + " has blocked the following Users: ");
			System.out.println(Blocked.get(i));
		}

	}

	public Profile getFriendsList() {
		Scanner input = new Scanner(System.in);
		int ch;
		System.out.println("Which Friend would you like to choose?");
		for (int i = 0; i < FriendsList.size(); i++) {
			System.out.println("Save #" + i + ": " + FriendsList.get(i));
		}
		ch = input.nextInt();
		input.close();
		return FriendsList.get(ch);
	}

	public Server getFavoriteChats() {
		Scanner input = new Scanner(System.in);
		int ch;
		System.out.println("Which Favorite Chat would you like to choose?");
		for (int i = 0; i < favoriteChats.size(); i++) {
			System.out.println("Save #" + i + ": " + favoriteChats.get(i));
		}
		ch = input.nextInt();
		input.close();
		return favoriteChats.get(ch);

	}

	public Server getPrivateMessages() {
		int i;
		Scanner input = new Scanner(System.in);
		System.out.println("Which Private Chat would you like to choose?");
		for (int p = 0; p < privateMessages.size(); p++) {
			System.out.println("Save #" + p + ": " + privateMessages.get(p));
		}
		i = input.nextInt();
		input.close();
		return privateMessages.get(i);
	}

	public Server getFavoriteForums() {
		int p;
		Scanner input = new Scanner(System.in);
		System.out.println("Which Favorite Forum would you like to choose?");
		for(int i = 0; i < favoriteForums.size(); i++) {
			System.out.println("Save #" + i + ": " + favoriteForums.get(i));
		}
		p = input.nextInt();
		input.close();
		return favoriteForums.get(p);
	}

	// Complete the body of the List Methods.
	public void AddToForumList(Server favForums) {
		favoriteForums.add(favForums);
		
	}

	public void AddToPMList(Server privMessages) {
		privateMessages.add(privMessages);
	}

	public void AddToChatList(Server favChats) {
		favoriteChats.add(favChats);
	}

	public void AddToFriendsList(Profile fList) {
		FriendsList.add(fList);
	}

	public void AddToBlockedList(Profile blockThis) {
		Blocked.add(blockThis);
	}

	public void AddToAudioList(File audSaves) {
		audioSaves.add(audSaves);
	}

	public void RemoveFromForumList(int favForums) {
		favoriteForums.remove(favForums);
	}

	public void RemoveFromPMList(int privMessages) {
		privateMessages.remove(privMessages);
	}

	public void RemoveFromChatList(int favChats) {
		favoriteChats.remove(favChats);
	}

	public void RemoveFromFriendsList(int fList) {
		FriendsList.remove(fList);
	}

	public void RemoveFromBlockedList(int blocked) {
		Blocked.remove(blocked);
	}

	public void RemoveFromAudioList(int audioSaves) {
		AudioSaves.remove(audioSaves);
	}

	public ArrayList<String> getUserImages() {
		return userImages;
	}

	public void setUserImages(String userImages) {
		this.userImages.add(userImages);
	}

	public String getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getLastActive() {
		return lastActive;
	}

	public void setLastActive(String lastActive) {
		this.lastActive = lastActive;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}

	public int getTotalForumsCreated() {
		return totalForumsCreated;
	}

	public void setTotalForumsCreated(int totalForumsCreated) {
		this.totalForumsCreated = totalForumsCreated;
	}

	public int getTotalDirectChats() {
		return totalDirectChats;
	}

	public void setTotalDirectChats(int totalDirectChats) {
		this.totalDirectChats = totalDirectChats;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}

	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}


	public static void main(String[] args) {
		Profile Test = new Profile();
	}
}