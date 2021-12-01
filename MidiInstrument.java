import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MidiInstrument extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField inGoing;
	JTextField outGoing;
	Color bg;
	Color fore;
	Color whiteKeys;
	Color blackKeys;
	Font fnt;
	ArrayList<JButton> Keys;
	JButton Save;
	JButton Open;
	JButton Preset;
	JMenu SoundMiniMenu;
	Dimension Max;
	Dimension Min;
	final JFileChooser SOP = new JFileChooser();
	private AudioInputStream AudStream;
	private ArrayList<Clip> keySounds;

	public MidiInstrument() {

		// initialize fields
		bg = new Color(154, 90, 186, 1);
		fore = new Color(154, 0, 186, 1);
		whiteKeys = new Color(255, 255, 255, 1);
		blackKeys = new Color(0, 0, 0, 1);
		fnt = new Font(Font.SERIF, 4, 12);
		Max = new Dimension(520, 185);
		Min = new Dimension(Max.width, Max.height);

		// set how the JFrame looks and how the objects within it will be laid out, and
		// enabled
		setName("KeyBoard");
		requestFocus();
		setEnabled(true);
		setVisible(true);
		setBounds(0, 0, Max.width, Max.height);
		setMaximumSize(Max);
		setMinimumSize(Min);
		setFont(fnt);
		setLayout(new BorderLayout());
		/*
		 * Next Lines Not Applicable for JPanel, only JFrame setTitle("Keyboard");
		 * setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 */

		// add() can add components or JObjects to the JFrame
		// borders must be set on JPanels
		// ACTIONLISTENERS MUST BE SET AFTER IN THE panel section it belongs with

		JPanel OuterFrame = new JPanel();
		OuterFrame.setAlignmentX(CENTER_ALIGNMENT);
		OuterFrame.setAlignmentY(CENTER_ALIGNMENT);
		OuterFrame.setBorder(BorderFactory.createEtchedBorder());
		OuterFrame.setLayout(new GridLayout(1, 3));
		OuterFrame.setBackground(Color.BLACK);
		OuterFrame.setSize(Max.width / 5, (Max.height / 2));
		Save = new JButton("Save");
		Save.addActionListener(new FileChooserListener());
		Open = new JButton("Open");
		Open.addActionListener(new FileChooserListener());
		Preset = new JButton("Preset");
		Preset.addActionListener(new FileChooserListener());

		// Search Text Area, Chosen Search Result/Current SoundFile

		/*
		 * Add Midi-Control Sound Files from the Midi Sound Directory thats associated
		 * with this application. Read each file name, add each file name to the
		 * Mini-menu. So that in Listener the name that is chosen can be found and
		 * opened "read through the Clip and sent to the mixer to be manipulated".
		 */
		SoundMiniMenu = new JMenu();
		SoundMiniMenu.setBackground(Color.WHITE);
		SoundMiniMenu.setForeground(Color.GRAY);
		SoundMiniMenu.setFont(fnt);
		SoundMiniMenu.setMnemonic(KeyEvent.VK_A);
		SoundMiniMenu.setText("Choose Sound");
		JMenuItem FirstEx = new JMenuItem("Example Item");
		JMenuItem SecondEx = new JMenuItem("Example 2");
		SoundMiniMenu.insert(FirstEx, 1);
		SoundMiniMenu.addSeparator();
		SoundMiniMenu.insert(SecondEx, 2);
		SoundMiniMenu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		inGoing = new JTextField((int) (Max.width / 5));
		inGoing.setText("Search");
		inGoing.setFont(fnt);
		inGoing.setHorizontalAlignment(2);
		inGoing.setAlignmentX(CENTER_ALIGNMENT);
		inGoing.setAlignmentY(CENTER_ALIGNMENT);
		inGoing.addActionListener(null);

		OuterFrame.add(inGoing);
		OuterFrame.add(SoundMiniMenu);
		OuterFrame.add(Save);
		OuterFrame.add(Open);
		OuterFrame.add(Preset);
		add(OuterFrame, BorderLayout.NORTH);

		// Make a open panel to save and open midi-instrument files or presets
		JPanel Keyboard = new JPanel();
		Keyboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Keyboard.setBackground(Color.BLACK);
		Keyboard.setLayout(new GridLayout(1, 12));
		// Keyboard.setSize(WIDTH, HEIGHT);
		Keys = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			if (i == 1 || i == 4 || i == 6 || i == 9 || i == 11) {
				// black keys
				Keys.add(new JButton());
				Keyboard.add(Keys.get(i));
				Keys.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK));
				Keys.get(i).setBackground(Color.BLACK);
				Keys.get(i).addActionListener(new BlackKeyListener());

			} else {
				// white Keys
				Keys.add(new JButton());
				Keyboard.add(Keys.get(i));
				Keys.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK));
				Keys.get(i).setBackground(Color.white);
				Keys.get(i).addActionListener(new WhiteKeyListener());
			}

		}
		add(Keyboard, BorderLayout.CENTER);

		keySounds = new ArrayList<>();
		File defaultClip = new File(
				"C:\\Users\\Althon Johnson\\OneDrive\\Documents\\Splice\\Tiesto & KSHMR - Secrets (Drop) Project\\Samples\\splice\\Hi Hat.wav");
		File secondaryClip = new File("C:\\Users\\Merc Kiv\\Music\\Samples\\Instrument\\Single Instrument\\Bass_01");
		try {
			// AudStream = AudioSystem.getAudioInputStream(defaultClip);
			AudStream = AudioSystem.getAudioInputStream(secondaryClip);
			System.out.println("Used Secondary");

			keySounds.add(AudioSystem.getClip());
			keySounds.get(0).open(AudStream);
			keySounds.get(0).addLineListener(null);

		} catch (IOException IOE) {
			JDialog noAudioFile = new JDialog();
			noAudioFile.setTitle("No Audio Stream");
			IOE.getMessage();
			IOE.getStackTrace();
		} catch (UnsupportedAudioFileException UAF) {
			JDialog noAudioFile = new JDialog();
			noAudioFile.setTitle("No Audio File");
			UAF.getMessage();
			UAF.getStackTrace();
		} catch (LineUnavailableException LUA) {
			JDialog noAudioFile = new JDialog();
			noAudioFile.setTitle("No Audio Line");
			LUA.getMessage();
			LUA.getStackTrace();
		}

	}

	public void setDimensions(int width, int height) {
		this.Max.width = width;
		this.Max.height = height;
		this.Min.width = width;
		this.Min.height = height;
	}

	public Clip getKeySoundsElement(int Element) {
		return keySounds.get(Element);
	}

	public void setKeySoundsElement(Clip keySounds) {
		this.keySounds.add(keySounds);
	}

	public AudioInputStream getAudStream() {
		return AudStream;
	}

	public void setAudStream(AudioInputStream audStream) {
		AudStream = audStream;
	}

	public class SearchListener implements ActionListener, KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class FileChooserListener implements ActionListener {
		public void actionPerformed(ActionEvent AE) {
			if (AE.getSource() == Save) {
				SOP.getCurrentDirectory();
				SOP.showSaveDialog(SOP);

			} else if (AE.getSource() == Open) {
				SOP.getCurrentDirectory();
				SOP.showOpenDialog(SOP);

			} else if (AE.getSource() == Preset) {
				SOP.getCurrentDirectory();
				SOP.showOpenDialog(SOP);

			}
		}
	}

	public class BlackKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			keySounds.get(0).start();
			keySounds.get(0).drain();

			/*
			 * Can make condition that checks array for clip, against the key that is
			 * pressed keyposition == arrayposition.
			 */
		}

	}

	public class WhiteKeyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			keySounds.get(0).start();
			keySounds.get(0).drain();
			
		}

	}
	
	public class MenuHoverListener implements MenuListener{

		@Override
		public void menuSelected(MenuEvent e) {
			
			
		}

		@Override
		public void menuDeselected(MenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void menuCanceled(MenuEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	public static void main(String[] args) {
		new MidiInstrument();
	}
}
