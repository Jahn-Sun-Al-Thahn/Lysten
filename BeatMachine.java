import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class BeatMachine extends JFrame {
	private JPanel North;
	private JPanel Center;
	private Dimension largeSQ;
	private Dimension medSQ;
	private Dimension smallSQ;
	private ArrayList<Pad> AllPads;
	public BeatMachine() {
		/* Creates BeatMachine GUI.
		 * 
		 */
		
		setBounds(180,80,1200,700);
		setVisible(true);
		setTitle("Beat Machine");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		largeSQ = new Dimension(1190,690);
		medSQ = new Dimension(1190,130);
		smallSQ = new Dimension(50,50);
		
		//Created Panels
		North = new JPanel();
		North.setLayout(new GridLayout(1,6));
		North.setBackground(Color.gray);
		North.setSize(medSQ);
		North.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		Center = new JPanel();
		Center.setLayout(new GridLayout(3,6));
		Center.setBackground(Color.lightGray);
		Center.setSize(largeSQ);
		Center.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		JMenuBar MenuBar = new JMenuBar();
		JMenu FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		MenuBar.add(FileMenu);
		
		JMenuItem New = new JMenuItem("New");
		FileMenu.add(New);
		JMenuItem Open = new JMenuItem("Open");
		FileMenu.add(Open);
		JMenuItem Save = new JMenuItem("Save");
		FileMenu.add(Save);
		setJMenuBar(MenuBar);
		
		
		/*Create Buttons,
		Fill Array list with Pads(buttons) so that they can be used to apply audio clips to.*/
		AllPads = new ArrayList<>();
		
		for(int i = 0; i < 18; i++) {
			AllPads.add(new Pad());
			Center.add(AllPads.get(i));
		}
	
		//Added Panels to Window
		add(North, BorderLayout.NORTH);
		add(Center, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		BeatMachine test = new BeatMachine();
	}
}
	