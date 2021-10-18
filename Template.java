import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

public class Template {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 800);
		frame.setTitle("Main Page");
		//frame.setBackground();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel title = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) title.getLayout();
		title.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(title, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Current Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(245, 245, 245));
		title.add(lblNewLabel);
		
		JPanel navigator = new JPanel();
		navigator.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(navigator, BorderLayout.SOUTH);
		navigator.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnNewButton_4 = new JButton("Profile");
		navigator.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Chats");
		navigator.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Main Feed");
		navigator.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Forums");
		navigator.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		navigator.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 673, 330, 22);
		panel.add(formattedTextField);
		formattedTextField.setHorizontalAlignment(SwingConstants.LEFT);
		formattedTextField.setColumns(30);
		formattedTextField.setFont(new Font("Liberation Sans", Font.PLAIN, 12));
		
		JButton btnNewButton_5 = new JButton("Send");
		btnNewButton_5.setBounds(356, 672, 62, 23);
		panel.add(btnNewButton_5);
	}
}
