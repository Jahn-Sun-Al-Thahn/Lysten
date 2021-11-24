import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class TextMessage extends JPanel{
	private static int msgCounter = 0;
	private static Vector<TextMessage> MsgLog = new Vector<>();
	private Calendar time;
	private ImageIcon profileImage;
	private JTextArea message;
	private JPanel North;
	private JPanel South;
	private JPanel East;
	private JPanel West;
	private JPanel Center;
	private Font font;
	
	public TextMessage(String MSG){
		Rectangle Bounds = new Rectangle(10,10, 500, 200);
		this.setBounds(Bounds);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createSoftBevelBorder(300));
		
		North = new JPanel();
		this.add(North, BorderLayout.NORTH);
		South = new JPanel();
		this.add(South, BorderLayout.SOUTH);
		East = new JPanel();
		this.add(East, BorderLayout.EAST);
		West = new JPanel();
		this.add(West, BorderLayout.WEST);
		Center = new JPanel();
		this.add(Center, BorderLayout.CENTER);
		
		/*Time in the North, message in the center, user image in the east or in the west depending on message order,
			Likes, Read notification, and read time stamp in South.
		*/
		//CENTER....Set Message, position and message
		
		message = new JTextArea();
		//message.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		message.setText(MSG);
		message.setBackground(null);
		font = new Font(Font.SANS_SERIF, 15, Font.PLAIN);
		addCounter();
		Center.add(message);
		
		//NORTH...Set Time, position, and result
		time = Calendar.getInstance();
		Date timeStr = time.getTime();
		JLabel TimeStamp = new JLabel();
		TimeStamp.setVerticalTextPosition(JLabel.CENTER);
		TimeStamp.setHorizontalTextPosition(JLabel.CENTER);	
		TimeStamp.setText(timeStr.toString());
		North.add(TimeStamp);
		
		//EAST OR WEST ...set User Profile Image, and position depending on msgCounter
		profileImage = new ImageIcon(Profile.getProfilePicture());
		this.ProfileImagePosition(West,East);
		
		//SOUTH...set Likes number, read notification, and Read time stamp
		South.setLayout(new FlowLayout());
		JButton like = new JButton("Likes");
		JButton dislike = new JButton("DisLike");
		JLabel beenRead = new JLabel("Read: " + timeStr.toString());
		//Add Icons to the South Bar
		Icon likes = new ImageIcon();
		Icon dislikes = new ImageIcon();
		Icon beeRead = new ImageIcon();
		//Add ABOVE Icons to South Bar
		beenRead.setVisible(true);
		South.add(like);
		South.add(dislike);
		South.add(beenRead);
		South.add(beenRead);
		
		MsgLog.add(this);
	}
	
	public static void addCounter() {
		msgCounter++;
	}
	
	public static void removeCounter() {
		msgCounter--;
	}
	
	public boolean isMSGCounterEven() {
		if(msgCounter % 2 == 0) {
			return true;
		}else {
			return false;
		}		
	}
	
	public boolean isWest() {
		//0 = West and 1 = East
		if(msgCounter % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void TextAreaPosition(JTextArea text) {
		
		if(isMSGCounterEven()) {
		//Move JTextField Components alignment to the Right.
			message.setAlignmentX(LEFT_ALIGNMENT);
		}else {
			message.setAlignmentX(RIGHT_ALIGNMENT);
		}
	}
	
	public void ProfileImagePosition(JPanel west, JPanel east){
		if(this.isWest()){
			west.add(new JLabel("Profile Name", this.profileImage, JLabel.CENTER));
		}else {
			east.add(new JLabel("Profile Name", this.profileImage, JLabel.CENTER));
			//east.add(profileImage);
		}
	}
	
	public void changeFont(int Size, int type ) {
		this.font.deriveFont(Size);
		this.font.deriveFont(type);

	}
	
	public void setProfileImage(String imageFile) {
		this.profileImage = new ImageIcon(imageFile);
	}
	
	public static void clearTextArea(JFormattedTextField text){
			try{
				text.commitEdit();
			}catch(ParseException PE) {
				JDialog UnCommited = new JDialog();
				UnCommited.setTitle("Text Not Committed");
			}
			text.setText("");
		
	}
	
	public class MsgListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		new TextMessage("This tis what the text would look like?");
	}
}

