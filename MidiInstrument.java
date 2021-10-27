import javax.swing.*;
import java.awt.*;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.JWindow;
import javax.swing.border.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MidiInstrument extends JFrame {

	JTextField inGoing;
	JTextField outGoing;
	EtchedBorder border;
	Color bg;
	Color fore;
	Color whiteKeys;
	Color blackKeys;
	Font fnt;
	
	public MidiInstrument() {
		//initialize fields
		bg = new Color(154,90,186,0);
		fore = new Color(154,0,186,1);
		whiteKeys = new Color(255,255,255,1);
		blackKeys = new Color(0,0,0,1);
		border = new EtchedBorder(1);
		fnt = new Font(Font.SERIF, 4, 12);
		Dimension Max = new Dimension(650,300);
		Dimension Min = new Dimension(649,299);
		
		//set how the JFrame looks and how the objects within it will be laid out, and enabled
		requestFocus();
		setEnabled(true);
		setVisible(true);
		setBounds(45,45,650,300);
		super.setMaximumSize(Max);
		super.setMinimumSize(Min);
		setFont(fnt);
		setLayout(new FlowLayout(0));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//add() can add components or JObjects to the JFrame
		//borders must be set on JPanels
		//ACTIONLISTENERS MUST BE SET AFTER IN THE panel section it belongs with
		
		JPanel OuterFrame = new JPanel();
		add(OuterFrame);
		OuterFrame.setBounds(5,5,650,300);
		OuterFrame.setAlignmentX(LEFT_ALIGNMENT);
		OuterFrame.setBorder(border);
		
		JPanel SP1_1 = new JPanel();
		OuterFrame.add(SP1_1);
		SP1_1.setBorder(border);
		inGoing = new JTextField(40);
		inGoing.setHorizontalAlignment(2);
		SP1_1.add(inGoing);
		inGoing.addActionListener(null);
		
		JPanel SP1_2 = new JPanel();
		OuterFrame.add(SP1_2);
		SP1_2.setBorder(border);
	}

	
	public static void main(String[] args) {
		new MidiInstrument();
	}
}
