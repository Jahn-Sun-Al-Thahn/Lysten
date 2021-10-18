import java.util.ArrayList;
import java.io.File;
import java.time.*;

public class UserActivity {

	private String dateJoined;
	private String lastActive;
	private int totalPosts;
	private int totalForumsCreated;
	private int totalDirectChats;
	private int upVotes;
	private int downVotes;
	private ArrayList<String> userImages;
	
	public UserActivity() {
		this.dateJoined = "" + LocalDate.now();
		this.lastActive = "";
		this.totalPosts = 0;
		this.totalForumsCreated = 0;
		this.totalDirectChats = 0;
		this.upVotes = 0;
		this.downVotes = 0;
		this.userImages = null;
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

	public ArrayList<String> getUserImages() {
		return userImages;
	}
	
	//Complete the body of the list methods.
	public void AddToImageList(ArrayList<String> userimages) {
		
	}
	
	public void RemoveFromImageList(ArrayList<String> userimages) {
		
	}
	
	public void TraverseImageList(ArrayList<String> userimages) {
		
	}

}
