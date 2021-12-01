import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneLayout;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.sound.sampled.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

public class Template {

	private JFrame frame;
	private JPanel title;
	private JPanel WestMenu;
	private JPanel EastMenu;
	private JPanel CenterPanel;
	private JPanel CenterSouthPanel;
	private JPanel navigator;
	private JPanel MsgPanel;
	private JPanel CPanel;
	private JScrollPane scrollPane;
	private GridLayout TextMsgGrid;
	private GridLayout WestSideMenu;
	private GridLayout EastSideMenu;
	private MidiInstrument keys;
	private JFormattedTextField formattedTextField;
	private ArrayList<TextMessage> msgs = new ArrayList<>();
	private Profile User = new Profile();
	private Search UserSearch = new Search();
	private MainFeed Feed = new MainFeed();
	private Forum Forum = new Forum();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Template window = new Template();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Template() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.setBounds(20, 20, 535, 800);
		frame.setTitle("Lysten");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		title = new JPanel();
		title.setLayout(new BorderLayout());
		title.setBackground(new Color(0, 128, 0));
		title.setLocation(5, 5);
		title.setBorder(BorderFactory.createEtchedBorder(Color.gray, Color.BLACK));
		frame.getContentPane().add(title, BorderLayout.NORTH);

		JButton sideBar = new JButton("*");
		sideBar.setSize(20, 20);
		sideBar.addActionListener(new ToggleVisibleMenuListeners());
		title.add(sideBar, BorderLayout.WEST);
		
		JButton rightSideBar = new JButton("*");
		rightSideBar.setSize(50,30);
		rightSideBar.addActionListener(new ToggleVisibleMenuListener());
		title.add(rightSideBar, BorderLayout.EAST);
		
		

		JLabel lblNewLabel = new JLabel("Current Chat");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(245, 245, 245));
		title.add(lblNewLabel);

		CenterSouthPanel = new JPanel();
		CenterSouthPanel.setLayout(new GridLayout(2, 0));
		frame.getContentPane().add(CenterSouthPanel, BorderLayout.SOUTH);

		navigator = new JPanel();
		navigator.setBackground(new Color(0, 128, 0));
		navigator.setBorder(BorderFactory.createEtchedBorder());
		navigator.setLayout(new GridLayout(0, 5, 0, 0));
		CenterSouthPanel.add(navigator);

		JButton btnNewButton_4 = new JButton("Profile");
		btnNewButton_4.addActionListener(new ProfileListener());
		navigator.add(btnNewButton_4);
		JButton btnNewButton_3 = new JButton("Chats");
		btnNewButton_3.addActionListener(null);
		navigator.add(btnNewButton_3);
		JButton btnNewButton_2 = new JButton("Main Feed");
		//btnNewButton_2.addActionListener(Feed);
		navigator.add(btnNewButton_2);
		JButton btnNewButton = new JButton("Forums");
		//btnNewButton.addActionListener(Forum);
		navigator.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Search");
		//btnNewButton_1.addActionListener(UserSearch);
		navigator.add(btnNewButton_1);

		CPanel = new JPanel();
		CPanel.setLayout(new FlowLayout());
		CPanel.setBounds(0, 0, 535,643);
		frame.add(CPanel, BorderLayout.CENTER);
		
		CenterPanel = new JPanel();
		CenterPanel.setPreferredSize(new Dimension(CPanel.getWidth(), 300));
		CenterPanel.setOpaque(true);
		CenterPanel.setVisible(false);
		CenterPanel.setBackground(Color.gray);
		CenterPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0)));
		
		
		TextMsgGrid = new GridLayout(100, 1);
		MsgPanel = new JPanel(TextMsgGrid);
		MsgPanel.setSize(520, 643);
		MsgPanel.setBorder(BorderFactory.createLineBorder(Color.green));
		MsgPanel.setVisible(true);
		
		scrollPane = new JScrollPane(MsgPanel);
		scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setPreferredSize(new Dimension(520, 643));
		scrollPane.setOpaque(true);
		scrollPane.setVisible(true);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setViewportView(MsgPanel);
		scrollPane.getVerticalScrollBar().setValue(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//vbarPolicyProperty().setValue(scrollPane.ScrollBarPolicy.NEVER);
		scrollPane.updateUI();
		CPanel.add(scrollPane);
		
		
		keys = new MidiInstrument();
		keys.setSize(519, 185);
		keys.setLocation(0,0);
		keys.setOpaque(true);
		keys.setVisible(false);
		//CPanel.add(keys, BorderLayout.SOUTH);
		CenterPanel.add(keys);

		formattedTextField = new JFormattedTextField();
		formattedTextField.setSize(300, 25);
		formattedTextField.setHorizontalAlignment(SwingConstants.LEFT);
		formattedTextField.setColumns(30);
		formattedTextField.setFont(new Font("Liberation Sans", Font.PLAIN, 12));
		formattedTextField.addActionListener(new TextListener());
		formattedTextField.addKeyListener(new TextListener());
		
		JButton Send = new JButton("Send");
		Send.setSize(70, 22);
		Send.addActionListener(new TextListener());

		JButton InstrumentCall = new JButton("Keys");
		InstrumentCall.addActionListener(new MidiToggleListener());

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		textPanel.setBorder(BorderFactory.createEtchedBorder());
		textPanel.setBackground(new Color(0, 128, 0));
		textPanel.setOpaque(true);
		textPanel.add(Send);
		textPanel.add(formattedTextField);
		textPanel.add(InstrumentCall);

		CenterSouthPanel.add(textPanel);
		CenterSouthPanel.add(navigator);

		WestMenu = new JPanel();
		WestSideMenu = new GridLayout(8, 1);
		WestMenu.setLayout(WestSideMenu);
		WestMenu.setBorder(BorderFactory.createEtchedBorder());
		JButton Recommend = new JButton("Recommended");
		JButton Favorites = new JButton("Favorites");
		JButton Popular = new JButton("Popular");
		JButton Add = new JButton("Add");

		Popular.setBounds(new Rectangle(10, 10));
		Popular.setBackground(Color.green);
		Popular.setBorder(BorderFactory.createRaisedBevelBorder());
		Popular.addActionListener(null);

		Recommend.setBounds(new Rectangle(10, 10));
		Recommend.setBackground(Color.green);
		Recommend.setBorder(BorderFactory.createRaisedBevelBorder());
		Recommend.addActionListener(null);

		Favorites.setBounds(new Rectangle(10, 10));
		Favorites.setBackground(Color.green);
		Favorites.setBorder(BorderFactory.createRaisedBevelBorder());
		Favorites.addActionListener(null);

		Add.setBounds(new Rectangle(10, 10));
		Add.setBackground(Color.green);
		Add.setBorder(BorderFactory.createRaisedBevelBorder());
		Add.addActionListener(new AddMenuItemListener());

		WestMenu.add(Add);
		WestMenu.add(Popular);
		WestMenu.add(Recommend);
		WestMenu.add(Favorites);
		

		frame.getContentPane().add(WestMenu, BorderLayout.WEST);
		WestMenu.setVisible(false);
		if (WestMenu.isVisible()) {
			formattedTextField.setSize(formattedTextField.getWidth() - 90, formattedTextField.getHeight());
		}

		EastMenu = new JPanel();
		EastSideMenu = new GridLayout(8, 1);
		EastMenu.setLayout(EastSideMenu);
		EastMenu.setBorder(BorderFactory.createEtchedBorder());
		
		JButton More = new JButton("Add Chat");
		More.setBounds(new Rectangle(0, 0, 40, 10));
		More.setBackground(Color.green);
		More.setBorder(BorderFactory.createRaisedBevelBorder());
		More.addActionListener(new AddRightMenuItemListener());
		EastMenu.add(More);
		
		frame.getContentPane().add(EastMenu, BorderLayout.EAST);
		EastMenu.setVisible(false);
		if (EastMenu.isVisible()) {
			formattedTextField.setSize(formattedTextField.getWidth() - 90, formattedTextField.getHeight());
		}
		
		

	}
	
	public void clearTextArea() throws ParseException{
		formattedTextField.commitEdit();
		formattedTextField.setText("");
	}

	public class ToggleVisibleMenuListeners implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (WestMenu.isVisible() == true) {
				WestMenu.setVisible(false);
			} else if (WestMenu.isVisible() == false) {
				WestMenu.setVisible(true);
			}
		}

	}
	public class ToggleVisibleMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (EastMenu.isVisible() == true) {
				EastMenu.setVisible(false);
			} else if (EastMenu.isVisible() == false) {
				EastMenu.setVisible(true);
			}
		}

	}

	public class SendListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	public class MidiToggleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (keys.isVisible() == true) {
				keys.setVisible(false);
				keys.getKeySoundsElement(0).close();
			} else if (keys.isVisible() == false) {
				keys.setVisible(true);
				try {
					if(keys.getKeySoundsElement(0).isOpen() == false) {
						keys.getKeySoundsElement(0).open(keys.getAudStream());
					}
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	public class AddMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton Adding = new JButton("New Item");
			Adding.setBounds(new Rectangle(15, 15));
			Adding.setBackground(Color.green);
			Adding.setBorder(BorderFactory.createRaisedBevelBorder());
			Adding.setVisible(true);
			Adding.addActionListener(null);
			WestMenu.add(Adding);
			WestMenu.updateUI();
		}

	}
	
	public class AddRightMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton Adding = new JButton("New ChatRoom");
			JDialog Room = new JDialog();
			Room.setTitle("New Chat");
			Adding.setBounds(new Rectangle(30, 15));
			Adding.setBackground(Color.green);
			Adding.setBorder(BorderFactory.createRaisedBevelBorder());
			Adding.setVisible(true);
			Adding.addActionListener(null);
			EastMenu.add(Adding);
			EastMenu.updateUI();

		}

	}
	
	public class TextListener implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int indents = formattedTextField.getText().length() / 35;
			String editedMsg = formattedTextField.getText().indent(indents);
			TextMessage text = new TextMessage(editedMsg);
			MsgPanel.add(text);
			MsgPanel.setFocusable(true);
			MsgPanel.updateUI();
			TextMessage.clearTextArea(formattedTextField);
			msgs.add(text);
			scrollPane.updateUI();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.isShiftDown() == true && e.getKeyCode() == KeyEvent.VK_ENTER) {
				String oldText = formattedTextField.getText();
				formattedTextField.setText(oldText + "\n");
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		
		}
	}
	
	public class ProfileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
}
